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
            <%
//                for(Order o: 
//                        existingOrder){
//            System.out.println("order id :" + o.getOrder_id());
       // }  
//                final long ONE_DAY_MILLISCONDS = 25 * 60 * 60 * 1000;
//                Date od = order.getOrder_datetime().getTime();
//                java.util.Date today = new java.util.Date();
//                java.util.Date yesterday = new java.util.Date(today - ONE_DAY_MILLISCONDS);
//                java.util.Date lastWeek = new java.util.Date(today - (7 * ONE_DAY_MILLISCONDS));

                for (Order order : existingOrder) {

                    java.sql.Date logicalDate = order.getOrder_datetime();
                    out.println(logicalDate);
                    Calendar c = Calendar.getInstance();
                    c.setTime(logicalDate);
                    c.add(Calendar.DATE, 1);
                    java.sql.Date exDate = new java.sql.Date(c.getTimeInMillis());
                    out.println(exDate);
                    

//                    double amount = order.getTotalPrice();
////                     Date od = order.getOrder_datetime().getTime();
////                    Date expiry = order.getOrder_datetime().getTime() + 60 * 60 * 24 * 1000;
//                    out.println(order.getDelivery_datetime().getTime() + 60 * 60 * 24 * 1000);
//                    out.println();
//                    out.println(order.getDelivery_datetime());
//                    out.println(order.getTotalPrice());
//                    out.println(amount);
//                    if (amount > 10000) {
//
//                    }
                }
            %>
        </body>
    </html>
