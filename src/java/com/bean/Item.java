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
public class Item implements Serializable {

    private int item_id;
    private String name, category, designer, description, img;
    private double price;

    public Item() {
    }

    public Item(int item_id, String name, String category, String designer,
            double price, String description, String img) {
        this.item_id = item_id;
        this.name = name;
        this.category = category;
        this.designer = designer;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Item{" + "item_id=" + item_id + ", name=" + name + ", category=" + category + ", designer=" + designer + ", img=" + img + ", price=" + price + "}\n";
    }

}
