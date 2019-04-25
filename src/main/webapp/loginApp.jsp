<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 22/03/2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Team 06 - Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<header class="w3-container w3-teal">
    <h1>Login</h1>
</header>

<div class="w3-container w3-half w3-margin-top">

    <form class="w3-container w3-card-4" method="POST" name="login" action="j_security_check" enctype="application/x-www-form-urlencoded">

        <p>
            <input class="w3-input" type="text" style="width:90%" name="j_username" required>
            <label>Name</label></p>
        <p>
            <input class="w3-input" type="password" style="width:90%" name="j_password" required>
            <label>Password</label></p>
        <p>
            <input class="w3-button w3-section w3-teal w3-ripple" type="submit"/></p>

    </form>


    <p>Name:<b>admin</b> Password:<b>admin</b></p>
    <p>Name:<b>guest</b> Password:<b>guest</b></p>

</div>

</body>
</html>
