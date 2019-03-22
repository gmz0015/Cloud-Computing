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
<div class="w3-bar w3-flat-wet-asphalt w3-card w3-large" style="z-index:4">
    <a class="w3-bar-item">Welcome <strong>Team 06</strong>! <%= new java.util.Date() %></a>
    <a href="#" class="w3-bar-item w3-button w3-right" onclick="document.getElementById('login').style.display='block'">Login</a>
    <a href="#" class="w3-bar-item w3-button w3-right" onclick=window.location.href="/platform/account.jsp">Account</a>
</div>
</html>
