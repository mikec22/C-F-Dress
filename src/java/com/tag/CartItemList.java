/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.OrderLine;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author shukyan
 */
public class CartItemList extends SimpleTagSupport {

    private Vector<OrderLine> orderLines;

    public Vector<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Vector<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {

            for (OrderLine ol : orderLines) {
                String img = "<img src='img/item/" + ol.getItem().getImg() + "'/>";
                String name = ol.getItem().getName();
                double unitPrice = ol.getItem().getPrice();
                double quantity = ol.getQuantity();
                double subtotal = quantity * unitPrice;

                out.println("<div><form action='handleCartItem' method='GET'>"
                        + img
                        + name
                        + unitPrice
                        + "<input type='nunber' name='quantity' value='" + quantity + "' />"
                        + subtotal
                        + "<input type='submit' name='action' value='Update'><input type='submit' name='submit_btn' value='action'>"
                        + "</form></div>");
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemTag tag", ex);
        }
    }
}
