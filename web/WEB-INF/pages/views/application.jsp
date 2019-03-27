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
<body style="background-color:rgb(234, 237, 241);min-height: 700px">

<div id="main" style="margin-left: 50px">

    <!-- Overview -->
    <div class="w3-container">

        <div class="w3-panel w3-leftbar w3-border-blue" >
            <span style="font-size: 16px">Overview</span>
        </div>
        <div class="w3-row-padding" >
            <%-- Message --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Instances</span>
                    </header>

                    <table class="w3-table w3-centered" style="table-layout:fixed">
                        <tr>
                            <td style="border-right:1px solid #dddddd">Total</td>
                            <td  style="border-right:1px solid #dddddd">Running</td>
                            <td  style="border-right:1px solid #dddddd">Maintain</td>
                            <td>Stop</td>
                        </tr>
                        <tr>
                            <td style="color: #09C;font-size: 24px;border-right:1px solid #dddddd">2</td>
                            <td style="color: #090;font-size: 24px;border-right:1px solid #dddddd">1</td>
                            <td style="color: #F00;font-size: 24px;border-right:1px solid #dddddd">0</td>
                            <td style="color: #F00;font-size: 24px">1</td>
                        </tr>
                    </table>

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
                        <h2>Hello World appid: <%= session.getAttribute("appid") %></h2>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <br/>
    <!-- Security -->
    <div class="w3-container">

        <div class="w3-panel w3-leftbar w3-border-blue">
            <span style="font-size: 16px">Security</span>
        </div>
        <div class="w3-row-padding" >
            <%-- Message --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" >
                        <span style="font-size: 17px">Operation Status</span>
                    </header>

                    <div class="w3-container w3-padding">
                        <div class="w3-row-padding">
                            <%-- CPU --%>
                            <div class="w3-third">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;text-align: center; height: 130px">
                                    <div class="w3-margin-top s3-margin-bottom">
                                        <span style="color:#C6D0D4;font-size:30px">34%</span>
                                    </div>
                                    <div class="w3-container w3-padding" style="margin-top: 20px">
                                        CPU
                                    </div>
                                </div>
                            </div>

                            <%-- Database Usage --%>
                            <div class="w3-third">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;text-align: center; height: 130px">
                                    <div class="w3-margin-top s3-margin-bottom">
                                        <span style="color:#C6D0D4;font-size:30px">53%</span>
                                    </div>
                                    <div class="w3-container w3-padding" style="margin-top: 10px">
                                        Internet Usage
                                    </div>
                                </div>
                            </div>

                            <%-- Database Usage --%>
                            <div class="w3-third">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;text-align: center; height: 130px">
                                    <div class="w3-margin-top s3-margin-bottom">
                                        <span style="color:#FF0000;font-size:30px">89%</span>
                                    </div>
                                    <div class="w3-container w3-padding" style="margin-top: 10px">
                                        Database Usage
                                    </div>
                                </div>
                            </div>
                        </div>
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
                        <h2>Hello World appid: <%= session.getAttribute("appid") %></h2>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <br/>
    <!-- Instances -->
    <div class="w3-container">

        <div class="w3-panel w3-leftbar w3-border-blue">
            <span style="font-size: 16px">My Instance</span>
        </div>
        <div class="w3-row-padding" >
            <%-- Message --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="text-align: left;background-color: #f9f9f9">
                        <span style="font-size: 15px">Temp School Gym - <%= session.getAttribute("appid") %></span>
                    </header>

                    <table class="w3-table w3-centered" style="table-layout:fixed">
                        <tr>
                            <th rowspan="2" style="text-align: center;vertical-align: middle;border-right:2px dashed #dddddd">
                                Running
                            </th>
                            <td>Visits 4</td>
                        </tr>
                        <tr>
                            <td>Rating 5</td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>


<%-- Backup --%>
<%--<%= session.getAttribute("appid") %>--%>