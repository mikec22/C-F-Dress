<%-- 
    Document   : searchClient
    Created on : Nov 23, 2016, 1:45:59 PM
    Author     : Mike
--%>

<%@include file="checkIsManagerLogin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/signup.css">
    </head>
    <body>

        <jsp:include page="managerMenu.jsp"/>
        <div class="container">
            <div class="signup">
                <div class="signupForm">
                    <h3>
                        <span class="signupDivider">You input any keyword to search the client</span></h3>
                    <form method="get" action="queryClients">
                        <input type="hidden" name="action" value="search"/>
                        <input type="text" name="keyword" />
                        <input type="submit" class="signupBtn" value="Search">
                    </form>
                </div>
            </div>
            <div style="text-align: center;">

            </div>
        </div>
    </body>
</html>
