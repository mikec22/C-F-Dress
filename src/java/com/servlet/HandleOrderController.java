package com.servlet;

import com.bean.Client;
import com.bean.Order;
import com.bean.OrderLine;
import com.db.OrderDB;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Vector;
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
        String action = request.getParameter("action");
        String msg = "";
//        if (action.equals("placeOrder")) {

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();

// set the calendar to start of today
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

// and get that as a Date
            Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            Date delivery_datetime = java.sql.Date.valueOf(request.getParameter("delivery_date")
                    + " " + request.getParameter("delivery_time") + ":00");

            boolean isVaild = today.compareTo(delivery_datetime) == 1;

            String option = request.getParameter("delivery_method");
            Client client = (Client) session.getAttribute("clientInfo");
            int client_id = client.getClient_id();
            String address = request.getParameter("delivery_address");
            String status = "processing";
            Order order = (Order) session.getAttribute("cart");
            System.out.println("I AM HERE ID: " + client_id);
            double amount = order.getTotalPrice();
            double balance = client.getBalance();
            double credit = client.getCredit_amount();
            System.out.println("I AM HERE A: " + amount + " B: " + balance + " C: " + credit);
            if ((balance + credit) < amount) {
                msg = "Balance not enough ";
            } else {
                Vector<OrderLine> order_line = order.getOrder_lines();
                System.out.println("I AM HERE" + order_line);
                boolean add = orderDB.addOrder(client_id, delivery_datetime, address, option, status, order_line);
                System.out.println("I AM HERE AFTER ADD" + add);
                if (add) {
                    int bonus_point = client.getBonus_point();
                    if (amount > 2000) {
                        bonus_point += (int) (amount * 0.05);
                    }
                    msg = "success";
                } else {
                    msg = "fail";
                }
            }

            System.out.println("Message:   " + msg);
        }
//        String targetUrl = "/placeOrder.jsp";
//        response.sendRedirect(targetUrl);
//        }
//    }
}
