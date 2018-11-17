<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.PaymentMethod"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<PaymentMethod> paymentMethods = view.getAttObjects("paymentMethods");
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

                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PAYMENT METHOD INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Payment</span>
                        <%
                            if (paymentMethods != null) {
                                out.print(paymentMethods.size());
                            } else {
                                out.print("0");
                            }
                        %>
                    </p>


                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">PAYMENT METHOD MANAGEMENT</p>
                    <p style="color: #90949c; min-width: 150px; display: inline-block;">
                        <% if (paymentMethods != null) { %>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Bank</th>
                                    <th scope="col">Account</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Manage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (PaymentMethod paymentMethod : paymentMethods) {
                                %>
                                <tr>
                                    <td><%= String.format("%02d", paymentMethod.getPaymentMethodid())%></td>
                                    <td><%= paymentMethod.getPaymentMethodnamebank()%></td>
                                    <td><%= paymentMethod.getPaymentMethodaccount()%></td>
                                    <td><%= paymentMethod.getPaymentMethodnameaccount()%></td>
                                    <td>edit</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <% } else { %>
                    <p class="text-center">Includes 0 method</p>
                    <% }%>
                    </p>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>