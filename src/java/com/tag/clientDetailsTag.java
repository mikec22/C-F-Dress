/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import com.bean.Client;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fai
 */
public class clientDetailsTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    private Client client;
    private String action;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
    
    @Override
    public void doTag() throws JspException {
        if(client.getLogin_id()!=null){
            showDetails();
        }
    }
    
    private void showDetails()throws JspException {
        JspWriter out = getJspContext().getOut();
        String gender = client.getGender();
        gender = gender.equalsIgnoreCase("m") ? "Male":"Female";
        try {
            out.print("<div id=\"pricing\">\n" +
"                <div class=\"price_card bravo\">\n" +
"                    <div class=\"header\">\n" +
"                        <span class=\"price\">" + client.getName() + "</span>\n" +
"                        <span class=\"name\">"+gender+"</span>\n" +
"                    </div>\n" +
"                    <ul class=\"features\">\n" +
"                        <li><label>LoginID</label><br>" + client.getLogin_id() +"</li>\n" +        
"                        <li><label>Email</label><br>" + client.getEmail() +"</li>\n" +
"                        <li><label>Date of Birthday</label><br>"+ client.getDob() +"</li>\n" +
"                        <li><label>Telephone Number</label><br>"+ client.getPhone() +"</li>\n" +
"                        <li><label>Delivery Address</label><br>" + client.getAddress() + "</li>\n" +
"                        <li><label>Bonus Point</label><br>"+ client.getBonus_point() +"</li>\n" +
"                        <li><label>Balance</label><br> HK$ " + client.getBalance() + "</li>\n" +
"                        <li><label>Credit Amount</label><br> HK$ " + client.getCredit_amount() + "</li>\n" +
"                        <li><a href='ClientDetailsController?action=editForm'><input class='button' type='submit' value='Edit'/></li></a>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in clientDetailsTag tag", ex);
        }
    }
    
}
