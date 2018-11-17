<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.OrderStatus"%>
<%@page import="Model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<Orders> orderses = view.getAttObjects("orders");
    OrderStatus orderStatus = new OrderStatus();
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
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">ORDERS INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Confirm</span>
                        <%
                            if (orderses != null) {
                                out.print(orderses.size());
                            } else {
                                out.print("0");
                            }
                        %>
                    </p>

                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">ORDERS MANAGEMENT</p>
                    <p style="color: #90949c; min-width: 150px; display: inline-block;">
                        <% if (orderses != null) { %>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Order ID</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Manage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int countTable = 1;
                                    for (Orders orders : orderses) {
                                %>
                                <tr>
                                    <th scope="row"><%= countTable++%></th>
                                    <td><%= String.format("%011d", orders.getOrderId())%></td>
                                    <td><%= orders.getOrderDate()%></td>
                                    <td><a class="btn btn-info" href="/officer/getPaymentDetail/<%= orders.getOrderId()%>"><i class="fas fa-search-plus"></i>view</a></td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <% }%>
                    </p>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>