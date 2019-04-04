
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Java Bean --%>
<jsp:useBean id="userBean" scope="session" class="team06.test.web.bean.UserBean" />

<%-- import --%>
<%@ page import="team06.test.domain.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE HTML>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<title>Team 06 - Application</title>
<body>
<form action="greeting" method=“GET">
    <div><h4>Say Hello</h4></div>
    <div>
        <input type="submit" value="Submit" />
    </div>
</form>

<table class="w3-table-all w3-centered ">
    <tr>
        <th>User ID</th>
        <th>User Name</th>
        <th>User Password</th>
        <th>User Role</th>
    </tr>
    <%
        List<User> users = userBean.getAllUsers();
        for (User user: users) {
    %>
    <tr>
        <td><%= user.getUserid() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getPassword() %></td>
        <td><%= user.getRole() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>