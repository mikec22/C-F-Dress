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
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ClientDetailsController", urlPatterns = {"/ClientDetailsController"})
public class ClientDetailsController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        if (action.equals("getClient")) {
            getClient(request, response);
        } else if (action.equals("editForm")) {
            editForm(request, response);
        } else if (action.equals("submitEdit")) {
            submitEdit(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
//            String referer = request.getHeader("Referer");
//            response.sendRedirect(referer);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    private void getClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Client client = (Client) session.getAttribute("clientInfo");
        client = db.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
//        request.setAttribute("client", client);
        getServletContext().getRequestDispatcher("/clientDetails.jsp").forward(request, response);
//        getServletContext().getRequestDispatcher("/clientDetails.jsp");
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Client client = (Client) session.getAttribute("clientInfo");
        client = db.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        getServletContext().getRequestDispatcher("/editClientDetails.jsp").forward(request, response);
    }

    private void submitEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        Client client = db.getClient(client_id);
        String name = (request.getParameter("name") == null|| request.getParameter("name").equals("")) ? client.getName() : request.getParameter("name");
        String gender = (request.getParameter("gender") == null|| request.getParameter("gender").equals("")) ? client.getGender() : request.getParameter("gender");
        String password = (request.getParameter("password") == null || request.getParameter("password").equals("")) ? client.getPassword() : request.getParameter("password");
        String cpassword = (request.getParameter("cpassword") == null|| request.getParameter("cpassword").equals("")) ? client.getPassword() : request.getParameter("cpassword");
        String email = (request.getParameter("email") == null|| request.getParameter("email").equals("")) ? client.getEmail() : request.getParameter("email");
        String phone = (request.getParameter("phone") == null|| request.getParameter("phone").equals("")) ? client.getPhone() : request.getParameter("phone");
        Date dob = (request.getParameter("dob") == null || request.getParameter("dob").equals(""))? client.getDob() : java.sql.Date.valueOf(request.getParameter("dob"));
        String address = (request.getParameter("address") == null|| request.getParameter("address").equals("")) ? client.getAddress() : request.getParameter("address");
        if (!password.equals(cpassword)) {
            request.setAttribute("msg", "Password not match");
        } else {
            client.setName(name);
            client.setGender(gender);
            client.setAddress(address);
            client.setDob(dob);
            client.setEmail(email);
            client.setPhone(phone);
            client.setPassword(cpassword);
            if (db.updateClient(client)) {
                request.setAttribute("msg", "Your registeration successful!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientDetailsController?action=getClient");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "The account already existed!");
            }

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
