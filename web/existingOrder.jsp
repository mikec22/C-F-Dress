<%-- 
    Document   : existingOrder
    Created on : Nov 25, 2016, 3:09:23 AM
    Author     : shukyan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:useBean id="existingOrder" class="java.util.Vector" scope="request"/>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean class="java.util.Vector<Order>" scope="request" id="existingOrder" />

        <%out.print("ORDER");
            for (Order order : existingOrder) {
                out.print("<form method='' action''>");
                String orderDate = order.getOrder_datetime().toString();
                int order_id = order.getOrder_id();
                //double amount = order.getTotalPrice();
                String option = order.getOption();
                String address = order.getAddress();
                long order_date = order.getOrder_datetime().getTime();
                Calendar c = Calendar.getInstance();
                long current = c.getTimeInMillis();
                out.print("<form method='' action''>" + orderDate);
                out.print("<input type ='text' name ='address' value='"+address+"'>"+order.getOrder_datetime().toString());
                //|| amount>1000
                if ((current - order_date) > 86400000) {
                    out.print("<input type='submit' name'action' value='Cancle'>");
                }

                out.print("<input type='submit' name'action' value='updateOrder'></form>");

            }
        %>
    </body>
</html>
