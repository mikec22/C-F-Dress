/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.Item;
import com.bean.Order;
import com.bean.OrderLine;
import java.util.Calendar;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author shukyan
 */
public class orderList extends SimpleTagSupport {

    private Vector<Order> orderList;
    private String type;

    public Vector<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Vector<Order> orderList) {
        this.orderList = orderList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean allowCancel(long order_date, long delivery_datetime, double amount, String option) {
        Calendar c = Calendar.getInstance();
        long current = c.getTimeInMillis();
        if ((current - order_date) > 86400000 && amount > 10000) {
            if (option.equals("self")) {
                return true;
            } else if (option.equals("delivery") && (delivery_datetime - current) > 86400000) {
                return true;
            }
        }

        return false;
    }

    public void doTag() throws JspException {
        if (type.equalsIgnoreCase("showOrderHistory")) {
            showOrderHistory();
        } else {
            showExistingOrders();
        }
    }

    private void showExistingOrders() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            out.print("*Only over HKD10000 order can cancel the order within 24 hours after\n"
                    + "ordered and at least 24 hours before delivery");

            for (Order order : orderList) {
                java.sql.Timestamp orderDate = order.getOrder_datetime();
                java.sql.Timestamp delivery_datetime = order.getDelivery_datetime();
                String[] datetime = delivery_datetime.toLocalDateTime().toString().split("T");
                int order_id = order.getOrder_id();
                double amount = order.getTotalPrice();
                String option = order.getOption();
                String address = order.getAddress();
                long order_date = orderDate.getTime();
                String ststus = order.getStatus();
                long delivery_Datetime = delivery_datetime.getTime();
                out.print("<br>id orderDate,(delivery date, time),amount, button");
                String displayStr = "<div><form method='POST' action='edtiExistingOrder'>"
                        + "<input type =\"hidden\" name =\"order_id\" value=\""
                        + order_id + "\">"
                        + "<input type =\"hidden\" name =\"ststus\" value=\""
                        + ststus + "\">"
                        + orderDate
                        + "$" + amount;
                if (option.equals("delivery")) {
                    displayStr += address
                            + "<input type =\"date\" name =\"delivery_date\" value=\""
                            + datetime[0]
                            + "\">" + "<input type =\"time\" name =\"delivery_time\" value=\""
                            + datetime[1] + "\">";
                }
                if (allowCancel(order_date, delivery_Datetime, amount, option)) {
                    displayStr += "<input type='submit' name='action' value='CancelOrder'>";
                }
                if (option.equals("delivery")) {
                    displayStr += "<input type='submit' name='action' value='updateOrder'></form></div>";
                }
                out.print(displayStr);

            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in tag", ex);
        }
    }

    private void showOrderHistory() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            if (orderList.isEmpty()) {
                out.print("<h3 style=\"text-align: center;\"'>No order history</h3>");
            } else {
                for (Order order : orderList) {
                    java.sql.Timestamp orderDate = order.getOrder_datetime();
                    java.sql.Timestamp delivery_datetime = order.getDelivery_datetime();
                    String[] datetime = delivery_datetime.toLocalDateTime().toString().split("T");
                    int order_id = order.getOrder_id();
                    double amount = order.getTotalPrice();
                    String option = order.getOption();
                    String address = order.getAddress();
                    String status = order.getStatus();
                    String delivery = "<p class=\"info\">Delivery Option : Self-pick up  </p>\n";
                    int totalItem = 0;
                    for (OrderLine orderLine : order.getOrder_lines()) {
                        totalItem += orderLine.getQuantity();
                    }
                    long delivery_Datetime = delivery_datetime.getTime();
                    if (option.equalsIgnoreCase("delivery")) {
                        if (order.getDelay_day() > 0) {
                            delivery = "<p class=\"info\">Delivery Time :  " + delivery_datetime + "</p>\n"
                                    + "<p class=\"info\">Delivery Address : " + address + " </p>"
                                    + "<p class=\"info\">Delay Day : " + order.getDelay_day() + " </p>";
                        } else {
                            delivery = "<p class=\"info\">Delivery Time :  " + delivery_datetime + "</p>\n"
                                    + "<p class=\"info\">Delivery Address : " + address + " </p>\n";
                        }
                    }
                    out.print("<div class='orderCard card-1'>\n"
                            + "                    <div id=\"left\">\n"
                            + "                        <p class=\"info\">Order ID : " + order_id + "</p>\n"
                            + "                        <p class=\"info\">Order Time : " + orderDate + " </p>\n"
                            + delivery
                            + "                    </div>\n"
                            + "                    <div id=\"right\" class=\"totalRow\">\n"
                            + "                        <p class=\"price\">Total item : <span class=\"value\">" + totalItem + "</span></p>\n"
                            + "                        <p class=\"price\">Bonus Points : " + order.getUseBonusPoints() + "</p>\n"
                            + "                        <p class=\"price\">Total Price : " + amount + "</p>\n"
                            + "                        <p class=\"price\">Status : " + status + "</p>\n"
                            + "                        <form name='getDetails' mothod='post' action='history'>"
                            + "                        <input type='hidden' name='action' value='getOrderDetails'>"
                            + "                        <input type='hidden' name='id' value='" + order.getOrder_id() + "'>"
                            + "<a href='javascript:document.getDetails.submit()' class=\"continue\">More Details</a></form>\n"
                            + "                    </div>\n"
                            + "                </div>");
                }
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in tag", ex);
        }
    }
}
