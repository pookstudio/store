<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>
<%@page import="Model.Payment"%>
<%@page import="PokoSystem.PokoView" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    boolean after = view.getAttBoolean("after");
    String paymentpage = view.getAttString("paymentpage");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= request.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_navigation.jsp" %>
        <%@include file="_top.jsp" %>
        <div class="container">
            <div class="row content">
                <div class="col-12">
                    <p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">ORDER INFORMATION</p>
                    <span class="text-center">
                        <h4>
                            <%
                                if (paymentpage.equals("confirm")) {
                                    if (after) {
                                        out.print("Confirm Success");
                                    } else {
                                        out.print("Confirm Fail");
                                    }
                                } else {
                                    if (after) {
                                        out.print("Cancel Success");
                                    } else {
                                        out.print("Cancel Fail");
                                    }
                                }
                            %>
                        </h4>
                    </span>
                </div>
            </div>
        </div>
            <%@include file="../_footer.jsp" %>
    </body>
</html>