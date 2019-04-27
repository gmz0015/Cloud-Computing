<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 26/03/2019
  Time: 10:42
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

<jsp:useBean id="databaseBean" scope="page" class="team06.platform.web.bean.DatabaseBean" />
<jsp:setProperty name="databaseBean" property="appId" value='<%= session.getAttribute("appId") %>'/>
<%
    databaseBean.getInfo(request);
    appBean.getInfo(request);
    appBean.doQuery(request, response);
    Database databaseInfo = databaseBean.queryDBbyId(request, response);
%>

<%-- Authentication --%>

<%-- Message --%>
<%@ include file="/WEB-INF/pages/component/message.jsp"%>
<%@ include file="/WEB-INF/pages/error/errorApp.jsp"%>
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
<%@ include file="/WEB-INF/pages/component/layout/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/layout/sidebar.jsp"%>
<section style="background-color:rgb(234, 237, 241);min-height: 700px;margin-top: 45px;padding-bottom: 20px">

    <div id="main" style="margin-left: 50px">

        <!-- Overview -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
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
                                <td style="border-right:1px solid #dddddd">Running</td>
                                <td style="border-right:1px solid #dddddd">Stop</td>
                                <td>Undeploy</td>
                            </tr>
                            <tr>
                                <td style="color: #09C;font-size: 24px;border-right:1px solid #dddddd"><%= appBean.getTotal() %></td>
                                <td style="color: #090;font-size: 24px;border-right:1px solid #dddddd"><%= appBean.getRunning() %></td>
                                <td style="color: #F00;font-size: 24px;border-right:1px solid #dddddd"><%= appBean.getStop() %></td>
                                <td class="w3-text-amber" style="font-size: 24px"><%= appBean.getUndeploy() %></td>
                            </tr>
                        </table>

                    </div>
                </div>
                <%-- Account Overview --%>
                <div class="w3-third">
                    <div class="w3-card" style="background-color:white;position:relative">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Account Balance</span>
                        </header>

                        <div class="w3-row" style="height:100%">
                            <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;min-height: 80px;margin: 10px">
                                <span class="w3-display-middle w3-xlarge" style="color:#9B9EA0">
                                    <%= appBean.getBalance() %>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Upload --%>
                <div class="w3-third">
                    <div class="w3-card" style="background-color:white;height:145px">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Upload</span>
                        </header>

                        <div style="height:90px">
                            <form action="${pageContext.request.contextPath}/application/create"
                                  enctype="multipart/form-data"
                                  method="POST"
                                  style="height:100%">
                                <div class="w3-display-container" style="height: 50%">
                                    <div class="w3-display-middle w3-border w3-border-white"
                                         style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                        <div class="w3-display-container" style="height: 100%">
                                            <input class="w3-display-middle" type="file" name="file" size="60" style="width: 270px"/>
                                        </div>
                                        <%-- target="nm_iframe" --%>
                                        <%-- <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe> --%>
                                    </div>
                                </div>

                                <div class="w3-display-container" style="height: 50%">
                                    <%--<div class="w3-display-middle w3-border w3-border-white"--%>
                                         <%--style="width: 99%;height: 90%;background-color: #F5F5F6;">--%>
                                        <%--<div class="w3-display-container" style="height: 100%">--%>
                                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-hover-white w3-hover-border-cyan" type="submit" name="Upload" value="Upload">
                                        <%--</div>--%>
                                    <%--</div>--%>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <!-- Database -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
                <span style="font-size: 16px">Database</span>
            </div>
            <div class="w3-row-padding" style="min-height:150px">
                <div class="w3-card" style="background-color:white;height: 100%">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Database Information</span>
                    </header>

                    <div class="w3-row-padding w3-display-container" style="min-height: 80px">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="background-color: #F5F5F6;height: 85%;width: 95%">
                            <div class="w3-display-container" style="height: 100%;width: 100%">
                                <span class="w3-display-left" style="padding-left: 10px;color: #666;font-size: 20px">
                                    Database Name:
                                </span>
                                <div>
                                    <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;">
                                        <%= databaseInfo.getDbName() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="w3-row-padding w3-display-container" style="min-height: 80px;border-right:1px dashed #dddddd;border-left:1px dashed #dddddd">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="background-color: #F5F5F6;height: 85%;width: 95%">
                            <div class="w3-display-container" style="height: 100%;width: 100%">
                                <span class="w3-display-left" style="padding-left: 10px;color: #666;font-size: 20px">
                                    User Name:
                                </span>
                                <div>
                                    <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;">
                                        <%= databaseInfo.getDbUsername() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="w3-display-container" style="min-height: 80px">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="background-color: #F5F5F6;height: 85%;width: 95%">
                            <div class="w3-display-container" style="height: 100%;width: 100%">
                                <span class="w3-display-left" style="padding-left: 10px;color: #666;font-size: 20px">
                                    User Password
                                </span>
                                <div>
                                    <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;">
                                        <%= databaseInfo.getDbPassword() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="w3-display-container" style="min-height: 80px;border-left:1px dashed #dddddd">
                        <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                             style="background-color: #F5F5F6;height: 85%;width: 95%">
                            <div class="w3-display-container" style="height: 100%;width: 100%">
                                <span class="w3-display-left" style="padding-left: 10px;color: #666;font-size: 20px">
                                    Total Usage:
                                </span>
                                <div>
                                    <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0">
                                        <%= databaseBean.queryUsage(databaseInfo.getDbName()) %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="w3-row-padding">
                    <div class="w3-card" style="background-color:white;margin-top:20px;margin-left:8px;margin-right:8px">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Database Detail</span>
                        </header>

                        <div style="">
                            <table class="w3-table w3-bordered">
                                <tr>
                                    <th>Table Name</th>
                                    <th>Table Row</th>
                                    <th>Usage - Byte</th>
                                    <th>Usage - KB</th>
                                </tr>
                                <%
                                    List<Map<String, String>> tableUsages = databaseBean.queryTableUsage(databaseInfo.getDbName());
                                    for (Map<String, String> tableUsage: tableUsages) {
                                %>
                                <tr style="text-align: center">
                                    <td><%= tableUsage.get("name") %></td>
                                    <td><%= tableUsage.get("row") %></td>
                                    <td><%= tableUsage.get("byteUsage") %></td>
                                    <td><%= tableUsage.get("KBUsage") %></td>
                                </tr>
                                <% } %>
                            </table>
                        </div>
                    </div>
            </div>
        </div>
        <br/>

        <!-- Instances -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
                <span style="font-size: 16px">Instance</span>
            </div>
            <%
                List<Application> appsInfo = appBean.getAppInfo();
                int i = 0;
                for (Application appInfo: appsInfo) {
                    // 3 apps in a row.
                    // At the begin of each row, there should be <div class="w3-row-padding" >
                    if ((i % 3) == 0) {
            %>
            <div class="w3-row-padding" >
                <% }/* end if */ %>
                <%-- Application --%>
                <div class="w3-third">
                    <div class="w3-card" style="background-color:white">

                        <header class="w3-container w3-padding" style="text-align: left;background-color: #f9f9f9">
                            <span style="font-size: 15px;vertical-align: middle">
                                <% if (appInfo.getStatus() == 2) { %>
                                <a href="/enter/?<%=appInfo.getContextPath()%>"><%= appInfo.getName() %></a>
                                <% } else { %>
                                <%= appInfo.getName() %>
                                <% } %>
                            </span>
                            <form class="w3-right" action="${pageContext.request.contextPath}/application/detail" method="POST">
                                <input type="hidden" name="appId" value=<%= appInfo.getAppId() %>>
                                <input class="w3-button w3-round-large w3-border w3-hover-white w3-hover-border-cyan" type="submit" name="Detail" value="View Detail" >
                            </form>
                        </header>

                        <table class="w3-table w3-centered" style="table-layout:fixed">
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
                <% if ((i % 3) == 2) { %>
            </div>
            <br/>
            <% }/* end if */ i++; }/* end for */ %>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>
</html>
