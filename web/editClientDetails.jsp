<%-- 
    Document   : editClientDetails
    Created on : 2016/11/24, 下午 01:04:14
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="clientInfo" scope="session" class="com.bean.Client"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maintaining Your Personal Information</title>
        <link rel="stylesheet" href="css/signup.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                <h3>Edit Your Personal Information<br>
                    <span class="signupDivider"></span></h3>
                <!-- <span class="divider"></span> -->
                <form method="post" action="ClientDetailsController" >
                    <input type="hidden" name="action" value="submitEdit"/>
                    <div class="signupForm">
                        <input type="hidden" name="client_id" value="<%=clientInfo.getClient_id()%>"/>                        
                        <h4>Name : </h4>
                        <input type="text" name="name" value="<%=clientInfo.getName()%>" placeholder="Your Name">
                    </div>
                    <h4>Gender : </h4>
                    <div id="radiogp">
                        <h4>
                            <%  String mChecked = "";
                                String fChecked = "";
                                if(clientInfo.getGender().equalsIgnoreCase("M")){
                                    mChecked = "checked";
                                }else{
                                    fChecked = "checked";
                                }
                            %>
                            <input type="radio" name="gender" value="M" <%=mChecked%>>  Male
                            <input type="radio" name="gender" value="F" <%=fChecked%>>  Female</h4>
                    </div>
                    <div class="signupForm">
                        <h4>Email : </h4>
                        <input type="email" name="email" value="<%=clientInfo.getEmail()%>" placeholder="Email">
                        <h4>If you want to change new password please fill this textbox : </h4>
                        <input type="password" name="password" class="half" placeholder="New Password" >
                        <input type="password" name="cpassword" class="half confirmpass" placeholder="Confirm Password" >
                       <h4>Phone Number : </h4>
                        <input type="tel" name="phone" value="<%=clientInfo.getPhone()%>" placeholder="Phone Number" required>
                    <h4>Date of Birthday : </h4>
                        <input type="date" name="dob" value="<%=clientInfo.getDob()%>" placeholder="Date of Birthday" required>
                        <h4>Delivery Address : </h4>
                        <textarea id="noresize" name="address" rows="5" placeholder="Your Delivery Address" required><%=clientInfo.getAddress()%></textarea>
                        <input type="submit" class="signupBtn" value="Submit">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
