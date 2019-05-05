<%@ page import="team06.platform.domain.Application" %><%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 28/03/2019
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- import --%>
<%@ page import="java.util.List" %>
<%@ page import="team06.platform.domain.Transaction" %>

<%-- Java Bean --%>
<jsp:useBean id="appCreateBean" scope="page" class="team06.platform.web.bean.ApplicationDetailBean" />
<jsp:setProperty name="appCreateBean" property="appId" value='<%= session.getAttribute("appId") %>'/>
<jsp:useBean id="appBean" scope="page" class="team06.platform.web.bean.ApplicationBean" />
<jsp:setProperty name="appBean" property="appId" value='<%= session.getAttribute("appId") %>'/>

<%-- onload --%>
<%
    appCreateBean.getInfo(request);
    appBean.setUserId(appCreateBean.getUserId());
    Application appInfo = appCreateBean.doQuery(request, response);
    appBean.applicationDetailInitial();
%>

<%-- Message --%>
<%@ include file="/WEB-INF/pages/component/message.jsp"%>

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
<%@ include file="/WEB-INF/pages/component/layout/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/layout/sidebar.jsp"%>

<%-- Change Name --%>
<div id="changeName" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=name" method="post">
            <div class="w3-section">
                <label><b>Please Enter Your Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Password" name="psw" required>
                <label><b>Please Enter Your Application's New Name</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Name" name="name" required>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeName').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Icon --%>
<div id="changeIcon" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=icon" enctype="multipart/form-data" method="post" >
            <div class="w3-section">
                <label><b>Please Enter Your Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Password" name="psw" required>
                <label><b>Please Upload Your Application's New Icon</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="file" name="icon">
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeIcon').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Description --%>
<div id="changeDescription" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=description" method="post">
            <div class="w3-section">
                <label><b>Please Enter Your Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Password" name="psw" required>
                <label><b>Please Enter Your Application's New Description</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Description" name="description" required>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeDescription').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change War FIle --%>
<div id="changeFile" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container"
              action="/changeWar?type=warFile"
              enctype="multipart/form-data"
              method="POST">
            <div class="w3-section">
                <label><b>Please Upload Your New War File</b></label>
                <input class="w3-input w3-border" type="file" name="file" size="60" style="width: 100%"/>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit" name="Upload">Upload</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeFile').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Entrance Mode --%>
<div id="changeMode1" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/charge?type=0" method="post">
            <div class="w3-section">
                <label>Please Confirm to change <b>Charge Mode</b> to <%@ include file="/WEB-INF/pages/component/chargeMode/entrance.jsp"%> Mode</label>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Confirm</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeMode1').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Both Mode --%>
<div id="changeMode2" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">

        <form class="w3-container" action="/charge?type=1" method="post">
            <div class="w3-section">
                <label>Please Confirm to change <b>Charge Mode</b> to <%@ include file="/WEB-INF/pages/component/chargeMode/both.jsp"%> Mode</label>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Confirm</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeMode2').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change In-app Mode --%>
<div id="changeMode3" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/charge?type=2" method="post">
            <div class="w3-section">
                <label>Please Confirm to change <b>Charge Mode</b> to <%@ include file="/WEB-INF/pages/component/chargeMode/inApp.jsp"%> Mode</label>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Confirm</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeMode3').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>
<section style="background-color:rgb(234, 237, 241);min-height: 700px;margin-top: 45px;padding-bottom: 20px">

