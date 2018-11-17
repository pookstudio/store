<%@page import="java.util.List"%>
<%@page import="Model.DeliveryAddress"%>
<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    List<DeliveryAddress> deliveryAddress = view.getAttObjects("deliveryAddress");
%>
<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">DELIVERY ADDRESS <i class="far fa-building"></i></p>
<div class="col-sm-12 col-md-10 col-lg-9 mx-auto">
    <div class="card card-signin my-5">
        <div class="card-body">
            <h5 class="card-title text-center"><i class="fas fa-shipping-fast"></i> Delivery Address</h5>
            <%
                for (DeliveryAddress delivery : deliveryAddress) {
            %>
            <p>
                <span style="color: #90949c; min-width: 80px; display: inline-block;">
                    <i class="fas fa-address-book"></i> 
                    <%= delivery.getAddress()%> 
                    <%= delivery.getSubdistrictName()%> 
                    <%= delivery.getDistrictName()%> 
                    <%= delivery.getProvinceName()%> 
                    <%= delivery.getZipcode()%>
                </span>
            </p>
            <%
                }
            %>
        </div>
    </div>
</div>