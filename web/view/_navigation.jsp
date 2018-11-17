<%@page import="Controller.UserSession"%>
<%@page import="Model.ProductsType"%>
<%@page import="Model.Navbar"%>
<style type="text/css">
    .dropdown-submenu {
        position: relative;
    }

    .dropdown-submenu a::after {
        transform: rotate(-90deg);
        position: absolute;
        right: 6px;
        top: 0.8em;
    }

    .dropdown-submenu .dropdown-menu {
        top: 0;
        left: 100%;
    }
    .navbar-custom:focus {
        outline-color: #333333;
    }
    .mini-picture-profile {
        width: 20px;
        height: 20px;
        border-radius: 50%;
        vertical-align: sub;
    }
</style>
<%!
    public String firstLetterCaps(String data) {
        String firstLetter = data.substring(0, 1).toUpperCase();
        String restLetter = data.substring(1).toLowerCase();
        return firstLetter + restLetter;
    }
%>
<%
    UserSession userSession = new UserSession(request, response);
%>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark navbar-customer">
    <div class="container">
        <a href="/" class="navbar-brand">Atom <i class="fas fa-dove"></i>S<I>oft</I></a>
        <button class="navbar-toggler navbar-custom" data-toggle="collapse" data-target="#navbarMenu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a href="/product/promotion" class="nav-link">Promotion</a>
                </li>

                <li class="nav-item dropdown">
                    <a href="#" 
                       class="nav-link dropdown-toggle"
                       data-toggle="dropdown" 
                       aria-haspopup="true" 
                       aria-expanded="false"
                       id="navbarLink">Products</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarLink">
                        <li>
                            <a class="dropdown-item" href="/product/getProduct/All">
                                All Products
                            </a>
                        </li>
                        <%!
                            public String printNavbar(String productName, int productID) {
                                String out = "";
                                out += "<li class=\"dropdown-submenu\">";
                                out += "<a class=\"dropdown-item dropdown-toggle\" href=\"#\">";
                                out += "<i class=\"far fa-smile\"></i> ";
                                out += productName;
                                out += "</a>";
                                out += "<ul class=\"dropdown-menu\">";
                                for (ProductsType productsType : Navbar.util.getProductsList()) {
                                    if (productsType.getProductTypeSubset() == productID && Navbar.util.getCountSubset(productsType.getProductTypeid()) == 0) {
                                        out += "<li>"
                                                + "<a class=\"dropdown-item\" href=\"/product/getProduct/" + productsType.getProductTypename() + "\">"
                                                + productsType.getProductTypename()
                                                + "</a>"
                                                + "</li>";
                                    } else if (productsType.getProductTypeSubset() == productID) {
                                        out += printNavbar(productsType.getProductTypename(), productsType.getProductTypeid());
                                    }
                                }
                                out += "</ul>";
                                out += "</li>";
                                return out;
                            }
                        %>
                        <%
                            for (ProductsType product : Navbar.util.getProductsList()) {
                                if (product.getProductTypeSubset() == 0 && Navbar.util.getCountSubset(product.getProductTypeid()) == 0) {
                                    out.print("<li>"
                                            + "<a class=\"dropdown-item\" href=\"/product/getProduct/" + product.getProductTypename() + "\">"
                                            + product.getProductTypename()
                                            + "</a>"
                                            + "</li>");
                                } else if (product.getProductTypeSubset() == 0) {
                                    out.print(printNavbar(product.getProductTypename(), product.getProductTypeid()));
                                }
                            }
                        %>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="/contact" class="nav-link">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <% if (!userSession.isMember()) { %>
                <li class="nav-item">
                    <a href="/user/login" class="nav-link"><i class="fas fa-users"></i>&nbsp;Sign in</a>
                </li>
                <% } else {%>
                <li class="nav-item">
                    <a href="/cart" class="nav-link">
                        <i class="fas fa-shopping-cart"></i>&nbsp;Cart&nbsp;<span class="badge badge-secondary"><%= Navbar.util.getCountCartProduct(userSession.getID())%></span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a href="#" 
                       class="nav-link dropdown-toggle"
                       data-toggle="dropdown" 
                       aria-haspopup="true" 
                       aria-expanded="false"
                       id="navbarUser">
                        <img class="mini-picture-profile" alt="picture profile" src="/drive/img/avatar/man_avatar.png" />&nbsp;<%= firstLetterCaps(userSession.getFirstname())%></a>
                    <ul class="dropdown-menu" aria-labelledby="navbarUser">
                        <li><a class="dropdown-item" href="/user"><i class="far fa-address-card"></i> Profile</a></li>
                        <div class="dropdown-divider"></div>
                        <li><a class="dropdown-item" href="/user/logout"><i class="fas fa-sign-out-alt"></i> Sign out</a></li>
                    </ul>
                </li>
                <% }%>
            </ul>
        </div>
    </div>
</nav>