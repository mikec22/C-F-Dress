<%-- 
    Document   : signup
    Created on : 2016/11/20, 下午 04:19:00
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Classic and Fashion Dress</title>
        <link rel="stylesheet" href="css/signup.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                <h3>Sign up to start shopping.<br>
                <span class="signupDivider">Sign up with your email address</span>
                <!-- <span class="divider"></span> -->
                <form method="post" action="Register">
                    <input type="hidden" name="action" value="register"/>
                    <div class="signupForm">
                        <input type="text" name="login_id" placeholder="Your Login Id" required>
                    <input type="text" name="name" placeholder="Your Preferred Name">
                    </div>
                    <div id="radiogp">
                        <span>Gender : </span>
                        <input type="radio" name="gender" value="M" checked>  Male
                        <input type="radio" name="gender" value="F">  Female<br>
                    </div>
                    <div class="signupForm">
                    <input type="email" name="email" placeholder="Email">
                    <input type="password" name="password" class="half" placeholder="Password" required>
                    <input type="password" name="cpassword" class="half confirmpass" placeholder="Confirm Password" required>
                    <input type="tel" name="phone" placeholder="Phone Number" required>
                    <input type="date" name="dob" required>
                    <textarea id="noresize" name="address" rows="5" placeholder="Your Delivery Address" required></textarea>
                    <input type="submit" class="signupBtn" value="Sign up">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

