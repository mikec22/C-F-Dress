
<%@include file="checkIsManagerLogin.jsp" %>
<%@page import="java.util.Vector, com.bean.OrderLine,java.sql.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="order" scope="request" class="com.bean.Order"/>
<%
    Vector<OrderLine> order_lines = order.getOrder_lines();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <h2>Details:</h2>
        <table>
            <tr><td>Client Name:</td><td><%= order.getClient().getName()%></td></tr>
            <tr><td>Delivery_Datetime:</td><td><%=order.getDelivery_datetime().toLocalDateTime().toString().replace('T', ' ')%></td></tr>
            <tr><td>Order_Datetime:</td><td><%= order.getOrder_datetime().toLocalDateTime().toString().replace('T', ' ')%></td></tr>
            <tr><td>Address:</td><td><%= order.getAddress()%></td></tr>
            <tr><td>Option:</td><td><%= order.getOption()%></td></tr>
            <tr><td>Status:</td><td><%= order.getStatus() %></td></tr>
            <tr><td>Total:</td><td><%= order.getTotalPrice()%></td></tr>
        </table>
        <form method="post" action="editOrder">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="order_id" value="<%=order.getOrder_id()%>" />
            <label for="day">Delay date:</label>
            <input id="day" type="datetime-local" name="delay_date" value="<%=order.getDelivery_datetime().toLocalDateTime()%>" required="true" />
            <label for="comboBox">Status:</label>
            <select id="comboBox" name="status">
                <option value="processing" >Processing</option>
                <option value="delivered">Delivered</option>
                <option value="picked-up">Picked-up</option>
                <option value="canceled">Canceled</option>
            </select>
            <button type="submit">Update</button>
        </form>
        <h1>Order Item</h1>
        <table border="1" style="text-align: center;">
            <tr><th>Item Name</th><th>Quantity</th><th>Price</th><th>Bonus Point</th></tr>
                    <%
                        for (OrderLine orderLine : order_lines) {
                            out.println("<tr><td>"
                                    + orderLine.getItem().getName() + "</td><td>"
                                    + orderLine.getQuantity() + "</td><td>"
                                    + orderLine.getPrice() + "</td></tr>");
                        }
                    %>
        </table>

    </body>
</html>
