/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gail
 */
public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Config.DBMS_URL, Config.DBMS_USER, Config.DBMS_PASS);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

}
