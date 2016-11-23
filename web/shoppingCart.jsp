<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="cart" scope="session" class="com.bean.ShoppingCart">
            <% out.print(cart);%>

    </head>

</html>
