/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Client;
import com.db.ClientDB;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fai
 */
@WebServlet(name = "RegistrationController", urlPatterns = {"/Register"})
public class RegistrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ClientDB db;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new ClientDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            doRegistering(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }

    private void doRegistering(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login_id, name, gender, email, password, phone, address;
        Date dob;
        String targetURL;
        Client client;
        ArrayList<String> clientData = new ArrayList();
        Enumeration eParams = request.getParameterNames();
        while (eParams.hasMoreElements()) {
            String strParam = (String) eParams.nextElement();
            String data;
            if (request.getParameter(strParam) == null) {
                data = "";
            } else {
                data = request.getParameter(strParam);
            }
            clientData.add(data);
        }
        login_id = clientData.get(1);
        name = clientData.get(2);
        gender = clientData.get(3);
        email = clientData.get(4);
        password = clientData.get(5);
        phone = clientData.get(7);
        dob = java.sql.Date.valueOf(clientData.get(8));
        address = clientData.get(9);
        boolean isExist = db.isExistClient(login_id, email);
        if (isExist || !clientData.get(5).equals(clientData.get(6))){
            targetURL = "/loginError.jsp";
        } else {
            client = new Client(login_id, name, gender, email, password, phone, dob, address);
            db.addClient(client);
            targetURL = "/RegisterResult.jsp";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);

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
