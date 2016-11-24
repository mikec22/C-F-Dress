<%-- 
    Document   : menu
    Created on : 2016/11/20, 下午 03:52:27
    Author     : Fai
--%>

<%@page import="com.bean.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Client client = (Client) session.getAttribute("clientInfo");
    if(client == null ){
        request.getRequestDispatcher(request.getContextPath()+ "/login").forward(request, response);
    }
//    if (client.getLogin_id()==null) {
//        session.removeAttribute("clientInfo");
//        response.sendRedirect(request.getContextPath()+ "/login");
//        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//    }
%>
<link rel="stylesheet" href="css/menu.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>

<nav class="stroke">
    <div class='atext'> Hi, <%=client.getName()%>
        <a href='login?action=logout'>Log out</a>
        <a href='shoppingCart?action=showCart'>Cart</a></div>
        
    <a href="<%=request.getContextPath()%>"><img src="img/cf_logo.png" style="display: block;margin: 0 auto; width: 15%; height: 15%"></a>

    <div id="wrap" >
        <form action="item" autocomplete="on" method="get">
            <input id="search" class="searchBar" name="keyword" type="text" placeholder="Search">
            <input class="searchIcon" id="search_submit" value="Rechercher" type="submit">
        </form>
    </div>
    <ul>
        <li><a href="<%=request.getContextPath()%>">Home</a></li>
        <li><a href="item?category=Clothing">Clothing</a></li>
        <li><a href="item?category=Shoes">Shoes</a></li>
        <li><a href="item?category=Watches">Watches</a></li>
        <li><a href='item?category=Gifts'>Gifts</a></li>
        <li><a href=''>Order</a></li>
        <li><a href=''>History</a></li>
        <li><a href='ClientDetailsController?action=getClient'>Personal Details</a></li>
    </ul>
</nav>

