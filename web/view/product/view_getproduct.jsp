<%-- 
    Document   : view_product
    Created on : Oct 19, 2018, 1:04:44 AM
    Author     : Gail
--%>
<%@page import="Model.Product"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    Product productOne = view.getAttObjects("product");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <style type="text/css">
        .content {
            background-color: #FEFEFE;
            padding: 30px 15px 15px 15px;
        }
    </style>
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
        <div class="container content">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/product">Home</a></li>
                        <%= printBreadcrumb(productOne.getProductTypeID())%>
                    <li class="breadcrumb-item active" aria-current="page"><%= productOne.getProductName()%></li>
                </ol>
            </nav>
            <div class="row">
                <div class="col-6">
                    <div id="carouselProduct" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-slide-number="0">
                                <img class="d-block w-100" src="http://placehold.it/770x300&text=one" alt="First slide">
                            </div>
                            <div class="carousel-item" data-slide-number="1">
                                <img class="d-block w-100" src="http://placehold.it/770x300&text=two" alt="Second slide">
                            </div>
                            <div class="carousel-item" data-slide-number="2">
                                <img class="d-block w-100" src="http://placehold.it/770x300&text=three" alt="Third slide">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <h4><%= productOne.getProductName()%></h4>
                    <p><%= productOne.getProductDetail()%></p>
                    <p>&#3647;<%= view.formatCurrency(productOne.getProductPrice())%></p>
                    <p><%= productOne.getProductStock()%></p>
                    <p><%= productOne.getProductDate()%></p>
                </div>
            </div>
            <ul class="row justify-content-center" id="slider-thumbs" style="list-style: none; margin: 20px 0 20px -55px;">
                <li class="col-sm-2">
                    <a id="carousel-selector-0"><img class="img-thumbnail" src="http://placehold.it/170x100&text=one"></a>
                </li>
                <li class="col-sm-2">
                    <a id="carousel-selector-1"><img class="img-thumbnail" src="http://placehold.it/170x100&text=two"></a>
                </li>
                <li class="col-sm-2">
                    <a id="carousel-selector-2"><img class="img-thumbnail" src="http://placehold.it/170x100&text=three"></a>
                </li>
            </ul>
            <div class="row justify-content-between">
                <div class="col-12">
                    <a class="btn btn-primary" href="/cart/add/<%= productOne.getProductID()%>"><i class="fas fa-cart-plus"></i> Add to Cart</a>
                    <a class="btn btn-info" href="/user/wishlist/add/<%= productOne.getProductID()%>"><i class="fas fa-heart"></i> Add to Wishlist</a>
                </div>
            </div>
        </div>
    <%@include file="../_footer.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#carouselProduct').carousel({
                interval: 10000
            });
            $('[id^=carousel-selector-]').click( function(){
            var id = this.id.substr(this.id.lastIndexOf("-") + 1);
            var idgo = parseInt(id);
            $('#carouselProduct').carousel(idgo);
        });
        });
    </script>
</body>
</html>
