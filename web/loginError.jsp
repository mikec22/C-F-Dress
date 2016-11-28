<%-- 
    Document   : loginError
    Created on : 2016/10/31, 下午 03:53:36
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <p>Incorrect Account or Password</p>
        <p style="text-align: center;">
            <%
                String userPath = (String) request.getAttribute("userPath");
            %>
            <a href="<%= request.getContextPath() + userPath %>"> Login Again</a>
        </p>
    </body>
</html>
