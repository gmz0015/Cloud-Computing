<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 26/03/2019
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Authentication --%>
<!DOCTYPE HTML>
<html xmlns:jsp="http://java.sun.com/JSP/Page">

<title>Team 06 - Detail</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<%@ include file="/WEB-INF/pages/component/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/sidebar.jsp"%>
<body style="background-color:rgb(234, 237, 241);min-height: 960px">

<div id="main" style="margin-left: 50px">

    <!-- Page content -->
    <div class="w3-container">

        <br/>
        <div class="w3-row-padding" >
            <%-- Message --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container" >
                        <h4>Message</h4>
                    </header>

                    <div class="w3-container w3-padding">
                        <h2>Hello World appid: <%= session.getAttribute("appid") %></h2>
                    </div>

                </div>
            </div>
            <%-- Account Overview --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container" >
                        <h4>Database Usage</h4>
                    </header>

                    <div class="w3-container w3-padding">
                        Hello Guest.
                    </div>

                </div>
            </div>

            <%-- Review --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container" >
                        <h4>Review</h4>
                    </header>

                    <div class="w3-container w3-padding">
                        Hello Guest.
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
