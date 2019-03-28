<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 28/03/2019
  Time: 13:26
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
                        <span style="color: #333333;font-size: 20px">Instances</span>
                    </header>

                    <table class="w3-table w3-centered" style="table-layout:fixed;height: 100px">
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
                <div class="w3-card" style="background-color:white;position:relative">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Account</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Balance
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px">34.5</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                    <span style="vertical-align: middle;color: #666;">Charge</span>
                                    <span style="vertical-align: middle;color: #666;">3.45/hour</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                    <span style="vertical-align: middle;color: #666;">Earn Peanut</span>
                                    <span style="vertical-align: middle;color: #666;">4.2/hour</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Database Usage --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Database Usage</span>
                    </header>

                    <div style="height:90px">
                        <div class="w3-container w3-row" style="margin-top: 10px;margin-bottom: 5px;">
                            <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                <span style="vertical-align: middle;color: #666;">Use</span>
                                <span style="vertical-align: middle;color: #666;">1.34 G</span>
                            </div>
                        </div>
                        <div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">
                            <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;">
                                <span style="vertical-align: middle;color: #666;">Remain</span>
                                <span style="vertical-align: middle;color: #666;">0.63 G</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
