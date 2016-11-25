/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Client;
import com.bean.Order;
import com.db.ClientDB;
import com.db.OrderDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
@WebServlet(name = "existingOrderController", urlPatterns = {"/existingOrderController"})
public class existingOrderController extends HttpServlet {

    private OrderDB db;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new OrderDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("showExistingOrder")) {
            showExistingOrder(request, response);
        } else if (action.equals("Cancle")) {
            CancleOrder(request, response);
        } else if (action.equals("editOrder")){
            editOrder(request, response);
        }
        else {
            //
        }

    }

    private void showExistingOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        int client_id = 1;
        //client.getClient_id();
        Vector<Order> orders = db.getExistedOrdersOfClient(client_id);
        request.setAttribute("existingOrder", orders);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/existingOrder.jsp");
        rd.forward(request, response);

    }
    private void CancleOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        //db.cancelOrder(order_id);
    
    }
    
     private void editOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

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
