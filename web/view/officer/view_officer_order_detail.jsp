<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Payment"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    Payment payment = view.getAttObjects("payment");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= request.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container">
            <div class="row content">
                <div class="col-12">
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">ORDER INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order ID</span>
                        <%= String.format("%011d", payment.getOrderId())%>
                    </p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Amount of money</span>
                        &#3647;<%= view.formatCurrency(payment.getPaymentAmount())%>
                    </p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Date Paid</span>
                        <%= payment.getInformDatetime()%>
                    </p>
                    <img src="<%= view.printImage(payment.getPaymentImage()) %>" class="img-fluid img-thumbnail" >
                </div>
                <div class="row justify-content-center">
                    <div class="col">
                        <a href="/officer/confirmPayment/<%= payment.getOrderId()%>" class="btn btn-success">Confirm</a>
                        <a href="/officer/cancelPayment/<%= payment.getOrderId()%>" class="btn btn-warning">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>