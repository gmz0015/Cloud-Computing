<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 24/04/2019
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- import --%>
<%@ page import="team06.platform.domain.Application" %>
<%@ page import="java.util.List" %>
<%@ page import="team06.platform.domain.Database" %>
<%@ page import="java.util.Map" %>

<%-- Java Bean --%>
<jsp:useBean id="appBean" scope="page" class="team06.platform.web.bean.ApplicationBean" />
<jsp:setProperty name="appBean" property="userid" value='<%= session.getAttribute("userid") %>'/>
<!DOCTYPE html>
<html>
<title>Team 06 - Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey w3-content" style="max-width:1600px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container">
        <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
            <i class="fa fa-remove"></i>
        </a>
        <img src="<%=request.getContextPath()%>/image/food.jpg" style="width:45%;" class="w3-round"><br><br>
        <h4><b>
            <% if (session.getAttribute("userrole") == null) { %>
            Hello Guest
            <% }else { %>
            <%=session.getAttribute("username")%>
            <% } %>
        </b>
        <%= request.isUserInRole("ADMIN") %></h4>
    </div>
    <div class="w3-bar-block">
        <a href="#" onclick="window.location.href='<%= request.getContextPath() + "/console" %>'" class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-code fa-fw w3-margin-right"></i>
            Console
        </a>
        <a href="#" onclick="window.location.href='<%= request.getContextPath() + "/guide" %>'" class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-book fa-fw w3-margin-right"></i>
            Guide
        </a>
        <% if (session.getAttribute("userid") == null) { %>
        <a href="#" class="w3-bar-item w3-button" onclick="window.location.href='login.jsp'" ><i class="fa fa-step-forward fa-fw w3-margin-right"></i>Login</a>
        <% }else { %>
        <a href="#" class="w3-bar-item w3-button" onclick="window.location.href='<%= request.getContextPath() + "/account" %>'"><i class="fa fa-bank fa-fw w3-margin-right"></i>Account</a>
        <a href="#" class="w3-bar-item w3-button" onclick=window.location.href="<%= request.getContextPath() %>/logout"><i class="fa fa-step-backward fa-fw w3-margin-right"></i>Logout</a>
        <% } %>
        <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>ABOUT</a>
        <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>CONTACT</a>
    </div>
    <div class="w3-panel w3-large">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

    <!-- Header -->
    <header id="portfolio">
        <a href="#"><img src="/image/food.jpg" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
        <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
        <div class="w3-container">
            <h1><b>
                <% if (session.getAttribute("userrole") == null) { %>
                Hello Guest
                <% }else { %>
                <%=session.getAttribute("username")%>
                <% } %>
            </b></h1>
            <div class="w3-section w3-bottombar w3-padding-16"></div>
        </div>
    </header>

    <%
        List<Application> appsInfo = appBean.getAllLiveAppInfo();
        int i = 0;
        for (Application appInfo: appsInfo) {
            // 3 apps in a row.
            // At the begin of each row, there should be <div class="w3-row-padding" >
            if ((i % 3) == 0) {
    %>
    <div class="w3-row-padding" >
        <% }/* end if */ %>
        <%-- Application --%>
        <div class="w3-third w3-container w3-margin-bottom">
            <img src="<%= appInfo.getIconPath() %>" alt="<%= appInfo.getName() %>" style="width:100%" class="w3-hover-opacity">
            <div class="w3-container w3-white">
                <p><b><a href="<%=appInfo.getContextpath()%>"><%= appInfo.getName() %></a> - <%= appInfo.getOwnername() %></b></p>
                <p><%= appInfo.getDescription() %></p>
            </div>
        </div>
        <% if ((i % 3) == 2) { %>
    </div>
    <% }/* end if */ i++; }/* end for */ %>

    <!-- Images of Us -->
    <div class="w3-row-padding w3-padding-16" id="about">
        <div class="w3-section w3-bottombar w3-padding-16"></div>
        <div class="w3-display-container w3-col m3">
            <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Me" style="width:100%">
            <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                <h3 style="color: black;text-align: center">Stelios Steliou</h3>
            </div>
        </div>
        <div class="w3-display-container w3-col m3">
            <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Me" style="width:100%">
            <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                <h3 style="color: black;text-align: center">Aleksandar Pantovic</h3>
            </div>
        </div>
        <div class="w3-display-container w3-col m3">
            <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Me" style="width:100%">
            <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                <h3 style="color: black;text-align: center">Mingze Gao</h3>
            </div>
        </div>
        <div class="w3-display-container w3-col m3">
            <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Me" style="width:100%">
            <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                <h3 style="color: black;text-align: center">Yilei Chen</h3>
            </div>
        </div>
    </div>

    <div class="w3-container w3-padding-large" style="margin-bottom:32px">
        <h4><b>About Us</b></h4>
        <p>Just me, myself and I, exploring the universe of unknownment. I have a heart of love and an interest of lorem ipsum and mauris neque quam blog. I want to share my world with you. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
    </div>

    <!-- Contact Section -->
    <div class="w3-container w3-padding-large w3-grey">
        <h4 id="contact"><b>Contact Us</b></h4>
        <hr class="w3-opacity">
        <form action="/action_page.php" target="_blank">
            <div class="w3-section">
                <label>Name</label>
                <input class="w3-input w3-border" type="text" name="Name" required>
            </div>
            <div class="w3-section">
                <label>Email</label>
                <input class="w3-input w3-border" type="text" name="Email" required>
            </div>
            <div class="w3-section">
                <label>Message</label>
                <input class="w3-input w3-border" type="text" name="Message" required>
            </div>
            <button type="submit" class="w3-button w3-black w3-margin-bottom"><i class="fa fa-paper-plane w3-margin-right"></i>Send Message</button>
        </form>
    </div>

    <div class="w3-black w3-center w3-padding-24">Designed by Team 06</div>

    <!-- End page content -->
</div>

<style>
    .nameBoard {
        z-index: 1;
    }
    .nameBoard:after {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: rgba(255,255,255,0.8);
        z-index: -1;
    }
</style>

<script>
    // Script to open and close sidebar
    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("myOverlay").style.display = "block";
    }

    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("myOverlay").style.display = "none";
    }
</script>

</body>
</html>

