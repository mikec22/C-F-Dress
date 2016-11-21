<%-- 
    Document   : item
    Created on : 2016/11/20, 下午 04:05:13
    Author     : Fai
--%>
<%@page import="com.db.ItemDB"%>
<%@page import="java.util.Vector"%>
<%@page import="com.bean.Item"%>
<%@ taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                text-align: center;
            }
            
            img {
                background: no-repeat center center ; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                height: 300px; 
                width: auto;
            }
            
            #img1{
                background: no-repeat center center ; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                height: 100%; 
                width: 300px;
            }
        </style>
        <link rel="stylesheet" href="css/card.css">
    </head>
    <%! ItemDB itemDB = new ItemDB(); %>
    <% 
    Vector <Item> itemList = new Vector();
    String keyword ;
    if(request.getParameter("getItem")==null){
        keyword = "";
    }else{
        keyword = request.getParameter("getItem");
    }
        itemList = itemDB.queryItemByKeyword(keyword);

    %>
    <body>
        <div class="context">
            <com:ItemTag itemList="<%=itemList%>" />
        </div>
    </body>
</html>
