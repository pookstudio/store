<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="Model.Address.SubdistrictsAndZipcodes"%>
<%@page import="Model.Address.Districts"%>
<%@page import="Model.Address.Geography"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView"%>
<%@page import="Model.Address.Provinces"%>
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
        <style type="text/css">
            select.input-lg {
                -webkit-appearance: none;
                -moz-appearance: none;
                -o-appearance: none;
                appearance: none;
            }

            select + i.fas {
                float: right;
                margin-top: -30px;
                margin-right: 25px;
                pointer-events: none;
                background-color: #fff;
                /*padding-right: 5px;*/
            }
        </style>
        <div class="container">
            <div class="row">
                <% if(addStatus) { %>
                <div class="">Increase Delivery Address success.</div>
                <% } else { %>
                <div class="">Increase Delivery Address Unsuccess.</div>
                <% } %>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
