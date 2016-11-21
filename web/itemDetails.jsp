<%-- 
    Document   : itemDetails
    Created on : 2016/11/22, 上午 05:51:24
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #context {
                width: 80%;
            }

            body {
                text-align: center;
            }

            img {
                background: no-repeat center center ; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                height: 500px; 
                width: auto;
            }

            .img1{
                background: no-repeat center center ; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                height: 100%; 
                width: 300px;
            }
            .right {
                display: inline-block;
                margin: 1rem;
                width: auto;
                float: top;
                position: relative;
                background: #aafed6;
            }

            .left {
                border-radius: 2px;
                display: inline-block;
                margin: 1rem;
                position: relative;
                width: auto;
                overflow: hidden;
            }
        </style>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div id="context">
            <div class="left">
                <img src="img/item/w1.jpg">
            </div>
            <div class="right">
                Quartz Gold-Tone and Rubber Casual Watch<br>
                watches<br>
                Tommy Hilfiger<br>
                $999.00<br>
            </div>
        </div>
    </body>
</html>
