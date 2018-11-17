<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    boolean orderCommit = view.getAttBoolean("orderCommit");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container" style="margin-top: 40px; margin-bottom: 40px;">
            <div class="row">
                <% if (orderCommit) { %>
                    Order Commit
                <% } else { %>
                    Order Rollback
                <% } %>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
