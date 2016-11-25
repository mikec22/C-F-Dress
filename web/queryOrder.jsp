<%-- 
    Document   : queryOrder
    Created on : Nov 25, 2016, 9:20:46 AM
    Author     : Mike
--%>

<%@page import="java.util.Vector, com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector<Vector<Order>> queryOrders = (Vector<Vector<Order>>) request.getAttribute("queryOrders");
    Vector<Order> orders = (Vector<Order>) request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Order</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <form method="get" action="queryOrder">
            <input type="hidden" name="action" value=""
            <input type="text" name="client_name"/>
            <button type="submit">Search</button>
        </form><br>
        <table border="1">
            <tr><th>Client Name</th><th>Delivery_Datetime</th><th>Order_Datetime</th><th>Address</th><th>Option</th><th><th>Status</th></th></tr>
        <%
            if(queryOrders!=null){
                for(Vector<Order> qOrders :queryOrders){
                    for (Order order : qOrders){
                        out.print("<tr><td>"+order.getClient().getName()+"</td><td>"
                                +order.getDelivery_datetime()+"</td><td>"
                                +order.getOrder_datetime()+"</td><td>"
                                +order.getAddress()+"</td><td>"
                                +order.getOption()+"</td><td>"
                                +order.getStatus()+"</td></tr>");
                    }
                }
            } else {
                for (Order order : orders){
                        out.print("<tr><td>"+order.getClient().getName()+"</td><td>"
                                +order.getDelivery_datetime()+"</td><td>"
                                +order.getOrder_datetime()+"</td><td>"
                                +order.getAddress()+"</td><td>"
                                +order.getOption()+"</td><td>"
                                +order.getStatus()+"</td></tr>");
                    }
            }
        %>
        </table>
    </body>
</html>
