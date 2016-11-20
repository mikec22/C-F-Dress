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
    </head>
    <body>
        <div style="text-align: center;">
            <h1>Manager Login</h1>
            <form method="post" action="ManagerLogin">
                <input type="hidden" name="action" value="authenticate"/>
                <table align="center">
                    <tr>
                        <td style="text-align: right;"><b>Login ID :</b></td>
                        <td><input type="text" required="required" name="login_id"></td>
                    </tr>
                    <tr>
                        <td style="text-align: right;"><b>Password :</b></td>
                        <td><input type="password" required="required" name="password"></td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="login"/>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
