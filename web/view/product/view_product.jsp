<%-- 
    Document   : view_product
    Created on : Oct 19, 2018, 1:04:44 AM
    Author     : Gail
--%>
<%@page import="java.util.List"%>
<%@page import="Model.Product"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<Product> productList = view.getAttObjects("product");
    String pagename = view.getAttString("pageTypeName");
    int pages = view.getAttInteger("pages");
    int pageI = view.getAttInteger("page");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <style type="text/css">
            body {
                background-color: #FEFEFE;
            }
        </style>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <%!            public String printBreadcrumb(int productTypeID) {
                String str = "";
                if (Navbar.util.getSubsetFromTypeID(productTypeID) != 0) {
                    str += printBreadcrumb(Navbar.util.getSubsetFromTypeID(productTypeID));
                }
                String productName = Navbar.util.isProductTypeName(productTypeID);
                str += "<li class=\"breadcrumb-item\"><a href=\"/product/getProduct/" + productName + "\">" + productName + "</a></li>";
                return str;
            }
        %>
        <div class="container-fluid">
            <div class="row">
                <div class="container" style="padding-top: 30px; padding-bottom: 15px;">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/product">Home</a></li>
                                <%
                                    if (!pagename.equals("All")) {
                                        out.print(
                                                printBreadcrumb(productList.get(0).getProductTypeID())
                                        );
                                    }
                                %>
                            <li class="breadcrumb-item active" aria-current="page">page <%= pageI%> of <%= pages%></li>
                        </ol>
                    </nav>
                    <div class="row">
                        <div class="card-columns">
                            <% for (Product product : productList) {%>
                            <div class="card">
                                <h5 class="card-header">Featured</h5>
                                <img class="card-img-top" src="/drive/img/items.jpg" alt="Lab" style="width: 100%" />
                                <div class="card-body">
                                    <h4 class="card-title"><%= product.getProductName()%></h4>
                                    <h6 class="card-subtitle mb-2 text-muted">Type <%= Navbar.util.isProductTypeName(product.getProductTypeID())%></h6>
                                    <p class="card-text"><%= product.getProductDetail()%></p>
                                    <p class="card-text text-right">&#3647;<%= view.formatCurrency(product.getProductPrice())%></p>
                                    <p class="card-text text-right"><%= product.getProductStock()%> Piece</p>
                                    <p class="text-right">
                                        <a class="btn btn-light " href="/product/getProduct/<%= product.getProductID()%>"><i class="fas fa-info-circle"></i> More Details</a>
                                        <a class="btn btn-primary" href="/cart/add/<%= product.getProductID()%>"><i class="fas fa-cart-plus"></i> Add to Cart</a>
                                    </p>
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>
                    <%
                        out.print(view.printPage("/product/getProduct/" + pagename, pages, pageI));
                    %>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
