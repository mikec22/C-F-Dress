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
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1>Login</h1>
            <form method="post" action="main">
                <input type="hidden" name="action" value="authenticate"/>
                <table align="center">
                    <tr>
                        <td style="text-align: right;"><b>Login :</b></td>
                        <td><input type="text" required="required" name="username"></td>
                    </tr>
                    <tr>
                        <td style="text-align: right;"><b>Password :</b></td>
                        <td><input type="password" required="required" name="password"></td>
                    </tr>
                </table>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
