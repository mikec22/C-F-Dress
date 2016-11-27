<%-- 
    Document   : history
    Created on : 2016/11/27, 上午 06:03:53
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib" prefix="com"%>
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
                
<!--                <div class='orderCard card-1'>
                    <div id="left">
                        <p class="info">Order ID : 1 </p>
                        <p class="info">Order Time :  </p>
                        <p class="info">Delivery Option :  </p>
                        <p class="info">Delivery Time :  </p>
                        <p class="info">Delivery Address :  </p>
                    </div>
                    <div id="right" class="totalRow">
                        <p class="price">Total item : <span class="value">1231</span></p>
                        <p class="price">Bonus Points : </p>
                        <p class="price">Total Price : </p>
                        <p class="price">Status : </p>
                        <a href="<%=request.getContextPath()%>" class="continue">More Details</a>
                    </div>
                </div>-->
                <com:existingOrderList type="showOrderHistory" orderList="<%=orderHistory%>"/>
            </section>

            <section id="content2" class="tab-content">
                <h3>Use bonus points records</h3>
                <com:BonusPointHistory bpList="<%=bonusPointsHistory%>"/>
            </section>
        </div>
    </body>
    <script src="js/jquery-3.1.1.min.js"></script>
</html>
