/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class User {
    private long userID;
    private String cmnd, username,avata,avata_name;
    private String  dob="",dantoc="",hotennguoidamho="",gioitinh="",quequan="",bhxh_id="",hogiadinh_id="";
     public User(long userID, String cmnd, String username, String password, String avata, String avata_name, long admin) {
        this.userID = userID;
        this.cmnd = cmnd;
        this.username = username;
        this.avata = avata;
        this.avata_name = avata_name;
        this.admin = admin;
    }
    
    

    public User(long userID, String cmnd, String username, String password, long admin) {
        this.userID = userID;
        this.cmnd = cmnd;
        this.username = username;
        this.admin = admin;
    }

    public User(String username, String dob, String dantoc, String hotennguoidamho, String gioitinh, String quequan, String bhxh_id, String hogiadinh_id,String cmnd) {
        this.cmnd = cmnd;
        this.username = username;
        this.dob = dob;
        this.dantoc = dantoc;
        this.hotennguoidamho = hotennguoidamho;
        this.gioitinh = gioitinh;
        this.quequan = quequan;
        this.bhxh_id = bhxh_id;
        this.hogiadinh_id = hogiadinh_id;
    }

    
    public User(String cmnd)
    {
        this.cmnd = cmnd;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDantoc() {
        return dantoc;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    public String getHotennguoidamho() {
        return hotennguoidamho;
    }

    public void setHotennguoidamho(String hotennguoidamho) {
        this.hotennguoidamho = hotennguoidamho;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getBhxh_id() {
        return bhxh_id;
    }

    public void setBhxh_id(String bhxh_id) {
        this.bhxh_id = bhxh_id;
    }

    public String getHogiadinh_id() {
        return hogiadinh_id;
    }

    public void setHogiadinh_id(String hogiadinh_id) {
        this.hogiadinh_id = hogiadinh_id;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public String getAvata_name() {
        return avata_name;
    }

    public void setAvata_name(String avata_name) {
        this.avata_name = avata_name;
    }
    private long admin;

    public User() {
    }



    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getcmnd() {
        return cmnd;
    }

    public void setcmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }





    public long getAdmin() {
        return admin;
    }

    public void setAdmin(long admin) {
        this.admin = admin;
    }
    
    
}
