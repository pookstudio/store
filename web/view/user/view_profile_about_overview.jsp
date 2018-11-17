<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    User user = view.getAttObjects("user");
%>
<%@include file="view_profile_about_overview_content.jsp" %>