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
public class ItemTag extends SimpleTagSupport {

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
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            for(Item item : itemList){
                out.print("<div class='card card-1'><img src='img/item/"+ item.getImg() +"'><p><br>" + 
                        item.getName() + "<br>" + item.getCategory() + "<br>$" + item.getPrice() + "</p></div>");
            }
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemTag tag", ex);
        }
    }
    
}
