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
        </style>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container container-long">
            <div class="row content">
                <div class="col-12 content-top">
                    <h3 style="color: #4b4f56;"><i class="fas fa-cog" style="color: #ACB2BB;"></i>&nbsp;Setting</h3>
                </div>
                <div class="col-sm-12 col-md-4 col-lg-3 col-self-left">
                    <ul>
                        <li><a id="overview" class="before-active activeee" href="#">Overview</a></li>
                        <li><a id="editprofile" class="before-active" href="#">Order History</a></li>
                    </ul>
                </div>
                <div id="pages" class="col col-self-right">
                    
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                var loadingText = '<div id=\"loader\"></div>';
                $('#overview').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                    type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=overview',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#editprofile').removeClass('activeee');
                            $('#changepassword').removeClass('activeee');
                            $('#deliveryaddress').removeClass('activeee');
                            $('#overview').addClass('activeee');
                        }
                    });
                });
                $('#editprofile').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                    type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=editprofile',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#overview').removeClass('activeee');
                            $('#changepassword').removeClass('activeee');
                            $('#deliveryaddress').removeClass('activeee');
                            $('#editprofile').addClass('activeee');
                        }
                    });
                });
                $('#changepassword').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                    type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=changepassword',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#overview').removeClass('activeee');
                            $('#editprofile').removeClass('activeee');
                            $('#deliveryaddress').removeClass('activeee');
                            $('#changepassword').addClass('activeee');
                        }
                    });
                });
                $('#deliveryaddress').click(function (event) {
                    event.preventDefault();
                    $('#pages').append(loadingText);
                    $.ajax({
                    type: 'POST',
                        url: '/user/getProfileAjax',
                        data: 'data=deliveryaddress',
                        success: function (data) {
                            $('#pages').html(data);
                            $('#overview').removeClass('activeee');
                            $('#editprofile').removeClass('activeee');
                            $('#changepassword').removeClass('activeee');
                            $('#deliveryaddress').addClass('activeee');
                        }
                    });
                });
            });
        </script>
    </body>
</html>
