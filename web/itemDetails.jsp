<%-- 
    Document   : itemDetails
    Created on : 2016/11/22, 上午 05:51:24
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<%
    String title = (String)request.getAttribute("title");
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
            <jsp:include page="menu.jsp"/>
        </div>
        <div id="content">
            <com:ItemDetailsTag item="<%=item%>"/>
<!--            <div class="left">
                <div class="left-content">
                    <img src="img/item/w1.jpg">
                </div>
            </div>
            <div class="right">
                Quartz Gold-Tone and Rubber Casual Watch<br>
                watches<br>
                Tommy Hilfiger<br>
                $999.00<br>
            </div>-->
        </div>
    </body>
</html>
