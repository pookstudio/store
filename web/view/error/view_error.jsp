<%-- 
    Document   : view_error
    Created on : Sep 24, 2018, 8:18:55 PM
    Author     : Gail
--%>

<%@page import="PokoSystem.PokoError"%>
<%@page import="PokoSystem.PokoView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    int errorID = view.getAttInteger("errorID");
    PokoError error = new PokoError();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body style="background-color: #232323;">
        <%@include file="../_navigation.jsp" %>
        <div class="container text-center">
            <div class="row" style="min-height: 400px;">
            <% if (errorID == error.ErrorGeneral) { %>
            <img src="<%= view.getContextPath() %>/public/img/503.png" class="img-fluid" alt="Not Found" />
            <span style="color: white;">
                <h1>Page Not Found</h1>
            </span>
            <% } else if (errorID == error.ErrorView) { %>
            <span style="color: white;">
                <h1>Programmer Error (VIEW)</h1>
            </span>
            <% } %>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
