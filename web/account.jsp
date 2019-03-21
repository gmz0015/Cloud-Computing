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


<body onload="getUserInfo(1)">

<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div>

    <%@ include file="/WEB-INF/views/sidebar.jsp"%>

    <div id="main" style="margin-left: 50px">

        <!-- Page content -->
        <div class="w3-container">
            <div class="w3-row">
                <%-- User --%>
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

                <%-- Account Overview --%>
                <div class="w3-col w3-card-4 w3-margin" style="width:30%">
                    <header class="w3-container" >
                        <h4><i class="fas fa-braille"></i> XXXX</h4>
                    </header>
                    <ul class="w3-ul">
                        <li class="w3-hover-red"><span>XXXX</span><span class="w3-right">XX.XX</span></li>
                        <li class="w3-hover-blue"><span>XXXX</span><span class="w3-right">XX.XX</span></li>
                        <li class="w3-hover-green"><span>XXXX</span><span class="w3-right">XX.XX</span></li>
                    </ul>
                </div>

            </div>

        </div>

        <%-- Playground --%>
        <div class="w3-card-4 w3-margin">

            <header class="w3-container w3-blue" >
                <h3><b><i class="fab fa-playstation"></i> Playground</b></h3>
            </header>

            <div class="w3-bar">
                <button class="w3-bar-item w3-button w3-black" style="width:25%">Add User</button>
                <button class="w3-bar-item w3-button w3-teal" style="width:25%">Switch User</button>
                <button class="w3-bar-item w3-button w3-red" style="width:25%">Delete User</button>
                <button class="w3-bar-item w3-button w3-yellow" style="width:25%" onclick="getUserInfo(2)">Update User</button>
            </div>

            <div class="w3-bar w3-margin-top">
                <button class="w3-bar-item w3-button w3-black" style="width:33.3%">Add Balance</button>
                <button class="w3-bar-item w3-button w3-teal" style="width:33.3%">Reduce Balance</button>
                <button class="w3-bar-item w3-button w3-red" style="width:33.3%">Make number invisible</button>
            </div>

        </div>

    </div>
</div>

<script language='javascript' src='js/sidebar.js'></script>
<script language='javascript' src='js/user.js'></script>
<script>
    function loadMain(type)
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        <%--xmlhttp.open("GET","${pageContext.request.contextPath}/web/try/ajax_info.txt",true);--%>
        console.log(type);
        xmlhttp.open("GET","loadMain?type="+type,true);
        xmlhttp.send();
    }
</script>
</body>
</html>
