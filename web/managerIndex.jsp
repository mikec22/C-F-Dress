<%-- 
    Document   : managerIndex
    Created on : Nov 22, 2016, 4:34:40 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bean.Staff" %>
<%@include file="checkIsManagerLogin.jsp" %>
<%    Staff managerInfo = (Staff) session.getAttribute("managerInfo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home page</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <h1 style="text-align: center; margin: 200px;">Hello, <%= managerInfo.getName() %> </h1>
    </body>
</html>
