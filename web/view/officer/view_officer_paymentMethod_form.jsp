<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.PaymentMethod"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    PaymentMethod paymentMethod = view.getAttObjects("paymentMethod");
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

                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PAYMENT METHOD INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Payment ID</span>
                        <%= paymentMethod.getPaymentMethodid()%>
                    </p>
                    <div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center"><i class="far fa-credit-card" style="color: #90949c;"></i> Payment</h5>
                                <%
                                    if (paymentMethod != null) {
                                %>
                                <form action="/user/setPaymentAjax" id="informPayment" class="form-signin" method="post" enctype="multipart/form-data">
                                    <div class="form-label-group">
                                        <input 
                                            type="text" 
                                            id="inputName" 
                                            name="inputName" 
                                            class="form-control"
                                            placeholder="Name of Delivery Method"
                                            value="<%= paymentMethod.getPaymentMethodid()%>"
                                            required 
                                            >
                                        <label for="inputName">Name of Delivery Method</label>
                                    </div>
                                    <div class="form-label-group">
                                        <div class="addon">
                                            &#3647;
                                        </div>
                                        <input 
                                            type="number" 
                                            id="inputMoney" 
                                            name="inputMoney" 
                                            class="form-control icon" 
                                            step="0.01"
                                            placeholder="Amount of Money"
                                            required 
                                            >
                                        <label for="inputMoney">Amount of Money</label>
                                    </div>
                                    <!--File Images-->
                                    <div class="custom-file" style="margin-bottom: 16px;">
                                        <input type="file" class="custom-file-input" id="inputFile" name="inputFile" required>
                                        <label class="custom-file-label" for="inputFile">Choose image</label>
                                    </div>
                                    <!--Submit Button-->
                                    <div class="form-label-group">
                                        <button 
                                            id="registerSubmit" 
                                            name="submit" 
                                            type="submit" 
                                            value="submit" 
                                            class="btn btn-lg btn-primary text-uppercase"
                                            style="width: 100%;">Confirm Payment 
                                            <i class="fas fa-check-double"></i>
                                        </button>
                                    </div>
                                </form>
                                <% } else { %>
                                <span class="text-center"><h4>Includes 0 method</h4></span>
                                <% }%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>