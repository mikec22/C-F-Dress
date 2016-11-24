<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>
<%@page import="com.bean.OrderLine,java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title = (String)request.getAttribute("title");
    String menu;
    if (session.getAttribute("clientInfo") != null) {
        menu = "clientMenu.jsp";
    } else {
        menu = "menu.jsp";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="<%=menu%>" />
        </div>
        <div>
            <h1>Shopping Cart</h1>
            <jsp:useBean id="cart" scope="session" class="com.bean.Order"/>
            <jsp:useBean id="client" scope="session" class="com.bean.Client"/>
            Grand total: $ <%=cart.getTotalPrice()%>
            <form method="POST" action="HandleOrderController" >
            <input type="hidden" name ="total" <%=cart.getTotalPrice()%> >
            <input type="submit" name="submit" value = "Check Out">
            <form>
        </div>

    </body>
</html>
