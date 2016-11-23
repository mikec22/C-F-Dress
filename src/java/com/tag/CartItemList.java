/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.CartItem;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author shukyan
 */
public class CartItemList extends SimpleTagSupport {

    private ArrayList<CartItem> cartItems;

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {

            for (CartItem cartItem : cartItems) {
                String img = "<img src='img/item/" + cartItem.getItem().getImg() + "'/>";
                String name = cartItem.getItem().getName();
                double unitPrice = cartItem.getItem().getPrice();
                double quantity = cartItem.getQuantity();
                double price = quantity * unitPrice;

                out.println("<div><form action='' method='GET'>"
                        + img
                        + name
                        + unitPrice
                        + "<input type='nunber' name='quantity' value='" + quantity + "' />"
                        + price
                        + "<input type='submit' name='submit_btn' value='Update'><input type='submit' name='submit_btn' value='Update'>"
                        + "</form></div>");
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in ItemTag tag", ex);
        }
    }
}
