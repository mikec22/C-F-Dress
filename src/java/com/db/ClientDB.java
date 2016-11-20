/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.bean.Client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mike
 */
public class ClientDB {

    String dburl, dbUser, dbPassword;

    public ClientDB() {
    }

    public ClientDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
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
    
    public boolean isExistClient(String login_id, String email){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isExist = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM client WHERE login_id=? or email=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, login_id);
            pStmnt.setString(2, email);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return isExist;
    }

    public boolean isValidClient(String login_id, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM client WHERE login_id=? and password=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, login_id);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next() && rs.getBoolean("verified")) {
                isValid = true;
                //System.out.print(rs.getBoolean("verified"));
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

    public Client getClient(String login_id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        Client client = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM client"
                    + " WHERE login_id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, login_id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                int client_id = rs.getInt("client_id");
                //Stringlogin_id = rs.getString("login_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int bonus_point = rs.getInt("bonus_point");
                boolean verified = rs.getBoolean("verified");
                double balance = rs.getDouble("balance");
                client = new Client(client_id, login_id, password, name,
                        gender, dob, email, phone, address,
                        bonus_point, verified, balance);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return client;
    }

    public Client getClient(int client_id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        Client client = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM client"
                    + " WHERE client_id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, client_id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                //int client_id = rs.getInt("client_id");
                String login_id = rs.getString("login_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int bonus_point = rs.getInt("bonus_point");
                boolean verified = rs.getBoolean("verified");
                double balance = rs.getDouble("balance");
                client = new Client(client_id, login_id, password, name,
                        gender, dob, email, phone, address,
                        bonus_point, verified, balance);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return client;
    }

    //For Client Register
    public boolean addClient(Client client) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO client (`login_id`, `password`, `name`, `gender`, "
                    + "`dob`, `email`, `phone`, `address`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, client.getLogin_id());
            pStmnt.setString(2, client.getPassword());
            pStmnt.setString(3, client.getName());
            pStmnt.setString(4, client.getGender());
            pStmnt.setDate(5, client.getDob());
            pStmnt.setString(6, client.getEmail());
            pStmnt.setString(7, client.getPhone());
            pStmnt.setString(8, client.getAddress());
            int rowCount = pStmnt.executeUpdate();
            if (rowCount == 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return isSuccess;
    }

}
