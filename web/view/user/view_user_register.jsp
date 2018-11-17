<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="Model.UserRegisterError"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView"%>
<%@page import="Model.UserRegister"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    UserRegister userRegister = view.getAttObjects("userRegister");
    List<Integer> errorID = view.getAttObjects("errorID");
    UserRegisterError error = new UserRegisterError();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
        <link href="/drive/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <%
            if (errorID.size() > 0 && !errorID.get(0).equals(error.ErrorNotError)) {
                out.print("<div class=\"container\" style=\"margin-top: 10px;\">");
                out.print("<div class=\"alert alert-danger\" role=\"alert\">");
                out.print("Error input data.");
                out.print("</div>");
                out.print("</div>");
            }
        %>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center"><i class="fas fa-user-plus"></i> Register</h5>
                            <form class="form-signin" method="post">
                                <!--Firstname Lastname-->
                                <div class="form-label-group">
                                    <input 
                                        type="text" 
                                        id="inputFirstname" 
                                        name="inputFirstname" 
                                        class="form-control" 
                                        placeholder="Firstname" 
                                        <%
                                            if (userRegister != null) {
                                                if (userRegister.getFirstname() != null) {
                                                    out.print("value=\"" + userRegister.getFirstname() + "\" ");
                                                }
                                            }
                                        %>
                                        required>
                                    <label for="inputFirstname">Firstname</label>
                                </div>
                                <div class="form-label-group">
                                    <input 
                                        type="text" 
                                        id="inputLastname" 
                                        name="inputLastname" 
                                        class="form-control" 
                                        placeholder="Lastname" 
                                        <%
                                            if (userRegister != null) {
                                                if (userRegister.getLastlame() != null) {
                                                    out.print("value=\"" + userRegister.getLastlame() + "\" ");
                                                }
                                            }
                                        %>
                                        required>
                                    <label for="inputLastname">Lastname</label>
                                </div>
                                <!--Email-->
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
                                        <%
                                            if (userRegister != null) {
                                                if (userRegister.getEmail() != null) {
                                                    out.print("value=\"" + userRegister.getEmail() + "\" ");
                                                }
                                            }
                                        %>
                                        required>
                                    <label for="inputEmail">Email address</label>
                                </div>
                                <!--Password-->
                                <div class="form-label-group" id="show_hide_password">
                                    <input 
                                        type="password" 
                                        id="inputPassword" 
                                        name="inputPassword" 
                                        class="form-control icon" 
                                        placeholder="Password" 
                                        pattern=".{8,32}"
                                        required title="8 to 32 characters">
                                    <label for="inputPassword">Password</label>
                                    <div class="addon">
                                        <a href="#"><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                                <div class="form-label-group" id="show_hide_password">
                                    <input type="password" id="inputCpassword" class="form-control" placeholder="Confirm password" required>
                                    <label for="inputCpassword">Confirm password</label>
                                </div>
                                <!--Gender-->
                                <%
                                    String male = "";
                                    String female = "";
                                    String maleActive = "";
                                    String femaleActive = "";
                                    if (userRegister != null) {
                                        if (userRegister.getGender() != null) {
                                            if (userRegister.getGender() == 0) {
                                                male = "checked ";
                                                maleActive = "active";
                                            } else {
                                                female = "checked ";
                                                femaleActive = "active";
                                            }
                                        } else {
                                            male = "checked ";
                                            maleActive = "active";
                                        }
                                    } else {
                                        male = "checked ";
                                        maleActive = "active";
                                    }
                                %>
                                <div class="form-label-group">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons" style="width: 100%;">
                                        <label class="btn btn-info <%= maleActive%>" style="width: 50%;">
                                            <input 
                                                type="radio" 
                                                name="inputGender" 
                                                id="genderm" 
                                                autocomplete="off" 
                                                <%= male %>
                                                value="0">
                                            <i class="fas fa-mars"></i> Male
                                        </label>
                                                <label class="btn btn-info <%= femaleActive%>" style="width: 50%;">
                                            <input 
                                                type="radio" 
                                                name="inputGender" 
                                                id="genderw" 
                                                autocomplete="off" 
                                                <%= female %>
                                                value="1">
                                            <i class="fas fa-venus"></i> Female
                                        </label>
                                    </div>
                                </div>
                                <!--Birthday-->
                                <div class="form-label-group">
                                    <div class="addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input 
                                        id="birthday" 
                                        name="inputBirthday" 
                                        class="form-control icon datepicker" 
                                        placeholder="Birthday" 
                                        data-provide="datepicker" 
                                        <%
                                            if (userRegister != null) {
                                                if (userRegister.getBirthday() != null) {
                                                    out.print("value=\"" + userRegister.getBirthday() + "\" ");
                                                }
                                            }
                                        %>
                                        required>
                                    <label for="birthday">Birthday</label>

                                </div>
                                <!--Telephone-->
                                <div class="form-label-group">
                                    <div class="addon">
                                        <i class="fas fa-phone"></i>
                                    </div>
                                    <input 
                                        type="tel" 
                                        id="inputTelephone" 
                                        name="inputTelephone" 
                                        class="form-control icon" 
                                        placeholder="Telephone" 
                                        minlength="9" maxlength="14" 
                                        pattern="^[0-9-+s()]*$" 
                                        <%
                                            if (userRegister != null) {
                                                if (userRegister.getTelephone() != null) {
                                                    out.print("value=\"" + userRegister.getTelephone() + "\" ");
                                                }
                                            }
                                        %>
                                        required>
                                    <label for="inputTelephone">Telephone</label>
                                </div>
                                <!-- Submit -->
                                <div class="custom-control custom-checkbox mb-3">
                                    <input 
                                        type="checkbox" 
                                        class="custom-control-input" 
                                        id="acceptsPolicy" 
                                        <%
                                            if (userRegister != null) {
                                                out.print("checked ");
                                            }
                                        %>
                                        required="true">
                                    <label class="custom-control-label">Accept <span class="btn-link" data-toggle="modal" data-target="#policy">privacy policy</span> and terms</label>
                                </div>
                                <div class="btn-group" role="group" style="width: 100%;">
                                    <button 
                                        id="registerSubmit" 
                                        name="submit" 
                                        type="submit" 
                                        value="submit" 
                                        class="btn btn-lg btn-primary text-uppercase" 
                                        style="width: 70%;">Register 
                                        <i class="fas fa-user-plus"></i>
                                    </button>
                                    <button 
                                        class="btn btn-lg btn-warning text-uppercase" 
                                        type="reset" style="width: 30%;"
                                        onclick="document.getElementById('inputFirstname').focus();">Reset 
                                        <i class="fas fa-undo d-none d-sm-inline"></i>
                                    </button>
                                </div>
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="view_user_register_policy.jsp" %>
        <%@include file="../_footer.jsp" %>
        <script src="/drive/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script type="text/javascript">
                                            $(document).ready(function () {
                                                $('#show_hide_password a').on('click', function (event) {
                                                    event.preventDefault();
                                                    if ($('#show_hide_password input').attr("type") === "text") {
                                                        $('#show_hide_password input').attr('type', 'password');
                                                        $('#show_hide_password i').addClass("fa-eye-slash");
                                                        $('#show_hide_password i').removeClass("fa-eye");
                                                    } else if ($('#show_hide_password input').attr("type") === "password") {
                                                        $('#show_hide_password input').attr('type', 'text');
                                                        $('#show_hide_password i').removeClass("fa-eye-slash");
                                                        $('#show_hide_password i').addClass("fa-eye");
                                                    }
                                                    $(this).parent().parent().children('input').focus();
                                                });
                                                /*-----Check password-----*/
                                                var password = document.getElementById("inputPassword")
                                                        , confirm_password = document.getElementById("inputCpassword");

                                                function validatePassword() {
                                                    if (password.value !== confirm_password.value) {
                                                        confirm_password.setCustomValidity("Passwords Don't Match");
                                                    } else {
                                                        confirm_password.setCustomValidity('');
                                                    }
                                                }
                                                password.onchange = validatePassword;
                                                confirm_password.onkeyup = validatePassword;
                                                /*-----EndCheck password-----*/

                                                /*-----Date birthday-----*/
                                                var year = new Date().getFullYear();
                                                $('#birthday').datepicker({
                                                    format: 'dd-mm-yyyy',
                                                    autoclose: true,
                                                    clearBtn: true,
                                                    daysOfWeekHighlighted: "0,6",
                                                    startView: 2,
                                                    defaultViewDate: {
                                                        year: year - 20,
                                                        month: 0,
                                                        day: 0
                                                    },
                                                    startDate: '-80y',
                                                    endDate: '-15y'
                                                });
                                                /*-----EndDate birthday-----*/
                                            });
                                            function accept() {
                                                $('#acceptsPolicy').prop('checked', true);
                                            }
                                            function unaccept() {
                                                $('#acceptsPolicy').prop('checked', false);
                                            }
        </script>
    </body>
</html>
