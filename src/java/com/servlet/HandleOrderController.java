package com.servlet;

import com.bean.Client;
import com.bean.Order;
import com.bean.OrderLine;
import com.db.ClientDB;
import com.db.OrderDB;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
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
    private ClientDB clientDB;

    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        orderDB = new OrderDB(dburl, dbUser, dbPassword);
        clientDB = new ClientDB(dburl, dbUser, dbPassword);
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
        String action = request.getParameter("action");
        String msg = "";
//        if (action.equals("placeOrder")) {

        Calendar c = Calendar.getInstance();

// set the calendar to start of today
        c.set(Calendar.DAY_OF_WEEK, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_WEEK, -1);

// and get that as a Date
//        Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//        Date delivery_date =  java.sql.Date.valueOf(request.getParameter("delivery_date"));
//        Date delivery_datetime = java.sql.Date.valueOf(datetime);
        boolean isVaild = false;
        String datetime = request.getParameter("delivery_date")
                + " " + request.getParameter("delivery_time") + ":00";
        java.sql.Timestamp delivery_datetime = java.sql.Timestamp.valueOf(datetime);
        java.util.Date today = c.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date delivery_date;
        try {
            delivery_date = df.parse(request.getParameter("delivery_date"));
            isVaild = delivery_date.compareTo(today) == 1;

        } catch (ParseException ex) {
            Logger.getLogger(HandleOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String option = request.getParameter("delivery_method");
        Client client = (Client) session.getAttribute("clientInfo");
        client = clientDB.getClient(client.getClient_id());
        session.setAttribute("clientInfo", client);
        int client_id = client.getClient_id();
        String address = request.getParameter("delivery_address");
        String status = "processing";
        Order order = (Order) session.getAttribute("cart");
        double amount = order.getTotalPrice();
        double balance = client.getBalance();
        double credit = client.getCredit_amount();
        int dp = order.getUseBonusPoints();
        int client_dp = client.getBonus_point();
        if (!isVaild) {
            msg = "The delivery date Can not be greater than the current time";
        } else {
            if (((balance + credit) < amount) && (dp > client_dp)) {
                msg = "Balance and Bonus Points not enough ";
            } else if ((balance + credit) < amount) {
                msg = "Balance not enough ";
            } else if ((dp > client_dp)) {
                msg = "Bonus Points not enough ";
            } else {
                Vector<OrderLine> order_line = order.getOrder_lines();
                boolean add = orderDB.addOrder(client_id, datetime, address, option, status, order_line);
                if (add) {
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
                        Order orderResult = new Order();
                        orderResult.setOrder_lines(order.getOrder_lines());
                        order = new Order();
                        client = clientDB.getClient(client.getClient_id());
                        session.setAttribute("clientInfo", client);
                        session.setAttribute("cart", order);
                        request.setAttribute("orderResult", orderResult);
                        getServletContext().getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
                    }
                } else {
                    msg = "fail";
                }
            }
        }

        System.out.println("Message:   " + msg);
    }
//        String targetUrl = "/placeOrder.jsp";
//        response.sendRedirect(targetUrl);
//        }
//    }
}
