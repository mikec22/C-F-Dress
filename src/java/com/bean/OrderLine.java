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
    private double totalPrice;
    private double price;
    private int quantity;
    private int bonusPoint;

    public OrderLine(Order order, Item item, double price, int quantity) {
        this.order = order;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.bonusPoint = 0;
    }
    
    public OrderLine(Order order, Item item, int bounsPoint, int quantity) {
        this.order = order;
        this.item = item;
        this.price = 0;
        this.totalPrice = 0;
        this.quantity = quantity;
        this.bonusPoint = bounsPoint;
    }

    public OrderLine() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
    
    public double getSubTotal(){
        return price*quantity;
    }
}
