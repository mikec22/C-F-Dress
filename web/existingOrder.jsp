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
    </head>
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <jsp:useBean class="java.util.Vector<Order>" scope="request" id="existingOrder" />
        <com:existingOrderList type="showExistingOrders" orderList="<%=existingOrder%>"/>

    </body>
</html>
