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

    public Vector<Order> getOrders() {
        return existingOrders;
    }

    public void setOrders(Vector<Order> existingOrders) {
        this.existingOrders = existingOrders;
    }

    public boolean allowCancel(long order_date, double amount) {
        Calendar c = Calendar.getInstance();
        long current = c.getTimeInMillis();
        if ((current - order_date) > 86400000 || amount > 10000) {
            return true;
        }
        return false;

    }

    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {

            for (Order order : existingOrders) {
                out.print("<form method='' action''>");
                String orderDate = order.getOrder_datetime().toString();
                String delivery_datetime = order.getDelivery_datetime().toString();
                String[] datetime = delivery_datetime.split(" ");
                int order_id = order.getOrder_id();
                double amount = order.getTotalPrice();
                String option = order.getOption();
                String address = order.getAddress();
                long order_date = order.getOrder_datetime().getTime();
                String displayStr = "<div><form method='' action''>"+ order_id 
                        + orderDate + "<input type ='text' name ='address' value='" 
                        + address + "'>" +"<input type ='date' name ='delivery_date' value='" 
                        + datetime[0] + "'>"+"<input type ='date' name ='delivery_time' value='" 
                        + datetime[1] + "'>" + "$"+amount;

                if (allowCancel(order_date, amount)) {
                    displayStr += "<input type='submit' name'action' value='CancelOrder'>";
                }
                displayStr += "<input type='submit' name'action' value='updateOrder'></form></div>";
                out.println(displayStr);

            }

        }catch (java.io.IOException ex) {
            throw new JspException("Error in tag", ex);
        }

    }

}
