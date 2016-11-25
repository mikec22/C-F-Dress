<%-- 
    Document   : orderSuccess
    Created on : 2016/11/25, 上午 08:21:20
    Author     : Fai
--%>

<%@page import="com.bean.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<jsp:useBean id="orderResult" scope="request" class="com.bean.Order"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Successful</title>
        <link rel="stylesheet" href="css/cart.css">
        <script src="jquery-3.1.1.min.js"></script>
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
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div>
            <div class="wrap cf">
                <h2>Order Successful</h2>
                <h4>Address : <%=orderResult.getAddress() %></h4>
                <h4>Status : <%=orderResult.getStatus() %></h4>
                <div class="heading cf">
<!--                    <h1 style="text-align: center">Order Successful</h1>-->
                    <a href="<%=request.getContextPath()%>" class="continue">Continue Shopping</a>
                </div>
                <div class="cart">
                    <ul class="cartWrap">
                        
                        <com:CartItemListTag status="result" orderLines="<%=orderResult.getOrder_lines()%>"/>
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
