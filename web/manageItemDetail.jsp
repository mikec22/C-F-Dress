<%-- 
    Document   : manageItemDetail
    Created on : Nov 24, 2016, 3:46:43 PM
    Author     : Mike
--%>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<jsp:useBean id="title" scope="request" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <form method="post" action="manageItem">
            
            <table>
                <tr><td>Name:</td><td><input type="text" name="name" value="<%= item.getName() %>"/></td></tr>
                <tr><td>Designer Name:</td><td><input type="text" name="designer" value="<%= item.getDesigner() %>"/></td></tr>
                <tr><td>Price:</td><td><input type="number" name="price" value="<%= item.getPrice() %>"/></td></tr>
                <tr><td>Description:</td><td><input type="textarea" name="description" value="<%= item.getDescription() %>"/></td></tr>
            </table>
            <input type="submit" value="submit"/>
            <input name="action" type="hidden" value="editItem"/>
            <input type="hidden" name="item_id" value="<%=item.getItem_id()%>"
            
        </form>
    </body>
</html>
