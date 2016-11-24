/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Item;
import com.bean.Order;
import com.bean.OrderLine;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/shoppingCart"})
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
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        if (action.equals("addToCart")) {
            addItemToCart(request, response);
        } else if (action.equals("showCart")) {
            showCart(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
            String referer = request.getHeader("Referer");
            response.sendRedirect(referer);
//            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);;
        }
    }

    private void addItemToCart(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        synchronized (session) {
        Order order = (Order) session.getAttribute("cart");
        order = order == null ? new Order() : (Order) session.getAttribute("cart");

        try {
            int itemID = Integer.parseInt(request.getParameter("itemId"));
            Item item = db.getItem(itemID);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            // Set quantity
            if (quantity < 0) {
                quantity = 1;

            }

            OrderLine orderline = new OrderLine();
            orderline.setItem(item);
            orderline.setPrice(item.getPrice());
            orderline.setQuantity(quantity);

            if (quantity == 0) {
                order.removeItem(orderline);
            } else {
                order.addItem(orderline);
            }

            // Update Cart session attribute
            session.setAttribute("cart", order);

            // Forward to JSP
            String url = "/itemDetails.jsp";
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(url);
            request.setAttribute("item", item);
            dispatcher.forward(request, response);
//    }
        } catch (NumberFormatException e) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void showCart(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("cart");
        order = order == null ? new Order() : (Order) session.getAttribute("cart");
        getServletContext().getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        
    }

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
