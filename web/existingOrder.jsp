<%-- 
    Document   : existingOrder
    Created on : Nov 25, 2016, 3:09:23 AM
    Author     : shukyan
--%>
<%@page import="com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib" prefix="com"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/existingOrder.css">
        <link rel="stylesheet" href="css/card.css">
    </head>
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div id="content">
            <h1>Only over HK$ 10000 order can cancel(Charge $500 handling fees) the order within 24 hours after ordered and at least 24 hours before delivery</h1>
            <jsp:useBean class="java.util.Vector<Order>" scope="request" id="existingOrder" />
            <com:existingOrderList type="showExistingOrders" orderList="<%=existingOrder%>"/>
        </div>

        <script src="js/jquery-3.1.1.min.js"></script>
    </body>
</html>
