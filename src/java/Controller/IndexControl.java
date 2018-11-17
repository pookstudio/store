package Controller;

import PokoSystem.PokoController;
import Service.ProductService;
import javax.servlet.annotation.WebServlet;

@WebServlet("/index/*")
public class IndexControl extends PokoController {

    ProductService productService = new ProductService();
    
    @Override
    public void main() {
        request.setAttribute("product", productService.getProduct(3));
        view("index/view_index");
    }

}
