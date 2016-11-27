<%-- 
    Document   : manageItemDetail
    Created on : Nov 24, 2016, 3:46:43 PM
    Author     : Mike
--%>

<%@include file="checkIsManagerLogin.jsp" %>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<jsp:useBean id="title" scope="request" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
        <link rel="stylesheet" href="css/managerItemDetail.css">
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <div id="content">
            <form method="post" action="manageItem">
                <input name="action" type="hidden" value="editItem"/>
                <input type="hidden" name="item_id" value="<%=item.getItem_id()%>"/>
                <div class='left'>
                    <img src="img/item/<%= item.getImg()%>"/> 
                </div>
                <div class="right" style="text-align: left;">
                    <p class="edit">Name: <br><br><input type="text" name="name" value="<%= item.getName()%>"/></p>
                    <p class="edit">Designer Name: <br><br><input type="text" name="designer" value="<%= item.getDesigner()%>"/></p>
                    <p class="edit">Price: <br><br><input type="number" name="price" value="<%= item.getPrice()%>"/></p>
                    <p class="edit">Description: <br><br><textarea name="description" ><%=item.getDescription()%></textarea></p>
                    <p class="edit"><input type="submit" value="submit"/></p>
                </div>    
            </form>
        </div>
    </body>
</html>
