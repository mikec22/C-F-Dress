<%-- 
    Document   : login
    Created on : 2016/11/20, 上午 02:02:05
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
        <link rel="stylesheet" href="css/signup.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                    <span class="signupDivider">Login to start shopping.</span>
                    <!-- <span class="divider"></span> -->
                    <form method="post" action="login" class="signupForm">
                        <input type="hidden" name="action" value="authenticate"/>
                        <input type="text" required="required" name="username" placeholder="Username">
                        <input type="password" name="password" placeholder="Password" required>
                        <input type="submit" class="signupBtn1" value="Sign in">
                    </form>
            </div>
        </div>
    </body>
</html>
