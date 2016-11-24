<%-- 
    Document   : searchClient
    Created on : Nov 23, 2016, 1:45:59 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <form method="get" action="queryClients">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="keyword" />
            <button type="submit">Search</button>
        </form>
    </body>
</html>
