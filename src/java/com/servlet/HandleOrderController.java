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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HandleOrderController", urlPatterns = {"/HandleOrderController"})
public class HandleOrderController extends HttpServlet {

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
        String action = request.getParameter("action");
        if (!isAuthenticated(request)) {
            doLogin(request, response);
        } else {
            if (action == null) {
                action = "";
            }
            if (action.equals("chooseOption")) {
                chooseDeliveryPption(request, response);
            } else if (action.equals("placeOrder")) {
                toPlaceOrder(request, response);
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
    
    private String isVaild(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        Order order = (Order) session.getAttribute("cart");
        double amount = order.getTotalPrice();
        double balance = client.getBalance();
        double credit = client.getCredit_amount();
        int dp = order.getUseBonusPoints();
        int client_dp = client.getBonus_point();
        String msg;
        if (((balance + credit) <= amount) && (dp >= client_dp)) {
            msg = "Balance and Bonus Points not enough ";
        } else if ((balance + credit) <= amount) {
            msg = "Balance not enough ";
        } else if ((dp >= client_dp)) {
            msg = "Bonus Points not enough ";
        }else {
            msg = "OK";
        }
        return msg;
    }

    private void chooseDeliveryPption(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = isVaild(request,response);
        if(msg.equalsIgnoreCase("OK")){
            request.getRequestDispatcher("/placeOrder.jsp").forward(request, response);
        }else{
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        }
    }

    private void toPlaceOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String msg = "";
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        int client_id = client.getClient_id();
        int a = -1;
        Calendar c = Calendar.getInstance();

// set the calendar to start of today
        c.set(Calendar.DAY_OF_WEEK, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_WEEK, -1);

        boolean isVaild = false;
        //default 1999-01-01 01:01:01;
        String datetime = "1999-01-01 01:01:01";
        String address = client.getAddress();
        String option = request.getParameter("delivery_method");
        if (option.equals("delivery")) {
            datetime = request.getParameter("delivery_date")
                    + " " + request.getParameter("delivery_time") + ":00";
            java.sql.Timestamp delivery_datetime = java.sql.Timestamp.valueOf(datetime);
            java.util.Date today = c.getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date delivery_date;
            try {
                delivery_date = df.parse(request.getParameter("delivery_date"));
                a = delivery_date.compareTo(Calendar.getInstance().getTime());
                isVaild = delivery_date.compareTo(Calendar.getInstance().getTime()) == 1;
                
            } catch (ParseException ex) {
                Logger.getLogger(HandleOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (option.equals("self")) {
            address = "self pick-up";
            isVaild = true;
        }

        String status = "processing";
        Order order = (Order) session.getAttribute("cart");
        double amount = order.getTotalPrice();
        double balance = client.getBalance();
        double credit = client.getCredit_amount();
        int dp = order.getUseBonusPoints();
        int client_dp = client.getBonus_point();
        if (!isVaild) {
            msg = "The delivery date Can not be greater than the current time";
        } else if (((balance + credit) <= amount) && (dp >= client_dp)) {
            msg = "Balance and Bonus Points not enough ";
        } else if ((balance + credit) <= amount) {
            msg = "Balance not enough ";
        } else if ((dp >= client_dp)) {
            msg = "Bonus Points not enough ";
        } else {
            order.setAddress(address);
            order.setOption(option);
            Vector<OrderLine> order_line = order.getOrder_lines();
            boolean add = orderDB.addOrder(client_id, datetime, address, option, status, order_line);
            if (add) {
                msg = "add Order success";
                Order orderResult = orderDB.getLastOrder();
                int bonus_point = client.getBonus_point();
                if (amount > 2000) {
                    bonus_point += (int) (amount * 0.05);
                }
                
                balance -= amount;
                bonus_point -= dp;
                client.setBalance(balance);
                client.setBonus_point(bonus_point);
                if (clientDB.updateClientBalanceBonusPoints(client)) {
                    msg = "success";
                    client = clientDB.getClient(client.getClient_id());
                    session.setAttribute("clientInfo", client);
                    session.removeAttribute("cart");
                    request.setAttribute("orderResult", orderResult);
                    request.setAttribute("status","result");
                    getServletContext().getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
                } else {
                    msg = "fail";
                }
            } else {
                msg = "fail";
            }
        }
        
        System.out.print(request.getParameter("delivery_date"));
        System.out.print(msg);
        System.out.print(a);
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
