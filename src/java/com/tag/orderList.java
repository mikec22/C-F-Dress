/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.Item;
import com.bean.Order;
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

    private Vector<Order> existingOrders;

    public Vector<Order> getExistingOrders() {
        return existingOrders;
    }

    public void setExistingOrders(Vector<Order> existingOrders) {
        this.existingOrders = existingOrders;
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
        JspWriter out = getJspContext().getOut();

        try {
            out.print("*Only over HKD10000 order can cancel the order within 24 hours after\n"
                    + "ordered and at least 24 hours before delivery");

            for (Order order : existingOrders) {

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

}
