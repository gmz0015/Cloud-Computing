<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 01/04/2019
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Java Bean --%>
<jsp:useBean id="adminBean" scope="page" class="team06.web.bean.AdminBean" />

<%-- import --%>
<%@ page import="team06.domain.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="team06.domain.AppsInfo" %>
<%@ page import="team06.domain.DBUser" %>

<html>
<title>Team 06 - Admin</title>
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
                <div class="w3-panel w3-leftbar w3-border-blue">
                    <span style="font-size: 16px">Memory</span>
                </div>
                <div class="w3-row-padding">
                    <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                        <div class="w3-display-container" style="height: 100%">
                            <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                 style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                <%
                                    Runtime rtm = Runtime.getRuntime();
                                    long mm = rtm.maxMemory()/1024/1024;
                                    long tm = rtm.totalMemory()/1024/1024;
                                    long fm = rtm.freeMemory()/1024/1024;

                                    out.println("JVM memory detail info :<br>");
                                    out.println("Max memory:"+mm+"MB"+"<br>");
                                    out.println("Total memory:"+tm+"MB"+"<br>");
                                    out.println("Free memory:"+fm+"MB"+"<br>");
                                    out.println("Available memory can be used is :"+(mm+fm-tm)+"MB"+"<br>");
                                %>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Application --%>
                <div class="w3-panel w3-leftbar w3-border-blue">
                    <span style="font-size: 16px">Application</span>
                </div>
                <div class="w3-row-padding">
                    <div class="w3-card" style="background-color:white;">
                        <table class="w3-table w3-bordered">
                            <tr>
                                <th>Context path</th>
                                <th>Status</th>
                                <th>Active Session</th>
                                <th>Folder Name</th>
                            </tr>
                            <%
                                List<AppsInfo> appsInfos = adminBean.listAllApps();
                                for (AppsInfo appsInfo: appsInfos) {
                            %>
                            <tr>
                                <td><%= appsInfo.getContextPath() %></td>
                                <td><%= appsInfo.getStatus() %></td>
                                <td><%= appsInfo.getSessions() %></td>
                                <td><%= appsInfo.getFolderName() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>

                <%-- Database --%>
                <div class="w3-panel w3-leftbar w3-border-blue">
                    <span style="font-size: 16px">Database</span>
                </div>
                <div class="w3-row-padding">
                    <div class="w3-card" style="background-color:white;">
                        <table class="w3-table w3-bordered">
                            <tr>
                                <th>Database Name</th>
                                <th>Database UserName</th>
                                <th>Database Password</th>
                            </tr>
                            <%
                                List<Database> databases = adminBean.queryDB();
                                for (Database database: databases) {
                            %>
                            <tr style="text-align: center">
                                <td><%= database.getDbname() %></td>
                                <td><%= database.getDbusername() %></td>
                                <td><%= database.getDbpassword() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>

                <%-- Database Users --%>
                <div class="w3-panel w3-leftbar w3-border-blue">
                    <span style="font-size: 16px">Users in Database</span>
                </div>
                <div class="w3-row-padding">
                    <div class="w3-card" style="background-color:white;">
                        <table class="w3-table w3-bordered">
                            <tr>
                                <th>Username</th>
                                <th>Host</th>
                            </tr>
                            <%
                                List<DBUser> dbUsers = adminBean.getAllUsers();
                                for (DBUser dbUser: dbUsers) {
                            %>
                            <tr style="text-align: center">
                                <td><%= dbUser.getUsername() %></td>
                                <td><%= dbUser.getHost() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</html>
