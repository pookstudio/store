/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gail
 */
public class Cart extends Product{
    
    private int quanity;
    private ProductsDetail productsDetail;

    public Cart() {
        quanity = 0;
        productsDetail = new ProductsDetail();
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public byte[] getProductsDetailimage() {
        return productsDetail.getProductsDetailimage();
    }

    public void setProductsDetailimage(byte[] productsDetailimage) {
        productsDetail.setProductsDetailimage(productsDetailimage);
    }

    
}
