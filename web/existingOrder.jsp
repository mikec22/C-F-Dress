<%-- 
    Document   : existingOrder
    Created on : Nov 25, 2016, 3:09:23 AM
    Author     : shukyan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib" prefix="com"%>
<%--<jsp:useBean id="existingOrder" class="java.util.Vector" scope="request"/>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean class="java.util.Vector<Order>" scope="request" id="existingOrder" />
          <%
              for(Order o: existingOrder){
                  System.out.println("fuck you");
              }
          %>
          
        <com:existingOrderList existingOrders="<%=existingOrder%>"/>
        <%
            for(Order o : existingOrder){
                System.out.println("fuck you bb");
            }
        %>
    </body>
</html>
