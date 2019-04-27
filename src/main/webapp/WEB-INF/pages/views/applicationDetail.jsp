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
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>

<%-- Java Bean --%>
<jsp:useBean id="appCreateBean" scope="page" class="team06.platform.web.bean.ApplicationDetailBean" />
<jsp:setProperty name="appCreateBean" property="appId" value='<%= session.getAttribute("appId") %>'/>
<jsp:useBean id="appBean" scope="page" class="team06.platform.web.bean.ApplicationBean" />
<jsp:setProperty name="appBean" property="appId" value='<%= session.getAttribute("appId") %>'/>

<%-- onload --%>
<%
    appCreateBean.getInfo(request);
    appBean.getInfo(request);
    Application appInfo = appCreateBean.doQuery(request, response);
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
                <input class="w3-display-right w3-button w3-red w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-red"
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
                <div class="w3-card" style="background-color:white">

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
                                   type="submit" name="Deploy" value="Start" >
                        </form>
                        <form action="${pageContext.request.contextPath}/application/detail/stop"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Deploy" value="Stop" >
                        </form>
                        <form action="${pageContext.request.contextPath}/application/detail/undeploy"
                              method="POST"
                              class="w3-quarter w3-display-container"
                              style="height:100%">
                            <input type="hidden" name="appId" value=<%= session.getAttribute("appId") %>>
                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                   style="background-color:#F5F5F6;height:90%;width:90%"
                                   type="submit" name="Deploy" value="Undeploy" >
                        </form>
                    </div>

                </div>
            </div>

            <%-- Overview --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="height: 45px;text-align: center;background-color: #f9f9f9">
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
        </div>

        <!-- Database -->
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
                            <tr style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
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
