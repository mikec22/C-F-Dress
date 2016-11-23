<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>
<%@page import="com.bean.OrderLine,java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div>
            <h1>Shopping Cart</h1>
            <jsp:useBean id="cart" scope="session" class="com.bean.Order"/>
            <com:CartItemListTag orderLines="<%=cart.getOrder_lines()%>"/>
            Grand total: $ <%=cart.getTotalPrice()%>
            <button>Check Out</button>
        </div>

    </body>
</html>
