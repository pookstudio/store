package Controller;

import Model.Address.Districts;
import Model.Address.SubdistrictsAndZipcodes;
import Model.DeliveryAddress;
import Model.OrderStatus;
import Model.Orders;
import Model.UserLogin;
import Model.UserRegister;
import Model.UserRegisterError;
import Service.UserService;
import javax.servlet.annotation.WebServlet;
import PokoSystem.PokoController;
import PokoSystem.PokoValidate;
import Service.OrderService;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.Part;

@WebServlet("/user/*")
@MultipartConfig
public class UserControl extends PokoController {

    private UserSession userSession;

    @Override
    public void main() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            request.setAttribute("user", userSession.getUser());
            view("user/view_user");
        } else {
            login();
        }
    }

    public void profile() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            request.setAttribute("user", userSession.getUser());
            view("user/view_profile");
        } else {
            login();
        }
    }

    public void wishlist() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            UserService userService = new UserService();
            request.setAttribute("user", userSession.getUser());
            request.setAttribute("productwishlist", userService.getProductWishlist(userSession.getID()));
            view("user/view_profile_wishlist");
        } else {
            login();
        }
    }

    public void wishlist(String actionString, Integer product_id) {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            UserService userService = new UserService();
            if (actionString.equals("add")) {
                if (!userService.isWishlist(userSession.getID(), product_id)) {
                    userService.addWishlist(userSession.getID(), product_id);
                }
            } else if (actionString.equals("remove")) {
                userService.removeWishlist(userSession.getID(), product_id);
            }
            redirect("/user/wishlist");
        } else {
            login();
        }
    }

    public void confirmpay() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            request.setAttribute("user", userSession.getUser());
            view("user/view_profile_confirmpay");
        } else {
            login();
        }
    }

    public void order() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            request.setAttribute("user", userSession.getUser());
            view("user/view_profile_order");
        } else {
            login();
        }
    }

    public void setting() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            request.setAttribute("user", userSession.getUser());
            view("user/view_profile_setting");
        } else {
            login();
        }
    }

    public void register() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            redirect("/user");
        } else {
            List<Integer> errorID = new ArrayList<>();
            errorID.clear();
            UserRegisterError errorRg = new UserRegisterError();
            if (request.getParameter("submit") == null) {
                errorID.add(errorRg.ErrorNotError);
                printViewRegister(errorID, null);
            } else {
                UserService userService = new UserService();
                UserRegister userRegister = new UserRegister();
                userRegister.setFirstname(getParameterString("inputFirstname"));
                userRegister.setLastlame(getParameterString("inputLastname"));
                userRegister.setEmail(getParameterString("inputEmail"));
                userRegister.setPassword(getParameterString("inputPassword"));
                userRegister.setGender(getParameterInteger("inputGender"));
                userRegister.setTelephone(getParameterString("inputTelephone"));
                Date date = PokoValidate.util.toDate(getParameterString("inputBirthday"));
                if (date != null) {
                    userRegister.setBirthday(date);
                } else {
                    errorID.add(errorRg.ErrorDateFormat);
                }

                if (userRegister.isNullEmpty()) {
                    errorID.add(errorRg.ErrorNullAndEmpty);
                } else {
                    if (!PokoValidate.util.validateEmail(userRegister.getEmail())) {
                        errorID.add(errorRg.ErrorEmailFormat);
                    }
                    if (userService.existEmail(userRegister.getEmail())) {
                        errorID.add(errorRg.ErrorEmailDuplicate);
                    }
                    if (!PokoValidate.util.validateLength(userRegister.getPassword(), 8, 32)) {
                        errorID.add(errorRg.ErrorPasswordFormat);
                    }
                    if (!PokoValidate.util.validateAge(userRegister.getBirthday(), 15, 80)) {
                        errorID.add(errorRg.ErrorAge);
                    }
                    if (!PokoValidate.util.validateTelephone(userRegister.getTelephone())) {
                        errorID.add(errorRg.ErrorTelephone);
                    }
                }
                if (errorID.size() > 0) {
                    printViewRegister(errorID, userRegister);
                } else {
                    /*----- Create DB -----*/
                    if (userService.createUser(userRegister)) {
                        request.setAttribute("addStatus", true);
                    } else {
                        request.setAttribute("addStatus", false);
                    }
                    view("user/view_user_register_after");
                }
            }
        }
    }

    private void printViewRegister(List<Integer> errorID, UserRegister userRegister) {
        request.setAttribute("userRegister", userRegister);
        request.setAttribute("errorID", errorID);
        view("user/view_user_register");
    }

    public void addDeliveryAddress() {
        UserService userService = new UserService();
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            if (userService.countAddress(userSession.getID()) < Config.MAXIMUM_ADDRESS) {
                if (request.getParameter("submit") == null) {
                    request.setAttribute("geo", userService.getGeographies());
                    request.setAttribute("provinces", userService.getProvinces());
                    request.setAttribute("districts", userService.getDistricts(1));
                    request.setAttribute("subdistricts", userService.getSubDistrictsAndZipcodes(1));
                    view("user/view_user_add_address");
                } else {
                    String address = getParameterString("inputAddress");
                    String subdistrict = getParameterString("inputSubDistrict");
                    if (address != null && subdistrict != null && userService.countAddress(userSession.getID()) < Config.MAXIMUM_ADDRESS) {
                        if (userService.addAddress(userSession.getID(), address, subdistrict)) {
                            request.setAttribute("addStatus", true);
                        } else {
                            request.setAttribute("addStatus", false);
                        }
                        view("user/view_user_add_address_after");
                    }
                }
            } else {
                redirect("/user");
            }
        } else {
            login();
        }
    }

    public void getAddressAjax() {
        try {
            UserService userService = new UserService();
            userSession = new UserSession(request, response);
            if (userSession.isMember()) {
                Integer provinceID = getParameterInteger("province");
                if (provinceID != null) {
                    List<Districts> districtses;
                    districtses = userService.getDistricts(provinceID);
                    if (districtses != null) {
                        districtses.forEach((districts) -> {
                            print("<option value=\"" + districts.getDistrictId() + "\">" + districts.getDistrictNameTh() + "</option>");
                        });
                    }
                } else {
                    Integer districtID = getParameterInteger("district");
                    if (districtID != null) {
                        List<SubdistrictsAndZipcodes> subdistrictsAndZipcodeses;
                        subdistrictsAndZipcodeses = userService.getSubDistrictsAndZipcodes(districtID);
                        if (subdistrictsAndZipcodeses != null) {
                            subdistrictsAndZipcodeses.forEach((SAndZ) -> {
                                print("<option value=\"" + SAndZ.getSubdistrictCode() + "\">" + SAndZ.getSubdistrictNameTh()
                                        + " (" + SAndZ.getZipcode() + ")" + "</option>");
                            });
                        }
                    }
                }
            } else {
                print(false);
            }
        } catch (Exception ex) {

        }
    }

    public void getProfileAjax() {
        try {
            UserService userService = new UserService();
            OrderService orderService = new OrderService();
            userSession = new UserSession(request, response);
            if (userSession.isMember()) {
                String data = getParameterString("data");
                if (data != null) {
                    OrderStatus orderStatus = new OrderStatus();
                    List<Orders> orders;
                    switch (data) {
                        case "overview":
                            request.setAttribute("user", userSession.getUser());
                            view("user/view_profile_about_overview");
                            break;
                        case "editprofile":
                            request.setAttribute("user", userSession.getUser());
                            view("user/_editprofile");
                            break;
                        case "changepassword":
                            view("user/_changepassword");
                            break;
                        case "deliveryaddress":
                            List<DeliveryAddress> deliveryAddresses = userService.getDeliveryAddress(userSession.getID());
                            if (deliveryAddresses.size() < Config.MAXIMUM_ADDRESS) {
                                request.setAttribute("addAddress", true);
                            } else {
                                request.setAttribute("addAddress", false);
                            }
                            request.setAttribute("deliveryAddress", deliveryAddresses);
                            view("user/_deliveryaddress");
                            break;
                        case "overviewpayment":
                            orders = orderService.getOrders(userSession.getID());
                            int confirm = 0;
                            int payment = 0;
                            int pay = 0;
                            int success = 0;
                            int cancel = 0;
                            for (Orders order : orders) {
                                if (order.getOrderStatus() == orderStatus.StatusConfirmOrder) {
                                    confirm++;
                                } else if (order.getOrderStatus() == orderStatus.StatusPayment) {
                                    payment++;
                                } else if (order.getOrderStatus() == orderStatus.StatusPay) {
                                    pay++;
                                } else if (order.getOrderStatus() == orderStatus.StatusPickup) {
                                    success++;
                                } else if (order.getOrderStatus() == orderStatus.StatusCancle) {
                                    cancel++;
                                }
                            }
                            List<Orders> orderses = null;
                            for (Orders order : orders) {
                                if (order.getOrderStatus() == orderStatus.StatusConfirmOrder
                                        || order.getOrderStatus() == orderStatus.StatusPayment
                                        || order.getOrderStatus() == orderStatus.StatusPay) {
                                    if (orderses == null) {
                                        orderses = new ArrayList<>();
                                    }
                                    orderses.add(order);
                                }
                            }
                            request.setAttribute("order_confirm", confirm);
                            request.setAttribute("order_payment", payment);
                            request.setAttribute("order_pay", pay);
                            request.setAttribute("orders", orderses);
                            view("user/view_profile_confirmpay_overview");
                            break;
                        case "addpayment":
                            orders = null;
                            for (Orders order : orderService.getOrders(userSession.getID())) {
                                if (order.getOrderStatus() == orderStatus.StatusConfirmOrder) {
                                    if (orders == null) {
                                        orders = new ArrayList<>();
                                    }
                                    orders.add(order);
                                }
                            }
                            request.setAttribute("orders", orders);
                            request.setAttribute("paymentMethods", orderService.getPaymentMethod());
                            view("user/view_profile_confirmpay_add");
                            break;
                        default:
                            break;
                    }
                }
            } else {
                print(false);
            }
        } catch (Exception ex) {

        }
    }

    public void setPaymentAjax() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            try {
                if (request.getParameter("submit") != null) {
                    Integer order_id = getParameterInteger("inputOrderConfirm");
                    Integer paymentMethod_id = getParameterInteger("paymentMethod");
                    float paymentAmount = Float.parseFloat(getParameterCustomer("inputAmount"));

                    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    String datetime = getParameterString("inputDate") + " " + getParameterString("inputTime");
                    Timestamp timestamp = new Timestamp(formatter.parse(datetime).getTime());

                    InputStream inputStream;
                    Part filepart = request.getPart("inputFile");
                    if (filepart != null) {
                        inputStream = filepart.getInputStream();
                        if (inputStream != null) {
                            OrderService orderService = new OrderService();
                            OrderStatus orderStatus = new OrderStatus();
                            String Message = "";
                            if (orderService.isInformPayment(order_id)) {
                                if (orderService.updateInformPayment(paymentAmount, order_id, paymentMethod_id, timestamp, inputStream)) {
                                    orderService.setOrderStatus(order_id, userSession.getID(), orderStatus.StatusPayment);
                                    Message = "Update Success";
                                } else {
                                    Message = "Update Fail";
                                }
                            } else {
                                if (orderService.setInformPayment(paymentAmount, order_id, paymentMethod_id, timestamp, inputStream)) {
                                    orderService.setOrderStatus(order_id, userSession.getID(), orderStatus.StatusPayment);
                                    Message = "Insert Success";
                                } else {
                                    Message = "Insert Fail";
                                }
                            }
                            print(Message);
                        }
                    }
                } else {

                }
            } catch (IOException | NumberFormatException | ParseException | ServletException ex) {
                Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            redirect("/user");
        }
    }

    public void resetpassword() {
        view("user/view_user_resetpassword");
    }

    public void login() {
//        User user = null;
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            redirect("/user");
        } else {
            Cookie[] cookies = request.getCookies();
            UserLogin userLogin = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("codetomEmail")) {
                        if (userLogin == null) {
                            userLogin = new UserLogin();
                        }
                        userLogin.setEmail(cookie.getValue());
                        userLogin.setSigned(true);
                    } else if (cookie.getName().equals("codetomPassword")) {
                        if (userLogin == null) {
                            userLogin = new UserLogin();
                        }
                        userLogin.setPwd(cookie.getValue());
                    }
                }
            }

            if (userLogin == null) {
                if (request.getParameter("submit") == null) {
                    printViewLogin(0);
                } else {
                    userLogin = new UserLogin();
                    userLogin.setEmail(getParameterString("inputEmail"));
                    userLogin.setPwd(getParameterString("inputPassword"));
                    if (existParameter("signed")) {
                        userLogin.setSigned(true);
                    } else {
                        userLogin.setSigned(false);
                    }
                    if (userLogin.isNullEmpty()) {
                        printViewLogin(1);
                    }
                }
            }

            if (userLogin != null) {
                UserService userService = new UserService();
                userSession.setUser(userService.validateUser(userLogin.getEmail(), userLogin.getPwd()));
                if (userSession.isMember()) {
                    if (userLogin.getSigned()) {
                        Cookie cEmail = new Cookie("codetomEmail", userLogin.getEmail());
                        Cookie cPassword = new Cookie("codetomPassword", userLogin.getPwd());
                        cEmail.setPath("/");
                        cPassword.setPath("/");
                        cEmail.setMaxAge(60 * 60 * 24 * Config.COOKIE_DAYS);
                        cPassword.setMaxAge(60 * 60 * 24 * Config.COOKIE_DAYS);
                        response.addCookie(cEmail);
                        response.addCookie(cPassword);
                    }
                    redirect("/user");
                } else {
                    printViewLogin(2);
                }
            }
        }
    }

    private void printViewLogin(int errorID) {
        request.setAttribute("errorID", errorID);
        view("user/view_user_login");
    }

    public void logout() {
        //Clear Session And Cookie
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            /*----- Remove Cookie ----*/
            Cookie cEmail = new Cookie("codetomEmail", null);
            Cookie cPassword = new Cookie("codetomPassword", null);
            cEmail.setPath("/");
            cPassword.setPath("/");
            cEmail.setMaxAge(0);
            cPassword.setMaxAge(0);
            response.addCookie(cEmail);
            response.addCookie(cPassword);
            /* ----- ----------- -----*/
            userSession.clear();
        }
        redirect("/user");
    }

}
