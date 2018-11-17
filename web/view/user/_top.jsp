<style type="text/css">
    .navbar-me {
        padding: 0;
        background-color: #FEFEFE;
        border-radius: 0 0 3px 3px;
    }
    .nav-link-me {
        padding-top: 1rem;
        padding-bottom: 1rem;
    }
    .navbar > ul > li {
        border-right: 1px solid #e9eaed;
    }
    .navbar > ul > li.active{
        background-color: #F5F6F7;
        font-weight: bold;
    }
    .nav-link-me:hover , .nav-link-me:active {
        background-color: #F5F6F7;
    }
    .border-box {
        border: 0.5px solid #dddfe2;
        border-radius: 3px;
        background-color: #FEFEFE;
    }
    .container-main {
        padding: 10px 0;
    }
    .container-long {
        padding: 0;
    }
    .content {
        margin: 10px 0;
        background-color: #FEFEFE;
        border: 1px solid #ccd0d5;
        border-radius: 3px;
    }
    .content-top {
        padding: 10px;
        background-color: #f5f6f7;
        border-radius: 3px 3px 0 0;
    }
    .col-left {

    }
    @media (min-width: 768px) {
        .col-right {
            margin-left: 10px;
        }   
    }
    .col-self-left {
        padding: 15px;
        border-right: 1px solid #ccc;
        border-top: 1px solid #ccc;
    }
    .col-self-right {
        padding: 15px;
        border-top: 1px solid #ccc;
    }
    .profile-picture {
        position: absolute;
        width: 168px;
        height: 168px;
        border: 4px solid #ffffff;
        border-radius: 100%;
    }
    .profile-picture-box {
        position: relative;
        bottom: 138px;
        left: 16px;
    }
    .profile-top {
        background: url('/drive/img/profile.jpg');
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col" style="padding-left: 0; padding-right: 0;">
            <div class="col-12 profile-top">
                <div class="col-12" style="min-height: 300px;">
                </div>
                <div class="row d-none d-sm-flex">
                    <div class="col" style="max-width: 200px;"></div>
                    <div class="col" style="color: white; padding-bottom: 15px;">
                        <h3><%= view.firstLetterCaps(user.getFirstname())%></h3>
                    </div>
                </div>
            </div>
            <nav class="navbar navbar-expand-lg navbar-light border-box navbar-me">
                <ul class="navbar-nav w-100">
                    <li class="nav-item" style="min-width: 200px;">
                        <span class="profile-picture-box">
                            <a href="#" style="text-decoration: none;">
                                <img 
                                    class="profile-picture" 
                                    alt="picture profile" 
                                    <%
                                        if (user.getGender() == 0) {
                                            out.print("src=\"/drive/img/avatar/man_avatar.png\" ");
                                        } else {
                                            out.print("src=\"/drive/img/avatar/women_avatar.png\" ");
                                        }
                                    %>
                                    />&nbsp;
                            </a>
                        </span>
                    </li>
                    <%!
                        public String printNavItem(boolean tf) {
                            if (tf) {
                                return "<li class=\"nav-item active\">";
                            } else {
                                return "<li class=\"nav-item\">";
                            }
                        }
                    %>
                    <%= printNavItem(view.isPathInfo("null"))%>
                    <a class="nav-link nav-link-me" href="/user">&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <%= printNavItem(view.isPathInfo("/profile"))%>
                    <a class="nav-link nav-link-me" href="/user/profile">&nbsp;&nbsp;&nbsp;About&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <%= printNavItem(view.isPathInfo("/wishlist"))%>
                    <a class="nav-link nav-link-me" href="/user/wishlist">&nbsp;&nbsp;&nbsp;Wishlist&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <%= printNavItem(view.isPathInfo("/confirmpay"))%>
                    <a class="nav-link nav-link-me" href="/user/confirmpay">&nbsp;&nbsp;&nbsp;Confirm Payment&nbsp;&nbsp;&nbsp;</a>
                    </li> 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle nav-link-me" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            &nbsp;&nbsp;&nbsp;More&nbsp;&nbsp;&nbsp;
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/user/order">Order</a>
                            <a class="dropdown-item" href="/user/setting">Setting</a>
                            <% if(user.getLevel() > 7) { %>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/officer">Console <i class="fas fa-terminal"></i></a>
                            <% } %>
                        </div>
                    </li>
                </ul>
            </nav> 
        </div>
    </div>
</div>