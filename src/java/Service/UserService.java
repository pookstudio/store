/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import Model.Address.Districts;
import Model.Address.Geography;
import Model.Address.Provinces;
import Model.Address.Subdistricts;
import Model.Address.SubdistrictsAndZipcodes;
import Model.Address.Zipcodes;
import Model.DeliveryAddress;
import Model.ProductWishlist;
import Model.User;
import Model.UserRegister;
import PokoSystem.PokoService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gail
 */
public class UserService extends PokoService {

    public boolean createUser(UserRegister userRegister) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_USER
                    + " (email, password, firstname, lastname, gender, birthday, telephone)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?);";
            pst = con.prepareStatement(qry);
            pst.setString(1, userRegister.getEmail());
            pst.setString(2, hashPassword(userRegister.getPassword()));
            pst.setString(3, userRegister.getFirstname());
            pst.setString(4, userRegister.getLastlame());
            pst.setInt(5, userRegister.getGender());
            pst.setDate(6, userRegister.getBirthday());
            pst.setString(7, userRegister.getTelephone());
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public boolean updateUser() {
        return true;
    }

    public boolean existEmail(String email) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_USER
                    + " WHERE email = ?;";
            pst = con.prepareStatement(qry);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public User validateUser(String email, String pass) {
        try {
            connect(DBConnection.getConnection());
//            con = DBConnection.getConnection();
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_USER
                    + " WHERE email = ? AND password = ?;";
            pst = con.prepareStatement(qry);
            pst.setString(1, email);
            pst.setString(2, hashPassword(pass));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setID(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setFirstname(rs.getString(4));
                user.setLastname(rs.getString(5));
                user.setGender(rs.getInt(6));
                user.setBirthday(rs.getDate(7));
                user.setTelephone(rs.getString(8));
                user.setLevel(rs.getInt(9));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Geography> getGeographies() {
        try {
            connect(DBConnection.getConnection());
            List<Geography> geographieses = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_GEOGRAPHIES;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Geography geographies = new Geography(
                        rs.getInt("geo_id"),
                        rs.getString("geo_name"));
                if (geographieses == null) {
                    geographieses = new ArrayList<>();
                }
                geographieses.add(geographies);
            }
            return geographieses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Provinces> getProvinces() {
        try {
            connect(DBConnection.getConnection());
            List<Provinces> provinceses = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_PROVINCES;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Provinces provinces = new Provinces(
                        rs.getInt("province_id"),
                        rs.getString("province_code"),
                        rs.getString("province_name_th"),
                        rs.getString("province_name_en"),
                        rs.getInt("geo_id"));
                if (provinceses == null) {
                    provinceses = new ArrayList<>();
                }
                provinceses.add(provinces);
            }
            return provinceses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<Districts> getDistricts(int provinceID) {
        try {
            connect(DBConnection.getConnection());
            List<Districts> districtses = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_DISTRICTS
                    + " WHERE province_id = ?";
            pst = con.prepareStatement(qry);
            pst.setInt(1, provinceID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Districts districts = new Districts(
                        rs.getInt("district_id"),
                        rs.getString("district_code"),
                        rs.getString("district_name_th"),
                        rs.getString("district_name_en"),
                        rs.getInt("geo_id"),
                        rs.getInt("province_id"));
                if (districtses == null) {
                    districtses = new ArrayList<>();
                }
                districtses.add(districts);
            }
            return districtses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<SubdistrictsAndZipcodes> getSubDistrictsAndZipcodes(int districtID) {
        try {
            connect(DBConnection.getConnection());
            List<SubdistrictsAndZipcodes> SAndZs = null;
            String qry = "SELECT * "
                    + "FROM "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_SUBDISTRICTS + " sub"
                    + " JOIN "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_ZIPCODES + " zip"
                    + " ON "
                    + " sub.subdistrict_code = zip.subdistrict_code "
                    + " WHERE district_id = ?";
            pst = con.prepareStatement(qry);
            pst.setInt(1, districtID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SubdistrictsAndZipcodes SAndZ = new SubdistrictsAndZipcodes(
                        new Subdistricts(
                                rs.getInt("subdistrict_id"),
                                rs.getString("subdistrict_code"),
                                rs.getString("subdistrict_name_th"),
                                rs.getString("subdistrict_name_en"),
                                rs.getInt("district_id"),
                                rs.getInt("province_id"),
                                rs.getInt("geo_id")),
                        new Zipcodes(
                                rs.getInt("zipcode_id"),
                                rs.getString("subdistrict_code"),
                                rs.getString("zipcode"))
                );
                if (SAndZs == null) {
                    SAndZs = new ArrayList<>();
                }
                SAndZs.add(SAndZ);
            }
            return SAndZs;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }

    public List<DeliveryAddress> getDeliveryAddress(int user_id) {
        return getDeliveryAddress(user_id, 0);
    }

    public List<DeliveryAddress> getDeliveryAddress(int user_id, int country) {
        try {
            connect(DBConnection.getConnection());
            List<DeliveryAddress> deliveryAddresses = null;
            String qry = "SELECT "
                    + "m.deliveryAddress_id, "
                    + "m.user_id, "
                    + "m.deliveryAddress_address, "
                    + "p.province_name_th as province_th, "
                    + "p.province_name_en as province_en, "
                    + "d.district_name_th as district_th, "
                    + "d.district_name_en as district_en, "
                    + "sd.subdistrict_code as subdistrictCode, "
                    + "sd.subdistrict_name_th as subdistrict_th, "
                    + "sd.subdistrict_name_en as subdistrict_en, "
                    + "z.zipcode as zipcode "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_ADDRESS + " m "
                    + " JOIN "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_SUBDISTRICTS + " sd ON m.subdistrict_code = sd.subdistrict_code "
                    + " JOIN "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_PROVINCES + " p ON sd.province_id = p.province_id "
                    + " JOIN "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_DISTRICTS + " d ON sd.district_id = d.district_id "
                    + " JOIN "
                    + Config.DATABASE_ADDRESS + "." + Config.TABLE_ADDRESS_ZIPCODES + " z ON sd.subdistrict_code = z.subdistrict_code "
                    + " WHERE m.user_id = ? "
                    + " ORDER BY m.deliveryAddress_id; ";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DeliveryAddress deliveryAddress = new DeliveryAddress(
                        rs.getInt("deliveryAddress_id"),
                        rs.getInt("user_id"),
                        rs.getString("deliveryAddress_address"),
                        rs.getString("province_th"),
                        rs.getString("district_th"),
                        rs.getString("subdistrict_th"),
                        rs.getString("subdistrictCode"),
                        rs.getString("zipcode")
                );
                if (country != 0) {
                    deliveryAddress.setProvinceName(rs.getString("provinces_en"));
                    deliveryAddress.setDistrictName(rs.getString("district_en"));
                    deliveryAddress.setDistrictName(rs.getString("subdistrict_en"));
                }
                if (deliveryAddresses == null) {
                    deliveryAddresses = new ArrayList<>();
                }
                deliveryAddresses.add(deliveryAddress);
            }
            return deliveryAddresses;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public boolean addAddress(int user_id, String address, String subdistrict) {
        try {
            connect(DBConnection.getConnection());
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_ADDRESS
                    + " (user_id, deliveryAddress_address, subdistrict_code)"
                    + " VALUES(?, ?, ?);";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setString(2, address);
            pst.setString(3, subdistrict);
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public int countAddress(int user_id) {
        try {
            connect(DBConnection.getConnection());
            String qry = "SELECT COUNT(user_id) "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_DELIVERY_ADDRESS
                    + " WHERE user_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
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
    
    public List<ProductWishlist> getProductWishlist(int user_id) {
        try {
            connect(DBConnection.getConnection());
            List<ProductWishlist> productWishlists = null;
            String qry = "SELECT product.*, wishlist.wishlist_id, wishlist.wishlist_date "
                    + " FROM " 
                    + Config.DATABASE + "." + Config.TABLE_PRODUCT + " product "
                    + " JOIN "
                    + Config.DATABASE + "." + Config.TABLE_WISHLIST + " wishlist "
                    + " ON product.product_id = wishlist.product_id "
                    + " WHERE user_id = ?;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductWishlist productWishlist = new ProductWishlist();
                productWishlist.setWishlistId(rs.getInt("wishlist_id"));
                productWishlist.setWishlistDate(rs.getDate("wishlist_date"));
                productWishlist.setProductID(rs.getInt("product_id"));
                productWishlist.setProductName(rs.getString("product_name"));
                productWishlist.setProductPrice(rs.getFloat("product_price"));
                productWishlist.setProductStock(rs.getInt("product_stock"));
                productWishlist.setProductTypeID(rs.getInt("productType_id"));
                productWishlist.setProductDetail(rs.getString("product_detail"));
                productWishlist.setProductDate(rs.getDate("product_date"));
                if (productWishlists == null) {
                    productWishlists = new ArrayList<>();
                }
                productWishlists.add(productWishlist);
            }
            return productWishlists;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
    
    public boolean addWishlist(int user_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            List<ProductWishlist> productWishlists = null;
            String qry = "INSERT INTO "
                    + Config.DATABASE + "." + Config.TABLE_WISHLIST
                    + " (user_id, product_id) "
                    + " VALUES (?, ?);";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, product_id);
            int rs = pst.executeUpdate();
            return rs == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public boolean removeWishlist(int user_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            List<ProductWishlist> productWishlists = null;
            String qry = "DELETE FROM "
                    + Config.DATABASE + "." + Config.TABLE_WISHLIST
                    + " WHERE user_id = ? AND product_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, product_id);
            int rs = pst.executeUpdate();
            return rs == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }
    
    public boolean isWishlist(int user_id, int product_id) {
        try {
            connect(DBConnection.getConnection());
            List<ProductWishlist> productWishlists = null;
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_WISHLIST
                    + " WHERE user_id = ? AND product_id = ? ;";
            pst = con.prepareStatement(qry);
            pst.setInt(1, user_id);
            pst.setInt(2, product_id);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        } finally {
            close();
        }
    }

    public String hashPassword(String str) {
        return MD5(str + "QwWqkjh8z7");
    }

}
