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
        if(item.getCategory().equals("gifts")){
            showGiftsItem();
        }else{
            showSellItem();
        }
    }
    
    private void showGiftsItem() throws JspException{
        JspWriter out = getJspContext().getOut();
        try {
            String cssClass = "img1";
            String img = "<img src='img/item/" + item.getImg() + "' class='" + cssClass + "' />";
            String name = "<p class='title'>" + item.getName() + "</p>";
            String category = "<p class='type'>" + item.getCategory() + "</p>";
            String designer = "<p>Design by</p><p class='designer'>" + item.getDesigner() + "</p>";
            String price = "<p class='price'>" + item.getPrice() + "<label class='bp'> Bonus Point</label> </p> ";
            String desc = "<p class='desc'>" + item.getDescription() + "</p>";
            String form = "<form method='post' action='shoppingCart'>\n" +
"                    <input type='hidden' name='action' value='addToCart'>"
                    + "<input type='hidden' name='itemId' value='"+ item.getItem_id() +"'>"
                    + 
"                    <input type=\"submit\" class=\"btn\" value=\"Redeem\">\n" +
"                </form>";
            
            out.print("<div class='left'><div class'left-content'>"
                    + img
                    + designer
                    + "</div></div>");
            out.print("<div class='right'>"
                    + name 
                    + category
                    + desc
                    + price
                    + form
                    + "</div>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemDetails tag", ex);
        }
    }
    
    private void showSellItem() throws JspException{
        JspWriter out = getJspContext().getOut();
        try {
            String cssClass;
            if (item.getCategory().equals("shoes")) {
                cssClass = "img1";
            } else {
                cssClass = "";
            }
            String img = "<img src='img/item/" + item.getImg() + "' class='" + cssClass + "' />";
            String name = "<p class='title'>" + item.getName() + "</p>";
            String category = "<p class='type'>" + item.getCategory() + "</p>";
            String designer = "<p>Design by</p><p class='designer'>" + item.getDesigner() + "</p>";
            String price = "<p class='price'>HKD$ " + item.getPrice() + "</p>";
            String desc = "<p class='desc'>" + item.getDescription() + "</p>";
            String form = "<form method='post' action='shoppingCart'>\n" +
"                    <div class='qty'><label for=\"quantity\">Quantity : </label>\n" +
"                    <input type='hidden' name='action' value='addToCart'>"
                    + "<input type='hidden' name='itemId' value='"+ item.getItem_id() +"'>"
                    + "<input type='number' min='1' size='5' id='numberinput' name='quantity' value='1' /></div>\n" +
"                    <input type=\"submit\" class=\"btn\" value=\"Add To Cart\">\n" +
"                </form>";
            
            out.print("<div class='left'><div>"
                    + img
                    + designer
                    + "</div></div>");
            out.print("<div class='right'>"
                    + name 
                    + category
                    + desc
                    + price
                    + form
                    + "</div>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemDetails tag", ex);
        }
    }

}
