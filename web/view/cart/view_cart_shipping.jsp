<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.OrdersDetail"%>
<%@page import="Controller.Config"%>
<%@page import="Model.DeliveryAddress"%>
<%@page import="Model.DeliveryMethod"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    boolean addAddress = view.getAttBoolean("addAddress");
    List<DeliveryMethod> deliveryMethods = view.getAttObjects("deliveryMethod");
    List<DeliveryAddress> deliveryAddresses = view.getAttObjects("deliveryAddress");
    OrdersDetail ordersDetail = view.getAttObjects("ordersDetail");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <style type="text/css">
            .header{
                padding: 20px;
                color: white;
                background-color: #2B3D4F;
            }
            .radioo {
                padding: 20px 10px 20px 10px;
                border-top: 1px solid #dee2e6;
            }
            .radioo > div > a {
                text-decoration: none;
            }
            .content {
                margin-top: 20px; 
                margin-bottom: 20px; 
                background-color: #FEFEFE;
                border: 1px solid #ccd0d5;
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
        </style>
        <form method="post" action="/cart/checkout">
            <div class="container content">
                <div class="row header" style="border-radius: 10px 10px 0 0;">
                    <div class="col">
                        <h5 class="align-middle"><i class="fas fa-rocket fa-2x"></i> Choose Your Delivery Method</h5>
                    </div>
                </div>
                <%
                    for (DeliveryMethod deliveryMethod : deliveryMethods) {
                %>
                <div class="row radioo align-items-center">
                    <div class="custom-control custom-radio">
                        <input 
                            type="radio" 
                            id="<%= deliveryMethod.getDeliveryMethodname() + deliveryMethod.getDeliveryMethodid().toString()%>" 
                            name="deliveryMethod" 
                            value="<%= deliveryMethod.getDeliveryMethodid()%>" 
                            class="custom-control-input"
                            <%
                                if (deliveryMethod.getDeliveryMethodid() == ordersDetail.getDeliveryMethodid()) {
                                    out.print("checked=\"checked\"");
                                }
                            %>
                            required>
                        <label class="custom-control-label" for="<%= deliveryMethod.getDeliveryMethodname() + deliveryMethod.getDeliveryMethodid().toString()%>">
                            <img src="<%= view.printImage(deliveryMethod.getDeliveryMethodimage()) %>" style="width: 150px; height: 67px;" >
                            <%= deliveryMethod.getDeliveryMethodname()%> &#3647;<%= deliveryMethod.getDeliveryMethodprice()%>
                        </label>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="row header" style="margin-top: 40px;">
                    <div class="col">
                        <!--<h5><i class="far fa-credit-card fa-2x"></i> Choose Your Payment Method</h5>-->
                        <h5 class="align-middle"><i class="fas fa-map-marked fa-2x"></i> Choose Your Delivery Address</h5>
                    </div>
                </div>
                <%
                    for (DeliveryAddress deliveryAddress : deliveryAddresses) {
                %>
                <div class="row radioo align-items-center">
                    <i class="fas fa-address-book fa-2x" style="color: #596167;"></i>&nbsp;&nbsp;
                    <div class="custom-control custom-radio">
                        <input 
                            type="radio" 
                            id="<%= deliveryAddress.getSubdistrictCode() + deliveryAddress.getID()%>" 
                            name="deliveryAddress" 
                            value="<%= deliveryAddress.getID()%>" 
                            class="custom-control-input" 
                            <%
                                if (deliveryAddress.getID() == ordersDetail.getDeliveryAddressid()) {
                                    out.print("checked=\"checked\"");
                                }
                            %>
                            required>
                        <label class="custom-control-label" for="<%= deliveryAddress.getSubdistrictCode() + deliveryAddress.getID()%>">
                            <%= deliveryAddress.getAddress()%> 
                            <%= deliveryAddress.getSubdistrictName()%> 
                            <%= deliveryAddress.getDistrictName()%> 
                            <%= deliveryAddress.getProvinceName()%> 
                            <%= deliveryAddress.getZipcode()%>
                        </label>
                    </div>
                </div>
                <%
                    }
                    if (addAddress) {
                %>
                <div class="row radioo">
                    <div class="col-12 col-sm-8 col-md-6 col-lg-4 align-self-center">
                        <a class="btn btn-lg btn-block btn-secondary" 
                           href="/user/addDeliveryAddress" 
                           style="border-radius: 30px 120px 90px 60px/120px 30px 60px 90px;">
                            <i class="fas fa-plus"></i> 
                            Add Delivery Address
                        </a>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="row radioo justify-content-end">
                    <div class="col-12 col-sm-8 col-md-6 col-lg-4 align-self-center">
                        <button 
                            type="submit" 
                            value="submit" 
                            class="btn btn-lg btn-block btn-info" 
                            style="border-radius: 30px 60px 90px 120px/60px 90px 60px 30px;">
                            Next to pay 
                            <i class="fas fa-arrow-right"></i>
                            <i class="far fa-credit-card"></i>
                        </button>
                    </div>
                </div>
            </div>
        </form>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
