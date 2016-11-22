<%-- 
    Document   : RegisterResult
    Created on : Nov 20, 2016, 5:55:29 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Result</title>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
            out.println("<h1>" + msg + "</h1>");
        %>
    </body>
</html>
