<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<title>Team 06 - Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>



<body>

<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div>

    <%@ include file="/WEB-INF/views/sidebar.jsp"%>

    <%@ include file="/WEB-INF/views/main.jsp"%>

</div>

<%@ include file="/WEB-INF/views/login.jsp"%>

<!-- JS to open and close sidebar with overlay effect -->
<script language='javascript' src='js/sidebar.js'></script>
<script>
    function w3_open() {
        if (document.getElementById("mySidebar").style.width === "150px")
        {
            document.getElementById("main").style.marginLeft = "50px";
            document.getElementById("mySidebar").style.width = "50px";
            document.getElementById("sidebar-menu").style.display = "none";
            document.getElementById("sidebar-home").style.display = "none";
            document.getElementById("sidebar-database").style.display = "none";
            document.getElementById("sidebar-playground").style.display = "none";
        }
        else
        {
            document.getElementById("main").style.marginLeft = "150px";
            document.getElementById("mySidebar").style.width = "150px";
            document.getElementById("sidebar-menu").style.display = "block";
            document.getElementById("sidebar-home").style.display = "block";
            document.getElementById("sidebar-database").style.display = "block";
            document.getElementById("sidebar-playground").style.display = "block";
        }
    }
</script>

</body>
</html>
