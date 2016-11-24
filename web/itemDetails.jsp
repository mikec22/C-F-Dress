<%-- 
    Document   : itemDetails
    Created on : 2016/11/22, 上午 05:51:24
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<%
    String title = (String) request.getAttribute("title");
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
        <link rel="stylesheet" href="css/itemDetails.css">
    </head>
    <body>
        <div id="menu">
            <jsp:include page="<%=menu%>"/>
        </div>
        <div id="content">
            <com:ItemDetailsTag item="<%=item%>"/>
        </div>
    </body>
</html>
