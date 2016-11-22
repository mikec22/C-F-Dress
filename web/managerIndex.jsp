<%-- 
    Document   : managerIndex
    Created on : Nov 22, 2016, 4:34:40 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.bean.Staff" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home page</title>
    </head>
    <body>
        <% 

    Staff manageInfo = (Staff) session.getAttribute("managerInfo");
    if (manageInfo == null ){
    out.println("true");
    }else 
out.print(false);
        
%>

        <jsp:include page="managerMenu.jsp"/>
    </body>
</html>
