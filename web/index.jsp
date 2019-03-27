<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html xmlns:jsp="http://java.sun.com/JSP/Page">

<title>Team 06 - Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<%-- Authentication --%>
<%--<%@ include file="/WEB-INF/logic/authentication.jsp"%>--%>

<%@ include file="/WEB-INF/pages/component/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/sidebar.jsp"%>

<section style="background-color:rgb(234, 237, 241);min-height: 960px">
<%--<div style="background-color:rgb(234, 237, 241);min-height: 960px">--%>

    <%@ include file="/WEB-INF/pages/views/home.jsp"%>

    <%--<jsp:include page="/WEB-INF/pages/views/home.jsp" />--%>

<%--</div>--%>

</section>

</html>
