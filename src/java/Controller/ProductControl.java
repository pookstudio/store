/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Service.ProductService;
import static java.lang.Math.ceil;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Gail
 */
@WebServlet("/product/*")
public class ProductControl extends PokoSystem.PokoController {

    protected ProductService productService = new ProductService();

    private final int LIMIT = Config.PAGES_LIMIT;

    @Override
    public void main() {
        view("product/view_home");
    }

    public void getProduct(Integer productId) {
        Product product = productService.getProductID(productId);
        if (product != null) {
            request.setAttribute("product", product);
            view("product/view_getproduct");
        } else {
            view("product/view_product_null");
        }
    }

    public void getProduct(String typeName) {
        getProduct(typeName, 1);
    }

    public void getProduct(String typeName, Integer page) {
        List<Product> products;
        if (typeName.equals("All")) {
            products = productService.getProductAll(LIMIT, LIMIT * (page - 1));
        } else {
            products = productService.getProductType(typeName, LIMIT, LIMIT * (page - 1));
        }
        if (products != null) {
            if (typeName.equals("All")) {
                request.setAttribute("pageTypeName", typeName);
                request.setAttribute("pages", getPages(productService.getProductCountAll()));
            } else {
                request.setAttribute("pageTypeName", typeName);
                request.setAttribute("pages", getPages(productService.getProductCount(typeName)));
            }
            request.setAttribute("page", page);
            request.setAttribute("product", products);
            view("product/view_product");
        } else {
            view("product/view_product_null");
        }
    }

    public void promotion() {
        request.setAttribute("product", productService.getProduct(10));
        view("product/view_promotion");
    }

    private int getPages(float productCount) {
        int pages = (int) ceil(productCount / LIMIT);
        return pages;
    }
}
