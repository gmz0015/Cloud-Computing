<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 22/03/2019
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% if(session.getAttribute("userinfo") == null) {
    System.out.println("NO PERMISSION");
    response.setHeader("refresh", "5;URL=" + request.getContextPath() + "/console.jsp");
} %>

<html>
</html>
