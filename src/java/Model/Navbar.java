/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Service.CartService;
import Service.NavbarService;
import java.util.List;

/**
 *
 * @author Gail
 */
public class Navbar {

    private List<ProductsType> productsTypes;
    public static Navbar util = new Navbar();

    protected NavbarService navbarService = new NavbarService();
    protected CartService cartService = new CartService();

    private Navbar() {
        if (productsTypes == null) {
            productsTypes = navbarService.getProductsType();
        }
    }

    public void updateNavbar() {
        productsTypes = navbarService.getProductsType();
    }

    public List<ProductsType> getProductsList() {
        return productsTypes;
    }

    public void setProductsList(List<ProductsType> productsTypes) {
        this.productsTypes = productsTypes;
    }

    public int getCountSubset(int subset) {
        int i = 0;
        i = productsTypes.stream().filter((productType) -> (productType.getProductTypeSubset() == subset)).map((_item) -> 1).reduce(i, Integer::sum);
        return i;
    }

    public int getSubsetFromTypeID(int productTypeID) {
        for (ProductsType productType : productsTypes) {
            if (productType.getProductTypeid() == productTypeID) {
                return productType.getProductTypeSubset();
            }
        }
        return -1;
    }

    public String isProductTypeName(int productTypeID) {
        for (ProductsType productType : productsTypes) {
            if (productType.getProductTypeid() == productTypeID) {
                return productType.getProductTypename();
            }
        }
        return null;
    }

    public int getCountCartProduct(int user_id) {
        OrderStatus cartStatus = new OrderStatus();
        return cartService.getCartCount(user_id, cartStatus.StatusBasket);
    }

}
