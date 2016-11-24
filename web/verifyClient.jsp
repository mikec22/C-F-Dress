<%-- 
    Document   : verifyClient
    Created on : Nov 23, 2016, 2:22:59 AM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="checkIsManagerLogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CF Dress</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <jsp:useBean id="client" scope="request" class="com.bean.Client"/>
        <h3>Client info</h3>
        <table>
            <tr><td>LoginID</td><td><%=client.getLogin_id() %></td></tr>
            <tr><td>Name</td><td><%=client.getName() %></td></tr>
            <tr><td>Gender</td><td><%=client.getGender() %></td></tr>
            <tr><td>Date Of Birth</td><td><%=client.getDob() %></td></tr>
            <tr><td>Email</td><td><%=client.getEmail() %></td></tr>
            <tr><td>Phone</td><td><%=client.getPhone() %></td></tr>
            <tr><td>Address</td><td><%=client.getAddress() %></td></tr>
        </table>
            <a href="<%= request.getContextPath() %>/verifyClient?action=approval&client_id=<%=client.getClient_id()%>">Approval</a>
    </body>
</html>
