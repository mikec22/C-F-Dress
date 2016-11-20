/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Mike
 */
public class Client implements Serializable {

    private int client_id, bonus_point;
    private String login_id, password, name, email, phone, address, gender;
    private double balance;
    private Date dob;
    private boolean verified;

    public Client() {
    }

    public Client(int client_id, String login_id, String password, String name, 
            String gender, Date dob, String email, String phone, String address, 
            int bonus_point, boolean verified, double balance) {
        this.client_id = client_id;
        this.bonus_point = bonus_point;
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.balance = balance;
        this.dob = dob;
        this.verified = verified;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getBonus_point() {
        return bonus_point;
    }

    public void setBonus_point(int bonus_point) {
        this.bonus_point = bonus_point;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", bonus_point=" + bonus_point + ", login_id=" + login_id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", balance=" + balance + ", dob=" + dob + ", verified=" + verified + '}';
    }
}