<div id="main" style="margin-left: 50px;padding-bottom: 20px">

    <div class="w3-container">

        <%-- Overview --%>
        <div class="w3-row-padding" >
            <form action="${pageContext.request.contextPath}/application/detail/delete"
                  method="POST"
                  class="w3-panel w3-leftbar w3-border-blue w3-display-container">
                <span style="font-size: 16px">Overview</span>
                <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                <input class="w3-display-right w3-button w3-red w3-round-large w3-border w3-hover-white w3-hover-border-red"
                       style="margin-right: 10px"
                       type="submit" name="Deploy" value="Delete This Application" >
            </form>

            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="height: 45px;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 15px;vertical-align: middle">
                                <% if (appInfo.getStatus() == 2) { %>
                                <a href="/enter/?<%=appInfo.getContextPath()%>"><%= appInfo.getName() %></a>
                                <% } else { %>
                                <%= appInfo.getName() %>
                                <% } %>
                            </span>
                    </header>

                    <table class="w3-table w3-centered" style="table-layout:fixed;height: 100px">
                        <tr>
                            <th rowspan="2" style="text-align: center;vertical-align: middle;border-right:2px dashed #dddddd">
                                <% if (appInfo.getStatus() == 0) { %>
                                <%@ include file="/WEB-INF/pages/component/status/undeploy.jsp"%>
                                <% } else if (appInfo.getStatus() == 1) { %>
                                <%@ include file="/WEB-INF/pages/component/status/stop.jsp"%>
                                <% } else if (appInfo.getStatus() == 2) { %>
                                <%@ include file="/WEB-INF/pages/component/status/running.jsp"%>
                                <% } %>
                            </th>
                            <td>Visits <%= appInfo.getVisits() %></td>
                        </tr>
                        <tr>
                            <td>Rating <%= appInfo.getRating() %></td>
                        </tr>
                    </table>
                </div>
            </div>

            <!-- Operation -->
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;">

                    <header class="w3-container w3-padding" style="height:45px;text-align: center;background-color: #f9f9f9">
                        <span style="color: #333333;font-size: 20px">Operation</span>
                    </header>

                    <div class="w3-row-padding" style="height: 100px">
                        <form action="${pageContext.request.contextPath}/application/detail/deploy"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Deploy" value="Deploy" >
                        </form>
                        <form action="${pageContext.request.contextPath}/application/detail/start"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Start" value="Start" >
                        </form>
                        <form action="${pageContext.request.contextPath}/application/detail/stop"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Stop" value="Stop" >
                        </form>
                        <form action="${pageContext.request.contextPath}/application/detail/undeploy"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Undeploy" value="Undeploy" >
                        </form>
                    </div>

                </div>
            </div>

            <%-- Control Center --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Control Center</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half" style="border-right:1px dashed #dddddd">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeName').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Name</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeDescription').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Description</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeIcon').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Icon</span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeFile').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Reupload War File</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

            <%-- Overview --%>
            <div class="w3-row-padding" >
                <div class="w3-panel w3-leftbar w3-border-blue w3-display-container">
                    <span style="font-size: 16px">Overview</span>
                </div>

                <%-- Icon --%>
                <div class="w3-third">
                    <div class="w3-card-4" style="max-width: 430px">
                        <img src="/image/icon/<%= appInfo.getIconPath() %>" alt="<%= appInfo.getName() %>" style="width:100%;max-width:430px">
                    </div>
                </div>

                <!-- Description -->
                <div class="w3-third">
                    <div class="w3-card" style="background-color:white">

                        <header class="w3-container w3-padding" style="height:45px;text-align: center;background-color: #f9f9f9">
                            <span style="color: #333333;font-size: 20px">Description</span>
                        </header>

                        <div class="w3-row-padding" style="height: 100px">
                            <p><%= appInfo.getDescription() %></p>
                        </div>

                    </div>
                </div>

                <div class="w3-third">
                    <div class="w3-card" style="background-color:white">

                        <header class="w3-container w3-padding" style="height:45px;text-align: center;background-color: #f9f9f9">
                            <span style="color: #333333;font-size: 20px">Charge Mode</span>
                        </header>

                        <div class="w3-row-padding" style="padding:5px;">
                            <% if (appBean.getChargeMode() == 0) { %>
                            <div class="w3-display-container w3-border w3-border-blue w3-white"
                                 style="background-color: #F5F5F6;height:55px;">
                                <% }else { %>
                                <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-red"
                                     style="background-color: #F5F5F6;height:55px;cursor: pointer;"
                                     onclick="document.getElementById('changeMode1').style.display='block'">
                                <% } %>
                                <span class="w3-display-middle" style="color: #666;"><%@ include file="/WEB-INF/pages/component/chargeMode/entrance.jsp"%></span>
                            </div>
                        </div>
                        <div class="w3-row-padding" style="padding:5px;">
                            <% if (appBean.getChargeMode() == 1) { %>
                            <div class="w3-display-container w3-border w3-border-blue w3-white"
                                 style="background-color: #F5F5F6;height:55px;">
                                <% }else { %>
                                <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-red"
                                     style="background-color: #F5F5F6;height:55px;cursor: pointer;"
                                     onclick="document.getElementById('changeMode2').style.display='block'">
                                    <% } %>
                                <span class="w3-display-middle" style="color: #666;width: 246px"><%@ include file="/WEB-INF/pages/component/chargeMode/both.jsp"%></span>
                            </div>
                        </div>
                        <div class="w3-row-padding" style="padding:5px;">
                            <% if (appBean.getChargeMode() == 2) { %>
                            <div class="w3-display-container w3-border w3-border-blue w3-white"
                                 style="background-color: #F5F5F6;height:55px;">
                                <% }else { %>
                                <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-red"
                                     style="background-color: #F5F5F6;height:55px;cursor: pointer;"
                                     onclick="document.getElementById('changeMode3').style.display='block'">
                                    <% } %>
                                <span class="w3-display-middle" style="color: #666;"><%@ include file="/WEB-INF/pages/component/chargeMode/inApp.jsp"%></span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        <!-- Transaction History -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
                <span style="font-size: 16px">Transaction History</span>
            </div>

            <div class="w3-row-padding">
                <div class="w3-card" style="background-color:white;margin-left:8px;margin-right:8px">

                    <div style="">
                        <table class="w3-table w3-bordered">
                            <tr>
                                <th>Index</th>
                                <th>From User Name</th>
                                <th>To User Name</th>
                                <th>Type</th>
                                <th>Application</th>
                                <th>Amount</th>
                                <th>Time</th>
                            </tr>
                            <%
                                int i = 0;
                                List<Transaction> transactions = appBean.getAppTransaction();
                                for (Transaction transaction: transactions) {
                            %>
                            <% if (transaction.getType().equals("Royalties - Dev")) { %>
                            <tr class="w3-pale-green" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("Royalties - SignIn")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("Royalties - Bank")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 2")) { %>
                            <tr class="w3-pale-yellow" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 2 - Bank")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 2 - Dev")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 3")) { %>
                            <tr class="w3-pale-yellow" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 3 - Bank")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 3 - SignIn")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% if (transaction.getType().equals("In-App - Mode 3 - Dev")) { %>
                            <tr class="" style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>
</html>
