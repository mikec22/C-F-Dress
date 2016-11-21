/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;

/**
 *
 * @author Mike
 */
public class OrderLine implements Serializable {
    private Order order;
    private Item item;
    private double price;
    private int quantity;

    public OrderLine(Order order, Item item, double price, int quantity) {
        this.order = order;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderLine() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
