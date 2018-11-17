/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import Model.Product;
import Model.ProductsDetail;
import PokoSystem.PokoService;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gail
 */
public class ProductService extends PokoService {

    public List<Product> getProduct(int limit) {
        try {
            connect(DBConnection.getConnection());
            List<Product> productList = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " ORDER BY product_id DESC LIMIT ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, limit);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                product.setProductTypeID(rs.getInt("productType_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductStock(rs.getInt("product_stock"));
                product.setProductDetail(rs.getString("product_detail"));
                product.setProductDate(rs.getDate("product_date"));
                if (productList == null) {
                    productList = new ArrayList<>();
                }
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Product> getProductAll(int limit, int offset) {
        try {
            connect(DBConnection.getConnection());
            List<Product> productList = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " ORDER BY product_id DESC LIMIT ? OFFSET ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, limit);
            pst.setInt(2, offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                product.setProductTypeID(rs.getInt("productType_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductStock(rs.getInt("product_stock"));
                product.setProductDetail(rs.getString("product_detail"));
                product.setProductDate(rs.getDate("product_date"));
                if (productList == null) {
                    productList = new ArrayList<>();
                }
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Product> getProductType(String productType_name, int limit, int offset) {
        try {
            connect(DBConnection.getConnection());
            List<Product> productList = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " WHERE productType_id = "
                    + " ( SELECT productType_id "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTTYPE
                    + " WHERE productType_name = ? AND product_stock > 0 ) "
                    + " ORDER BY product_id DESC LIMIT ? OFFSET ?;";
            pst = con.prepareStatement(qry);
            pst.setString(1, productType_name);
            pst.setInt(2, limit);
            pst.setInt(3, offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                product.setProductTypeID(rs.getInt("productType_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductStock(rs.getInt("product_stock"));
                product.setProductDetail(rs.getString("product_detail"));
                product.setProductDate(rs.getDate("product_date"));
                if (productList == null) {
                    productList = new ArrayList<>();
                }
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public Product getProductID(int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " WHERE product_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, product_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                product.setProductTypeID(rs.getInt("productType_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductStock(rs.getInt("product_stock"));
                product.setProductDetail(rs.getString("product_detail"));
                product.setProductDate(rs.getDate("product_date"));
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public List<ProductsDetail> getProductsDetail(int product_id) {
        try {
            connect(DBConnection.getConnection());
            List<ProductsDetail> productsDetails = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTS_DETAIL
                    + " WHERE product_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, product_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductsDetail productsDetail = new ProductsDetail();
                productsDetail.setProductsDetailid(rs.getInt("productsDetail_id"));
                productsDetail.setProductsDetailimage(rs.getBlob("productsDetail_image").getBytes(1, (int) rs.getBlob("productsDetail_image").length()));
                productsDetail.setProductsDetaildate(rs.getDate("productsDetail_date"));
                productsDetail.setProductId(rs.getInt("product_id"));
                if (productsDetails == null) {
                    productsDetails = new ArrayList<>();
                }
                productsDetails.add(productsDetail);
            }
            return productsDetails;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public int getProductCount(String productType_name) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT count(product_id) "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " WHERE productType_id = "
                    + " (SELECT productType_id "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTTYPE
                    + " WHERE productType_name = ?);";
            pst = con.prepareStatement(qry);
            pst.setString(1, productType_name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            close();
        }
    }
    
    public boolean updateProduct(int product_id, int productType_id, String product_name, float product_price, int product_stock, String product_detail) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " SET "
                    + " productType_id = ?, "
                    + " product_name = ?, "
                    + " product_price = ?, "
                    + " product_stock = ?, "
                    + " product_detail = ? "
                    + " WHERE product_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, productType_id);
            pst.setString(2, product_name);
            pst.setFloat(3, product_price);
            pst.setInt(4, product_stock);
            pst.setString(5, product_detail);
            pst.setInt(6, product_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public boolean addProduct(int productType_id, String product_name, float product_price, int product_stock, String product_detail) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " (productType_id, product_name, product_price, product_stock, product_detail) "
                    + " VALUES (?, ?, ?, ?, ?) ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, productType_id);
            pst.setString(2, product_name);
            pst.setFloat(3, product_price);
            pst.setInt(4, product_stock);
            pst.setString(5, product_detail);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public int addProductReturnLastID(int productType_id, String product_name, float product_price, int product_stock, String product_detail) {
        try {
            connect(DBConnection.getConnection());
            setAutoCommit(false);
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT
                    + " (productType_id, product_name, product_price, product_stock, product_detail) "
                    + " VALUES (?, ?, ?, ?, ?) ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, productType_id);
            pst.setString(2, product_name);
            pst.setFloat(3, product_price);
            pst.setInt(4, product_stock);
            pst.setString(5, product_detail);
            int row = pst.executeUpdate();
            
            qry = "SELECT LAST_INSERT_ID();";
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            int last_id = 0;
            if(rs.next()) {
                last_id = rs.getInt(1);
            }
            con.commit();
            return last_id;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        } finally {
            close();
        }
    }
    
    public boolean addImageProduct(InputStream productsDetail_image, int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTS_DETAIL
                    + " (productsDetail_image, product_id) "
                    + " VALUES (?, ?) ;";
            pst = con.prepareStatement(qry);
            pst.setBlob(1, productsDetail_image);
            pst.setInt(2, product_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public int getProductCountAll() {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT count(product_id) "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            return 0;
        } finally {
            close();
        }
    }
    
    public boolean removeImageProduct(int productsDetail_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "DELETE FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTS_DETAIL
                    + " WHERE productsDetail_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, productsDetail_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean existField(String table, String field, String name) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE
                    + ".? WHERE ? = ?;";
            pst = con.prepareStatement(qry);
            pst.setString(1, table);
            pst.setString(2, field);
            pst.setString(3, name);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

}
