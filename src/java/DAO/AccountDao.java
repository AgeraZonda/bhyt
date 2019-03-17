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
import model.Account;
import model.User;

/**
 *
 * @author nguye
 */
public class AccountDao {

    public boolean checkcmnd(String cmnd) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM account WHERE cmnd = '" + cmnd + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean inseartUser(Account u) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into account(cmnd,password) values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCmnd());
            ps.setString(2, u.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updatePass(String cmnd, String pass) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "update account set user_password=? where cmnd=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, cmnd);

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public User login(String cmnd, String password) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM account WHERE cmnd='" + cmnd + "' and password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                UserDao udao = new UserDao();
                u = udao.getUserFromAccount(cmnd);
                
                
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
