<%-- 
    Document   : item
    Created on : 2016/11/20, 下午 04:05:13
    Author     : Fai
--%>
<%@page import="com.db.ItemDB"%>
<%@page import="java.util.Vector"%>
<%@page import="com.bean.Item"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title = (String)request.getAttribute("title");
    String menu;
    if (session.getAttribute("managerInfo") != null) {
        menu = "managerMenu.jsp";
    }else if (session.getAttribute("clientInfo") != null) {
        menu = "clientMenu.jsp";
    } else {
        menu = "menu.jsp";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
        <link rel="stylesheet" href="css/card.css">
        <link rel="stylesheet" href="css/item.css">
    </head>
    <% 
    Vector <Item> itemList = (Vector<Item>)request.getAttribute("itemList");
    %>
    <body>
        <div id="menu">
            <jsp:include page="<%=menu%>" />
        </div>
        <div id="content">
            <com:ItemListTag itemList="<%=itemList%>" />
        </div>
    </body>
</html>
