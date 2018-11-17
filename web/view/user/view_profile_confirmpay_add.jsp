<%@page import="Model.PaymentMethod"%>
<%@page import="java.util.List"%>
<%@page import="Model.Orders"%>
<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    List<Orders> orderses = view.getAttObjects("orders");
    List<PaymentMethod> paymentMethods = view.getAttObjects("paymentMethods");
%>
<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">CONFIRM PAYMENT</p>
<div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
    <div class="card card-signin my-5">
        <div class="card-body">
            <h5 class="card-title text-center"><i class="far fa-credit-card" style="color: #90949c;"></i> Payment</h5>
            <%
                if (orderses != null) {
            %>
            <form action="/user/setPaymentAjax" id="informPayment" class="form-signin" method="post" enctype="multipart/form-data">
                <!--List Order-->
                <div class="form-label-group">
                    <select class="form-control input-lg" id="inputOrderConfirm" name="inputOrderConfirm" required>
                        <%
                            for (Orders orders : orderses) {
                                out.print("<option value=\"" + orders.getOrderId() + "\">" + String.format("%011d", orders.getOrderId()) + " (" + orders.getOrderDate() + ") " + "</option>");
                            }
                        %>
                    </select>
                    <i class="fas fa-chevron-down"></i>
                    <label for="inputOrderConfirm" style="width: fit-content; padding-right: 0;">
                        Order ID</label>
                </div>
                <!--Radio Bank-->
                <%
                    for (PaymentMethod paymentMethod : paymentMethods) {
                %>
                <div class="custom-control custom-radio">
                    <input 
                        type="radio" 
                        id="<%= paymentMethod.getPaymentMethodnamebank() + paymentMethod.getPaymentMethodid()%>" 
                        name="paymentMethod" 
                        value="<%= paymentMethod.getPaymentMethodid()%>" 
                        class="custom-control-input"
                        required>
                    <label class="custom-control-label" for="<%= paymentMethod.getPaymentMethodnamebank()+ paymentMethod.getPaymentMethodid()%>">
                        <p><%= paymentMethod.getPaymentMethodnamebank()%></p>
                    </label>
                </div>
                <%
                    }
                %>
                <div class="form-label-group">
                    <div class="addon">
                        &#3647;
                    </div>
                    <input 
                        type="number" 
                        id="inputAmount" 
                        name="inputAmount" 
                        class="form-control icon" 
                        step="0.01"
                        placeholder="Amount of Money"
                        required 
                        >
                    <label for="inputAmount">Amount of Money</label>
                </div>
                <div class="form-label-group">
                    <div class="addon">

                    </div>
                    <input 
                        type="text" 
                        id="inputDate" 
                        name="inputDate" 
                        class="form-control icon" 
                        data-provide="datepicker" 
                        placeholder="Date" 
                        required 
                        >
                    <label for="inputDate">Date</label>
                </div>
                <div class="form-label-group">
                    <div class="addon">

                    </div>
                    <input 
                        type="time" 
                        id="inputTime" 
                        name="inputTime" 
                        class="form-control icon" 
                        placeholder="Time 24hr" 
                        required 
                        >
                    <label for="inputTime">Time 24hr</label>
                </div>
                <!--File Images-->
                <div class="custom-file" style="margin-bottom: 16px;">
                    <input type="file" class="custom-file-input" id="inputFile" name="inputFile" required>
                    <label class="custom-file-label" for="inputFile">Choose image</label>
                </div>
                <!--Submit Button-->
                <div class="form-label-group">
                    <button 
                        id="registerSubmit" 
                        name="submit" 
                        type="submit" 
                        value="submit" 
                        class="btn btn-lg btn-primary text-uppercase"
                        style="width: 100%;">Confirm Payment 
                        <i class="fas fa-check-double"></i>
                    </button>
                </div>
            </form>
            <% } else { %>
            <span class="text-center"><h4>Includes 0 order</h4></span>
            <% }%>
        </div>
    </div>
</div>