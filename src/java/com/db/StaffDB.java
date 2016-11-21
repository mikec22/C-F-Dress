/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.bean.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mike
 */
public class StaffDB {

    private String dburl, dbUser, dbPassword;

    public StaffDB() {
        dburl = "jdbc:mysql://localhost:3306/CF_DB";
        dbUser = "root";
        dbPassword = "";
    }

    public StaffDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean isValidStaff(String login_id, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM staff "
                    + "WHERE login_id=? and password=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, login_id);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return isValid;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dburl, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Staff getStaff(String login_id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        Staff staff = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM staff"
                    + " WHERE login_id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, login_id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                int staff_id = rs.getInt("staff_id");
                //Stringlogin_id = rs.getString("login_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                staff = new Staff(staff_id, login_id, password, name, gender);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return staff;
    }
}
