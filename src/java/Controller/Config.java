/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Gail
 */
public class Config {
    
    public static String DATABASE = "mydb";
    public static String DATABASE_ADDRESS = "addressDelivery";
    
    public static String TABLE_ORDERS = "orders";
    public static String TABLE_ORDERS_ITEM = "ordersItem";
    public static String TABLE_ORDERS_DETAIL = "ordersDetail";
    public static String TABLE_USER = "user";
    public static String TABLE_PRODUCT = "products";
    public static String TABLE_PRODUCTS_DETAIL = "productsDetail";
    public static String TABLE_PRODUCTTYPE = "productsType";
    public static String TABLE_DELIVERY_METHOD = "deliveryMethod";
    public static String TABLE_DELIVERY_ADDRESS = "deliveryAddress";
    public static String TABLE_WISHLIST = "wishlist";
    public static String TABLE_PAYMENT_METHOD = "paymentMethod";
    public static String TABLE_PAYMENT = "payment";
    
    public static String TABLE_ADDRESS_GEOGRAPHIES = "geography";
    public static String TABLE_ADDRESS_PROVINCES = "provinces";
    public static String TABLE_ADDRESS_DISTRICTS = "districts";
    public static String TABLE_ADDRESS_SUBDISTRICTS = "subdistricts";
    public static String TABLE_ADDRESS_ZIPCODES = "zipcodes";
    
    public static int COOKIE_DAYS = 15;
    public static int MAXIMUM_ADDRESS = 4;
    public static int PAGES_LIMIT = 6;
    
    public static String DBMS_URL = "jdbc:mysql://127.0.0.1:3306/?characterEncoding=utf-8";
    public static String DBMS_USER = "tom";
    public static String DBMS_PASS = "Naruepon@9";

    private Config() {
        
    }
    
}
