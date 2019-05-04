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
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>

<%-- Java Bean --%>
<jsp:useBean id="appBean" scope="page" class="team06.platform.web.bean.ApplicationBean" />
<% appBean.getInfo(request); %>
<%-- Java Bean --%>
<jsp:useBean id="indexBean" scope="page" class="team06.platform.web.bean.IndexBean" />
<% indexBean.getInfo(request); %>

<%-- Error --%>
<%@ include file="/WEB-INF/pages/error/errorPermission.jsp"%>
<!DOCTYPE html>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<title>Team 06 - Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
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
        <% if (indexBean.getUserId() == null) { %>
        <img src="/image/avatar/avatar.jpg" style="width:45%;" class="w3-round"><br><br>
        <h4><b>
            Hello Guest
        </b></h4>
        <% }else { %>
        <img src="/image/avatar/<%= indexBean.getAvatar() %>" style="width:45%;" class="w3-round"><br><br>
        <h4><b>
            Hello <%= indexBean.getUserName() %>
        </b></h4>
        <% } %>
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
        <% if (indexBean.getUserId() == null) { %>
        <a href="#" class="w3-bar-item w3-button" onclick="window.location.href='<%= request.getContextPath() + "/login" %>'" ><i class="fa fa-step-forward fa-fw w3-margin-right"></i>Login</a>
        <% }else { %>
        <a href="#" class="w3-bar-item w3-button" onclick="window.location.href='<%= request.getContextPath() + "/account" %>'"><i class="fa fa-bank fa-fw w3-margin-right"></i>Account</a>
        <a href="#" class="w3-bar-item w3-button" onclick="window.location.href='<%= request.getContextPath() + "/logout" %>'"><i class="fa fa-step-backward fa-fw w3-margin-right"></i>Logout</a>
        <% } %>
        <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>About</a>
        <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>Contact</a>
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
                <% if (session.getAttribute("userId") == null) { %>
                Hello Guest
                <% }else { %>
                <%=session.getAttribute("userName")%>
                <% } %>
            </b></h1>

        </div>
    </header>

    <div class="w3-section w3-bottombar w3-padding-16">
        <h2 style="padding-left: 16px">Our Applications</h2>
    </div>

    <div>

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
            <img src="/image/icon/<%= appInfo.getIconPath() %>" alt="<%= appInfo.getName() %>" style="width:100%;max-height: 250px" class="w3-hover-opacity">
            <div class="w3-container w3-white" style="padding-top:20px">
                <% if (appInfo.getChargeMode() == 0) { %>
                <%@ include file="/WEB-INF/pages/component/chargeMode/entrance.jsp"%>
                <% } %>
                <% if (appInfo.getChargeMode() == 1) { %>
                <%@ include file="/WEB-INF/pages/component/chargeMode/both.jsp"%>
                <% } %>
                <% if (appInfo.getChargeMode() == 2) { %>
                <%@ include file="/WEB-INF/pages/component/chargeMode/inApp.jsp"%>
                <% } %>
            </div>
            <div class="w3-container w3-white">
                <p><b><a href="/enter/?<%=appInfo.getContextPath()%>"><%= appInfo.getName() %></a> - <%= appInfo.getOwnerName() %></b></p>
                <p><%= appInfo.getDescription() %></p>
                <p>
                    <%
                        int unit = (int) appInfo.getRating();
                        int tenths = (int) (appInfo.getRating() * 10 - unit * 10);
                        int k = 0;
                        for (int j=0; j<unit; j++){
                    %>
                    <i class="fas fa-star rating-star" style="cursor: pointer;" onclick="window.location.href='/rating?level=<%=k+1%>&appId=<%=appInfo.getAppId()%>'"></i>
                    <% k++; } if (tenths > 5) { %>
                    <i class="fas fa-star-half-alt rating-star" style="cursor: pointer;" onclick="window.location.href='/rating?level=<%=k+1%>&appId=<%=appInfo.getAppId()%>'"></i>
                    <% k++; } for (int kk = k; kk < 5 ; kk++ ) {%>
                        <i class="far fa-star rating-star" style="cursor: pointer;" onclick="window.location.href='/rating?level=<%=k+1%>&appId=<%=appInfo.getAppId()%>'"></i>
                    <% k++; } %>
                </p>
            </div>
        </div>
        <% if ((i % 3) == 2) { %>
    </div>
    <% }/* end if */ i++; }/* end for */ %>
    </div>
    <div class="w3-section w3-bottombar w3-padding-16"></div>

    <!-- Work Row -->
    <div class="w3-row-padding w3-padding-64 w3-theme-l1" id="work">

        <div class="w3-quarter">
            <h2>Our Advantages</h2>
            <ul style="line-height: 40px">
                <li><b>Specific API Documents</b></li>
                <li><b>Detailed Guide</b></li>
                <li><b>Rating System</b></li>
                <li><b>Friendly Interface</b></li>
                <li><b>Powerful Manager System</b></li>
            </ul>
        </div>

        <div class="w3-quarter">
            <div class="w3-card w3-white">
                <img src="/image/avatar6.png" alt="User" style="width:100%">
                <div class="w3-container">
                    <h3>User</h3>
                    <ul>
                        <li>Look through all applications</li>
                        <li>View visits and rating of applications</li>
                        <li>View bank balance and transaction history</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="w3-quarter">
            <div class="w3-card w3-white">
                <img src="/image/avatar2.png" alt="Developer" style="width:100%">
                <div class="w3-container">
                    <h3>Developer</h3>
                    <ul>
                        <li>Deploy and manager applications</li>
                        <li>View visits history</li>
                        <li>View applications' transaction history</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="w3-quarter">
            <div class="w3-card w3-white">
                <img src="/image/avatar4.png" alt="Mountains" style="width:100%">
                <div class="w3-container">
                    <h3>Admin</h3>
                    <ul>
                        <li>Process feedback on time</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="w3-row-padding w3-padding w3-theme-l1" id="list">
        <h2><b>Authority List</b></h2>
        <!-- Images of Us -->
        <table class="w3-table w3-centered">
            <tr class="" style="border-bottom:1px solid #dddddd">
                <th>Web Page</th>
                <th>Guest</th>
                <th>User</th>
                <th>Developer</th>
                <th>Admin</th>
            </tr>
            <tr>
                <td>Home</td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Guide</td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Console</td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Account</td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Preference</td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Application</td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Application Detail</td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">check</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
            <tr>
                <td>Admin</td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">close</i></td>
                <td><i class="material-icons">check</i></td>
            </tr>
        </table>
    </div>


    <div class="w3-container w3-padding-large" style="margin-bottom:32px">

        <h4><b>About Us</b></h4>
        <!-- Images of Us -->
        <div class="w3-row-padding w3-padding-16" id="about">

            <div class="w3-display-container w3-col m3">
                <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Stelios Steliou" style="width:100%">
                <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                    <h3 style="color: black;text-align: center">Stelios Steliou</h3>
                </div>
            </div>
            <div class="w3-display-container w3-col m3">
                <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Aleksandar Pantovic" style="width:100%">
                <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                    <h3 style="color: black;text-align: center">Aleksandar Pantovic</h3>
                </div>
            </div>
            <div class="w3-display-container w3-col m3">
                <img class="" src="${pageContext.servletContext.contextPath}/image/MingzeGao.jpg" alt="Mingze Gao" style="width:100%">
                <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                    <h3 style="color: black;text-align: center">Mingze Gao</h3>
                </div>
            </div>
            <div class="w3-display-container w3-col m3">
                <img src="<%=request.getContextPath()%>/image/img_avatar3.jpg" alt="Yilei Chen" style="width:100%">
                <div class="w3-display-bottommiddle nameBoard" style="width:95%;margin-bottom: 10px;padding-left: 20px;padding-right: 20px">
                    <h3 style="color: black;text-align: center">Yilei Chen</h3>
                </div>
            </div>
        </div>
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

    <div class="w3-black w3-center w3-padding-24">Develop by Team 06</div>

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
    .mingze {
        transform: rotate(90deg);
        -ms-transform: rotate(90deg); /* IE 9 */
        -moz-transform: rotate(90deg); /* Firefox */
        -webkit-transform: rotate(90deg); /* Safari and Chrome */
        -o-transform: rotate(90deg); /* Opera */
    }
    .rating-star:hover{color: red;}
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

