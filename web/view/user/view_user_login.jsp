<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="PokoSystem.PokoView"%>
<%@page import="Model.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    int errorID = view.getAttInteger("errorID");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <i class="fas fa-user-circle fa-10x text-center" style="width: 100%; color: #777777;"></i>
                            <p><h5 class="card-title text-center">Sign In</h5></p>
                            <%
                                if (errorID > 0) {
                            %>
                            <div class="container">
                                <div class="alert alert-danger" role="alert">
                                    Incorrect email or password.
                                </div>
                            </div>
                            <%
                                }
                            %>
                            <form class="form-signin" method="post">
                                <div class="form-label-group">
                                    <div class="addon">
                                        <i class="fas fa-at"></i>
                                    </div>
                                    <input 
                                        type="email" 
                                        id="inputEmail" 
                                        name="inputEmail" 
                                        class="form-control icon" 
                                        placeholder="Email address" 
                                        pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" 
                                        required autofocus>
                                    <label for="inputEmail">Email address</label>
                                </div>
                                <div class="form-label-group" id="show_hide_password">
                                    <input type="password" id="inputPassword" name="inputPassword" class="form-control icon" placeholder="Password" required>
                                    <label for="inputPassword">Password</label>
                                    <div class="addon">
                                        <a href="#"><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                                <div class="custom-control custom-checkbox mb-3">
                                    &nbsp;&nbsp;<input type="checkbox" class="custom-control-input" id="signed" name="signed">
                                    <label class="custom-control-label" for="signed"><i class="far fa-clock" style="color: #777777;"></i> Stay signed in</label>
                                </div>
                                <button name="submit" value="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in <i class="fas fa-sign-in-alt"></i></button>
                                <hr class="my-4">
                                <a class="btn btn-link" href="/user/resetpassword"><i class="fas fa-user-check"></i> Forgot Your Password?</a>
                                <a class="btn btn-link" href="/user/register"><i class="fas fa-user-plus"></i> Register</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#show_hide_password a').on('click', function (event) {
                    event.preventDefault();
                    if ($('#show_hide_password input').attr("type") === "text") {
                        $('#show_hide_password input').attr('type', 'password').focus();
                        $('#show_hide_password i').addClass("fa-eye-slash");
                        $('#show_hide_password i').removeClass("fa-eye");
                    } else if ($('#show_hide_password input').attr("type") === "password") {
                        $('#show_hide_password input').attr('type', 'text').focus();
                        $('#show_hide_password i').removeClass("fa-eye-slash");
                        $('#show_hide_password i').addClass("fa-eye");
                    }
                });
            });
        </script>
    </body>
</html>
