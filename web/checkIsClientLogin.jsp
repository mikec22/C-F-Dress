<%-- 
    Document   : checkIsClientLogin
    Created on : Nov 25, 2016, 12:27:58 AM
    Author     : Mike
--%>
<%
    if (session.getAttribute("clientInfo") == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
