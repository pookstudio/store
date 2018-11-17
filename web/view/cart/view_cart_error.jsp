<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.CartError"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    int errorID = view.getAttInteger("errorID");
    CartError error = new CartError();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container" style="margin-top: 40px; margin-bottom: 40px; min-height: 400px;">
            <% if (errorID == error.ErrorLimitOver) { %>
                you have item in cart > 10 item
            <% } else if (errorID == error.ErrorNoItem) { %>
                YOU not have item in cart
            <% } else if (errorID == error.ErrorDelete) { %>
                Delete item in Cart Unsuccess.
            <% } %>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
