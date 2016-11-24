package com.servlet;

import com.bean.Client;
import com.bean.Order;
import com.bean.OrderLine;
import com.db.OrderDB;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
 * @author shukyan
 */
@WebServlet(name = "HandleOrderController", urlPatterns = {"/HandleOrderController"})
public class HandleOrderController extends HttpServlet {

    private OrderDB orderDB;

    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        orderDB = new OrderDB(dburl, dbUser, dbPassword);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("delivery_datetime"));
        String action = request.getParameter("action");
        if (action.equals("placeOrder")) {
        }
        //Date delivery_datetime = java.sql.Date.valueOf(request.getParameter("delivery_datetime"));
//        String delivery_datetime = request.getParameter("delivery_datetime");
        String delivery_datetime = "1999-05-05 13:44:00";
        String option = request.getParameter("delievry_method");
        Client client = (Client) request.getAttribute("client");
//        int client_id = client.getClient_id();
        int client_id = 1;
        String address = request.getParameter("delivery_address");
        String status = "processing";
        Order order= (Order)session.getAttribute("cart");
//        Vector<OrderLine> order_line = order.getOrder_lines();
        Vector<OrderLine> order_line = null;
        System.out.print(order_line);
        orderDB.addOrder(client_id, delivery_datetime, address, option, status, order_line);
          
//        String targetUrl = "/placeOrder.jsp";
//        response.sendRedirect(targetUrl);
//        }
    }
}