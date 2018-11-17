<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    float sum = view.getAttFloat("sum");
    float tax = view.getAttFloat("tax");
    List<Cart> carts = view.getAttObjects("cartProduct");
    float shipping = view.getAttFloat("method");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_top.jsp" %>

        <style type="text/css">
            .total {
                max-width: 25%;
                min-width: 150px;
            }
            .imgcart {
                max-width: 80px;
            }
            .quantity {
                max-width: 150px;
            }
            .price {

            }
            .form-total {
                padding: 15px;
                border-top: 1px solid #dee2e6;
            }
            .content {
                margin-top: 20px; 
                margin-bottom: 20px; 
                background-color: #FEFEFE;
                padding-bottom: 20px;
                padding-top: 40px;
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
        </style>
        <div class="container content">
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            <div class="row">
                                <div class="col text-center">
                                    Product
                                </div>
                                <div class="col text-center quantity">
                                    Quantity
                                </div>
                                <div class="col text-right price">
                                    Price
                                </div>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%                        for (Cart cart : carts) {
                    %>
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col">
                                    <%= cart.getProductName()%>
                                </div>
                                <div class="col text-center quantity">
                                    <span><%= cart.getQuanity()%></span>
                                </div>
                                <div class="col text-right price">&#3647;<%= view.formatCurrency(cart.getProductPrice() * cart.getQuanity())%>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <div class="row text-right form-total">
                <div class="col">
                    Total Products
                </div>
                <div class="col total">
                    &#3647;<%= view.formatCurrency(sum)%>
                </div>
            </div>
            <div class="row text-right form-total">
                <div class="col">
                    Tax 6 %
                </div>
                <div class="col total">
                    &#3647;<%= view.formatCurrency(tax)%>
                </div>
            </div>
            <div class="row text-right form-total">
                <div class="col">
                    <i class="fas fa-shipping-fast"></i> Shipping
                </div>
                <div class="col total">
                    &#3647;<%= shipping %>
                </div>
            </div>
            <div class="row text-right font-weight-bold form-total">
                <div class="col">
                    Total All
                </div>
                <div class="col total">
                    &#3647;<%= view.formatCurrency(sum + tax + shipping)%>
                </div>
            </div>
            <div class="row justify-content-end">
                <div class="col-12 col-sm-8 col-md-6 col-lg-4 align-self-center">
                    <a class="btn btn-lg btn-block btn-success" href="/cart/orderConfirm" style="border-radius: 30px 120px 90px 60px/120px 30px 60px 90px;">
                        Confirm Order 
                        <i class="fas fa-check-double"></i>
                    </a>
                </div>
            </div> 
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
