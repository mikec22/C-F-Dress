<%-- 
    Document   : placeOrder.jsp
    Created on : Nov 22, 2016, 3:56:43 AM
    Author     : shukyan
--%>
<%@page import="java.util.Vector,com.bean.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Place Order </title>
    <script type="text/javascript">
        function handleClick(clickedId)
        {
            if (clickedId == "delivery") {
                document.getElementById('delivery_detail').style.display = "inline";
                document.getElementById('pick-up').style.display = "none";
            } else {
                document.getElementById('delivery_detail').style.display = "none";
                document.getElementById('pick-up').style.display = "inline";
            }
        }
    </script>
</head>

<jsp:useBean id="order" scope="request" class="com.bean.Order"/>
<jsp:useBean id="clientInfo" class="com.bean.Client" scope="session" />



<form method="post" action="HandleOrderController" >
    <input type="hidden" name="action" value="placeOrder"/>
    Delivery method
    <input type ="radio" name="delivery_method" value="delivery" id="delivery" onclick="handleClick(this.id);" checked>Delivery
    <input type ="radio" name="delivery_method" value="self" id="self" onclick="handleClick(this.id);" >Self-pick up<br>
    <div id="delivery_detail" >
        <p>Delivery datetime* <br>
            <input type="date" name="delivery_date" value="">
            <input type="time" name="delivery_time" value=""></p>
        <p>Delivery address*<br>
            <input type="text" name="delivery_address" value="<%=clientInfo.getAddress()%>"></p>
    </div>
    <div id ="pick-up" style="display:none">
        <p>Separate notice will be given when items arrived.</p>

    </div>
    <input type="submit" value="Comfirm">

</form>


