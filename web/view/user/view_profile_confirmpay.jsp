<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    User user = view.getAttObjects("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= request.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
        <link href="/drive/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            li > a {
                display: block;
                color: #90949c;
                padding: 8px 16px;
                text-decoration: none;
            }

            /* Change the link color on hover */
            li > a:hover {
                color: #000;
                text-decoration: none;
            }
            .before-active {
                border-left: 4px solid #FEFEFE;
            }
            .activeee {
                font-weight: bold;
                border-left: 4px solid #666666;
            }
            /* ------ Animation ------*/
            #loader {
                position: absolute;
                left: 50%;
                top: 110px;
                z-index: 1;
                margin: -40px 0 0 -40px;
                border: 16px solid #f3f3f3;
                border-radius: 50%;
                border-top: 16px solid #3498db;
                width: 80px;
                height: 80px;
                -webkit-animation: spin 2s linear infinite;
                animation: spin 2s linear infinite;
            }

            @-webkit-keyframes spin {
                0% { -webkit-transform: rotate(0deg); }
                100% { -webkit-transform: rotate(360deg); }
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
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
        </style>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container container-long">
            <div class="row content">
                <div class="col-12 content-top">
                    <h3 style="color: #4b4f56;"><i class="fas fa-check" style="color: #ACB2BB;"></i>&nbsp;Payment</h3>
                </div>
                <div class="col-sm-12 col-md-4 col-lg-3 col-self-left">
                    <ul>
                        <li><a id="overviewpayment" class="before-active" href="#">Overview</a></li>
                        <li><a id="addpayment" class="before-active" href="#">Add Confirm Payment</a></li>
                    </ul>
                </div>
                <div id="pages" class="col col-self-right">

                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
        <script src="/drive/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var loadingText = '<div id=\"loader\"></div>';
                $('#overviewpayment').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                        type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=overviewpayment',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#addpayment').removeClass('activeee');
                            $('#overviewpayment').addClass('activeee');
                        }
                    });
                });
                $('#addpayment').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                        type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=addpayment',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#overviewpayment').removeClass('activeee');
                            $('#addpayment').addClass('activeee');
                            /*-----Date birthday-----*/
                            var year = new Date().getFullYear();
                            $('#inputDate').datepicker({
                                format: 'dd-mm-yyyy',
                                autoclose: true,
                                clearBtn: true,
                                daysOfWeekHighlighted: "0,6"
                            });
                            /*-----EndDate birthday-----*/
                            /*$('form#informPayment').submit(function (event) {
                                event.preventDefault();
                                var formData = $('#informPayment').serialize();
                                console.log(formData);
                                $.ajax({
                                    url: $(this).attr('action'),
                                    data: formData,
                                    type: 'POST',
                                    cache: false,
                                    contentType: false,
                                    processData: false,
                                    success: function (data, textStatus, jqXHR) {
                                        alert(data);
                                    }
                                });
                            });*/
                        }
                    });
                });
            });
        </script>
    </body>
</html>
