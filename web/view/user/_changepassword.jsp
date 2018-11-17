<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">CHANGE PASSWORD <i class="fas fa-shield-alt"></i></p>
<div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
    <div class="card card-signin my-5">
        <div class="card-body">
            <h5 class="card-title text-center"><i class="fas fa-user-lock" style="color: #90949c;"></i> Password</h5>
            <form class="form-signin" method="post">
                <!--Password-->
                <div class="form-label-group" id="show_hide_password">
                    <input 
                        type="password" 
                        id="inputPassword" 
                        name="inputPassword" 
                        class="form-control icon" 
                        placeholder="New Password" 
                        pattern=".{8,32}"
                        required title="8 to 32 characters">
                    <label for="inputPassword">New Password</label>
                    <div class="addon">
                        <a href="#"><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                    </div>
                </div>
                <div class="form-label-group" id="show_hide_password">
                    <input 
                        type="password" 
                        id="inputCpassword" 
                        class="form-control" 
                        placeholder="Confirm new password" 
                        required>
                    <label for="inputCpassword">Confirm new password</label>
                </div>
                <div class="form-label-group">
                    <button 
                        id="registerSubmit" 
                        name="submit" 
                        type="submit" 
                        value="submit" 
                        class="btn btn-lg btn-primary text-uppercase"
                        style="width: 100%;">Change Password 
                        <i class="fas fa-check-double"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
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
    });
</script>