<%-- 
    Document   : itemDetails
    Created on : 2016/11/22, 上午 05:51:24
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<jsp:useBean id="item" scope="request" class="com.bean.Item"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #content {
                width: 80%;
                position: relative;
                margin: 0 auto; 
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

            .left {
                float:left;
                width:70%;
            }
            .left-content {
                width: 60%;
                margin-right:100px;
            }
            .right {
                float:right;
                width: auto;
                margin: 50px;
                margin-right: 50px;
                margin-left: -100px;
            }
            
            @media only screen and (max-width: 1100px) {
                .left {
                    width: 100%;
                }
                .left-content{
                    margin: 0 auto;
                }
                .right {
                    width: 100%;
                    margin-right: 0px;
                }
            }
        </style>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp"/>
        </div>
        <div id="content">
            <com:ItemDetailsTag item="<%=item%>"/>
<!--            <div class="left">
                <div class="left-content">
                    <img src="img/item/w1.jpg">
                </div>
            </div>
            <div class="right">
                Quartz Gold-Tone and Rubber Casual Watch<br>
                watches<br>
                Tommy Hilfiger<br>
                $999.00<br>
            </div>-->
        </div>
    </body>
</html>
