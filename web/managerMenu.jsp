<%-- 
    Document   : managerMenu
    Created on : 2016/11/21, 下午 03:07:02
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/menu.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
<link href='https://raw.github.com/FortAwesome/Font-Awesome/master/docs/assets/css/font-awesome.min.css' rel='stylesheet' type='text/css'>

<nav class="fill">
    <ul>
        <li><a href="<%= request.getContextPath() + "/ManagerLogin" %>">Home</a></li>
        <li><a href="<%=request.getContextPath() + "/manageItem" %>">Item details</a></li>
        <li><a href="<%=request.getContextPath() + "/queryOrder?action=queryOrder" %>">Order status</a></li>
        <li><a href="<%=request.getContextPath()+"/verifyClient" %>">Verify client</a></li>
        <li><a href="<%=request.getContextPath()+"/managerClientCredit" %>">Approving credit</a></li>
        <li><a href="<%=request.getContextPath()+"/queryOrder?action=incompleteOrder" %>">Incomplete Orders Report</a></li>
        <li><a href="<%=request.getContextPath() + "/ManagerLogin?action=logout"%>">Logout</a></li>
    </ul>
</nav>

