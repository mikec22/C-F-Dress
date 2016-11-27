<%-- 
    Document   : managerItem
    Created on : Nov 24, 2016, 2:17:20 AM
    Author     : Mike
--%>

<%@include file="checkIsManagerLogin.jsp" %>
<%@page import="com.db.ItemDB,com.bean.Item,java.util.Vector"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    String title = (String) request.getAttribute("title");
    Vector<Item> itemList = (Vector<Item>) request.getAttribute("itemList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
        <link rel="stylesheet" href="css/card.css">
        <link rel="stylesheet" href="css/item.css">
        <link rel="stylesheet" href="css/signup.css">
    </head>
    <body>
        <div id="menu">
            <jsp:include page="managerMenu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                <div class="signupForm">
                    <h3><span class="signupDivider">input any keyword to search item</span></h3>
                    <form action="item" method="get">
                        <input type="hidden" value="manageList" name="action"/>
                        <input type="text" name="keyword" id="box"/>
                        <input type="submit" class="signupBtn" value="Search">
                    </form>
                </div></div></div>
        <div id="content">
            <com:ItemListTag user="manager" itemList="<%=itemList%>" />
        </div>
    </body>
</html>
