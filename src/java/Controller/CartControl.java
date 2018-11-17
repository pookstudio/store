/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cart;
import Model.CartError;
import Model.OrderStatus;
import Model.DeliveryAddress;
import Model.DeliveryMethod;
import Model.OrdersDetail;
import Service.CartService;
import Service.OrderService;
import Service.UserService;
import java.util.List;
import java.util.Objects;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Gail
 */
@WebServlet("/cart/*")
public class CartControl extends PokoSystem.PokoController {

    private final CartService cartService = new CartService();
    private final CartError errorID = new CartError();
    private final OrderStatus orderStatus = new OrderStatus();
    private UserSession userSession;

    private void login() {
        redirect("/user");
    }

    private void addNewCart() {
        if (!cartService.exitCartStatus(userSession.getID(), orderStatus.StatusBasket)) {
            cartService.addNewCart(userSession.getID());
        }
    }

    @Override
    public void main() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            addNewCart();
            if (cartService.getCartCount(userSession.getID(), orderStatus.StatusBasket) > 0) {
                List<Cart> carts = cartService.getCartProduct(userSession.getID(), orderStatus.StatusBasket);
                float sum = 0;
                for (Cart cart : carts) {
                    sum += cart.getProductPrice() * cart.getQuanity();
                    cart.setProductsDetailimage(cartService.getImageProduct(cart.getProductID()));
                }
                request.setAttribute("sum", sum);
                request.setAttribute("cartProduct", carts);
                view("cart/view_cart");
            } else {
                view("cart/view_cart_null");
            }
        } else {
            login();
        }
    }

    public void add(Integer productID) {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            addNewCart();
            int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
            if (cartService.getCartCount(userSession.getID(), orderStatus.StatusBasket) > 9
                    && !cartService.existItem(order_id, productID)) {
                request.setAttribute("errorID", errorID.ErrorLimitOver);
                view("cart/view_cart_error");
            } else {
                if (cartService.existItem(order_id, productID)) {
                    /* Add product in cart +1 */
                    cartService.updateCartProduct(order_id, productID, cartService.getQuantity(order_id, productID) + 1);
                } else {
                    cartService.addCartProduct(order_id, productID, 1);
                }
                redirect("/cart");
            }
        } else {
            login();
        }
    }
    
    public void remove(Integer productID) {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            addNewCart();
            int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
            if (!cartService.existItem(order_id, productID)) {
                request.setAttribute("errorID", errorID.ErrorNoItem);
                view("cart/view_cart_error");
            } else {
                if (cartService.getQuantity(order_id, productID) > 1) {
                    /* Sub product in cart 1 */
                    cartService.updateCartProduct(order_id, productID, cartService.getQuantity(order_id, productID) - 1);
                    redirect("/cart");
                } else {
                    delete(productID);
                }
            }
        } else {
            login();
        }
    }

    public void delete(Integer productID) {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            addNewCart();
            int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
            if (cartService.existItem(order_id, productID)) {
                if (cartService.deleteCartProduct(order_id, productID)) {
                    redirect("/cart");
                } else {
                    request.setAttribute("errorID", errorID.ErrorDelete);
                    view("cart/view_cart_error");
                }
            } else {
                request.setAttribute("errorID", errorID.ErrorNoItem);
                view("cart/view_cart_error");
            }
        } else {
            login();
        }
    }

    public void checkout() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            if (cartService.getCartCount(userSession.getID(), orderStatus.StatusBasket) > 0) {
                Integer address = getParameterInteger("deliveryAddress");
                Integer method = getParameterInteger("deliveryMethod");
                if (address != null && method != null) {
                    UserService userService = new UserService();
                    int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
                    if (!cartService.updateOrderDetailAddressAndMethod(order_id, address, method)) {

                    }
                    float shipping = 0;
                    OrderService orderService = new OrderService();
                    for (DeliveryMethod deliveryMethod : orderService.getDeliveryMethods()) {
                        if (Objects.equals(deliveryMethod.getDeliveryMethodid(), method)) {
                            shipping = deliveryMethod.getDeliveryMethodprice();
                        }
                    }
                    String addressString = "";
                    for (DeliveryAddress deliveryAddres : userService.getDeliveryAddress(userSession.getID())) {
                        if (deliveryAddres.getID() == address) {
                            addressString = deliveryAddres.getAddress()
                                    + deliveryAddres.getSubdistrictName()
                                    + deliveryAddres.getDistrictName()
                                    + deliveryAddres.getProvinceName()
                                    + deliveryAddres.getZipcode();
                        }
                    }
                    List<Cart> carts = cartService.getCartProduct(userSession.getID(), orderStatus.StatusBasket);
                    float sum = 0;
                    for (Cart cart : carts) {
                        sum += cart.getProductPrice() * cart.getQuanity();
                    }
                    request.setAttribute("address", addressString);
                    request.setAttribute("sum", sum);
                    request.setAttribute("tax", (sum * 6) / 100);
                    request.setAttribute("method", shipping);
                    request.setAttribute("cartProduct", carts);
                    view("cart/view_cart_checkout");
                } else {
                    redirect("/cart/shipping");
                }
            } else {
                redirect("/cart");
            }
        } else {
            login();
        }
    }

    public void shipping() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            if (cartService.getCartCount(userSession.getID(), orderStatus.StatusBasket) > 0) {
                UserService userService = new UserService();
                int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
                List<DeliveryAddress> deliveryAddresses = userService.getDeliveryAddress(userSession.getID());
                if (deliveryAddresses.size() < Config.MAXIMUM_ADDRESS) {
                    request.setAttribute("addAddress", true);
                } else {
                    request.setAttribute("addAddress", false);
                }
                request.setAttribute("ordersDetail", cartService.getOrderDetail(order_id));
                OrderService orderService = new OrderService();
                request.setAttribute("deliveryMethod", orderService.getDeliveryMethods());
                request.setAttribute("deliveryAddress", deliveryAddresses);
                view("cart/view_cart_shipping");
            } else {
                redirect("/cart");
            }
        } else {
            login();
        }
    }

    public void orderConfirm() {
        userSession = new UserSession(request, response);
        if (userSession.isMember()) {
            int order_id = cartService.getOrderID(userSession.getID(), orderStatus.StatusBasket);
            OrdersDetail ordersDetail = cartService.getOrderDetail(order_id);
            if (cartService.getCartCount(userSession.getID(), orderStatus.StatusBasket) > 0) {
                if (ordersDetail.getDeliveryAddressid() == 0 || ordersDetail.getDeliveryMethodid() == 0) {
                    redirect("/cart/shipping");
                } else {
                    UserService userService = new UserService();
                    List<DeliveryAddress> deliveryAddresses = userService.getDeliveryAddress(userSession.getID());
                    boolean commit = cartService.OrderConfirm(
                            order_id,
                            orderStatus.StatusConfirmOrder,
                            cartService.getOrderItem(order_id),
                            deliveryAddresses.get(ordersDetail.getDeliveryAddressid() - 1).getAddress(),
                            deliveryAddresses.get(ordersDetail.getDeliveryAddressid() - 1).getSubdistrictCode()
                    );
                    request.setAttribute("orderCommit", commit);
                    view("cart/view_cart_orderConfirm");
                }
            } else {
                redirect("/cart");
            }
        } else {
            login();
        }
    }

}
