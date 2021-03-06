/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author Mike
 */
public class Order implements Serializable {

    private int order_id,delay_day;
    private Client client;
    private Timestamp delivery_datetime, order_datetime;
    private String address, option, status;
    private Vector<OrderLine> order_lines;

    public Order() {
        order_lines = new Vector<OrderLine>();
    }

    public Order(int order_id, Client client, Timestamp delivery_datetime, Timestamp order_datetime, String address, String option, String status, Vector<OrderLine> order_line) {
        this.order_id = order_id;
        this.client = client;
        this.delivery_datetime = delivery_datetime;
        this.order_datetime = order_datetime;
        this.address = address;
        this.option = option;
        this.status = status;
        this.order_lines = order_line;
    }
    
    public Order(int order_id, Client client, Timestamp delivery_datetime, Timestamp order_datetime, String address, String option, String status, Vector<OrderLine> order_line,int delay_day) {
        this.order_id = order_id;
        this.client = client;
        this.delivery_datetime = delivery_datetime;
        this.order_datetime = order_datetime;
        this.address = address;
        this.option = option;
        this.status = status;
        this.order_lines = order_line;
        this.delay_day = delay_day;
    }

    public int getDelay_day() {
        return delay_day;
    }

    public void setDelay_day(int delay_day) {
        this.delay_day = delay_day;
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

    public Timestamp getDelivery_datetime() {
        return delivery_datetime;
    }

    public void setDelivery_datetime(Timestamp delivery_datetime) {
        this.delivery_datetime = delivery_datetime;
    }

    public Timestamp getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(Timestamp order_datetime) {
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
                if(!ol.getItem().getCategory().equalsIgnoreCase("gifts")){
                    ol.setQuantity(ol.getQuantity() + orderLine.getQuantity());
                }
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
            if(!ol.getItem().getCategory().equals("gifts")){
                totalPrice += ol.getItem().getPrice() * ol.getQuantity();
            }
            System.out.println(ol.getPrice());
            System.out.println(totalPrice);
        }
        return totalPrice;
    }
    
    public int getUseBonusPoints(){
        int bp = 0;
        for (OrderLine ol : order_lines) {
            if(ol.getItem().getCategory().equals("gifts")){
                bp += ol.getItem().getPrice() * ol.getQuantity();
            }
        }
        return bp;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", client=" + client + ", delivery_datetime=" + delivery_datetime + ", order_datetime=" + order_datetime + ", address=" + address + ", option=" + option + ", status=" + status + ", order_lines=" + order_lines + '}';
    }
}
