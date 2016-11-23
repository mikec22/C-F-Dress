/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.CartItem;
import com.bean.Item;
import com.bean.ShoppingCart;
import com.db.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shukyan
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartController extends HttpServlet {
//	private static final long serialVersionUID = 1L;

    private ItemDB db;

    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new ItemDB(dburl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

//        synchronized (session) {
        ShoppingCart sc = (ShoppingCart) session.getAttribute("cart");

        if (sc == null) {
            sc = new ShoppingCart();
        }

        int itemID = Integer.parseInt(request.getParameter("itemId"));
        Item item = db.getItem(itemID);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println(itemID);
        System.out.println(item);
        System.out.println(quantity);
        // Set quantity
        if (quantity < 0) {
            quantity = 1;

        }

        CartItem cartItem = new CartItem(item, quantity);

        if (quantity == 0) {
            sc.removeItem(cartItem);
        } else {
            sc.addItem(cartItem);
        }

        // Update Cart session attribute
        session.setAttribute("cart", sc);

        // Forward to JSP
        String url = "/itemDetails.jsp";
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(url);
        request.setAttribute("item", item);
        dispatcher.forward(request, response);

    }

//    }
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
