/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Gail
 */
public class Product {
    
    protected Integer productID;
    protected Integer productTypeID;
    protected String productName;
    protected Float productPrice;
    protected Integer productStock;
    protected String productDetail;
    protected Date productDate;
    protected List<ProductsDetail> productsDetails;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(Integer productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String ProductDetail) {
        this.productDetail = ProductDetail;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public List<ProductsDetail> getProductsDetails() {
        return productsDetails;
    }

    public void setProductsDetails(List<ProductsDetail> productsDetails) {
        this.productsDetails = productsDetails;
    }
    

}
