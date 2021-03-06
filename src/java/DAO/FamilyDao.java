/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Family;
import model.User;

/**
 *
 * @author nguye
 */
public class FamilyDao {

    public boolean checkFamily(String hogiadinh, String cmnd) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select * from family where hogiadinh_id = '" + hogiadinh + "' and cmnd = '" + cmnd + "'";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean insertFamily(Family f) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into family(hogiadinh_id,cmnd) values(?,?)";
            if (checkFamily(f.getHogiadinh_id(), f.getCmnd()) == false) {
                ps = con.prepareStatement(sql);
                ps.setString(1, f.getHogiadinh_id());
                ps.setString(2, f.getCmnd());
                ps.executeUpdate();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
