<%-- 
    Document   : placeOrder.jsp
    Created on : Nov 22, 2016, 3:56:43 AM
    Author     : shukyan
--%>
<%@page import="java.util.Vector,com.bean.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="checkIsClientLogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place Order </title>
        <link rel="stylesheet" href="css/signup.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/modal.css">
    </head>
    <jsp:useBean id="order" scope="request" class="com.bean.Order"/>
    <jsp:useBean id="clientInfo" class="com.bean.Client" scope="session" />
    <body>
        <div id="menu">
            <jsp:include page="clientMenu.jsp" />
        </div>
        <div class="container">
            <div class="signup">
                <h3>Choose your delivery method<br>
                    <span class="signupDivider">choose delivery to your address or Self-pick up</span></h3>

                <form method="post" action="HandleOrderController" >
                    <input type="hidden" name="action" value="placeOrder"/>
                    <input type ="radio" name="delivery_method" value="delivery" id="delivery" onclick="handleClick(this.id);" checked> Delivery
                    <input type ="radio" name="delivery_method" value="self" id="self" onclick="handleClick(this.id);" > Self-pick up<br>
                    <div class="signupForm">
                        <div id="delivery_detail" >
                            <p>Delivery date</p>
                            <input id="dateP" type="date" name="delivery_date" value="">
                            <p>Delivery time</p>
                            <input id="timeP" type="time" name="delivery_time" value="">
                            <p>Delivery address</p>
                            <input type="text" name="delivery_address" value="<%=clientInfo.getAddress()%>">
                        </div>
                        <div id ="pick-up" style="display:none">
                            <p>Separate notice will be given when items arrived.</p>

                        </div>
                        <input type="submit" value="Comfirm">
                    </div>
                </form>
            </div>
    </body>
    <script type="text/javascript">

       
                function handleClick(clickedId)
                {
                    if (clickedId == "delivery") {
                        document.getElementById('delivery_detail').style.display = "inline";
                        document.getElementById('pick-up').style.display = "none";
                    } else {
                        document.getElementById('delivery_detail').style.display = "none";
                        document.getElementById('pick-up').style.display = "inline";
                    }
                }

    </script>
    <script src="js/jquery-3.1.1.min.js"></script>
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
</html>
