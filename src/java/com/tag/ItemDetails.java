/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.Item;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fai
 */
public class ItemDetails extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            String cssClass;
            if (item.getCategory().equals("shoes")) {
                cssClass = "img1";
            } else {
                cssClass = "";
            }
            String img = "<img src='img/item/" + item.getImg() + "' class='" + cssClass + "' />";
            String name = "" + item.getName() + "<br>";
            String category = "<p>" + item.getCategory() + "</p>";
            String designer = "<p>" + item.getDesigner() + "</p>";
            String price = "<p>$ " + item.getPrice() + "</p>";
            
            out.print("<div class='left'><div class'left-content'>"
                    + img
                    + "</div></div>");
            out.print("<div class='right'>"
                    + name 
                    + category
                    + designer
                    + price
                    + "</div>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemDetails tag", ex);
        }
    }

}
