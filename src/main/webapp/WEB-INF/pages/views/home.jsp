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
<%@ page import="team06.platform.domain.Application" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>

<%-- Java Bean --%>
<jsp:useBean id="indexBean" scope="page" class="team06.platform.web.bean.IndexBean" />
<% indexBean.getInfo(request); %>
<%--<jsp:setProperty name="indexBean" property="*" />--%>

<%-- Error --%>
<%@ include file="/WEB-INF/pages/error/errorPermission.jsp"%>
<html xmlns:jsp="http://java.sun.com/JSP/Page">

<%-- Change Password --%>
<div id="changePassword" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=password" method="post">
            <div class="w3-section">
                <label><b>Please Enter Your Old Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Old Password" name="psw0" required>
                <label><b>Please Enter Your New Password</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Password" name="psw1" required>
                <label><b>Please Enter Your New Password Again</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Password Again" name="psw2" required>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changePassword').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Avatar --%>
<div id="changeAvatar" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=avatar" enctype="multipart/form-data" method="post" >
            <div class="w3-section">
                <label><b>Please Enter Your Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Password" name="psw" required>
                <label><b>Please Upload Your New Avatar</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="file" name="avatar">
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeAvatar').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>

<%-- Change Email --%>
<div id="changeEmail" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

        <form class="w3-container" action="/change?type=email" method="post">
            <div class="w3-section">
                <label><b>Please Enter Your Password</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Password" name="psw" required>
                <label><b>Please Enter Your New Email</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Email" name="email" required>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('changeEmail').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        </div>

    </div>
</div>


<div id="main" style="margin-left: 50px">
    <%-- Welcome Message --%>
    <div class="w3-container">
        <br/>
        <div class="w3-row-padding" >
            <% if (indexBean.getUserRole() == null) { %>
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
            <% }else if(indexBean.getUserRole().equals("USER")) { %>
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
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getUserName() %></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half w3-padding" style="">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Balance
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getBalance() %></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Control Center - User --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Control Center</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half" style="border-right:1px dashed #dddddd">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changePassword').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Password</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeAvatar').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Avatar</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeEmail').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Email</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" >
                                    <span style="vertical-align: middle;color: #666;">Become a Developer</span>
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
                                <span style="vertical-align: middle;color: #666;">Last View:</span>
                                <span style="vertical-align: middle;color: #666;">Test Food Search</span>
                            </div>
                        </div>
                        <div class="w3-container w3-row" style="margin-top: 5px;margin-bottom: 10px;">
                            <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="vertical-align: middle;background-color: #F5F5F6;height:35px;text-align: center;">
                                <span style="vertical-align: middle;color: #666;">View Browsing History</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <% }else if(indexBean.getUserRole().equals("DEVELOPER")) { %>
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
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getUserName() %></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half w3-padding" style="">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Balance
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getBalance() %></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Control Center - Developer --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Control Center</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half" style="border-right:1px dashed #dddddd">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changePassword').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Password</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeAvatar').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Avatar</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeEmail').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Email</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" >
                                    <span style="vertical-align: middle;color: #666;">You are Developer</span>
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
            <% }else if(indexBean.getUserRole().equals("ADMIN")) { %>
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
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getUserName() %></span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half w3-padding" style="">
                            <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                    Balance
                                </div>
                                <div class="w3-row" style="text-align: center;vertical-align: middle">
                                    <span style="color:#9B9EA0;font-size:18px"><%= indexBean.getBalance() %></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- Control Center - Admin --%>
            <div class="w3-third">
                <div class="w3-card" style="background-color:white;position:relative">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Control Center</span>
                    </header>

                    <div class="w3-row" style="height:100px">
                        <div class="w3-half" style="border-right:1px dashed #dddddd">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changePassword').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Password</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeAvatar').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Avatar</span>
                                </div>
                            </div>
                        </div>

                        <div class="w3-half">
                            <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" onclick="document.getElementById('changeEmail').style.display='block'">
                                    <span style="vertical-align: middle;color: #666;">Change Email</span>
                                </div>
                            </div>

                            <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;cursor: pointer;" >
                                    <span style="vertical-align: middle;color: #666;">You are Developer</span>
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
            <% } %>
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
                            <th>Application Name</th>
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
                            <td>
                                <% if (appInfo.getStatus() == 2) { %>
                                <a href="/enter/?<%=appInfo.getContextPath()%>"><%= appInfo.getName() %></a>
                                <% } else { %>
                                <%= appInfo.getName() %>
                                <% } %>
                            </td>
                            <td><%= appInfo.getOwnerName() %></td>
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
                                <%@ include file="/WEB-INF/pages/component/status/undeploy.jsp"%>
                                <% } else if (appInfo.getStatus() == 1) { %>
                                <%@ include file="/WEB-INF/pages/component/status/stop.jsp"%>
                                <% } else if (appInfo.getStatus() == 2) { %>
                                <%@ include file="/WEB-INF/pages/component/status/running.jsp"%>
                                <% } %>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/application/detail" method="POST">
                                    <input type="hidden" name="appId" value=<%= appInfo.getAppId() %>>
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
</div>

<style>
</style>
</html>
