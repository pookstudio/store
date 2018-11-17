/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import Model.DeliveryMethod;
import Model.Orders;
import Model.Payment;
import Model.PaymentMethod;
import PokoSystem.PokoService;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gail
 */
public class OrderService extends PokoService {

    public List<Orders> getOrders(int user_id) {
        try {
            connect(DBConnection.getConnection());
            List<Orders> orderses = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " WHERE user_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders(
                        rs.getInt("order_id"),
                        rs.getDate("order_date"),
                        rs.getInt("order_status"));
                if (orderses == null) {
                    orderses = new ArrayList<>();
                }
                orderses.add(orders);
            }
            return orderses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public Orders getOrder(int user_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " WHERE user_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            Orders orders = null;
            while (rs.next()) {
                orders = new Orders(
                        rs.getInt("order_id"),
                        rs.getDate("order_date"),
                        rs.getInt("order_status"));
            }
            return orders;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Orders> getOrderStatus(int order_status) {
        try {
            connect(DBConnection.getConnection());
            List<Orders> orderses = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " WHERE order_status = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders(
                        rs.getInt("order_id"),
                        rs.getDate("order_date"),
                        rs.getInt("order_status"));
                if (orderses == null) {
                    orderses = new ArrayList<>();
                }
                orderses.add(orders);
            }
            return orderses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<DeliveryMethod> getDeliveryMethods() {
        try {
            connect(DBConnection.getConnection());
            List<DeliveryMethod> deliveryMethods = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_METHOD;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DeliveryMethod deliveryMethod = new DeliveryMethod();
                deliveryMethod.setDeliveryMethodid(rs.getInt("deliveryMethod_id"));
                deliveryMethod.setDeliveryMethodname(rs.getString("deliveryMethod_name"));
                deliveryMethod.setDeliveryMethodprice(rs.getInt("deliveryMethod_price"));
                Blob images = rs.getBlob("deliveryMethod_image");
                deliveryMethod.setDeliveryMethodimage(images.getBytes(1, (int) images.length()));
                if (deliveryMethods == null) {
                    deliveryMethods = new ArrayList<>();
                }
                deliveryMethods.add(deliveryMethod);
            }
            return deliveryMethods;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public DeliveryMethod getDeliveryMethod(int deliveryMethod_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_METHOD
                    + " WHERE deliveryMethod_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, deliveryMethod_id);
            ResultSet rs = pst.executeQuery();
            DeliveryMethod deliveryMethod = null;
            if (rs.next()) {
                deliveryMethod = new DeliveryMethod();
                deliveryMethod.setDeliveryMethodid(rs.getInt("deliveryMethod_id"));
                deliveryMethod.setDeliveryMethodname(rs.getString("deliveryMethod_name"));
                deliveryMethod.setDeliveryMethodprice(rs.getInt("deliveryMethod_price"));
            }
            return deliveryMethod;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public boolean addDeliveryMethod(String deliveryMethod_name, int deliveryMethod_price, InputStream deliveryMethod_image) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_METHOD
                    + " (deliveryMethod_name, deliveryMethod_price, deliveryMethod_image) "
                    + " VALUES (?, ?, ?) ;";
            pst = con.prepareStatement(qry);
            pst.setString(1, deliveryMethod_name);
            pst.setInt(2, deliveryMethod_price);
            pst.setBlob(3, deliveryMethod_image);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public boolean updateDeliveryMethod(int deliveryMethod_id, String deliveryMethod_name, int deliveryMethod_price, InputStream deliveryMethod_image) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_METHOD
                    + " SET "
                    + " deliveryMethod_name = ?, "
                    + " deliveryMethod_price = ?, "
                    + " deliveryMethod_image = ? "
                    + " WHERE deliveryMethod_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setString(1, deliveryMethod_name);
            pst.setInt(2, deliveryMethod_price);
            pst.setBlob(3, deliveryMethod_image);
            pst.setInt(4, deliveryMethod_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean setOrderStatus(int order_id, int user_id, int order_status) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_ORDERS
                    + " SET "
                    + " order_status = ? "
                    + " WHERE order_id = ? AND user_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setFloat(1, order_status);
            pst.setInt(2, order_id);
            pst.setInt(3, user_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public List<PaymentMethod> getPaymentMethod() {
        try {
            connect(DBConnection.getConnection());
            List<PaymentMethod> paymentMethods = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PAYMENT_METHOD;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PaymentMethod paymentMethod = new PaymentMethod(
                        rs.getInt("paymentMethod_id"),
                        rs.getString("paymentMethod_name_bank"),
                        rs.getString("paymentMethod_account"),
                        rs.getString("paymentMethod_name_account"));
                if (paymentMethods == null) {
                    paymentMethods = new ArrayList<>();
                }
                paymentMethods.add(paymentMethod);
            }
            return paymentMethods;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public Payment getPayment(int order_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PAYMENT
                    + " WHERE order_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            ResultSet rs = pst.executeQuery();
            Payment payment = null;
            while (rs.next()) {
                payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getDate("payment_datetime"),
                        rs.getInt("payment_amount"),
                        rs.getInt("order_id"),
                        rs.getInt("paymentMethod_id"),
                        rs.getDate("inform_datetime"),
                        rs.getBlob("payment_image").getBytes(1, (int) rs.getBlob("payment_image").length()));
            }
            return payment;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public boolean setInformPayment(float payment_amount, int order_id, int paymentMethod_id, Timestamp inform_datetime, InputStream payment_image) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_PAYMENT
                    + " (payment_amount, order_id, paymentMethod_id, inform_datetime, payment_image) "
                    + " VALUES (?, ?, ?, ?, ?) ";
            pst = con.prepareStatement(qry);
            pst.setFloat(1, payment_amount);
            pst.setInt(2, order_id);
            pst.setInt(3, paymentMethod_id);
            pst.setTimestamp(4, inform_datetime);
            pst.setBlob(5, payment_image);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean updateInformPayment(float payment_amount, int order_id, int paymentMethod_id, Timestamp inform_datetime, InputStream payment_image) {
        try {
            connect(DBConnection.getConnection());
            String qry = "UPDATE "
                    + Config.DATABASE + "." + Config.TABLE_PAYMENT
                    + " SET "
                    + " payment_amount = ?,"
                    + " paymentMethod_id = ?, "
                    + " inform_datetime = ?, "
                    + " payment_image = ? "
                    + " WHERE order_id = ? ";
            pst = con.prepareStatement(qry);
            pst.setFloat(1, payment_amount);
            pst.setInt(2, paymentMethod_id);
            pst.setTimestamp(3, inform_datetime);
            pst.setBlob(4, payment_image);
            pst.setInt(5, order_id);
            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean isInformPayment(int order_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PAYMENT
                    + " WHERE order_id = ? ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, order_id);
            ResultSet row = pst.executeQuery();
            return row.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    

}
