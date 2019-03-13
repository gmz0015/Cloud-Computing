<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Sidebar -->
<div class="w3-sidebar w3-flat-wet-asphalt w3-card-4 w3-animate-left w3-large"
     style="display:none;z-index:4" id="mySidebar">
    <div class="w3-panel w3-border-top w3-border-bottom w3-border-blue">
        <h1>Welcome</h1>
        <h1><strong>Team 06</strong></h1>
        <h5><%= new java.util.Date() %></h5>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-green">Home</a>
        <a href="#" class="w3-bar-item w3-button">Account</a>
        <a href="#" class="w3-bar-item w3-button">Log out</a>
    </div>
</div>
</html>
