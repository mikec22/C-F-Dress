/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Client;
import com.bean.Order;
import com.bean.OrderLine;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fai
 */
@WebServlet(name = "HistoryController", urlPatterns = {"/history"})
public class HistoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private OrderDB orderDB;
    private ClientDB clientDB;

    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        orderDB = new OrderDB(dburl, dbUser, dbPassword);
        clientDB = new ClientDB(dburl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        String action = request.getParameter("action");
        if (!isAuthenticated(request)) {
            doLogin(request, response);
        } else {
            if (action == null) {
                action = "";
            }
            if (action.equals("getHistory")) {
                getHistory(request, response);
            } else if (action.equals("getOrderDetails")) {
                getOrderDetails(request, response);
            }
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        if (client != null) {
            if (client.getLogin_id() != null && !client.getLogin_id().equals("")) {
                result = true;
            }
        }
        return result;
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetURL = "/login.jsp";
        request.getRequestDispatcher(targetURL).forward(request, response);
    }

    private void getHistory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        Vector<Order> orderHistory = getOrderHistory(request, response);
        Vector<OrderLine> bonusPointsHistory = getBonusPointsHistory(request, response);;
        request.setAttribute("orderHistory", orderHistory);
        request.setAttribute("bonusPointsHistory", bonusPointsHistory);
        request.getRequestDispatcher("/history.jsp").forward(request, response);
    }

    private Vector<Order> getOrderHistory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vector<Order> orderList;
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        orderList = orderDB.getLastTenOrders(client.getClient_id());
        return orderList;
    }

    private Vector<OrderLine> getBonusPointsHistory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vector<OrderLine> bonusPointsHistory;
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        bonusPointsHistory = orderDB.getGiftsOrderLines(client.getClient_id());
        return bonusPointsHistory;
    }

    private void getOrderDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order orderResult = orderDB.getOrder(id);
        request.setAttribute("orderResult", orderResult);
        request.setAttribute("status", "details");
        getServletContext().getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
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
