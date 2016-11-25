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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mike
 */
@WebServlet(name = "QueryOrder", urlPatterns = {"/queryOrder"})
public class QueryOrder extends HttpServlet {
    
    private OrderDB orderDB;
    private ClientDB clientDB;
    
    @Override
    public void init() throws ServletException {
        super.init();
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        orderDB = new OrderDB(dburl, dbUser, dbPassword);
        clientDB = new ClientDB(dburl, dbUser, dbPassword);
    }

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
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("queryOrder")) {
            String client_name = request.getParameter("client_name");
            if (client_name == null || client_name.equals("")) {
                request.setAttribute("orders", orderDB.getAllOrders());
                getServletContext().getRequestDispatcher("/queryOrder.jsp").forward(request, response);
            } else {
                Vector<Client> clients = clientDB.queryClientByName(client_name);
                Vector<Vector<Order>> orders = new Vector();
                for (Client client : clients) {
                    orders.add(orderDB.getOrders(client.getClient_id()));
                }
                request.setAttribute("queryOrders", orderDB.getOrders(0));
                getServletContext().getRequestDispatcher("/queryOrder.jsp").forward(request, response);
            }
        } else if (action.equals("showOrderDetail")) {
            
        }
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
