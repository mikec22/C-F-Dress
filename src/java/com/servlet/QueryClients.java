/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Client;
import com.db.ClientDB;
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
@WebServlet(name = "QueryClients", urlPatterns = {"/queryClients"})
public class QueryClients extends HttpServlet {

    private ClientDB clientDB;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        clientDB = new ClientDB(dbUrl, dbUser, dbPassword);
    }

    private void doShowNotVerified(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vector<Client> clients = clientDB.getAllNotVerifyClients();
        request.setAttribute("clients", clients);
        getServletContext().getRequestDispatcher("/clientTable.jsp").forward(request, response);
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
        if (action == null || action.equalsIgnoreCase("")) {

        } else if (action.equals("deposit")) {
            String keyword = request.getParameter("keyword");
            if (keyword != null || action.equals("")) {
                request.setAttribute("clients", clientDB.queryClientByKeyword(keyword));
                getServletContext().getRequestDispatcher("/searchClientResultForDeposit.jsp").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("showNotVerified")) {
            doShowNotVerified(request, response);
        } else if (action.equalsIgnoreCase("depositClient")) {
            int client_id = Integer.parseInt(request.getParameter("client_id"));
            request.setAttribute("client", clientDB.getClient(client_id));
            getServletContext().getRequestDispatcher("/depositClient.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
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
