<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>
<%@page import="com.bean.CartItem,java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <jsp:useBean id="cart" scope="session" class="com.bean.ShoppingCart"/>
        <com:CartItemListTag cartItems="<%=cart.getItems()%>"/>
        Total <%=cart.getTotalPrice()%>
        
        <button>Check Out</button>
    </body>
</html>
