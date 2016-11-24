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
 * @author Fai
 */
@WebServlet(name = "CartItemController", urlPatterns = {"/CartItemController"})
public class CartItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        if (action.equals("update")) {
            update(request, response);
        } else if (action.equals("delete")) {
            delete(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);;
        }
        response.sendRedirect(request.getContextPath() + "/shoppingCart?action=showCart");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int item_id = Integer.parseInt(request.getParameter("id"));
        Order order = (Order) session.getAttribute("cart");
        Vector<OrderLine> order_lines = order.getOrder_lines();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        for (OrderLine ol : order_lines) {
            if (ol.getItem().getItem_id() == item_id) {
                ol.setQuantity(quantity);
                break;
            }
        }
        order.setOrder_lines(order_lines);
        session.setAttribute("cart", order);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int item_id = Integer.parseInt(request.getParameter("id"));
        Order order = (Order) session.getAttribute("cart");
        Vector<OrderLine> order_lines = order.getOrder_lines();
        for (OrderLine ol : order_lines) {
            if (ol.getItem().getItem_id() == item_id) {
                order.removeItem(ol);
                break;
            }
        }
        order.setOrder_lines(order_lines);
        session.setAttribute("cart", order);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
