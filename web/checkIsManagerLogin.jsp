<%-- 
    Document   : checkIsManagerLogin
    Created on : Nov 24, 2016, 1:07:46 PM
    Author     : Mike
--%>
<%@page import="com.bean.Staff" %>
<%
    if (session.getAttribute("managerInfo") == null) {
        response.sendRedirect(request.getContextPath() + "/ManagerLogin");
        return;
    }
%>
