<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 28/03/2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Authentication --%>
<!DOCTYPE HTML>
<html xmlns:jsp="http://java.sun.com/JSP/Page">

<title>Team 06 - Application</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<%@ include file="/WEB-INF/pages/component/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/sidebar.jsp"%>
<section style="background-color:rgb(234, 237, 241);min-height: 700px;margin-top: 45px;">

    <div id="main" style="margin-left: 50px">
        <%-- Deploy Application --%>
        <div class="w3-container">
            <div class="w3-panel w3-leftbar w3-border-blue">
                <span style="font-size: 16px">Upload Application</span>
            </div>
            <div class="w3-row-padding">
                <%--<div class=""--%>
                <%-- Applications --%>
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <div class="w3-display-container" style="height: 50%">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="width: 99%;height: 90%;background-color: #F5F5F6;">
                            Upload
                        </div>
                    </div>

                    <div class="w3-display-container" style="height: 50%">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="width: 99%;height: 90%;background-color: #F5F5F6;">
                             Upload
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</html>
