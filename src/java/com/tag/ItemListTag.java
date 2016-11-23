/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.Item;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fai
 */
public class ItemListTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    private Vector<Item> itemList;

    public Vector<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Vector<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            for (Item item : itemList) {
                String cssClass;
                if (item.getCategory().equals("shoes")) {
                    cssClass = "img1";
                } else {
                    cssClass = "";
                }
                String img = "<img src='img/item/" + item.getImg() + "' class='"+ cssClass +"' />";
                String name = "<p class='title'>" + item.getName() + "</p>";
                String category = "<p class='type'>" + item.getCategory() + "</p>";
                String designer = "<p class='designer'>Design by : " + item.getDesigner() + "</p>";
                String price = "<p class='price'>$ " + item.getPrice() + "</p>";
                
                out.print("<div class='card card-1'><a href='item?action=getItem&id="+ item.getItem_id() +"'>" + 
                        img + "</a>" +
                        name + 
                        category + 
                        designer + 
                        price + 
                        "</div>");
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemTag tag", ex);
        }
    }

}
