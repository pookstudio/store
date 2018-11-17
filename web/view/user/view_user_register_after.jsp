<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="PokoSystem.PokoView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    boolean addStatus = view.getAttBoolean("addStatus");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container" style="margin-top: 10px; min-height: 400px;">
            <% if (addStatus) { %>
            <div class="alert alert-success" role="alert">
                Success.
            </div>
            <% } else { %>
            <div class="alert alert-danger" role="alert">
                Unsuccess.
            </div>
            <% } %>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
