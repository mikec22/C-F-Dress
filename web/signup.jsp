<%-- 
    Document   : signup
    Created on : 2016/11/20, 下午 04:19:00
    Author     : Fai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Classic and Fashion Dress</title>
        <link rel="stylesheet" href="css/signup.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/modal.css">
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                <%
                    String mChecked = "checked";
                    String fChecked = "";
                    String gender = request.getParameter("gender");
                    if (gender != null) {
                        if (gender.equalsIgnoreCase("F")) {
                            fChecked = "checked";
                            mChecked = "";
                        }
                    }
//                    if (gender.equalsIgnoreCase("F")) {
//                        fChecked = "checked";
//                    } else {
//                        mChecked = "checked";
//                    }
                    String login = request.getParameter("login_id") == null ? "" : request.getParameter("login_id");
                    String name = request.getParameter("name") == null ? "" : request.getParameter("name");
                    String email = request.getParameter("email") == null ? "" : request.getParameter("email");
                    String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone");
                    String dob = request.getParameter("dob") == null ? "" : request.getParameter("dob");
                    String address = request.getParameter("address") == null ? "" : request.getParameter("address");
                %>
                <h3>Sign up to start shopping.<br>
                    <span class="signupDivider">Sign up with your email address</span></h3>
                <!-- <span class="divider"></span> -->
                <form method="post" action="register" >
                    <input type="hidden" name="action" value="doRegister"/>
                    <div class="signupForm">
                        <input type="text" name="login_id" placeholder="Your Login Id" required value="<%=login%>">
                        <input type="text" name="name" placeholder="Your Preferred Name" value="<%=name%>">
                    </div>
                    <div id="radiogp">
                        <h4>
                            <span style="font-weight: 700;">Gender : </span>
                            <input type="radio" name="gender" value="M" <%=mChecked%>>  Male
                            <input type="radio" name="gender" value="F"<%=fChecked%>>  Female</h4>
                    </div>
                    <div class="signupForm">
                        <input type="email" name="email" placeholder="Email" value="<%=email%>">
                        <input type="password" name="password" class="half" placeholder="Password">
                        <input type="password" name="cpassword" class="half confirmpass" placeholder="Confirm Password" required >
                        <input type="tel" minlength="8" maxlength="8" name="phone" placeholder="Phone Number" required value="<%=phone%>">
                    </div>
                    <div id="radiogp">
                        <h4>
                            <span style="font-weight: 700;">Date of Birthday </span></h4>
                        <input type="date" name="dob"  placeholder="Date of Birthday" required value="<%=dob%>">
                    </div>
                    <div class="signupForm">
                        <textarea id="noresize" name="address" rows="5" placeholder="Your Delivery Address" required><%=address%></textarea>
                        <input type="submit" class="signupBtn" value="Sign up">
                    </div>
                </form>
            </div>
        </div>

        <jsp:useBean id="msg" scope="request" class="java.lang.String"/>
        <div class="svgs" style="display: none;">
            <svg xmlns="http://www.w3.org/2000/svg">
            <symbol id="icon-close" viewBox="0 0 16.196 16.197">
                <title>Close</title>
                <path d="M15.615,3.07c0.619-0.62,0.77-1.618,0.258-2.329c-0.652-0.906-1.924-0.981-2.679-0.226L8.627,5.084 c-0.292,0.292-0.765,0.292-1.057,0L3.069,0.582c-0.62-0.62-1.617-0.771-2.328-0.258C-0.165,0.976-0.24,2.248,0.516,3.003 l4.567,4.569c0.292,0.292,0.292,0.765,0,1.057l-4.501,4.503c-0.619,0.619-0.771,1.617-0.259,2.328 c0.652,0.902,1.924,0.976,2.679,0.226l4.568-4.569c0.291-0.291,0.765-0.291,1.057,0l4.501,4.503 c0.619,0.626,1.616,0.772,2.327,0.259c0.906-0.652,0.981-1.924,0.227-2.68l-4.568-4.569c-0.291-.292-0.291-0.765,0-1.057 L15.615,3.07z"></path>
            </symbol>
            </svg>
        </div>
        <!--        <div class="container">
                    <button name="modalBtn" class="btn" type="button" data-trigger-modal="modal">Trigger modal</button>
                </div>-->
        <div class="modal modal--scale-up" id="modal">
            <div class="modal__window">
                <button class="modal__close-btn" type="button" data-close-modal>
                    <svg class="modal__close-icon">
                    <use xlink:href="#icon-close"></use>
                    </svg>
                </button>
                <div class="modal__header">
                    <h2 class="modal__title">Error </h2>
                </div>
                <div class="modal__content">
                    <%=msg%>
                    <!--                    <button class="btn" type="button" data-close-modal>Close Modal</button>-->
                </div>
            </div>
        </div>

        <script src="js/modal.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script>
            var modalEl = document.getElementById('modal');
            var modalInst = new Modal(modalEl, {
                openCallback: function () {
                    console.log('Callback for when Modal is open.');
                },
                closeCallback: function () {
                    console.log('Callback for when Modal is closed.');
                }
            });
            modalInst.init();
            2
        </script>
        <%
            if (request.getAttribute("msg") != null && !request.getAttribute("msg").equals("")) {
                out.println("<script>$(document).ready(function () { modalInst.openModal();});</script>");
            }
        %>
    </body>
</html>

