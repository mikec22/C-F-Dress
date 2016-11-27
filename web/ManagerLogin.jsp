<%-- 
    Document   : login
    Created on : Nov 20, 2016, 10:12:43 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Login</title>
        <link rel="stylesheet" href="css/signup.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container">
            <div class="signup">
                <span class="signupDivider" style="font-size: 20px;">Manager Login</span>
                <form method="post" action="ManagerLogin" class="signupForm">
                    <input type="hidden" name="action" value="authenticate"/>
                    <input type="text" required="required" name="login_id" placeholder="Username">
                    <input type="password" name="password" placeholder="Password" required>
                    <input type="hidden" name="action" value="login"/>
                    <input type="submit" class="signupBtn1" value="Log in">
                </form>
            </div>
        </div>
    </body>
</html>
