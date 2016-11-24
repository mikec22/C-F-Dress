/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Order;
import com.bean.OrderLine;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
@WebServlet(name = "CartItemController", urlPatterns = {"/CartItemController"})
public class CartItemController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int item_id = Integer.parseInt(request.getParameter("id"));
        Order order = (Order) session.getAttribute("cart");
        Vector<OrderLine> order_lines = order.getOrder_line();
        if (action.equals("Update")) {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            for (OrderLine ol : order_lines) {
                if (ol.getItem().getItem_id() == item_id) {
                    ol.setQuantity(quantity);
                }
            }
        } else if (action.equals("Delete")) {
            for (OrderLine ol : order_lines) {
                if (ol.getItem().getItem_id() == item_id) {
                    order.removeItem(ol);
                }
            }

        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
            String referer = request.getHeader("Referer");
            response.sendRedirect(referer);
        }
        response.sendRedirect("/shoppingCart?action=showCart");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
