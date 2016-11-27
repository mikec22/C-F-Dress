<%-- 
    Document   : item
    Created on : 2016/11/20, 下午 04:05:13
    Author     : Fai
--%>
<%@page import="com.db.ItemDB"%>
<%@page import="java.util.Vector"%>
<%@page import="com.bean.Item"%>
<%@taglib uri="/WEB-INF/tlds/com-taglib.tld" prefix="com" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="msg" scope="request" class="java.lang.String"/>
<jsp:useBean id="search" scope="request" class="java.lang.String"/>
<jsp:useBean id="keyword" scope="request" class="java.lang.String"/>
<jsp:useBean id="category" scope="request" class="java.lang.String"/>
<jsp:useBean id="itemIDSelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="nameSelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="priceSelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="categorySelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="designerSelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="ascSelected" scope="request" class="java.lang.String"/>
<jsp:useBean id="descSelected" scope="request" class="java.lang.String"/>
<%
    String title = (String) request.getAttribute("title");
    String menu;
    if (session.getAttribute("managerInfo") != null) {
        menu = "managerMenu.jsp";
    } else if (session.getAttribute("clientInfo") != null) {
        menu = "clientMenu.jsp";
    } else {
        menu = "menu.jsp";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
        <link rel="stylesheet" href="css/card.css">
        <link rel="stylesheet" href="css/item.css">
    </head>
    <%
        Vector<Item> itemList = (Vector<Item>) request.getAttribute("itemList");
    %>
    <body>
        <div id="menu">
            <jsp:include page="<%=menu%>" />
        </div>
        <div id="content">
            <div style="float: left;">
                <form name="form1" method="get" action="item">
                    <input type="hidden" name="action" value="changeOrder">
                    <input type="hidden" name="keyword" value="<%=keyword%>" >
                    <input type="hidden" name="category" value="<%=category%>">
                    Sort by :<select name="sortby" onchange="javascript:document.form1.submit();">
                    <option value="item_id" <%=itemIDSelected%>>Default</option>
                    <option value="name" <%=nameSelected%>>Name</option>
                    <option value="price" <%=priceSelected%>>Price</option>
                    <option value="category" <%=categorySelected%>>Category</option>
                    <option value="designer" <%=designerSelected%>>Designer</option>
                </select>
                <select name="orderby" onchange="javascript:document.form1.submit();">
                    <option value="ASC" <%=ascSelected%>>Ascending</option>
                    <option value="DESC"<%=descSelected%>>Descending</option>
                </select>
                </form>
            </div>
            <br>
            <h3 style="text-align: left; color: #444; font-weight: 200;"><%=msg%></h3>
            <h4 style="text-align: left;color: #444;font-weight: 200;"><%=search%></h4>

            <com:ItemListTag itemList="<%=itemList%>" />
        </div>
    </body>
</html>
