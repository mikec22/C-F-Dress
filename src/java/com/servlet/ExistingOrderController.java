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
@WebServlet(name = "ExistingOrderController", urlPatterns = {"/existingOrder"})
public class ExistingOrderController extends HttpServlet {

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
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        if (action.equals("showExistingOrder")) {
            showExistingOrder(request, response);
        } else if (action.equals("CancelOrder")) {
            CancelOrder(request, response);
        } else if (action.equals("updateOrder")) {
            editOrder(request, response);
        }

    }

    private void showExistingOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        int client_id = client.getClient_id();
        Vector<Order> orders = orderDB.getExistedOrdersOfClient(client_id);
        request.setAttribute("existingOrder", orders);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/existingOrder.jsp");
        rd.forward(request, response);

    }

    private void CancelOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String datetime = "";
        if (request.getParameter("delivery_date") == null || request.getParameter("delivery_time") == null) {
            datetime = "1999-01-01 01:01:01";
        } else {
            datetime = request.getParameter("delivery_date")
                    + " " + request.getParameter("delivery_time") + ":00";
        }
        String status = request.getParameter("status");
        System.out.println("status" + status);
        System.out.println("datetime " + datetime);
        System.out.println("ID" + request.getParameter("order_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        if(amount>2000){
            Client client = clientDB.getClient(client_id);
            client.setBonus_point(client.getBonus_point()-(int)(amount*0.05));
            clientDB.updateClientBalanceBonusPoints(client);
        }
        
        orderDB.updateStatus(order_id, datetime, status);
        clientDB.depositClient(client_id, (amount - 500));

        response.sendRedirect(request.getContextPath() + "/existingOrder?action=showExistingOrder");

    }

    private void editOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String datetime = "";
        if (request.getParameter("delivery_date") == null || request.getParameter("delivery_time") == null) {
            datetime = "1999-01-01 01:01:01";
        } else {
            datetime = request.getParameter("delivery_date")
                    + " " + request.getParameter("delivery_time") + ":00";
        }
        String status = request.getParameter("status");
        System.out.println("status" + status);
        System.out.println("datetime " + datetime);
        System.out.println("ID" + request.getParameter("order_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int client_id = Integer.parseInt(request.getParameter("client_id"));

        orderDB.updateStatus(order_id, datetime, status);

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
