<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>
<%@page import="com.bean.OrderLine,java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title = (String) request.getAttribute("title");
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
            <jsp:include page="<%=menu%>" />
        </div>
        <div>
            <!--            <h1>Shopping Cart</h1>
            <jsp:useBean id="cart" scope="session" class="com.bean.Order"/>
            <jsp:useBean id="client" scope="session" class="com.bean.Client"/>
            Grand total: $
            <form method="POST" action="HandleOrderController" >
            <input type="hidden" name ="total"  >
            <input type="submit" name="submit" value = "Check Out">-->
            <!--            <form>-->
            <div class="wrap cf">
                <div class="heading cf">
                    <h1>My Cart</h1>
                    <a href="<%=request.getContextPath()%>" class="continue">Continue Shopping</a>
                </div>
                <div class="cart">
                    <ul class="cartWrap">
                        <com:CartItemListTag orderLines="<%=cart.getOrder_lines()%>"/>
                    </ul>
                </div>
                    <div class="subtotal cf" >
                    <ul>
                        <li class="totalRow"><span class="label">Use Bonus points</span><span class="value"><%=cart.getUseBonusPoints()%> BP</span></li>
                        <li class="totalRow final"><span class="label">Total</span><span class="value">HK$<%=cart.getTotalPrice()%></span></li>
                        <li class="totalRow"><a href="HandleOrderController" class="btn continue">Checkout</a></li>
                    </ul>
                </div>
            </div>
        </div>

    </body>
</html>
