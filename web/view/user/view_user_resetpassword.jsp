<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="PokoSystem.PokoView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center"><i class="fas fa-user-md"></i> Reset password</h5>
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
                                <button name="submit" value="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Send <i class="far fa-paper-plane fa-lg"></i></button>
                            </form>
                        </div></div>
                </div>
            </div>
            <div class="card-columns">
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
    </body>
</html>
