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

<style>
    html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>

<body>

<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div>

    <%@ include file="/WEB-INF/views/sidebar.jsp"%>

    <jsp:include page="/WEB-INF/views/main.jsp"/>

</div>

<!-- JS to open and close sidebar with overlay effect -->
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
    function loadXMLDoc()
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
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("app1-div").innerHTML=xmlhttp.responseText;
            }
        }
        <%--xmlhttp.open("GET","${pageContext.request.contextPath}/web/try/ajax_info.txt",true);--%>
        xmlhttp.open("GET","HelloWorld",true);
        xmlhttp.send();
    }
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
