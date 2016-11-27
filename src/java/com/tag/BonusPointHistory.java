package com.tag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.bean.OrderLine;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fai
 */
public class BonusPointHistory extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    private Vector<OrderLine> bpList;

    public Vector<OrderLine> getBpList() {
        return bpList;
    }

    public void setBpList(Vector<OrderLine> bpList) {
        this.bpList = bpList;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            if (bpList.isEmpty()) {
                out.print("<h3 style=\"text-align: center;\"'>No use bonus points history</h3>");
            } else {
                for (OrderLine orderLine : bpList) {
                    out.print("<div class='orderCard card-1'>\n"
                            + "                    <div id=\"left\">\n"
                            + "                     <img src='img/item/" + orderLine.getItem().getImg() + "' />"
                            + "                        <p class=\"info\">" + orderLine.getItem().getName() + "</p>"
                            + "                    </div>\n"
                            + "                    <div id=\"right\" class=\"totalRow\">\n"
                            + "                        <p class=\"info\">Order ID : " + orderLine.getOrder().getOrder_id() + "</p>"
                            + "                        <p class=\"info\">Order Time : " + orderLine.getOrder().getOrder_datetime() + " </p>"
                            + "                        <p class=\"price\">Use Bonus Points : " + orderLine.getOrder().getUseBonusPoints() + "</p>\n"
                            + "                    </div>\n"
                            + "                </div>");
                }
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in BonusPointHistory tag", ex);
        }
    }

}
