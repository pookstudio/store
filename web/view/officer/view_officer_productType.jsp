<%@page import="Model.OrderStatus"%>
<%@page import="Model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    int confirm = view.getAttInteger("order_confirm");
    int payment = view.getAttInteger("order_payment");
    int pay = view.getAttInteger("order_pay");
    List<Orders> orderses = view.getAttObjects("orders");
    OrderStatus orderStatus = new OrderStatus();
%>
<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">OFFICER INFORMATION</p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Confirm</span><%= confirm%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Payment</span><%= payment%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Pay</span><%= pay%></p>


<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">ORDER INFORMATION</p>
<p style="color: #90949c; min-width: 150px; display: inline-block;">
<% if (orderses != null) { %>
<div class="table-responsive">
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Order ID</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
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
                <td>
                    <%
                        if(orders.getOrderStatus() == orderStatus.StatusConfirmOrder) {
                            out.print("Confirm Order");
                        } else if (orders.getOrderStatus() == orderStatus.StatusPayment) {
                            out.print("Inform Payment");
                        } else if (orders.getOrderStatus() == orderStatus.StatusPay) {
                            out.print("Paid");
                        } else {
                            out.print("?");
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<% } else { %>
<p class="text-center">Includes 0 items</p>
<% }%>
</p>