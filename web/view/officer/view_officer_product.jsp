<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<Product> products = view.getAttObjects("products");
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

                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PRODUCTS INFORMATION <i class="fas fa-info-circle"></i></p>
                    <p>
                        <span style="color: #90949c; min-width: 150px; display: inline-block;">
                            <a href="/officer/addProduct" class="btn btn-info"><i class="fas fa-plus"></i> Add Product</a>
                        </span>
                    </p>


                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">PRODUCT MANAGEMENT <i class="fas fa-toolbox"></i></p>
                    <p style="color: #90949c; min-width: 150px; display: inline-block;">
                        <%
                            if (products != null) {
                        %>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Manage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Product product : products) {
                                %>
                                <tr>
                                    <td><%= String.format("%011d", product.getProductID())%></td>
                                    <td><%= product.getProductName()%></td>
                                    <td><%= product.getProductStock()%></td>
                                    <td>
                                        <a href="/officer/updateProduct/<%= product.getProductID() %>" class="btn btn-info"><i class="fas fa-edit"></i> Edit</a>
                                        <a href="/officer/imageProduct/<%= product.getProductID() %>" class="btn btn-info"><i class="far fa-image"></i> Picture</a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <% } else { %>
                    <p class="text-center">Includes 0 items</p>
                    <% }%>
                    </p>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>