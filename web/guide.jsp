<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 05/04/2019
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Team 06 - Guide</title>
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
        <div class="w3-container">
            <div class="w3-row-padding" >

                <%-- Memory --%>
                <div class="w3-quarter">
                    <div class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Content</span>
                    </div>
                    <div class="w3-left" style="padding-left:3%">
                        <ul>
                            <li><a href="#introduction">Introduction</a></li>
                            <ul>
                                <li>How to Use Application</li>
                                <li>How about the charge</li>
                            </ul>
                            <li><a href="#guest">As Guest</a></li>
                            <li><a href="#user">As User</a></li>
                            <ul>
                                <li>How to Use Application</li>
                                <li>How about the charge</li>
                            </ul>
                            <li><a href="#developer">As Developer</a></li>
                            <ul>
                                <li>How to Use Database</li>
                                <li>How to Create Application</li>
                                <li>How about the charge</li>
                            </ul>
                            <li><a href="#admin">As Admin</a></li>
                            <ul>
                                <li>How to Manager Application</li>
                                <li>How to Manager Database</li>
                            </ul>
                        </ul>
                    </div>
                </div>

                <div class="w3-threequarter">
                    <%-- Platform Introduction --%>
                    <div id="introduction" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Platform Introduction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <p>
                                Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                            </p>
                            <p>
                                We provide login service and bank service.
                            </p>
                        </div>
                    </div>

                    <%-- As Guest --%>
                    <br/>
                    <div id="guest" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Guest Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <p>
                                Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                            </p>
                            <p>
                                We provide login service and bank service.
                            </p>
                        </div>
                    </div>

                    <%-- As User --%>
                    <br/>
                    <div id="user" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">User Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <p>
                                Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                            </p>
                            <p>
                                We provide login service and bank service.
                            </p>
                        </div>
                    </div>

                        <%-- As Developer --%>
                        <br/>
                        <div id="developer" class="w3-panel w3-leftbar w3-border-blue">
                            <span style="font-size: 16px">Developer Instruction</span>
                        </div>
                        <div class="w3-card" style="background-color:white">
                            <div class="w3-container">
                                <p>
                                    Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                                </p>
                                <p>
                                    We provide login service and bank service.
                                </p>
                            </div>
                        </div>

                        <%-- As Admin --%>
                        <br/>
                        <div id="admin" class="w3-panel w3-leftbar w3-border-blue">
                            <span style="font-size: 16px">Admin Instruction</span>
                        </div>
                        <div class="w3-card" style="background-color:white">
                            <div class="w3-container">
                                <p>
                                    Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                                </p>
                                <p>
                                    We provide login service and bank service.
                                </p>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>

</section>
</html>

