<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Model.ProductsDetail"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    Product productit = view.getAttObjects("product");
    List<ProductsDetail> productsDetails = view.getAttObjects("productsDetail");
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
        <style type="text/css">
            .one {
                width: 100%;
            }
        </style>
        <div class="container">
            <div class="row content">
                <div class="col-12">
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PRODUCT IMAGES MANAGEMENT</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Product ID </span>
                        <%= String.format("%011d", productit.getProductID())%>
                    </p>
                    <div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center"><i class="far fa-image" style="color: #90949c;"></i> Product Images</h5>
                                <form action="/officer/addImageProductForm" class="form-signin" method="post" enctype="multipart/form-data">
                                    <%
                                        if (productsDetails != null) {
                                            for (ProductsDetail productsDetail : productsDetails) {
                                    %>
                                    <img src="<%= view.printImage(productsDetail.getProductsDetailimage())%>" class="img-thumbnail img-fluid one" >
                                    <a href="/officer/removeImageProduct/<%= productit.getProductID() %>/<%= productsDetail.getProductsDetailid() %>" class="btn btn-warning one"><i class="fas fa-trash-alt"></i> remove</a>
                                    <div class="dropdown-divider"></div>
                                    <%
                                            }
                                        }
                                    %>
                                    <div class="custom-file" style="margin-bottom: 16px;">
                                        <input type="hidden" id="product_id" name="product_id" value="<%= productit.getProductID()%>">
                                        <input type="file" class="custom-file-input" id="inputFile" name="inputFile" required>
                                        <label class="custom-file-label" for="inputFile"><i class="fas fa-plus"></i> Add image</label>
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
    <script type="text/javascript">
        $(document).ready(function (){
            $('#inputFile').change(function () {
                if(this.files.length > 0){
                    this.form.submit();
                }
            });
        });
    </script>
</body>
</html>