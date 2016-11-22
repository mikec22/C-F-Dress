<%-- 
    Document   : menu
    Created on : 2016/11/20, 下午 03:52:27
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/menu.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
<link href='https://raw.github.com/FortAwesome/Font-Awesome/master/docs/assets/css/font-awesome.min.css' rel='stylesheet' type='text/css'>

<nav class="stroke">
    <a href="index.jsp"><img src="img/cf_logo.png" style="display: block;margin: 0 auto; width: 15%; height: 15%"></a>
    <div id="wrap" >
        <form action="item" autocomplete="on" method="get">
            <input id="search" class="searchBar" name="keyword" type="text" placeholder="Search">
            <input class="searchIcon" id="search_submit" value="Rechercher" type="submit">
        </form>
    </div>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="item?category=clothing">Clothing</a></li>
        <li><a href="item?category=shoes">Shoes</a></li>
        <li><a href="item?category=watches">Watches</a></li>
        <li><a href="register?action=fillForm">Sign up</a></li>
        <li><a href="login">Sign in</a></li>

    </ul>
</nav>

