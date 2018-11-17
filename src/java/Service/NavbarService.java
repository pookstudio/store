/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import Model.ProductsType;
import PokoSystem.PokoService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gail
 */
public class NavbarService extends PokoService {

    public List<ProductsType> getProductsType() {
        try {
            connect(DBConnection.getConnection());
            List<ProductsType> productList = new ArrayList<>();
            String qry = "SELECT * "
                    + " FROM "
                    + Config.DATABASE + "." + Config.TABLE_PRODUCTTYPE;
            pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductsType product = new ProductsType();
                product.setProductTypeid(rs.getInt("productType_id"));
                product.setProductTypename(rs.getString("productType_name"));
                product.setProductTypeSubset(rs.getInt("productType_subset"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            return null;
        } finally {
            close();
        }
    }
}
