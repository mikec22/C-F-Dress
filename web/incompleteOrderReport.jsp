<%-- 
    Document   : incompleteOrderReport
    Created on : Nov 24, 2016, 6:36:40 PM
    Author     : Mike
--%>

<%@page import="com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="checkIsManagerLogin.jsp" %>
<jsp:useBean id="orders" scope="request" class="java.util.Vector<Order>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Report</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <div style="text-align: center;margin: auto; width: 80%;">
            <h2>Incomplete Order</h2>
            <table border="1" style="text-align: center;">
                <tr><th>Client Name</th><th>Delivery_Datetime</th><th>Order_Datetime</th><th>Address</th><th>Option</th><th>Status</th></tr>
                        <%
                            for (Order order : orders) {
                                out.print("<tr><td>" + order.getClient().getName() + "</td><td>"
                                        + order.getDelivery_datetime() + "</td><td>"
                                        + order.getOrder_datetime() + "</td><td>"
                                        + order.getAddress() + "</td><td>"
                                        + order.getOption() + "</td><td>"
                                        + order.getStatus() + "</td><td>"
                                        + "<a href=" + request.getContextPath()
                                        + "/queryOrder?action=showOrderDetail&order_id="
                                        + order.getOrder_id() + ">Show Detail</a>" + "</tr></tr>");
                            }
                        %>
            </table>
        </div>
    </body>
</html>
