<%-- 
    Document   : clientTable
    Created on : Nov 23, 2016, 2:24:15 AM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bean.Client" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>C&F Dress</title>
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <jsp:useBean id="clients" scope="request" class="java.util.Vector<Client>"/>
        <table border="1">
            <tr><th>LoginID</th><th>Name</th><th>Gender</th><th>Date Of Birth</th>
                <th>Email</th><th>Phone</th></tr>
                    <%
                        for (Client client : clients) {
                            out.println("<tr><td>" + client.getLogin_id() + "</td><td>"
                                    + client.getName() + "</td><td>"
                                    + client.getGender() + "</td><td>"
                                    + client.getDob() + "</td><td>"
                                    + client.getEmail() + "</td><td>"
                                    + client.getPhone() + "</td><td>"
                                    + "<a href=\"" + request.getContextPath()
                                    + "/verifyClient?action=show&client_id="
                                    + client.getClient_id()
                                    + "\"/>Show</a></td></tr>");
                        }
                    %>
        </table>
        
    </body>
</html>