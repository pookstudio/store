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
        <link href="<%= request.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container">
            <div class="row content">
                <div class="col-12">
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">OFFICER INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;"> -- </span>-</p>


                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">OFFICER MANAGEMENT</p>
                    <p style="color: #90949c; min-width: 150px; display: inline-block;">
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
