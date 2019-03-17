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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author User
 */
public class UserDao {

    public boolean inseartUser(User u) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user(user_name,cmnd,admin) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getcmnd());
            ps.setLong(3, u.getAdmin());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public User findUserByCMND(String cmnd) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select * from user where cmnd like '%"+ cmnd + "%'";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 User u = new User();
                u.setAdmin(rs.getLong("admin"));
                u.setUserID(rs.getLong("user_id"));
                u.setBhxh_id(rs.getString("bhxh_id"));
                u.setDantoc(rs.getString("dantoc"));
                u.setDob(rs.getString("dob"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setHogiadinh_id(rs.getString("hogiadinh_id"));
                u.setHotennguoidamho(rs.getString("hotennguoidamho"));
                u.setQuequan(rs.getString("quequan"));
                u.setcmnd(rs.getString("cmnd"));
                u.setUsername(rs.getString("user_name"));
                con.close();
                return u;
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }

    public boolean updateUser(User u) {
        Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        try {
//            long id = u.getUserID();
//            String email = u.getEmail();
//            String username = u.getUsername();
            String sql = "update user set user_name=?,dob=?,dantoc=?,hotennguoidamho=?,gioitinh=?,quequan=?,bhxh_id=?,hogiadinh_id=? where cmnd=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getDob());
            ps.setString(3, u.getDantoc());
            ps.setString(4, u.getHotennguoidamho());
            ps.setString(5, u.getGioitinh());
            ps.setString(6, u.getQuequan());
            ps.setString(7, u.getBhxh_id());
            ps.setString(8, u.getHogiadinh_id());
            ps.setString(9, u.getcmnd());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public User getUserFromAccount(String cmnd) {

        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM user WHERE cmnd='" + cmnd + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();

                u.setAdmin(rs.getLong("admin"));
                u.setUserID(rs.getLong("user_id"));
                u.setBhxh_id(rs.getString("bhxh_id"));
                u.setDantoc(rs.getString("dantoc"));
                u.setDob(rs.getString("dob"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setHogiadinh_id(rs.getString("hogiadinh_id"));
                u.setHotennguoidamho(rs.getString("hotennguoidamho"));
                u.setQuequan(rs.getString("quequan"));
                u.setcmnd(rs.getString("cmnd"));
                u.setUsername(rs.getString("user_name"));

                con.close();
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static User getUser(String userID) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM user WHERE user_id='" + userID + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getLong("user_id"));
                u.setcmnd(rs.getString("cmnd"));
                u.setUsername(rs.getString("user_name"));
                u.setAdmin(rs.getLong("admin"));
                con.close();
                System.out.println(u.getUserID());
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<User> getListUser() throws SQLException {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM user WHERE admin#'1'";
        ArrayList<User> list = new ArrayList<>();
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setUserID(rs.getLong("user_id"));
            u.setcmnd(rs.getString("cmnd"));
            u.setUsername(rs.getString("user_name"));
            u.setAdmin(rs.getLong("admin"));
            list.add(u);
        }
        return list;
    }

}
