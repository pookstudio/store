/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Gail
 */
public class ProductWishlist extends Product{
    
    private final Wishlist wishlist;

    public ProductWishlist() {
        wishlist = new Wishlist();
    }

    public Integer getWishlistId() {
        return wishlist.getWishlistId();
    }

    public void setWishlistId(Integer wishlistId) {
        wishlist.setWishlistId(wishlistId);
    }

    public Date getWishlistDate() {
        return wishlist.getWishlistDate();
    }

    public void setWishlistDate(Date wishlistDate) {
        wishlist.setWishlistDate(wishlistDate);
    }
    
}
