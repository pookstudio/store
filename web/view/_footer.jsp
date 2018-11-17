<style type="text/css">
    .foot-head {
        margin-top: 20px;
        padding-left: 25px;
        color: #858D95;
    }
    .foot-link {
        color: #dee2e6;
        text-decoration: none;
    }
    .foot-link > h6 > i {
        text-align: center;
        width: 25px;
        color: #33393F;
        transition: all .1s ease-in;
    }
    .foot-link:hover > h6 > i,
    .foot-link:active > h6 > i {
        color: #EBF2F8;
    }
    .foot-link:visited, .foot-link:hover, .foot-link:active {
        text-decoration: none;
        color: #EBF2F8;
    }
</style>
<footer>
    <div class="container-fluid h-100" style="background-color: #202428;">
        <div class="row d-flex h-100" style="background-color: #33393F; padding: 48px;">
            <div class="container">
                <div class="row align-items-start">
                    <div class="align-self-start col-12 col-sm-6 col-md-6 col-lg-3">
                        <h6 class="foot-head">PROJECT</h6>
                        <a class="foot-link" href="#" ><h6><i class="far fa-newspaper"></i>Updates</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-code"></i>Code</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="far fa-file-alt"></i>License</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fab fa-github"></i>GitHub Project</h6></a>
                    </div>
                    <div class="align-self-start col-12 col-sm-6 col-md-6 col-lg-3">
                        <h6 class="foot-head">LINK & PRODUCTS</h6>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-link"></i>Promotions</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-link"></i>Hardware</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-link"></i>Software</h6></a>
                    </div>
                    <div class="align-self-start col-12 col-sm-6 col-md-6 col-lg-3">
                        <h6 class="foot-head">SUPPORT</h6>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-wrench"></i>Troubleshooting</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="far fa-question-circle"></i>Common Questions</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-bug"></i>Report a Bug</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fas fa-headset"></i>Get Help</h6></a>
                    </div>
                    <div class="align-self-start col-12 col-sm-6 col-md-6 col-lg-3">
                        <h6 class="foot-head">COMPANY</h6>
                        <a class="foot-link" href="mailto:5905501200@rumail.ru.ac.th?subject=H1,codetom" ><h6><i class="far fa-envelope"></i>Contact Us</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fab fa-facebook-f"></i>Facebook</h6></a>
                        <a class="foot-link" href="#" ><h6><i class="fab fa-twitter"></i>Twitter</h6></a>
                    </div>
                </div>
            </div>
        </div>
        <span class="text-muted span_footer text-center copyright">
            Copyright &copy; 2018, Code<i class="fas fa-code"></i>tom. All Rights Reserved. 
            <a href="http://admin.codetom.xyz:8080" style="color: #777777;"><i class="fas fa-laptop-code"></i></a>
        </span>
    </div>
</footer>
<script src="/drive/js/jquery-3.3.1.min.js" type="text/javascript" ></script>
<script src="/drive/js/popper.min.js" type="text/javascript" ></script>
<script src="/drive/js/bootstrap.min.js" type="text/javascript" ></script>
<script type="text/javascript">
    $(document).ready(function () {
        var scroll_start = 0;
        var startchange = $('nav');
        var offset = startchange.offset();
        if (startchange.length) {
            /*$(document).scroll(function () {
             scroll_start = $(this).scrollTop();
             if (scroll_start > offset.top) {
             $(".top_top").css('margin-bottom', startchange.outerHeight());
             $('nav').addClass('fixed-top');
             } else {
             $(".top_top").css('margin-bottom', '0px');
             $('nav').removeClass('fixed-top');
             }
             });*/
            $(document).scroll(function () {

            });
        }
        $('.dropdown-menu a.dropdown-toggle').on('click', function (e) {
            if (!$(this).next().hasClass('show')) {
                $(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
            }
            var $subMenu = $(this).next(".dropdown-menu");
            $subMenu.toggleClass('show');


            $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function (e) {
                $('.dropdown-submenu .show').removeClass("show");
            });
            return false;
        });
    });
    /*
     $(window).on('scroll', function(){
     if($(window).scrollTop()){
     $('nav').addClass('fixed-top');
     }else{
     $('nav').removeClass('black');
     }
     })*/
</script>