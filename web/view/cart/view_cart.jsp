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
    List<Cart> carts = view.getAttObjects("cartProduct");
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
                max-width: 250px;
            }
            .price {
                max-width: 150px;
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
            .amount {
                padding: 12px 20px;
                border: 1px solid #cccccc;
                border-radius: 3px;
            }
            .img-mini {
                width: 50px;
                height: 50px;
            }
        </style>
        <div class="container content">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                            <div class="row">
                                <div class="col imgcart"></div>
                                <div class="col text-center">
                                    Product
                                </div>
                                <div class="col text-center quantity">
                                    Quantity
                                </div>
                                <div class="col text-right price">
                                    Price
                                </div>
                                <div class="col imgcart"></div>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Cart cart : carts) {
                    %>
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col imgcart">
                                    <a href="/product/getProduct/<%= cart.getProductID()%>">
                                        <%
                                            if(cart.getProductsDetailimage() != null) {
                                        %>
                                        <img src="<%= view.printImage(cart.getProductsDetailimage()) %>" class="img-thumbnail img-mini" />
                                        <%  } else { %>
                                        <img src="https://dummyimage.com/50x50/55595c/fff" class="img-thumbnail img-mini" />
                                        <%  }   %>
                                    </a>
                                </div>
                                <div class="col">
                                    <a style="text-decoration: none;" href="/product/getProduct/<%= cart.getProductID()%>">
                                        <%= cart.getProductName()%>
                                    </a>
                                    <h6 class="text-muted">ID <%= cart.getProductID()%></h6>
                                </div>
                                <div class="col quantity">
                                    <a href="/cart/add/<%= cart.getProductID() %>"><i class="fas fa-plus-circle fa-2x"></i></a>
                                    <span class="amount"><%= cart.getQuanity()%></span>
                                    <a href="/cart/remove/<%= cart.getProductID() %>"><i class="fas fa-minus-circle fa-2x"></i></a>
                                </div>
                                <div class="col text-right price">
                                    &#3647;<%= view.formatCurrency(cart.getProductPrice())%>
                                    <p class="font-weight-bold">&#3647;<%= view.formatCurrency(cart.getProductPrice() * cart.getQuanity())%></p>
                                </div>
                                <div class="col imgcart">
                                    <style type="text/css">
                                        .delete {
                                            color: #CDD3D9;
                                        }
                                        .delete:hover {
                                            color: #202428;
                                        }
                                    </style>
                                    <a class="delete" href="/cart/delete/<%= cart.getProductID()%>">
                                        <i class="fas fa-trash fa-2x"></i>
                                    </a>
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
                <div class="col font-weight-bold total">
                    &#3647;<%= view.formatCurrency(sum)%>
                </div>
            </div>
            <div class="row justify-content-end">
                <div class="col-12 col-sm-8 col-md-6 col-lg-4 align-self-center">
                    <a class="btn btn-lg btn-block btn-info" href="/cart/shipping" style="border-radius: 120px 90px 60px 30px/30px 60px 90px 120px;">
                        Continue to Buy 
                        <i class="fas fa-arrow-right"></i> 
                        <i class="fas fa-shipping-fast"></i>
                    </a>
                </div>
            </div>
        </div> 
    </div>
    <%@include file="../_footer.jsp" %>
</body>
</html>
