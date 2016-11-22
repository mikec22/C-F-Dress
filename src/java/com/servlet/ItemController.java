/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Item;
import com.db.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shukyan
 */
@WebServlet(name = "itemController", urlPatterns = {"/item"})
public class ItemController extends HttpServlet {

    private ItemDB itemDB;

    @Override
    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        itemDB = new ItemDB(dburl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "getItemList";
        }

        if (action.equals("getItem")) {
            showItem(request, response);
        } else if (action.equals("getItemList")) {
            showItemList(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

    }

    private void showItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            Item item = itemDB.getItem(id);
            rd = getServletContext().getRequestDispatcher("/itemDetails.jsp");
            request.setAttribute("item", item);
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    private void showItemList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        Vector<Item> itemList = itemDB.queryItemByKeyword(keyword);
        request.setAttribute("itemList", itemList);
        getServletContext().getRequestDispatcher("/item.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
