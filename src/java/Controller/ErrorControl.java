package Controller;

import PokoSystem.PokoController;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        urlPatterns = {"/404", "/error"}
)
public class ErrorControl extends PokoController {

    @Override
    public void main() {
        Integer errorID = getParameterInteger("errorID");
        if (errorID != null) {
            request.setAttribute("errorID", errorID);
        } else {
            request.setAttribute("errorID", error.ErrorGeneral);
        }
        view("error/view_error");
    }

}
