<%-- 
    Document   : history
    Created on : 2016/11/27, 上午 06:03:53
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib" prefix="com"%>
<%@include file="checkIsClientLogin.jsp" %>
<jsp:useBean class="java.util.Vector" scope="request" id="orderHistory" />
<jsp:useBean class="java.util.Vector" scope="request" id="bonusPointsHistory" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <link rel="stylesheet" href="css/tabs.css">
        <link rel="stylesheet" href="css/card.css">
    </head>
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <h1>Order and Bonus Points History</h1>
        <div class="tab_container">
            <input id="tab1" type="radio" name="tabs" checked>
            <label for="tab1"><i class="fa fa-shopping-cart"></i><span>Order</span></label>

            <input id="tab2" type="radio" name="tabs">
            <label for="tab2"><i class="fa fa-pencil-square-o"></i><span>Bonus Points</span></label>

            <section id="content1" class="tab-content">
                <h3>Last 10 order records</h3>
                <com:existingOrderList type="showOrderHistory" orderList="<%=orderHistory%>"/>
            </section>

            <section id="content2" class="tab-content">
                <h3>Use bonus points records</h3>
                <com:BonusPointHistory bpList="<%=bonusPointsHistory%>"/>
            </section>
        </div>
    </body>
</html>
