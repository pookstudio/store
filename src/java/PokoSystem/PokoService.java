/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokoSystem;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gail
 */
public class PokoService {

    protected Connection con;
    protected PreparedStatement pst;

    protected String MD5(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes;
            hashInBytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PokoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected void connect(Connection con) {
        this.con = con;
    }
    
    protected void setAutoCommit(boolean autoCommit) {
        try {
            this.con.setAutoCommit(autoCommit);
        } catch (SQLException ex) {
            Logger.getLogger(PokoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void close() {
        try {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {

        }
    }

}
