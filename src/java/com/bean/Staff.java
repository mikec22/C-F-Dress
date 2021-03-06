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
public class Staff implements Serializable {

    private int staff_id;
    private String login_id, password, name, gender;

    public Staff() {
    }

    public Staff(int staff_id, String login_id, String password, String name, String gender) {
        this.staff_id = staff_id;
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.gender = gender;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Staff{" + "staff_id=" + staff_id + ", login_id=" + login_id + ", password=" + password + ", name=" + name + ", gender=" + gender + '}';
    }

}
