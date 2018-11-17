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
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/videobg.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <% if (!view.isMobile()) { %>
        <div class="hvideo">
            <div class="overlay"></div>
            <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
                <source src="/drive/video/office/office.mp4" type="video/mp4">
                <source src="/drive/video/office/office.webm" type="video/webm"> 
                <source src="/drive/video/office/office.ogv" type="video/ogg"> 
                <source src="/drive/video/office/office.3gp" type="video/3gp">
            </video>
            <div class="container h-100">
                <div class="d-flex text-center h-100">
                    <div class="my-auto w-100 text-white">
                        <h1 class="display-3">Atom <i class="fas fa-dove"></i>S<i>oft</i> Co., Ltd</h1>
                        <h2>The Best Solution For You</h2>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <%@include file="../_carousel.jsp" %>
        <div class="container-fluid">
            <div class="container" style="padding-top: 30px; padding-bottom: 15px;">
                <div class="card-columns">
                    <%
                        if (request.getAttribute("product") != null) {
                            List<Product> productList = (List<Product>) request.getAttribute("product");
                            for (Product product : productList) {
                    %>
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
                                <a class="btn btn-light " href="/product/getProduct/<%= product.getProductID()%>"><i class="fas fa-info-circle"></i> More Detail</a>
                                <a class="btn btn-primary" href="/cart/add/<%= product.getProductID()%>"><i class="fas fa-cart-plus"></i> Add</a>
                            </p>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
            <div class="row"  style="height: 600px; background-color: #F4F4F4;">
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #ED9BA1"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #ADC9C7"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #2C2C2C"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #E5C268"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #DDDBDC"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #ACBE8A"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #B0B2BC"></div>
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3" style="background-color: #03A4B6"></div>
            </div>
            <div class="row paral paralsecSolution">
                <div class="col text-center align-items-center major_top" style="height:380px;">
                    <span class="w-100">
                        <h1>The Best Solution For You</h1>
                    </span>
                </div>
            </div>
            <div class="row"  style="height: 500px; background-color: #FEFEFE;"></div>
            <div class="row"  style="height: 500px; background-color: #F4F4F4;"></div>
            <div class="row"  style="height: 500px; background-color: #FEFEFE;"></div>
            <div class="row"  style="height: 500px; background-color: #F4F4F4;"></div>
            <div class="row"  style="height: 500px; background-color: #FEFEFE;"></div>
            <div class="row paral paralsec">
                <div class="col text-center align-items-center major_top" style="height:380px;">
                    <span class="w-100">
                        <h1>The Best Solution For You</h1>
                    </span>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
