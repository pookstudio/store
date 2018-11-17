/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.OrderStatus;
import Service.OrderService;
import Service.ProductService;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

/**
 *
 * @author Gail
 */
@WebServlet("/officer/*")
@MultipartConfig
public class OfficerControl extends PokoSystem.PokoController {

    private UserSession userSession;

    private void login() {
        redirect("/user");
    }

    private boolean checkOfficer(UserSession userSession) {
        return userSession.isMember() && userSession.getLevel() > 7;
    }

    @Override
    public void main() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            request.setAttribute("user", userSession.getUser());
            view("officer/view_officer");
        } else {
            login();
        }
    }

    public void orders() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            OrderStatus orderStatus = new OrderStatus();
            request.setAttribute("orders", orderService.getOrderStatus(orderStatus.StatusPayment));
            view("officer/view_officer_order");
        } else {
            login();
        }
    }

    public void deliveryMethods() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            request.setAttribute("deliveryMethods", orderService.getDeliveryMethods());
            view("officer/view_officer_deliveryMethod");
        } else {
            login();
        }
    }

    public void paymentMethods() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            request.setAttribute("paymentMethods", orderService.getPaymentMethod());
            view("officer/view_officer_paymentMethod");
        } else {
            login();
        }
    }

    public void product() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            request.setAttribute("products", productService.getProduct(100));
            view("officer/view_officer_product");
        } else {
            login();
        }
    }

    public void productType() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            request.setAttribute("products", productService.getProduct(100));
            view("officer/view_officer_product");
        } else {
            login();
        }
    }

    public void promotions() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            request.setAttribute("products", productService.getProduct(100));
            view("officer/view_officer_product");
        } else {
            login();
        }
    }

    public void getPaymentDetail(Integer order_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            request.setAttribute("payment", orderService.getPayment(order_id));
            view("officer/view_officer_order_detail");

        } else {
            login();
        }
    }

    public void confirmPayment(Integer order_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            OrderStatus orderStatus = new OrderStatus();
            request.setAttribute("paymentpage", "confirm");
            request.setAttribute("after", orderService.setOrderStatus(order_id, userSession.getID(), orderStatus.StatusPay));
            view("officer/view_officer_order_detail_after");
        } else {
            login();
        }
    }

    public void cancelPayment(Integer order_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            OrderStatus orderStatus = new OrderStatus();
            request.setAttribute("paymentpage", "cancel");
            request.setAttribute("after", orderService.setOrderStatus(order_id, userSession.getID(), orderStatus.StatusPaymentCancel));
            view("officer/view_officer_order_detail_after");
        } else {
            login();
        }
    }

    public void addDeliveryMethod() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            view("officer/view_officer_deliveryMethod_formAdd");
        } else {
            login();
        }
    }

    public void addDeliveryMethodForm() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            if (request.getParameter("submit") != null) {
                try {
                    String deliveryMethod_name = getParameterString("deliveryMethod_name");
                    Integer deliveryMethod_price = getParameterInteger("deliveryMethod_price");
                    InputStream inputStream;
                    Part filepart = request.getPart("inputFile");
                    if (filepart != null) {
                        inputStream = filepart.getInputStream();
                        if (inputStream != null) {
                            OrderService orderService = new OrderService();
                            if (orderService.addDeliveryMethod(deliveryMethod_name, deliveryMethod_price, inputStream)) {
                                redirect("/officer/deliveryMethods");
                            }
                        }
                    }
                } catch (IOException | ServletException ex) {
                    Logger.getLogger(OfficerControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                redirect("/officer/addDeliveryMethod");
            }
        } else {
            login();
        }
    }

    public void updateDeliveryMethod(Integer deliveryMethod_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            OrderService orderService = new OrderService();
            request.setAttribute("deliveryMethod", orderService.getDeliveryMethod(deliveryMethod_id));
            view("officer/view_officer_deliveryMethod_formUpdate");
        } else {
            login();
        }
    }

    public void updateDeliveryMethodForm() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            if (request.getParameter("submit") != null) {
                try {
                    Integer deliveryMethod_id = getParameterInteger("deliveryMethod_id");
                    String deliveryMethod_name = getParameterString("deliveryMethod_name");
                    Integer deliveryMethod_price = getParameterInteger("deliveryMethod_price");
                    InputStream inputStream;
                    Part filepart = request.getPart("inputFile");
                    if (filepart != null) {
                        inputStream = filepart.getInputStream();
                        if (inputStream != null) {
                            OrderService orderService = new OrderService();
                            if (orderService.updateDeliveryMethod(deliveryMethod_id, deliveryMethod_name, deliveryMethod_price, inputStream)) {
                                redirect("/officer/deliveryMethods");
                            }
                        }
                    }
                } catch (IOException | ServletException ex) {
                    Logger.getLogger(OfficerControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                redirect("/officer");
            }
        } else {
            login();
        }
    }

    public void updateProduct(Integer product_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            request.setAttribute("product", productService.getProductID(product_id));
            view("officer/view_officer_product_formUpdate");
        } else {
            login();
        }
    }

    public void updateProductForm() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            if (request.getParameter("submit") != null) {
                Integer product_id = getParameterInteger("product_id");
                Integer productType_id = getParameterInteger("productType_id");
                String product_name = getParameterString("product_name");
                Float product_price = Float.parseFloat(getParameterCustomer("product_price"));
                Integer product_stock = getParameterInteger("product_stock");
                String product_detail = getParameterString("product_detail");
                ProductService productService = new ProductService();
                if (productService.updateProduct(product_id, productType_id, product_name, product_price, product_stock, product_detail)) {
                    redirect("/officer/product");
                }
            } else {
                redirect("/officer");
            }
        } else {
            login();
        }
    }

    public void addProduct() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            view("officer/view_officer_product_formAdd");
        } else {
            login();
        }
    }

    public void addProductForm() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            if (request.getParameter("submit") != null) {
                Integer productType_id = getParameterInteger("productType_id");
                String product_name = getParameterString("product_name");
                Float product_price = Float.parseFloat(getParameterCustomer("product_price"));
                Integer product_stock = getParameterInteger("product_stock");
                String product_detail = getParameterString("product_detail");
                ProductService productService = new ProductService();
                int product_id = productService.addProductReturnLastID(productType_id, product_name, product_price, product_stock, product_detail);
                if (product_id > 0) {
                    redirect("/officer/imageProduct/" + product_id);
                }
            } else {
                redirect("/officer");
            }
        } else {
            login();
        }
    }

    public void imageProduct(Integer product_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            request.setAttribute("product", productService.getProductID(product_id));
            request.setAttribute("productsDetail", productService.getProductsDetail(product_id));
            view("officer/view_officer_product_image");
        } else {
            login();
        }
    }

    public void addImageProductForm() {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            try {
                Integer product_id = getParameterInteger("product_id");
                InputStream inputStream;
                Part filepart = request.getPart("inputFile");
                if (filepart != null) {
                    inputStream = filepart.getInputStream();
                    if (inputStream != null) {
                        ProductService productService = new ProductService();
                        if (productService.addImageProduct(inputStream, product_id)) {
                            redirect("/officer/imageProduct/" + product_id);
                        }
                    }
                }
            } catch (IOException | ServletException ex) {
                Logger.getLogger(OfficerControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            login();
        }
    }

    public void removeImageProduct(Integer product_id, Integer productsDetail_id) {
        userSession = new UserSession(request, response);
        if (checkOfficer(userSession)) {
            ProductService productService = new ProductService();
            if (productService.removeImageProduct(productsDetail_id)) {
                redirect("/officer/imageProduct/" + product_id);
            }
        } else {
            login();
        }
    }

}
