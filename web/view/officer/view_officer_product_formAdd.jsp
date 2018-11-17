<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
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
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PRODUCT MANAGEMENT</p>
                    <div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center"><i class="fas fa-plus" style="color: #90949c;"></i> Add Product</h5>
                                <form action="/officer/addProductForm" class="form-signin" method="post" enctype="multipart/form-data">
                                    <div class="form-label-group">
                                        <input 
                                            type="number" 
                                            id="productType_id" 
                                            name="productType_id" 
                                            class="form-control"
                                            placeholder="Product Type"
                                            required 
                                            >
                                        <label for="productType_id">Product Type</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input 
                                            type="text" 
                                            id="product_name" 
                                            name="product_name" 
                                            class="form-control"
                                            placeholder="Product Name"
                                            required 
                                            >
                                        <label for="product_name">Product Name</label>
                                    </div>
                                    <div class="form-label-group">
                                        <div class="addon">
                                            &#3647;
                                        </div>
                                        <input 
                                            type="number" 
                                            id="product_price" 
                                            name="product_price" 
                                            class="form-control icon" 
                                            placeholder="Product Price"
                                            required 
                                            >
                                        <label for="product_price">Product Price</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input 
                                            type="number" 
                                            id="product_stock" 
                                            name="product_stock" 
                                            class="form-control" 
                                            placeholder="Product Stock"
                                            required 
                                            >
                                        <label for="product_stock">Product Stock</label>
                                    </div>
                                    <div class="form-label-group">
                                        <textarea 
                                            id="product_detail" 
                                            name="product_detail" 
                                            class="form-control" 
                                            placeholder="Product Detail"
                                            required></textarea>
                                    </div>
                                    <!--Submit Button-->
                                    <div class="form-label-group">
                                        <button 
                                            id="registerSubmit" 
                                            name="submit" 
                                            type="submit" 
                                            value="submit" 
                                            class="btn btn-lg btn-primary text-uppercase"
                                            style="width: 100%;">Add Product 
                                            <i class="fas fa-plus"></i>
                                        </button>
                                    </div>
                                </form>
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