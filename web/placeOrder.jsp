<%-- 
    Document   : placeOrder.jsp
    Created on : Nov 22, 2016, 3:56:43 AM
    Author     : shukyan
--%>
<%@page import="java.util.Vector,com.bean.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <script type="text/javascript">
            function handleClick(clickedId)
            {
                if (clickedId == "delivery")
                    document.getElementById('delivery_detail').style.display = "inline";
                    document.getElementById('pick-up').style.display = "none";
                else
                    document.getElementById('delivery_detail').style.display = "none";
                    document.getElementById('pick-up').style.display = "inline";
            }
        </script>
    </head>
    
        <jsp:useBean id="order" scope="request" class="com.bean.Order">
        <jsp:useBean id="clientInfo" class="com.bean.Client" scope="session" />
                
            <%
                Vector<OrderLine> orderline = order.getOrder_line();
                //show cartItem
                
            %>
               
        <form method="post" action="HandleOrderController" >
            <input type="hidden" name="client" value=""/>
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="number" name="quantity" value="1" required><br>
            delivery method
            <input type ="radio" name="delivery_method" value="delivery" id="delivery" onclick="handleClick(this.id);">Delivery
            <input type ="radio" name="delivery_method" value="self" id="self" onclick="handleClick(this.id);" checked>Self-pick up<br>
            <div id="delivery_detail" style="display:none">
                *Delivery datetime: <br>
                <input type="datetime" name="delivery_datetime" value=""><br>
                *Delivery address:<br>
                <input type="text" name="delivery_address" value="<%=clientInfo.getAddress()%>"><br>
            </div>
            <div id ="pick-up" >
                Separate notice will be given when items arrived
                
            </div>
            <input type="submit" value="Comfirm">

        </form>
    
</html>
