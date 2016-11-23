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
        <li><a href="<%= request.getContextPath() %>">Home</a></li>
        <li><a href="">Item details</a></li>
        <li><a href="">Order status</a></li>
        <li><a href="<%=request.getContextPath()+"/verifyClient" %>">Verify client</a></li>
        <li><a href="<%=request.getContextPath()+"/approvingCredit" %>">Approving credit</a></li>
        <li><a href="">Report</a></li>
        <li><a href="<%=request.getContextPath()%>/ManagerLogin?action=logout">Logout</a></li>
    </ul>
</nav>

