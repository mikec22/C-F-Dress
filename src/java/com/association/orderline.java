/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.association;

import com.bean.CartItem;
import java.util.ArrayList;

/**
 *
 * @author shukyan
 */
public class orderline {

    private ArrayList<CartItem> cartItems;

    public orderline() {
        cartItems = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getItems() {
        return cartItems;
    }

    public void addItem(CartItem cartItem) {
        //keep the quantity updated
        for (CartItem ci : cartItems) {
            if (ci.getItem().getItem_id() == cartItem.getItem().getItem_id()) {
                ci.setQuantity(cartItem.getQuantity());
                break;
            }
        }

        cartItems.add(cartItem);
    }

    public void removeItem(CartItem cartItem) {
        for (CartItem ci : cartItems) {
            if (ci.getItem().getItem_id() == cartItem.getItem().getItem_id()) {
                cartItems.remove(ci);
                break;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;

        for (CartItem ci : cartItems) {
            total = ci.getItem().getPrice()*ci.getQuantity();
        }

        return total;
    }

}
