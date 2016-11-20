<%-- 
    Document   : item
    Created on : 2016/11/20, 下午 04:05:13
    Author     : Fai
--%>

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
    <body>
        <div class="context">
            <%
                for(int i=1 ; i<=10;i++){
                    out.print("<div class='card card-1'><img src='img/item/c"+ i +".jpg'><br>Black Halo Women's Constance Velvet Dress<br>Clothing<br>$350.00 </div>");
                    out.print("");
                }
                
                for(int i=1 ; i<=10;i++){
                    out.print("<div class='card card-1'><img id='img1' src='img/item/s"+ i +".jpg'></div>");
                }
                
                for(int i=1 ; i<=10;i++){
                    out.print("<div class='card card-1'><img src='img/item/w"+ i +".jpg'></div>");
                }
            %>
        </div>
    </body>
</html>
