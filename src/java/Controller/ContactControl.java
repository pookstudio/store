package Controller;

import javax.servlet.annotation.WebServlet;
import PokoSystem.PokoController;

@WebServlet("/contact/*")
public class ContactControl extends PokoController {

    @Override
    public void main() {
        me();
    }

    public void me() {
        view("contact/view_contact");
    }

}
