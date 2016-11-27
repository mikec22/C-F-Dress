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
    
    private String status = "cart";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

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
            if (orderLines.isEmpty()) {
                out.print("<h4 class=\"itemNumber\">No item here</h4>");
            } else {
                for (OrderLine ol : orderLines) {
                    String img = "<img src=\"img/item/" + ol.getItem().getImg() + "\" alt=\"\" class=\"itemImg\" />";
                    String name = ol.getItem().getName();
                    double unitPrice = ol.getItem().getPrice();
                    int quantity = ol.getQuantity();
                    double subtotal = quantity * unitPrice;
                    String total = "<p>HK$" + subtotal + "</p>\n";
                    String updateForm = "<form name='updateForm' action='CartItemController' method='post'><p> <input type=\"number\" min='1' name='quantity' value='" + quantity + "' class=\"qty\" /> "
                            + "x HK$" + unitPrice + "</p>\n"
                            + ""
                            + "<input type='hidden' name='action' value='update'/>\n"
                            + "<input type='hidden' name='id' value='" + ol.getItem().getItem_id() + "'/>\n"
                            + "<a href=\"javascript:document.updateForm.submit()\" class=\"update\"> UPDATE  </a>\n"
                            + "</form>";
                    String deleteBtn = "<form name='deleteItemForm' action='CartItemController' method='post'>" +
"                            <input type='hidden' name='action' value='delete'/>" +
"                            <input type='hidden' name='id' value='" + ol.getItem().getItem_id() + "'/>" +
"                            <a href=\"javascript:document.deleteItemForm.submit()\" class='remove'>X</a></form>" + 
                             "";
                    if(ol.getItem().getCategory().equals("gifts")){
                        total = "<p>" + subtotal + " BP</p>\n";
                        updateForm = "";
                    }
                    if(status.equals("result")){
                        updateForm = "";
                        deleteBtn = "";
                    }else if (status.equalsIgnoreCase("details")){
                        updateForm = "";
                        deleteBtn = "";
                    }
                    
                    out.print("<div class=\"heading cf\"><li class=\"items odd\">\n"
                            + "                        <div class=\"infoWrap\"> \n"
                            + "                            <div class=\"cartSection\">\n"
                            + img
                            + "<p class=\"itemNumber\">" + ol.getItem().getCategory() + "</p>\n"
                            + "                                <h3>" + name + "</h3>\n"
                            + "\n"
                            + updateForm
                            + "                                <p class=\"stockStatus\"></p>\n"
                            + "                            </div>"
                            + "<div class=\"prodTotal cartSection\">\n"
                            + total
                            + "                            </div>\n"
                            + "                            <div class=\"cartSection removeWrap\">\n"
                            + deleteBtn
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                    </li></div>");

//                out.println("<div><form action='CartItemController' method='GET'>"
//                        + img
//                        + name
//                        + unitPrice
//                        + "<input type='nunber' name='quantity' value='" + quantity + "' />"
//                        + subtotal
//                        + "<input type='submit' name='action' value='delect'><input type='submit' name='submit_btn' value='action'>"
//                        + "</form></div>");
                }
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemTag tag", ex);
        }
    }
}
