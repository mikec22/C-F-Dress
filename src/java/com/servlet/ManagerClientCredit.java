/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.db.ClientDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mike
 */
@WebServlet(name = "ManagerClientCredit", urlPatterns = {"/managerClientCredit"})
public class ManagerClientCredit extends HttpServlet {

    private ClientDB clientDB;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        clientDB = new ClientDB(dbUrl, dbUser, dbPassword);
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
            getServletContext().getRequestDispatcher("/searchClientForManager.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("deposit")) {
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            int client_id = Integer.parseInt(request.getParameter("client_id"));
            if (clientDB.depositClient(client_id, quantity)) {
                response.sendRedirect(request.getContextPath()
                        + "/queryClients?action=changeBalance&client_id=" + client_id);
            } else {
                request.setAttribute("msg", "The quantity must be greater than zero. Please try again!");
                this.getServletContext().getRequestDispatcher("/queryClients?action=changeBalance&"
                        + "client_id=" + client_id).forward(request, response);
            }

        } else if (action.equalsIgnoreCase("withdraw")) {
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            int client_id = Integer.parseInt(request.getParameter("client_id"));
            if (clientDB.withdrawClient(client_id, quantity)) {
                response.sendRedirect(request.getContextPath()
                        + "/queryClients?action=changeBalance&client_id=" + client_id);
            } else {
                request.setAttribute("msg", "The quantity must be greater than zero. Please try again!");
                this.getServletContext().getRequestDispatcher("/queryClients?action=changeBalance&"
                        + "client_id=" + client_id).forward(request, response);
            }

        } else if (action.equalsIgnoreCase("approvalCredit")) {
            double amount = Double.parseDouble(request.getParameter("quantity"));
            int client_id = Integer.parseInt(request.getParameter("client_id"));
            if (clientDB.approvalCredit(client_id, amount)) {
                response.sendRedirect(request.getContextPath()
                        + "/queryClients?action=changeBalance&client_id=" + client_id);
            } else {
                request.setAttribute("msg", "The Credit must be greater than or equals zero. Please try again!");
                this.getServletContext().getRequestDispatcher("/queryClients?action=changeBalance&"
                        + "client_id=" + client_id).forward(request, response);
            }

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
        response.sendRedirect(request.getContextPath() + "/ManagerLogin");
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
