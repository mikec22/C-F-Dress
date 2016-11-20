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
    private String address, status;
    private Vector<OrderLine> order_line;

    public Order() {
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

    public Vector<OrderLine> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(Vector<OrderLine> order_line) {
        this.order_line = order_line;
    }

}
