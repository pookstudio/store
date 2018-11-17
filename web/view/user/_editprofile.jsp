<%@page import="Model.User"%>
<%@page import="PokoSystem.PokoView"%>
<%
    PokoView view = new PokoView(request, response);
    User user = view.getAttObjects("user");
%>
<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">EDIT PROFILE <i class="far fa-file-alt"></i></p>
<div class="col-sm-10 col-md-9 col-lg-7 mx-auto">
    <div class="card card-signin my-5">
        <div class="card-body">
            <h5 class="card-title text-center">Basic Information</h5>
            <form class="form-signin" method="post">
                <!--Firstname Lastname-->
                <div class="form-label-group">
                    <input 
                        type="text" 
                        id="inputFirstname" 
                        name="inputFirstname" 
                        class="form-control" 
                        placeholder="Firstname" 
                        value="<%= user.getFirstname()%>" 
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
                        value="<%= user.getLastname()%>"
                        required>
                    <label for="inputLastname">Lastname</label>
                </div>
                <!--Gender-->
                <div class="form-label-group">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons" style="width: 100%;">
                        <label class="btn btn-info <%= (user.getGender() == 0) ? "active" : "" %>" style="width: 50%;">
                            <input 
                                type="radio" 
                                name="inputGender" 
                                id="genderm" 
                                autocomplete="off" 
                                <% if (user.getGender() == 0) {
                                        out.print("checked");
                                    } %> 
                                value="0"><i class="fas fa-mars"></i> Male
                        </label>
                        <label class="btn btn-info <%= (user.getGender() == 1) ? "active" : "" %>" style="width: 50%;">
                            <input 
                                type="radio" 
                                name="inputGender" 
                                id="genderw" 
                                autocomplete="off" 
                                <% if (user.getGender() == 1) {
                                        out.print("checked");
                                    }%> 
                                value="1"><i class="fas fa-venus"></i> Female
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
                        value="<%= user.getBirthday()%>"
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
                        value="<%= user.getTelephone()%>"
                        required>
                    <label for="inputTelephone">Telephone</label>
                </div>
                <!-- Submit -->
                <div class="form-label-group">
                    <button 
                        id="registerSubmit" 
                        name="submit" 
                        type="submit" 
                        value="submit" 
                        class="btn btn-lg btn-primary text-uppercase"
                        style="width: 100%;">Save 
                        <i class="fas fa-save"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>