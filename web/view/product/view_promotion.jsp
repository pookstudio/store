<%-- 
    Document   : view_product
    Created on : Oct 19, 2018, 1:04:44 AM
    Author     : Gail
--%>
<%@page import="java.util.List"%>
<%@page import="Model.Product"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <%
            if (request.getAttribute("product") != null) {
                List<Product> productList = (List<Product>) request.getAttribute("product");
        %>
        <div class="container-fluid">
            <div class="row"  style="background-color: #FEFEFE;">
                <div class="container" style="padding-top: 30px; padding-bottom: 15px;">
                    <div class="row">
                        <div class="card-columns">
                            <% for (Product product : productList) {%>
                            <div class="card">
                                <h5 class="card-header">Featured</h5>
                                <img class="card-img-top" src="/drive/img/items.jpg" alt="Lab" style="width: 100%" />
                                <div class="card-body">
                                    <h4 class="card-title"><%= product.getProductName()%></h4>
                                    <h6 class="card-subtitle mb-2 text-muted"><%= product.getProductTypeID() %></h6>
                                    <p class="card-text"><%= product.getProductDetail()%></p>
                                    <a class="btn btn-primary" href="">Add</a>
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% }%>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
