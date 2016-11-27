<%-- 
    Document   : searchClientResult
    Created on : Nov 23, 2016, 4:48:39 PM
    Author     : Mike
--%>

<%@include file="checkIsManagerLogin.jsp" %>
<%@page import="com.bean.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>C&F Dress</title>
        <link rel="stylesheet" href="css/table.css">
    </head>
    <body>
        <jsp:include page="managerMenu.jsp"/>
        <jsp:useBean id="clients" scope="request" class="java.util.Vector<Client>"/>
        <div style="text-align: center; width: 80%; margin: 0px auto;">
            <table style="margin: 30px;" >
                <tr><th>LoginID</th><th>Name</th><th>Gender</th><th>Date Of Birth</th>
                    <th>Email</th><th>Phone</th></tr>
                        <%                        for (Client client : clients) {
                                out.println("<tr><td>" + client.getLogin_id() + "</td><td>"
                                        + client.getName() + "</td><td>"
                                        + client.getGender() + "</td><td>"
                                        + client.getDob() + "</td><td>"
                                        + client.getEmail() + "</td><td>"
                                        + client.getPhone() + "</td><td>"
                                        + "<a href=\"" + request.getContextPath()
                                        + "/queryClients?action=changeBalance&client_id="
                                        + client.getClient_id()
                                        + "\"/>Deposit</a></td></tr>");
                            }
                        %>
            </table>
        </div>

    </body>
</html>
