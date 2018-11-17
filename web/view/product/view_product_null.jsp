<%-- 
    Document   : view_product
    Created on : Oct 19, 2018, 1:04:44 AM
    Author     : Gail
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
        <style type="text/css">
            body {
                background-color: #FEFEFE;
            }
        </style>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="container" style="padding-top: 30px; padding-bottom: 15px; min-height: 400px;">
                    No item in system.
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
