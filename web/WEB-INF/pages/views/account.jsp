<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 20/03/2019
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Team 06 - Welcome - Account</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<%-- import --%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>

<%-- Java Bean --%>
<jsp:useBean id="userBean" scope="session" class="javabean.UserBean" />
<jsp:setProperty name="userBean" property="*" />

<%-- Authentication --%>
<%@ include file="/WEB-INF/logic/authentication.jsp"%>

<body onload="getUserInfo(1), getUserNameList()">

<%@ include file="/WEB-INF/pages/component/layout/navigation.jsp"%>

<div>

    <%@ include file="/WEB-INF/pages/component/layout/sidebar.jsp"%>

    <div id="main" style="margin-left: 50px">

        <!-- Page content -->
        <div class="w3-container">
            <div class="w3-row">
                <%-- User_old --%>
                <div class="w3-col w3-card-4 w3-margin" style="width:30%">
                    <header class="w3-container" >
                        <h4><i class="fas fa-braille"></i> <span id="username">UserName</span></h4>
                    </header>

                    <ul class="w3-ul">
                        <li class="w3-hover-red"><span>E-Mail</span><span id="email" class="w3-right">xx@xx.com</span></li>
                        <li class="w3-hover-blue"><span>Birthday</span><span id="birthday" class="w3-right">XXXX-XX-XX</span></li>
                        <li class="w3-hover-green"><span>Last Login Time</span><span id="time" class="w3-right">13.4</span></li>
                    </ul>
                </div>

                <%-- Account Overview --%>
                <div class="w3-col w3-card-4 w3-margin" style="width:30%">
                    <header class="w3-container" >
                        <h4><i class="fas fa-braille"></i> Account Overview</h4>
                    </header>
                    <ul class="w3-ul">
                        <li class="w3-hover-red"><span>Balance</span><span class="w3-right">203.13</span></li>
                        <li class="w3-hover-blue"><span>Due</span><span class="w3-right">3.29</span></li>
                        <li class="w3-hover-green"><span>Time</span><span class="w3-right">1234.2</span></li>
                    </ul>
                </div>

                    <%
                        userBean.doAction(request);
                    %>
                <%-- Account Overview --%>
                <div class="w3-col w3-card-4 w3-margin" style="width:30%">

                    <%
                        Map<String, String> userInfo = userBean.getUserInfo();
                    %>
                    <header class="w3-container" >
                        <h4><i class="fas fa-braille"></i> <%= userInfo.get("displayname") %></h4>
                    </header>
                    <ul class="w3-ul">

                        <li class="w3-hover-red"><span>E-Mail</span><span class="w3-right"><%= userInfo.get("email") %></span></li>
                        <li class="w3-hover-blue"><span>Birthday</span><span class="w3-right"><%= userInfo.get("birthday") %></span></li>
                        <li class="w3-hover-green"><span>Username</span><span class="w3-right"><%= userInfo.get("username") %></span></li>
                    </ul>
                </div>

            </div>

        </div>

        <div class="w3-card-4 w3-margin">

            <header class="w3-container w3-blue" >
                <h3><b><i class="fab fa-playstation"></i> Playground</b></h3>
            </header>

            <%--<jsp:useBean id="userBean" scope="session" class="javabean.UserControllerController" />--%>
            <%--<jsp:setProperty name="userBean" property="*" />--%>
            <form type="post" action="">
                    <span><br />Please enter item to add or remove:
                        <br />Add Item:</span>
                <select name="userNameList">
                    <%
                        Map<String, String> usersName = userBean.getUsersName();
                        Iterator<Map.Entry<String, String>> usersNameIterator = usersName.entrySet().iterator();
                        while (usersNameIterator.hasNext()) {
                            Map.Entry<String, String> userName = usersNameIterator.next();
                    %>
                    <option value =<%= userName.getKey() %>> <%= userName.getValue() %> </option>
                    <% } %>
                </select>
                <br /><br />
                <input type="submit" name="submit" value="switch User" />
            </form>
        </div>

        <%-- Playground --%>
        <div class="w3-card-4 w3-margin">

            <header class="w3-container w3-blue" >
                <h3><b><i class="fab fa-playstation"></i> Playground</b></h3>
            </header>

            <div class="w3-bar">
                <button class="w3-bar-item w3-button w3-black" style="width:25%">Add User</button>

                <select id="UserList" class="w3-bar-item w3-button" style="width:12%">
                </select>
                <button class="w3-bar-item w3-button w3-teal" onclick="getUserNameList()" style="width:13%">Switch User</button>
                <button class="w3-bar-item w3-button w3-red" style="width:25%">Delete User</button>
                <button class="w3-bar-item w3-button w3-yellow" style="width:25%" onclick="getUserInfo(2)">Update User</button>
            </div>

        </div>

    </div>
</div>

<script language='javascript' src='../../../js/sidebar.js'></script>

</body>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>
</html>
