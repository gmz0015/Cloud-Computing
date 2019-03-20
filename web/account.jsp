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


<body>

<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div>

    <%@ include file="/WEB-INF/views/sidebar.jsp"%>

    There is a account

</div>
</body>

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

</html>
