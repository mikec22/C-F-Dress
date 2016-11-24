/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Mike
 */
public class Order implements Serializable {

    private int order_id;
    private Client client;
    private Date delivery_datetime, order_datetime;
    private String address, option, status;
    private Vector<OrderLine> order_lines;

    public Order() {
        order_lines = new Vector<OrderLine>();
    }

    public Order(int order_id, Client client, Date delivery_datetime, Date order_datetime, String address, String option, String status, Vector<OrderLine> order_line) {
        this.order_id = order_id;
        this.client = client;
        this.delivery_datetime = delivery_datetime;
        this.order_datetime = order_datetime;
        this.address = address;
        this.option = option;
        this.status = status;
        this.order_lines = order_line;
    }

    public Vector<OrderLine> getOrder_lines() {
        return order_lines;
    }

    public void setOrder_lines(Vector<OrderLine> order_lines) {
        this.order_lines = order_lines;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDelivery_datetime() {
        return delivery_datetime;
    }

    public void setDelivery_datetime(Date delivery_datetime) {
        this.delivery_datetime = delivery_datetime;
    }

    public Date getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(Date order_datetime) {
        this.order_datetime = order_datetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(OrderLine orderLine) {
        //keep the quantity updated
        for (OrderLine ol : order_lines) {
            if (ol.getItem().getItem_id() == orderLine.getItem().getItem_id()) {
                ol.setQuantity(ol.getQuantity() + orderLine.getQuantity());
                return;
            }
        }

        order_lines.add(orderLine);
    }

    public void removeItem(OrderLine orderLine) {
        for (OrderLine ol : order_lines) {
            if (ol.getItem().getItem_id() == orderLine.getItem().getItem_id()) {
                order_lines.remove(ol);
                return;
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (OrderLine ol : order_lines) {
            totalPrice += ol.getItem().getPrice() * ol.getQuantity();
            System.out.println(ol.getPrice());
            System.out.println(totalPrice);
        }
        return totalPrice;
    }
}
