<style type="text/css">
    .activeee {
        font-weight: bold;
        border-left: 4px solid #666666;
    }
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
    .border-box {
        border: 0.5px solid #dddfe2;
        border-radius: 3px;
        background-color: #FEFEFE;
    }
    .content {
        margin-top: 10px;
        margin-bottom: 10px;
        padding: 15px;
        background-color: #FEFEFE;
        border: 1px solid #ccd0d5;
        border-radius: 3px;
    }
    .content-top {
        padding: 10px;
        background-color: #FEFEFE;
        border: 1px solid #ccd0d5;
        border-top: none;
        border-radius: 0 0 3px 3px;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col-12 content-top">
            <h3 style="color: #4b4f56;"><i class="fas fa-laptop-code" style="color: #ACB2BB;"></i>&nbsp;Officer</h3>
            <nav class="navbar navbar-expand-lg navbar-light">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/officer">Officer</a></li>
                    <li class="nav-item"><a class="nav-link" href="/officer/orders">Orders</a></li>
                    <li class="nav-item dropdown">
                        <a 
                            class="nav-link dropdown-toggle" 
                            href="#" 
                            id="navbarDropdownProduct" 
                            role="button" 
                            data-toggle="dropdown" 
                            aria-haspopup="true" 
                            aria-expanded="false">Products</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownProduct">
                            <a class="dropdown-item" href="/officer/product">Product All</a>
                            <a class="dropdown-item" href="/officer/productType">Product Types</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/officer/deliveryMethods">Delivery Method</a></li>
                    <li class="nav-item"><a class="nav-link" href="/officer/paymentMethods">Payment Method</a></li>
                    <li class="nav-item"><a class="nav-link" href="/officer/promotions">Promotions</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>