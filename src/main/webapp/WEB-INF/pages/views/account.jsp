<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 26/03/2019
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- import --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%-- Java Bean --%>
<jsp:useBean id="accountBean" scope="page" class="team06.platform.web.bean.AccountBean" />
<jsp:setProperty name="accountBean" property="userid" value='<%= session.getAttribute("userid") %>'/>

<%-- Authentication --%>

<%-- Message --%>
<%@ include file="/WEB-INF/pages/component/message.jsp"%>

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
                                        <span style="color:#9B9EA0;font-size:18px">
                                            <%= accountBean. %>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="w3-half">
                                <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                    <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                         style="background-color: #F5F5F6;height:35px;text-align: center;">
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
            <div class="w3-row-padding" >
                <div class="w3-threequarter">
                    <div class="w3-card" style="background-color:white;height:150px">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Database Information</span>
                        </header>

                        <div class="w3-row-padding" style="height: 67%">
                            <div class="w3-quarter w3-display-container" style="height: 100%">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height: 85%;width: 95%">
                                    <div class="w3-display-container" style="height: 100%;width: 100%">
                                        <span class="w3-display-topleft" style="padding-top: 5%;padding-left: 5%;color: #666;">
                                            Database Name
                                        </span>
                                        <div>
                                            <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;padding-top:18%">
                                                <%= databaseInfo.getDbname() %>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="w3-quarter w3-display-container" style="height: 100%;border-right:1px dashed #dddddd;border-left:1px dashed #dddddd">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height: 85%;width: 95%">
                                    <div class="w3-display-container" style="height: 100%;width: 100%">
                                        <span class="w3-display-topleft" style="padding-top: 5%;padding-left: 5%;color: #666;">
                                            User Name
                                        </span>
                                        <div>
                                            <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;padding-top:18%">
                                                <%= databaseInfo.getDbusername() %>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="w3-quarter w3-display-container" style="height: 100%">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height: 85%;width: 95%">
                                    <div class="w3-display-container" style="height: 100%;width: 100%">
                                        <span class="w3-display-topleft" style="padding-top: 5%;padding-left: 5%;color: #666;">
                                            User Password
                                        </span>
                                        <div>
                                            <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;padding-top:18%">
                                                <%= databaseInfo.getDbpassword() %>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="w3-quarter w3-display-container" style="height: 100%;border-left:1px dashed #dddddd">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height: 85%;width: 95%">
                                    <div class="w3-display-container" style="height: 100%;width: 100%">
                                        <span class="w3-display-topleft" style="padding-top: 5%;padding-left: 5%;color: #666;">
                                            Total Usage
                                        </span>
                                        <div>
                                            <span class="w3-display-middle" style="font-size: 20px;color:#9B9EA0;padding-top:18%">
                                                <%= database.queryUsage(databaseInfo.getDbname()) %>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="changePassword" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

                        <div class="w3-center"><br>
                            <span onclick="document.getElementById('changePassword').style.display='none'"
                                  class="w3-button w3-xlarge w3-hover-red w3-display-topright"
                                  title="Cancel Change">
                                &times;
                            </span>
                        </div>

                        <form class="w3-container"
                              action="${pageContext.request.contextPath}/application"
                              method="POST">
                            <div class="w3-section">
                                <input type="hidden" name="username" value=<%= databaseInfo.getDbusername() %>>
                                <label><b>New Password</b></label>
                                <input class="w3-input w3-border" type="password" placeholder="Please Enter New Password" name="password" required>
                                <button class="w3-button w3-block w3-green w3-section w3-padding"
                                        type="submit"
                                        name="changePassword"
                                        value="changePassword">
                                    Confirm Change Password
                                </button>
                            </div>
                        </form>

                        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
                            <button onclick="document.getElementById('changePassword').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
                        </div>

                    </div>
                </div>

                <div id="ExecuteSQL" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

                        <form class="w3-container"
                              action="${pageContext.request.contextPath}/application"
                              method="POST">
                            <div class="w3-section">
                                <input type="hidden" name="username" value=<%= databaseInfo.getDbusername() %>>
                                <input type="hidden" name="dbname" value=<%= databaseInfo.getDbname() %>>
                                <label><b>New Password</b></label>
                                <textarea class="w3-input w3-border" placeholder="Please Enter SQL" name="SQL" required style="height:200px"></textarea>
                                <button class="w3-button w3-block w3-green w3-section w3-padding"
                                        type="submit"
                                        name="executeSQL"
                                        value="executeSQL">
                                    Confirm Execute SQL
                                </button>
                            </div>
                        </form>

                        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
                            <button onclick="document.getElementById('ExecuteSQL').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
                        </div>

                    </div>
                </div>

                <%-- Database Usage --%>
                <div class="w3-quarter">
                    <div class="w3-card" style="background-color:white;height:150px">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Database Operation</span>
                        </header>

                        <div style="height:90px">
                            <div class="w3-container w3-row" style="margin-top: 10px;margin-bottom: 5px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     onclick="document.getElementById('changePassword').style.display='block'"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;">
                                    <span style="vertical-align: middle;color: #666;">
                                        Change Password
                                    </span>
                                </div>
                            </div>
                            <div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     onclick="document.getElementById('ExecuteSQL').style.display='block'"
                                     style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;">
                                    <span style="vertical-align: middle;color: #666;">Execute SQL</span>
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
                                List<Map<String, String>> tableUsages = database.queryTableUsage(databaseInfo.getDbname());
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
        <!-- Security -->
        <%--<div class="w3-container">--%>

        <%--<div class="w3-panel w3-leftbar w3-border-blue">--%>
        <%--<span style="font-size: 16px">Security</span>--%>
        <%--</div>--%>
        <%--<div class="w3-row-padding" >--%>
        <%--&lt;%&ndash; Message &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-card" style="background-color:white">--%>

        <%--<header class="w3-container w3-padding" >--%>
        <%--<span style="font-size: 17px">Operation Status</span>--%>
        <%--</header>--%>

        <%--<div class="w3-container w3-padding">--%>
        <%--<div class="w3-row-padding">--%>
        <%--&lt;%&ndash; CPU &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"--%>
        <%--style="background-color: #F5F5F6;text-align: center; height: 130px">--%>
        <%--<div class="w3-margin-top s3-margin-bottom">--%>
        <%--<span style="color:#C6D0D4;font-size:30px">34%</span>--%>
        <%--</div>--%>
        <%--<div class="w3-container w3-padding" style="color: #333333;margin-top: 20px">--%>
        <%--CPU--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash; Database Usage &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"--%>
        <%--style="background-color: #F5F5F6;text-align: center; height: 130px">--%>
        <%--<div class="w3-margin-top s3-margin-bottom">--%>
        <%--<span style="color:#C6D0D4;font-size:30px">53%</span>--%>
        <%--</div>--%>
        <%--<div class="w3-container w3-padding" style="color: #333333;margin-top: 10px">--%>
        <%--Internet Usage--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash; Database Usage &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"--%>
        <%--style="background-color: #F5F5F6;text-align: center; height: 130px">--%>
        <%--<div class="w3-margin-top s3-margin-bottom">--%>
        <%--<span style="color:#FF0000;font-size:30px">89%</span>--%>
        <%--</div>--%>
        <%--<div class="w3-container w3-padding" style="color: #333333;margin-top: 10px">--%>
        <%--Database Usage--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash; Database Usage &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-card" style="background-color:white">--%>

        <%--<header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">--%>
        <%--<span style="font-size: 20px">Database Usage</span>--%>
        <%--</header>--%>

        <%--<div style="height:90px">--%>
        <%--<div class="w3-container w3-row" style="margin-top: 10px;margin-bottom: 5px;">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">--%>
        <%--<span style="vertical-align: middle;color: #666;">Use</span>--%>
        <%--<span style="vertical-align: middle;color: #666;">1.34 G</span>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;">--%>
        <%--<span style="vertical-align: middle;color: #666;">Remain</span>--%>
        <%--<span style="vertical-align: middle;color: #666;">0.63 G</span>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash; Database Usage &ndash;%&gt;--%>
        <%--<div class="w3-third">--%>
        <%--<div class="w3-card" style="background-color:white">--%>

        <%--<header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">--%>
        <%--<span style="font-size: 20px">Database Usage</span>--%>
        <%--</header>--%>

        <%--<div style="height:90px">--%>
        <%--<div class="w3-container w3-row" style="margin-top: 10px;margin-bottom: 5px;">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">--%>
        <%--<span style="vertical-align: middle;color: #666;">Use</span>--%>
        <%--<span style="vertical-align: middle;color: #666;">1.34 G</span>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">--%>
        <%--<div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;">--%>
        <%--<span style="vertical-align: middle;color: #666;">Remain</span>--%>
        <%--<span style="vertical-align: middle;color: #666;">0.63 G</span>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>

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
                                <a href="<%=appInfo.getContextpath()%>"><%= appInfo.getName() %></a>
                                <% } else { %>
                                <%= appInfo.getName() %>
                                <% } %>
                            </span>
                            <form class="w3-right" action="${pageContext.request.contextPath}/application/detail" method="POST">
                                <input type="hidden" name="appid" value=<%= appInfo.getAppid().toString() %>>
                                <input type="hidden" name="userid" value=<%= appBean.getUserid() %>>
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