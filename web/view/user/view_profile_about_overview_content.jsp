<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 20px;">BASIC INFORMATION</p>
<p><span style="color: #90949c; min-width: 80px; display: inline-block;">Name</span><%= user.getFirstname()%>&nbsp;&nbsp;&nbsp;<%= user.getLastname()%></p>
<p><span style="color: #90949c; min-width: 80px; display: inline-block;">Email</span><%= user.getEmail()%></p>
<p><span style="color: #90949c; min-width: 80px; display: inline-block;">Gender</span><%
    if (user.getGender() == 0) {
        out.print("Male <i class=\"fas fa-mars fa-1x\"></i>");
    } else {
        out.print("Femal <i class=\"fas fa-venus fa-1x\"></i>");
    }
    %></p>


<p style="border-bottom: 1px solid #dddfe2; color: #90949c; font-weight: 600; margin-top: 40px;">CONTACT INFORMATION</p>
<p><span style="color: #90949c; display: inline-block; min-width: 40px;">&nbsp;&nbsp;<i class="fas fa-mobile"></i></span><%= user.getTelephone().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3")%></p>
<p><span style="color: #90949c; display: inline-block; min-width: 40px;">&nbsp;&nbsp;<i class="fas fa-birthday-cake"></i></span><%= user.getBirthday()%></p>