/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.db.ClientDB;
import com.db.OrderDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shukyan
 */
@WebServlet(name = "edtiExistingOrder", urlPatterns = {"/edtiExistingOrder"})
public class edtiExistingOrder extends HttpServlet {

    private OrderDB orderDB;
    private ClientDB clientDB;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        orderDB = new OrderDB(dbUrl, dbUser, dbPassword);
        clientDB = new ClientDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String datetime = request.getParameter("delivery_date")
                + " " + request.getParameter("delivery_time") + ":00";
        String status = request.getParameter("ststus");;
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        if (action.equals("CancelOrder")) {
            double amount = Double.parseDouble("amount");
            orderDB.updateStatus(order_id, datetime, "cancelled");
            clientDB.depositClient(client_id, (amount-500));
        } else if (action.equals("updateOrder")) {
            orderDB.updateStatus(order_id, datetime, status);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No action done!!!");
            response.sendRedirect(request.getContextPath() + "/existingOrder?action=showExistingOrder");
        }
        response.sendRedirect(request.getContextPath() + "/existingOrder?action=showExistingOrder");
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
