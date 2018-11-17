<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    User user = view.getAttObjects("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container">
            <div class="row container-main">
                <div class="col-sm-12 col-md-4 col-xl-3 border-box col-left">
                    left
                    <div style="min-height: 500px;"></div>
                </div>
                <div class="col border-box col-right">
                    right
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
