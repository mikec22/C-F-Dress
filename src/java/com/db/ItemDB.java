/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.bean.Item;
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
public class ItemDB implements Serializable {

    private String dburl, dbUser, dbPassword;

    public ItemDB() {
        dburl = "jdbc:mysql://localhost:3306/CF_DB";
        dbUser = "root";
        dbPassword = "";
    }

    public ItemDB(String dburl, String dbUser, String dbPassword) {
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

    public String getDburl() {
        return dburl;
    }

    public void setDburl(String dburl) {
        this.dburl = dburl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Vector<Item> querySellItemByKeyword(String keyword) {
        Vector<Item> items = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM item "
                    + "WHERE category != 'gifts' "
                    + "AND ("
                    + "name LIKE ? "
                    + "OR price LIKE ? "
                    + "OR category LIKE ? "
                    + "OR designer LIKE ? )";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "%" + keyword + "%");
            pStmnt.setString(2, "%" + keyword + "%");
            pStmnt.setString(3, "%" + keyword + "%");
            pStmnt.setString(4, "%" + keyword + "%");
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
                items.add(item);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return items;
    }

    public Vector<Item> queryItemByKeyword(String keyword) {
        Vector<Item> items = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM item "
                    + "WHERE name LIKE ? "
                    + "OR category LIKE ? "
                    + "OR price LIKE ? "
                    + "OR designer LIKE ?";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "%" + keyword + "%");
            pStmnt.setString(2, "%" + keyword + "%");
            pStmnt.setString(3, "%" + keyword + "%");
            pStmnt.setString(4, "%" + keyword + "%");
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
                items.add(item);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return items;
    }

    public Vector<Item> queryItemByCategoryKeyword(String keyword, String category) {
        Vector<Item> items = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM item "
                    + "WHERE category = ? "
                    + "AND ( name LIKE ? "
                    + "OR designer LIKE ? "
                    + "OR price LIKE ? )";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, category);
            pStmnt.setString(2, "%" + keyword + "%");
            pStmnt.setString(3, "%" + keyword + "%");
            pStmnt.setString(4, "%" + keyword + "%");

            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
                items.add(item);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return items;
    }

    public Vector<String> getAllCategories() {
        Vector<String> categories = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT DISTINCT category FROM item";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString(1));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return categories;
    }

    public Vector<String> getAllDesigners() {
        Vector<String> designers = new Vector();
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT DISTINCT designer FROM item";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                designers.add(rs.getString(1));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return designers;
    }

    public Item getItem(int item_id) {
        Item item = null;
        try {
            Connection cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM item "
                    + "WHERE item_id = ?";
            PreparedStatement pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, item_id);
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return item;
    }

    public boolean updateItem(Item item) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE item SET item_id = ?,"
                    + " name = ?,"
                    + " category = ?,"
                    + " designer = ?,"
                    + " price = ?,"
                    + " description = ?,"
                    + " img = ?"
                    + " WHERE item_id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, item.getItem_id());
            pStmnt.setString(2, item.getName());
            pStmnt.setString(3, item.getCategory());
            pStmnt.setString(4, item.getDesigner());
            pStmnt.setDouble(5, item.getPrice());
            pStmnt.setString(6, item.getDescription());
            pStmnt.setString(7, item.getImg());
            pStmnt.setInt(8, item.getItem_id());
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
