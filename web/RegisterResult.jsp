<%-- 
    Document   : RegisterResult
    Created on : Nov 20, 2016, 5:55:29 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="msg" scope="request" class="java.lang.String"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Result</title>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div>
            <h1 style="text-align: center"><%=msg%></h1>
        </div>
    </body>
</html>
