<%-- 
    Document   : depositClient
    Created on : Nov 23, 2016, 10:32:15 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="managerMenu.jsp"/>
<jsp:useBean id="client" scope="request" class="com.bean.Client"/>
<jsp:useBean id="msg" scope="request" class="java.lang.String"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Client info</h3>
        <table>
            <tr><td>LoginID</td><td><%=client.getLogin_id()%></td></tr>
            <tr><td>Name</td><td><%=client.getName()%></td></tr>
            <tr><td>Gender</td><td><%=client.getGender()%></td></tr>
            <tr><td>Date Of Birth</td><td><%=client.getDob()%></td></tr>
            <tr><td>Email</td><td><%=client.getEmail()%></td></tr>
            <tr><td>Phone</td><td><%=client.getPhone()%></td></tr>
            <tr><td>Address</td><td><%=client.getAddress()%></td></tr>
            <tr><td>Balance</td><td><%=client.getBalance()%></td></tr>
            <tr><td>Credit Amount</td><td><%=client.getCredit_amount()%></td></tr>
        </table>
        <form action="managerClientCredit" method="post">
            <input type="hidden" name="client_id" value="<%= client.getClient_id()%>"/>
            <input type="radio" name="action" value="deposit" id="deposit" checked="true"/><label for="deposit">Deposit</label>
            <input type="radio" name="action" value="withdraw" id="withdraw"/><label for="withdraw">Withdraw</label>
            <input type="radio" name="action" value="approvalCredit" id="approvalCredit"/><label for="approvalCredit">Approval Credit</label><br>
            <input type="number" name="quantity" min="0"/>
            <button type="submit"/>Submit</button>
        <h5><%= msg%></h5>
    </form>
</body>
</html>
