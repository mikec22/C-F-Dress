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
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="item.jsp">Dress</a></li>
        <li><a href="signup.jsp">Sign up</a></li>
        <li><a href="login.jsp">Sign in</a></li>
        <div id="wrap" >
            <form action="" autocomplete="on">
                <input id="search" class="searchBar" name="search" type="text" placeholder="Any Keyword..."><input class="searchIcon" id="search_submit" value="Rechercher" type="submit">
            </form>
        </div>
    </ul>
</nav>

