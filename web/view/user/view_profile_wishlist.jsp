<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.ProductWishlist"%>
<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    User user = view.getAttObjects("user");
    List<ProductWishlist> productWishlists = view.getAttObjects("productwishlist");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= request.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            li > a {
                display: block;
                color: #90949c;
                padding: 8px 16px;
                text-decoration: none;
            }

            /* Change the link color on hover */
            li > a:hover {
                color: #000;
                text-decoration: none;
            }
            .before-active {
                border-left: 4px solid #FEFEFE;
            }
            .activeee {
                font-weight: bold;
                border-left: 4px solid #666666;
            }
            /* ------ Animation ------*/
            #loader {
                position: absolute;
                left: 50%;
                top: 110px;
                z-index: 1;
                margin: -40px 0 0 -40px;
                border: 16px solid #f3f3f3;
                border-radius: 50%;
                border-top: 16px solid #3498db;
                width: 80px;
                height: 80px;
                -webkit-animation: spin 2s linear infinite;
                animation: spin 2s linear infinite;
            }

            @-webkit-keyframes spin {
                0% { -webkit-transform: rotate(0deg); }
                100% { -webkit-transform: rotate(360deg); }
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }
            .content-wishlist {
                margin: 15px 0;
                padding: 10px 0;
                border-radius: 3px;
                background-color: #2B3D4F;
                color: #FEFEFE;
            }
            .product-action {
                background-color: rgba(1,1,1,0.5);
                border-radius: 3px;
                padding: 2px;
                display: inline-block;
                float: right;
            }
            .product-createdate {
                display: inline-block;
                float: right;
            }
        </style>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container container-long">
            <div class="row content">
                <div class="col-12 content-top" style="background-color: #FEFEFE;">
                    <h3 style="color: #4b4f56;"><i class="fas fa-heart" style="color: #ACB2BB;"></i>&nbsp;Wishlist</h3>
                </div>
                <div id="pages" class="col">
                    <%                        
                        if (productWishlists != null) {
                            for (ProductWishlist productWishlist : productWishlists) {
                    %>
                    <div class="row content-wishlist">
                        <div class="col-sm-12 col-md-6">
                            <img 
                                src="/drive/img/items.jpg" 
                                class="img-fluid" 
                                style="width: 400px; height: 200px;" 
                                alt="Products">
                        </div>
                        <div class="col-sm-12 col-md-6">
                            <p><%= productWishlist.getProductName()%></p>
                            <p>RELEASE DATE: <%= productWishlist.getProductDate()%></p>
                            <p>Tag</p>
                        </div>
                        <div class="col align-self-end">
                            <div class="product-action">
                                <span style="padding: 0 10px;">&#3647;<%= view.formatCurrency(productWishlist.getProductPrice())%></span> 
                                <a href="/product/getProduct/<%= productWishlist.getProductID()%>" class="btn btn-info">View Details</a>
                                <a href="/cart/add/<%= productWishlist.getProductID()%>" class="btn btn-success">Add to Cart</a>
                            </div>
                                <div class="product-createdate">Added on <%= productWishlist.getWishlistDate()%>
                                    (<a href="/user/wishlist/remove/<%= productWishlist.getProductID()%>">remove</a>)
                                </div>
                        </div>
                    </div>
                    <%                        
                            }
                        } else {
                    %>
                    <div class="row content-wishlist" style="padding: 10px;">
                    Includes 0 items
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {

            });
        </script>
    </body>
</html>
