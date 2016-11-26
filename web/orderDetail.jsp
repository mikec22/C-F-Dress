<%-- 
    Document   : orderDetail
    Created on : Nov 25, 2016, 12:03:29 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="order" scope="request" class="com.bean.Order"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr><td>Client Name:<td><td><%= order.getClient().getName() %></td></tr>
            <tr><td>Delivery_Datetime:</td><td><%= order.getDelivery_datetime() %></td></tr>
            <tr><td>Order_Datetime:</td><td><%= order.getOrder_datetime() %></td></tr>
            <tr><td>Address:</td><td><%= order.getAddress() %></td></tr>
            <tr><td>Option:</td><td><%= order.getOption() %></td></tr>
            <tr><td>Status:</td><td><%= order.getStatus() %></td></tr>
        </table>
        <h1>Item</h1>
        <table>
            
        </table>
        <form>

        </form>
    </body>
</html>
