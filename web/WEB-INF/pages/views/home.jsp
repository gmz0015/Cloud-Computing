<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- import --%>
<%@ page import="java.util.Date" %>
<%@ page import="team06.domain.Application" %>
<%@ page import="java.util.List" %>

<%-- Java Bean --%>
<jsp:useBean id="indexBean" scope="session" class="team06.web.bean.IndexBean" />
<%--<jsp:setProperty name="indexBean" property="*" />--%>

<%-- Set userid to session --%>
<% request.setAttribute("userid", indexBean.getUserid()); %>
<% String error = request.getParameter("error"); %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<%-- Error Permission --%>
<%-- 0 => No permission to access the application --%>
<% if (error != null){ if (error.equals("0")) { %>
<div id="errorPermission" class="w3-modal" style="display:block;">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <h2>Permission Denied</h2>
        </header>
        <div class="w3-container">
            <h4>Sorry, you don't have the permission to access this application.</h4>
            <button class="w3-button w3-blue w3-padding w3-round-large w3-hover-red w3-margin"
                    onclick="document.getElementById('errorPermission').style.display='none'">
                Close
            </button>
        </div>
    </div>
</div>
<% } } %>

<div id="main" style="margin-left: 50px">
    <%-- Welcome Message --%>
    <div class="w3-container">
        <br/>
        <div class="w3-row-padding" >
            <% switch (indexBean.getRole()) { case "Guest": { %>
            <%-- Welcome Message - Guest --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Welcome</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Hello
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px">Guest</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">
                                        Login
                                    </span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">Sign Up</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Introduction - Guest --%>
            <div class="w3-twothird">
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Our Advantage</span>
                    </header>

                    <div class="w3-row" style="height: 96px;padding-top: 4px;padding-bottom: 4px">
                        <div class="w3-half" style="border-right:1px dashed #dddddd">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: help;">
                                    <span style="vertical-align: middle;color: #666;"><b>Life - Concerned</b> Platform</span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: help;">
                                    <span style="vertical-align: middle;color: #666;"><b>Friendly</b> Interface Design</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: help;">
                                    <span style="vertical-align: middle;color: #666;">Rating System</span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: help;">
                                    <span style="vertical-align: middle;color: #666;">Powerful <b>Cloud Ecosystems</b></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% break; }case "User": { %>
            <%-- Welcome Message - User --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Welcome</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Hello
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%=indexBean.getUsername()%></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">
                                        Login
                                    </span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">Sign Up</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Account Overview - User --%>
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
                                    <span style="vertical-align: middle;color: #666;">Test School Gym: </span>
                                    <span style="vertical-align: middle;color: #666;"><i class="fab fa-asymmetrik"></i> 15</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                    <span style="vertical-align: middle;color: #666;">Test Food Search: </span>
                                    <span style="vertical-align: middle;color: #666;"><i class="fab fa-asymmetrik"></i> 5</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Browsing History - User --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Browsing History</span>
                    </header>

                    <div style="height:90px">
                        <div class="w3-container w3-row" style="margin-top: 10px;margin-bottom: 5px;">
                            <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                <span style="vertical-align: middle;color: #666;">Last Day:</span>
                                <span style="vertical-align: middle;color: #666;">Test Food Search</span>
                            </div>
                        </div>
                        <div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">
                            <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;">
                                <span style="vertical-align: middle;color: #666;">3 Days Ago: </span>
                                <span style="vertical-align: middle;color: #666;">Test School Gym</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <% break; }case "Developer": { %>
            <%-- Welcome Message - Developer --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Welcome</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Hello
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%=indexBean.getUsername()%></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">
                                        Login
                                    </span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">Sign Up</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Account Overview - Developer --%>
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

            <%-- Database Usage - Developer --%>
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
            <% break; }case "Admin": { %>
            <%-- Welcome Message - Admin --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative;height: 150px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Welcome</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Hello
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%=indexBean.getUsername()%></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">
                                        Login
                                    </span>
                                </div>
                            </div>
                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                     style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;"
                                     onclick="window.location.href='<%= request.getContextPath() + "/login" %>'">
                                    <span style="vertical-align: middle;color: #666;">Sign Up</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Account Overview - Admin --%>
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

            <%-- Database Usage - Admin --%>
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
            <% break; } } %>
        </div>
    </div>

    <%-- All Applications --%>
    <div class="w3-container">
        <br/>
        <div class="w3-panel w3-leftbar w3-border-blue">
            <span style="font-size: 16px">Our Applications</span>
        </div>
        <div class="w3-row-padding">
            <%--<div class=""--%>
            <%-- Applications --%>
            <div class="w3-card">

                <div class="w3-responsive">
                    <%-- w3-table w3-bordered --%>
                    <table class="app w3-table w3-centered w3-white">
                        <tr class="" style="width:10%">
                            <th>Application</th>
                            <th>Owner</th>
                            <th>Visits</th>
                            <th>Rating</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        <%
                            List<Application> appsInfo = indexBean.getAllApps();
                            for (Application appInfo: appsInfo) {
                        %>
                        <tr class="w3-border" style="background-color: #F5F5F6;text-align: center">
                            <td><%= appInfo.getName() %></td>
                            <td><%= appInfo.getOwnername() %></td>
                            <td><%= appInfo.getVisits() %></td>
                            <td>
                                <%
                                    int unit = (int) appInfo.getRating();
                                    int tenths = (int) (appInfo.getRating() * 10 - unit * 10);
                                    for (int i=0; i<unit; i++){
                                %>
                                <i class="fas fa-star"></i>
                                <%

                                    }
                                    if (tenths > 5) {
                                %>
                                <i class="fas fa-star-half-alt"></i>
                                <% } %>
                            </td>
                            <td>
                                <% if (appInfo.getStatus() == 0) { %>
                                <%@ include file="/WEB-INF/pages/status/running.jsp"%>
                                <% } else if (appInfo.getStatus() == 1) { %>
                                <%@ include file="/WEB-INF/pages/status/maintainance.jsp"%>
                                <% } else if (appInfo.getStatus() == 2) { %>
                                <%@ include file="/WEB-INF/pages/status/stop.jsp"%>
                                <% } %>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/application/detail" method="POST">
                                    <input type="hidden" name="appid" value=<%= appInfo.getAppid().toString() %>>
                                    <input class="w3-button w3-round-large w3-border w3-hover-white w3-hover-border-cyan" type="submit" name="Detail" value="Detail">
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <%-- Charge Information --%>
    <div class="w3-container">
        <br/>
        <div class="w3-panel w3-leftbar w3-border-blue">
            <span style="font-size: 16px">Charge Information</span>
        </div>
        <div class="w3-row-padding">
            <%--<div class=""--%>
            <%-- Applications --%>
            <div class="w3-card">

                <div class="w3-responsive">
                    <%-- w3-table w3-bordered --%>
                    <table class="w3-table-all w3-centered">
                        <tr class="w3-border">
                            <th>Standard</th>
                            <th>Gold</th>
                            <th>Ultimate</th>
                        </tr>
                        <tr >
                            <th>10/hour</th>
                            <th>15/hour</th>
                            <th>20/hour</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

<style>
</style>
</html>
