<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.DeliveryMethod"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    DeliveryMethod deliveryMethod = view.getAttObjects("deliveryMethod");
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
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">DELIVERY METHOD INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Delivery Methods ID </span>
                        <%= String.format("%02d", deliveryMethod.getDeliveryMethodid())%>
                    </p>
                    <div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center"><i class="far fa-credit-card" style="color: #90949c;"></i> Delivery Method</h5>
                                <%
                                    if (deliveryMethod != null) {
                                %>
                                <form action="/officer/updateDeliveryMethodForm" class="form-signin" method="post" enctype="multipart/form-data">
                                    <input type="hidden" id="deliveryMethod_id" name="deliveryMethod_id" value="<%= deliveryMethod.getDeliveryMethodid()%>">
                                    <div class="form-label-group">
                                        <input 
                                            type="text" 
                                            id="deliveryMethod_name" 
                                            name="deliveryMethod_name" 
                                            class="form-control"
                                            placeholder="Name of Delivery Method"
                                            value="<%= deliveryMethod.getDeliveryMethodname()%>"
                                            required 
                                            >
                                        <label for="deliveryMethod_name">Name of Delivery Method</label>
                                    </div>
                                    <div class="form-label-group">
                                        <div class="addon">
                                            &#3647;
                                        </div>
                                        <input 
                                            type="number" 
                                            id="deliveryMethod_price" 
                                            name="deliveryMethod_price" 
                                            class="form-control icon" 
                                            placeholder="Amount of Money"
                                            value="<%= deliveryMethod.getDeliveryMethodprice()%>"
                                            required 
                                            >
                                        <label for="deliveryMethod_price">Amount of Money</label>
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
                                            style="width: 100%;">Update Delevery Method
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
    </div>
    <%@include file="../_footer.jsp" %>
</body>
</html>