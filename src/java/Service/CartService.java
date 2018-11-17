/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import Model.Cart;
import Model.DeliveryMethod;
import Model.OrdersDetail;
import Model.OrdersItem;
import PokoSystem.PokoService;
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
public class CartService extends PokoService {

    public List<Cart> getCartProduct(int user_id, int order_status) {
        try {
            connect(DBConnection.getConnection());
            List<Cart> carts = null;
            String qry = "SELECT p.*, o_s.quantity "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS + " o_m "
                    + " JOIN "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM + " o_s "
                    + " ON o_m.order_id = o_s.order_id "
                    + " JOIN "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT + " p "
                    + " ON o_s.product_id = p.product_id "
                    + " WHERE o_m.user_id = ? AND o_m.order_status = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, order_status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setProductID(rs.getInt("product_id"));
                cart.setProductTypeID(rs.getInt("productType_id"));
                cart.setProductName(rs.getString("product_name"));
                cart.setProductPrice(rs.getFloat("product_price"));
                cart.setProductStock(rs.getInt("product_stock"));
                cart.setProductDetail(rs.getString("product_detail"));
                cart.setQuanity(rs.getInt("quantity"));
//                cart.setProductsDetailimage(rs.getBlob("productsDetail_image").getBytes(1, (int) rs.getBlob("productsDetail_image").length()));
                if (carts == null) {
                    carts = new ArrayList<>();
                }
                carts.add(cart);
            }
            return carts;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public byte[] getImageProduct(int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT productsDetail_image "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTS_DETAIL
                    + " WHERE product_id = ? LIMIT 1;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, product_id);
            ResultSet rs = pst.executeQuery();
            byte[] image = null;
            if(rs.next()) {
                image = rs.getBlob("productsDetail_image").getBytes(1, (int) rs.getBlob("productsDetail_image").length());
            }
            return image;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public boolean exitCartStatus(int user_id, int order_status) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " WHERE user_id = ? AND order_status = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, order_status);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean addNewCart(int user_id) {
        try {
            connect(DBConnection.getConnection());
            setAutoCommit(false);
            String qry;

            /* SQL statement 1 */
            qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " (user_id) "
                    + " VALUE (?);";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.executeUpdate();

            /* SQL statement 2 */
            qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_DETAIL
                    + " (order_id) "
                    + " VALUE (LAST_INSERT_ID());";
            pst = con.prepareStatement(qry);
            pst.executeUpdate();

            con.commit();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } finally {
            close();
        }
    }

    public boolean addCartProduct(int order_id, int product_id, int quantity) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " (order_id, product_id, quantity) "
                    + " VALUE (?, ?, ?);";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            pst.setInt(2, product_id);
            pst.setInt(3, quantity);
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean updateCartProduct(int order_id, int product_id, int quantity) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " SET quantity = ? "
                    + " WHERE order_id = ? AND product_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, quantity);
            pst.setInt(2, order_id);
            pst.setInt(3, product_id);
            int updateState = pst.executeUpdate();
            return updateState == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean deleteCartProduct(int order_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "DELETE "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " WHERE order_id = ? AND product_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            pst.setInt(2, product_id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public int getCartCount(int user_id, int order_status) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT count(*) "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS + " o_m "
                    + " JOIN "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM + " o_s "
                    + " ON o_m.order_id = o_s.order_id "
                    + " WHERE o_m.user_id = ? AND o_m.order_status = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, order_status);
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

    public List<OrdersItem> getOrderItem(int order_id) {
        try {
            connect(DBConnection.getConnection());
            List<OrdersItem> ordersItems = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " WHERE order_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrdersItem ordersItem = new OrdersItem(
                        rs.getInt("orderItem_id"),
                        rs.getInt("quantity"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"));
                if (ordersItems == null) {
                    ordersItems = new ArrayList<>();
                }
                ordersItems.add(ordersItem);
            }
            return ordersItems;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public boolean existItem(int order_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " WHERE order_id = ? AND product_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            pst.setInt(2, product_id);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public int getQuantity(int order_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT quantity "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_ITEM
                    + " WHERE order_id = ? AND product_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            pst.setInt(2, product_id);
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

    public int getOrderID(int user_id, int order_status) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT order_id "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " WHERE user_id = ? AND order_status = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, order_status);
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

    public boolean updateOrderDetailAddressAndMethod(int order_id, int deliveryAddress_id, int deliveryMethod_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_DETAIL
                    + " SET deliveryAddress_id = ?, deliveryMethod_id = ? "
                    + " WHERE order_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, deliveryAddress_id);
            pst.setInt(2, deliveryMethod_id);
            pst.setInt(3, order_id);
            int updateState = pst.executeUpdate();
            return updateState == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public OrdersDetail getOrderDetail(int order_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_DETAIL
                    + " WHERE order_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new OrdersDetail(
                        rs.getInt("orderDetail_id"),
                        rs.getInt("deliveryAddress_id"),
                        rs.getInt("deliveryMethod_id"),
                        rs.getInt("order_id"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public boolean OrderConfirm(int order_id, int order_status, List<OrdersItem> ordersItems, String orderDetail_address, String subdistrict_code) {
        try {
            connect(DBConnection.getConnection());
            setAutoCommit(false);
            String qry;

            /* SQL First Statement */
            int countReductProduct = 0;
            for (OrdersItem ordersItem : ordersItems) {
                qry = "UPDATE "
                        + Config.DATABASE + "." + Config.TABLE_PRODUCT
                        + " SET "
                        + " product_stock = product_stock - ? "
                        + " WHERE product_id = ? "
                        + " AND product_stock > ? - 1 ;";
                pst = con.prepareStatement(qry);
                pst.setInt(1, ordersItem.getQuantity());
                pst.setInt(2, ordersItem.getProductId());
                pst.setInt(3, ordersItem.getQuantity());
                countReductProduct += pst.executeUpdate();
            }

            /* SQL statement 1 */
            qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " SET order_status = ?, order_date = CURRENT_TIMESTAMP "
                    + " WHERE order_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_status);
            pst.setInt(2, order_id);
            pst.executeUpdate();

            /* SQL statement 2 */
            qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS_DETAIL
                    + " SET orderDetail_address = ? , subdistrict_code = ? "
                    + " WHERE order_id = ?; ";
            pst = con.prepareStatement(qry);
            pst.setString(1, orderDetail_address);
            pst.setString(2, subdistrict_code);
            pst.setInt(3, order_id);
            pst.executeUpdate();

            if (countReductProduct == ordersItems.size()) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } finally {
            close();
        }
    }

}
