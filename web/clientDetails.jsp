<%-- 
    Document   : clientDetails
    Created on : 2016/11/23, 下午 02:12:16
    Author     : Fai
--%>

<%@page import="com.bean.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<%@include file="checkIsClientLogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Classic and Fashion Dress</title>
        <link rel="stylesheet" href="css/clientDetails.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>

    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div class="content">
            <jsp:useBean id="clientInfo" scope="session" class="com.bean.Client"/>
            <com:clientDetailsTag client="<%=clientInfo%>"/>
        </div>
    </body>
</html>