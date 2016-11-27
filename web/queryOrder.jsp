<%-- 
    Document   : queryOrder
    Created on : Nov 24, 2016, 9:20:46 AM
    Author     : Mike
--%>

<%@include file="checkIsManagerLogin.jsp" %>
<%@page import="java.util.Vector, com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    Vector<Vector<Order>> queryOrders = (Vector<Vector<Order>>) request.getAttribute("queryOrders");
    Vector<Order> orders = (Vector<Order>) request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Order</title>
        <link rel="stylesheet" href="css/table.css">
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <div style="text-align: center;margin: auto; width: 80%;">
            <form style="margin: 30px" method="get" action="queryOrder">
                <input type="hidden" name="action" value="queryOrder" />
                <label for="inputBox">Client Name: </label> <input type="text" name="client_name" id="inputBox" placeholder="Name"/>
                <button type="submit">Search</button>
            </form><br>
            <table border="1" style="text-align: center;">
                <tr><th>Client Name</th><th>Delivery_Datetime</th><th>Order_Datetime</th><th>Address</th><th>Option</th><th>Status</th></tr>
                        <%
                            if (queryOrders != null) {
                                out.println("<h1>Result:</h1>");
                                for (Vector<Order> qOrders : queryOrders) {
                                    for (Order order : qOrders) {
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
                                }
                            } else {
                                out.println("<h1>Result:</h1>");
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
                            }
                        %>
            </table>
        </div>
    </body>
</html>
