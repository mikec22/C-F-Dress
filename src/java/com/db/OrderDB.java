/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.bean.Order;
import com.bean.OrderLine;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Mike
 */
public class OrderDB implements Serializable {

    private String dburl, dbUser, dbPassword;

    public OrderDB() {
        dburl = "jdbc:mysql://localhost:3306/CF_DB";
        dbUser = "root";
        dbPassword = "";
    }

    public OrderDB(String dburl, String dbUser, String dbPassword) {
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

    public Vector<Order> getOrders(int client_id) {
        Vector<Order> orders = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM order "
                    + "WHERE client_id = ?";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, client_id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                ClientDB clientDB = new ClientDB();
                Order order = new Order(rs.getInt(1), clientDB.getClient(rs.getInt(2)),
                        rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), null);
                order.setOrder_line(getOrderLines(order));
                orders.add(order);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return orders;
    }

    public Vector<OrderLine> getOrderLines(Order order) {
        Vector<OrderLine> orderLines = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM order_line "
                    + "WHERE order_id = ?";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, order.getOrder_id());
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                ItemDB itemDB = new ItemDB();
                OrderLine orderLine = new OrderLine(order,
                        itemDB.getItem(rs.getInt(2)), rs.getDouble(3),rs.getInt(4));
                orderLines.add(orderLine);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return orderLines;
    }
    
    
}
