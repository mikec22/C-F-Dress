/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.bean.CartItem;
import java.util.ArrayList;

/**
 *
 * @author shukyan
 */
public class ShoppingCart {

    private ArrayList<CartItem> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<CartItem>();
    }

    public ShoppingCart(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList<CartItem> getItems() {
        return cartItems;
    }

    public void addItem(CartItem cartItem) {
        //keep the quantity updated
        for (CartItem ci : cartItems) {
            if (ci.getItem().getItem_id() == cartItem.getItem().getItem_id()) {
                ci.setQuantity(ci.getQuantity() + cartItem.getQuantity());
                return;
            }
        }

        cartItems.add(cartItem);
    }

    public void removeItem(CartItem cartItem) {
        for (CartItem ci : cartItems) {
            if (ci.getItem().getItem_id() == cartItem.getItem().getItem_id()) {
                cartItems.remove(ci);
                return;
            }
        }
    }

    public void changeQuantity(int id,int quantity) {
        for (CartItem ci : cartItems) {
            if (ci.getItem().getItem_id() == id) {
                ci.setQuantity(quantity);
                return;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem ci : cartItems) {
            total = ci.getItem().getPrice() * ci.getQuantity();
        }
        return total;
    }

}
