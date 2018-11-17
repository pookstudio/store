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
        <style type="text/css">
            body {
                background-color: white;
            }
        </style>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <div class="container" style="background-color: #ffffff;">
            <div class="row" style="min-height: 200px;">

            </div>
            <div class="row text-center">
                <div class="col">
                    <h3 class="align-center text-muted"><i class="fas fa-map-marked-alt"></i> Find Us Here</h3>
                </div>
            </div>
        </div>

        <!---------------------------------------- Start GoogleMap ---------------------------------------->
        
        <style>
            #map{
                width: 100%;
                height: 25rem;
                /*                -webkit-filter: grayscale(100%);
                                -moz-filter: grayscale(100%);
                                -ms-filter: grayscale(100%);
                                -o-filter: grayscale(100%);
                                filter: gray;
                                background-color: grey;*/
            }
        </style>
        <div id="map"></div>
        <script>
            function myMap() {
                var uluru = {
                    lat: 13.7548119,
                    lng: 100.6192582
                };
                var map = new google.maps.Map(
                        document.getElementById('map'), {
                    zoom: 17,
                    center: uluru
                });
                var marker = new google.maps.Marker({
                    position: uluru,
                    map: map
                });
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCEyC0vwB2cwRCtbaKwJQIAvHWa5YHH2PQ&callback=myMap">
        </script>
        
        <!---------------------------------------- End GoogleMap ---------------------------------------->

        <%@include file="../_footer.jsp" %>
    </body>
</html>
