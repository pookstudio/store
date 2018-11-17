<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    int size = view.getAttInteger("order_size");
    int confirm = view.getAttInteger("order_confirm");
    int payment = view.getAttInteger("order_confirm");
    int pay = view.getAttInteger("order_pay");
    int success = view.getAttInteger("order_success");
    int cancel = view.getAttInteger("order_cancel");
%>
<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">PAYMENT INFORMATION</p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Total</span><%= size%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Confirm</span><%= confirm%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Payment</span><%= payment%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order pay</span><%= pay%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Success</span><%= success%></p>
<p><span style="color: #90949c; min-width: 150px; display: inline-block;">Order Cancel</span><%= cancel%></p>


<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">GRAPH INFORMATION</p>