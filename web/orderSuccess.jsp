<%-- 
    Document   : orderSuccess
    Created on : 2016/11/25, 上午 08:21:20
    Author     : Fai
--%>

<%@page import="com.bean.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<jsp:useBean id="orderResult" scope="request" class="com.bean.Order"/>
<jsp:useBean id="clientInfo" scope="session" class="com.bean.Client"/>
<jsp:useBean id="status" scope="request" class="java.lang.String"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Successful</title>
        <link rel="stylesheet" href="css/cart.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script>
            $('a.remove').click(function () {
                event.preventDefault();
                $(this).parent().parent().parent().hide(400);

            })

            $('a.btn.continue').click(function () {
                $('li.items').show(400);
            })
        </script> 
    </head>
    <%
        String tilte = "Order Successful";
        String ContinueShopping = "Continue Shopping";
        if (request.getAttribute("status") != null) {
            if (!request.getAttribute("status").equals("")) {
                if (request.getAttribute("status").equals("details")) {
                    ContinueShopping ="";
                    tilte = "Order Details";
                }
            }
        }
    %>
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div>
            <div class="wrap cf">
                <h2><%=tilte%></h2>
                <h4>Order ID : <%=orderResult.getOrder_id()%></h4>
                <h4>Order time : <%=orderResult.getOrder_datetime()%></h4>
                <h4>Your current balance : HK$ <%=clientInfo.getBalance()%></h4>
                <h4>Your current bonus point : <%=clientInfo.getBonus_point()%></h4>
                <%
                    if (orderResult.getOption().equals("delivery")) {
                        out.print("<h4>Delivery address : " + orderResult.getAddress());
                        out.print("<h4>Delivery Date and Time : " + orderResult.getDelivery_datetime());
                    } else {
                        out.print("<h4>Delivery Option : Self-pick up");
                    }
                %>
                <div class="heading cf">
                    <!--                    <h1 style="text-align: center">Order Successful</h1>-->
                    <a href="<%=request.getContextPath()%>" class="continue"><%=ContinueShopping%></a>
                </div>
                <div class="cart">
                    <ul class="cartWrap">    
                        <com:CartItemListTag status="<%=status%>" orderLines="<%=orderResult.getOrder_lines()%>"/>
                    </ul>
                </div>
                <div class="subtotal cf" >
                    <ul>
                        <li class="totalRow"><span class="label">Use Bonus points</span><span class="value"><%=orderResult.getUseBonusPoints()%> BP</span></li>
                        <li class="totalRow final"><span class="label">Total</span><span class="value">HK$<%=orderResult.getTotalPrice()%></span></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
