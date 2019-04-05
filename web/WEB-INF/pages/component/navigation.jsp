<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 14/03/2019
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- Navigation --%>
<header class="nav w3-bar w3-flat-wet-asphalt w3-card w3-large"
        style="height: 45px;z-index:100;background-color: #252a2f;position: fixed;top:0">
    <a class="w3-bar-item">Welcome <strong>Team 06</strong>!</a>
    <%
        if(session.getAttribute("userid") == null) {
    %>
    <%-- logout, need to login --%>
    <a href="#" class="w3-bar-item w3-button w3-right" onclick="window.location.href='<%= request.getContextPath() %>/login.jsp'" >Login</a>
    <%
        } else {
    %>
    <%-- login, need to logout --%>
    <a href="#" class="w3-bar-item w3-button w3-right" onclick=window.location.href="<%= request.getContextPath() %>/logout">Logout</a>
    <a href="#" class="w3-bar-item w3-button w3-right" onclick=window.location.href="account.jsp">Account</a>
    <%
        }
    %>

</header>
<style>
    /*.nav{position:fixed;top:0;left:0;}*/
</style>
</html>
