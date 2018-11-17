<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.DeliveryMethod"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<DeliveryMethod> deliveryMethods = view.getAttObjects("deliveryMethods");
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
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">DELIVERY METHOD INFORMATION</p>
                    <p><span style="color: #90949c; min-width: 150px; display: inline-block;">Delivery Methods </span>
                        <%
                            if (deliveryMethods != null) {
                                out.print(deliveryMethods.size());
                            } else {
                                out.print("0");
                            }
                        %>
                    </p>
                    <a href="/officer/addDeliveryMethod" class="btn btn-info"><i class="fas fa-plus"></i> Add Delivery Method</a>

                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">DELIVERY METHOD MANAGEMENT</p>
                    <p style="color: #90949c; min-width: 150px; display: inline-block;">
                        <% if (deliveryMethods != null) { %>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col"><i class="far fa-image"></i></th>
                                    <th scope="col">Name</th>
                                    <th scope="col">&#3647;Price</th>
                                    <th scope="col">Manage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (DeliveryMethod deliveryMethod : deliveryMethods) {
                                %>
                                <tr>
                                    <td><%= String.format("%02d", deliveryMethod.getDeliveryMethodid())%></td>
                                    <td><img src="<%= view.printImage(deliveryMethod.getDeliveryMethodimage()) %>" style="width: 150px; height: 67px;" ></td>
                                    <td><%= deliveryMethod.getDeliveryMethodname()%></td>
                                    <td>&#3647;<%= view.formatCurrency(deliveryMethod.getDeliveryMethodprice())%></td>
                                    <td><a href="/officer/updateDeliveryMethod/<%= deliveryMethod.getDeliveryMethodid() %>" class="btn btn-info"><i class="fas fa-edit"></i>Edit</a></td>
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