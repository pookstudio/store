<%-- 
    Document   : index
    Created on : Aug 25, 2018, 9:35:22 PM
    Author     : tom
--%>

<%@page import="Model.Address.SubdistrictsAndZipcodes"%>
<%@page import="Model.Address.Districts"%>
<%@page import="Model.Address.Geography"%>
<%@page import="java.util.List"%>
<%@page import="PokoSystem.PokoView"%>
<%@page import="Model.Address.Provinces"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PokoView view = new PokoView(request, response);
    List<Geography> geographys = view.getAttObjects("geo");
    List<Provinces> provinceses = view.getAttObjects("provinces");
    List<Districts> districtses = view.getAttObjects("districts");
    List<SubdistrictsAndZipcodes> subdistrictsAndZipcodeses = view.getAttObjects("subdistricts");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../_JsAndCss.jsp" %>
        <link href="<%= view.getContextPath()%>/public/css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../_top.jsp" %>
        <style type="text/css">
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
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center"><i class="fas fa-address-book"></i> Add Delivery Address</h5>
                            <form class="form-signin" method="post">
                                <!--Address-->
                                <div class="form-label-group">
                                    <div class="addon">
                                        <i class="far fa-keyboard"></i>
                                    </div>
                                    <input 
                                        type="text" 
                                        id="inputAddress" 
                                        name="inputAddress" 
                                        class="form-control icon" 
                                        placeholder="Address" 
                                        pattern=".{5,255}" 
                                        title="5 to 255 characters" 
                                        required 
                                        autofocus>
                                    <label for="inputAddress">
                                        Address</label>
                                </div>
                                <div class="form-label-group">
                                    <select class="form-control input-lg" id="inputProvince" name="inputProvince" required>
                                        <%
                                            out.print("<optgroup label=\"" + geographys.get(1).getGeoName() + "\">");
                                            for (Provinces provinces : provinceses) {
                                                if (provinces.getGeoId() == 2) {
                                                    out.print("<option value=\"" + provinces.getProvinceId() + "\">" + provinces.getProvinceNameTh() + "</option>");
                                                }
                                            }
                                            out.print("</optgroup>");
                                            for (Geography geography : geographys) {
                                                if (geography.getGeoId() != 2) {
                                                    out.print("<optgroup label=\"" + geography.getGeoName() + "\">");
                                                    for (Provinces provinces : provinceses) {
                                                        if (provinces.getGeoId() != 2 && provinces.getGeoId() == geography.getGeoId()) {
                                                            out.print("<option value=\"" + provinces.getProvinceId() + "\">" + provinces.getProvinceNameTh() + "</option>");
                                                        }
                                                    }
                                                    out.print("</optgroup>");
                                                }
                                            }

                                        %>
                                    </select>
                                    <i class="fas fa-chevron-down"></i>
                                    <label for="inputProvince" style="width: fit-content; padding-right: 0;">
                                        <i class="fas fa-map-marked-alt"></i> Provinces</label>
                                </div>
                                <div class="form-label-group">
                                    <select class="form-control input-lg" id="inputDistrict" name="inputDistrict" required>
                                        <%  for (Districts districts : districtses) {
                                                out.print("<option value=\"" + districts.getDistrictId() + "\">" + districts.getDistrictNameTh() + "</option>");
                                            }
                                        %>
                                    </select>
                                    <i class="fas fa-chevron-down"></i>
                                    <label for="inputDistrict" style="width: fit-content; padding-right: 0;"><i class="fas fa-map-signs"></i> Districts</label>
                                </div>
                                <div class="form-label-group">
                                    <select class="form-control input-lg" id="inputSubDistrict" name="inputSubDistrict" required>
                                        <%
                                            for (SubdistrictsAndZipcodes SAndZ : subdistrictsAndZipcodeses) {
                                                out.print("<option value=\"" + SAndZ.getSubdistrictCode() + "\">" + SAndZ.getSubdistrictNameTh()
                                                        + " (" + SAndZ.getZipcode() + ")" + "</option>");
                                            }
                                        %>
                                    </select>
                                    <i class="fas fa-chevron-down"></i>
                                    <label for="inputSubDistrict" style="width: fit-content; padding-right: 0;">
                                        <i class="fas fa-map-marker-alt"></i> SubDistricts</label>
                                </div>
                                <div class="btn-group" role="group" style="width: 100%;">
                                    <button 
                                        class="btn btn-lg btn-warning text-uppercase" 
                                        type="reset" 
                                        style="width: 30%;"
                                        onclick="clean()">Reset 
                                        <i class="fas fa-undo d-none d-sm-inline"></i>
                                    </button>
                                    <button 
                                        id="addAddress" 
                                        name="submit" 
                                        type="submit" 
                                        value="submit" 
                                        class="btn btn-lg btn-primary text-uppercase" 
                                        style="width: 70%;">ADD ADDRESS 
                                        <i class="fas fa-plus fa-1x"></i>
                                    </button>

                                </div>
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../_footer.jsp" %>
        <script type="text/javascript">
            function clean() {
                document.getElementById('inputAddress').focus();
                province();
            }
            function province() {
                $.ajax({
                    type: 'POST',
                    url: '/user/getAddressAjax',
                    data: 'province=' + 1,
                    success: function (html) {
                        $('#inputDistrict').html(html);
                        $.ajax({
                            type: 'POST',
                            url: '/user/getAddressAjax',
                            data: 'district=' + 1,
                            success: function (html) {
                                $('#inputSubDistrict').html(html);
                            }
                        });
                    }
                });
            }
            $(document).ready(function () {
                $('#inputProvince').on('change', function () {
                    var province = $(this).val();
                    if (province) {
                        $.ajax({
                            type: 'POST',
                            url: '/user/getAddressAjax',
                            data: 'province=' + province,
                            success: function (html) {
                                $('#inputDistrict').html(html);
                                $.ajax({
                                    type: 'POST',
                                    url: '/user/getAddressAjax',
                                    data: 'district=' + $('#inputDistrict').val(),
                                    success: function (html) {
                                        $('#inputSubDistrict').html(html);
                                    }
                                });
                            }
                        });
                    }
                });
                $('#inputDistrict').on('change', function () {
                    var district = $(this).val();
                    if (district) {
                        $.ajax({
                            type: 'POST',
                            url: '/user/getAddressAjax',
                            data: 'district=' + district,
                            success: function (html) {
                                $('#inputSubDistrict').html(html);
                            }
                        });
                    }
                });
            });
        </script>
    </body>
</html>
