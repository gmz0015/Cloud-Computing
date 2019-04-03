<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 28/03/2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Java Bean --%>
<jsp:useBean id="appCreateBean" scope="page" class="team06.web.bean.AppCreateBean" />

<%-- import --%>
<%@ page import="team06.domain.Database" %>

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

            <br/>
            <div class="w3-row-padding" >
                <%-- Allocate Database --%>
                <div class="w3-quarter">
                    <% if (appCreateBean.getNextStep() == 0) { %>
                    <div class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Allocate Database</span>
                    </div>
                    <% }else { %>
                    <div class="w3-panel w3-leftbar w3-border-green">
                        <span style="font-size: 16px">Allocate Database</span>
                    </div>
                    <% } %>
                    <div class="w3-row-padding">
                        <% Database database = appCreateBean.queryDBbyid(2); %>
                        <%-- Applications --%>
                        <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                            <div class="w3-display-container" style="height: 33.3%">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                    <div class="w3-display-container" style="height: 100%">
                                        <span class="w3-display-middle" style="width:100%">Your Database name is: <%= database.getDbname() %></span>
                                    </div>
                                </div>
                            </div>

                            <div class="w3-display-container" style="height: 33.3%">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                    <div class="w3-display-container" style="height: 100%">
                                        <span class="w3-display-middle" style="width:100%">Your Database username is: <%= database.getDbusername() %></span>
                                    </div>
                                </div>
                            </div>

                            <div class="w3-display-container" style="height: 33.3%">
                                <div class="w3-display-middle w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                    <div class="w3-display-container" style="height: 100%">
                                        <span class="w3-display-middle" style="width:100%">Your Database password is: <%= database.getDbpassword() %></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Upload --%>
                <div class="w3-quarter">
                    <% if (appCreateBean.getNextStep() == 0) { %>
                    <div class="w3-panel w3-leftbar w3-border-red">
                        <span style="font-size: 16px">Upload Application</span>
                    </div>
                    <% }else if (appCreateBean.getNextStep() == 1) { %>
                    <div class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Upload Application</span>
                    </div>
                    <% }else { %>
                    <div class="w3-panel w3-leftbar w3-border-green">
                        <span style="font-size: 16px">Upload Application</span>
                    </div>
                    <% } %>
                    <div class="w3-row-padding">
                        <%-- Applications --%>
                        <div class="w3-card" style="background-color:white;position:relative;height: 150px">
                            <form action="" enctype="multipart/form-data" method="POST" style="height:100%">
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
                                    <div class="w3-display-middle w3-border w3-border-white"
                                         style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                        <div class="w3-display-container" style="height: 100%">
                                            <input class="w3-display-middle w3-button w3-round-large w3-border w3-hover-white w3-hover-border-cyan" type="submit" name="Detail" value="Upload">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <% appCreateBean.doDeploy(request); %>
                <%-- Deploy --%>
                <div class="w3-half">
                    <div class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Status</span>
                    </div>
                    <div class="w3-row-padding">
                        <%-- Applications --%>
                        <div class="w3-card" style="background-color:white;position:relative;height: 150px">
                            <div class="w3-row-padding" style="height: 100%">

                                <%-- Upload Status --%>
                                <div class="w3-third w3-display-container" style="height: 100%">
                                    <div class="w3-display-middle w3-border w3-border-white"
                                         style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                        <div class="w3-display-container w3-border w3-border-white" style="height: 50%">
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Upload</span>
                                        </div>
                                        <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="height: 50%">
                                            <% if (appCreateBean.getUploadStatus() == 0) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Waiting</span>
                                            <% }else if (appCreateBean.getUploadStatus() == 1) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Failed</span>
                                            <% }else if (appCreateBean.getUploadStatus() == 2) { %>
                                            <span class="w3-display-middle" style="color: #090;font-size:18px">Successful</span>
                                            <% } %>
                                        </div>
                                    </div>
                                </div>

                                <%-- Deploy Status --%>
                                <div class="w3-third w3-display-container" style="height: 100%;border-right:2px dashed #dddddd;border-left:2px dashed #dddddd">
                                    <div class="w3-display-middle w3-border w3-border-white"
                                         style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                        <div class="w3-display-container w3-border w3-border-white" style="height: 50%;">
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Deploy</span>
                                        </div>
                                        <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="height: 50%">
                                            <% if (appCreateBean.getDeployStatus() == 0) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Waiting</span>
                                            <% }else if (appCreateBean.getDeployStatus() == 1) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Failed</span>
                                            <% }else if (appCreateBean.getDeployStatus() == 2) { %>
                                            <span class="w3-display-middle" style="color: #090;font-size:18px">Successful</span>
                                            <% } %>
                                        </div>
                                    </div>
                                </div>

                                <%-- Startup Status --%>
                                <div class="w3-third w3-display-container" style="height: 100%">
                                    <div class="w3-display-middle w3-border w3-border-white"
                                         style="width: 99%;height: 90%;background-color: #F5F5F6;">
                                        <div class="w3-display-container w3-border w3-border-white" style="height: 50%;">
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Startup</span>
                                        </div>
                                        <div class="w3-display-container w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="height: 50%">
                                            <% if (appCreateBean.getStartupStatus() == 0) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Waiting</span>
                                            <% }else if (appCreateBean.getStartupStatus() == 1) { %>
                                            <span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Failed</span>
                                            <% }else if (appCreateBean.getStartupStatus() == 2) { %>
                                            <span class="w3-display-middle" style="color: #090;font-size:18px">Successful</span>
                                            <% } %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <br/>
            <div class="w3-row-padding" >
                <% if (appCreateBean.getNextStep() == 0) { %>
                <div class="w3-panel w3-leftbar w3-border-red">
                    <span style="font-size: 16px">API Configuration</span>
                </div>
                <% }else if (appCreateBean.getNextStep() == 1) { %>
                <div class="w3-panel w3-leftbar w3-border-red">
                    <span style="font-size: 16px">API Configuration</span>
                </div>
                <% }else if (appCreateBean.getNextStep() == 2) { %>
                <div class="w3-panel w3-leftbar w3-border-blue">
                    <span style="font-size: 16px">API Configuration</span>
                </div>
                <% }else { %>
                <div class="w3-panel w3-leftbar w3-border-green">
                    <span style="font-size: 16px">API Configuration</span>
                </div>
                <% } %>
                <div class="w3-row-padding">
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
    </div>
</section>

</html>

<%--<div class="w3-display-container" style="height: 50%">--%>
<%--<div class="w3-display-middle w3-border w3-border-white"--%>
<%--style="width: 99%;height: 90%;background-color: #F5F5F6;">--%>
<%--<div class="w3-display-container" style="height: 100%">--%>
<%--<% if (request.getAttribute("Upload Status") != null) { if (request.getAttribute("Upload Status").equals("1")) { %>--%>
<%--<span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Upload Successful</span>--%>
<%--<% }else { %>--%>
<%--<span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Upload Failed</span>--%>
<%--<% } }else { %>--%>
<%--<span class="w3-display-middle" style="color:#9B9EA0;font-size:18px">Waiting to Upload</span>--%>
<%--<% } %>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>