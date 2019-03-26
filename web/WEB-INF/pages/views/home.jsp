<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- import --%>
<%@ page import="java.util.Date" %>
<%@ page import="team06.domain.Application" %>
<%@ page import="java.util.List" %>

<%-- Java Bean --%>
<jsp:useBean id="indexBean" scope="session" class="team06.web.bean.IndexBean" />
<%--<jsp:setProperty name="indexBean" property="*" />--%>

<% String error = request.getParameter("error");
System.out.println("error is: " + error);%>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<%-- Error Permission --%>
<%-- 0 => No permission to access the application --%>
<% if (error != null){
    if (error.equals("0")) { %>
<div id="errorPermission" class="w3-modal" style="display:block;">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <h2>Permission Denied</h2>
        </header>
        <div class="w3-container">
            <h4>Sorry, you don't have the permission to access this application.</h4>
            <button class="w3-button w3-blue w3-padding w3-round-large w3-hover-red w3-margin"
                    onclick="document.getElementById('errorPermission').style.display='none'">
                Close
            </button>
        </div>
    </div>
</div>
<% }
}%>
<div id="main" style="margin-left: 50px">

    <!-- Page content -->
    <div class="w3-container">

        <br/>
        <%-- Dashboard --%>
        <div class="w3-card-4">

            <header class="w3-container w3-blue" >
                <h4><b><i class="fas fa-braille"></i> Dashboard</b></h4>
            </header>

            <% if (!indexBean.getUserid().equals("guest")) { %>
            Hello, <%= indexBean.getUsername() %>
            <% }else { %>
            Hello, Guest.
            <% } %>

        </div>

        <br/>
        <%-- Applications --%>
        <div class="w3-card-4">

            <div class="w3-responsive">
                <%-- w3-table w3-bordered --%>
                <table class="w3-table-all w3-centered">
                    <tr class="w3-blue" style="width:10%">
                        <th>Application</th>
                        <th>Owner</th>
                        <th>Visits</th>
                        <th>Rating</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    <%
                        List<Application> appsInfo = indexBean.getAllApps();
                        for (Application appInfo: appsInfo) {
                    %>
                    <tr>
                        <td><%= appInfo.getName() %></td>
                        <td><%= appInfo.getOwnername() %></td>
                        <td><%= appInfo.getVisits() %></td>
                        <td>
                            <%
                                int unit = (int) appInfo.getRating();
                                int tenths = (int) (appInfo.getRating() * 10 - unit * 10);
                                for (int i=0; i<unit; i++){
                            %>
                            <i class="fas fa-star"></i>
                            <%

                                }
                                if (tenths > 5) {
                            %>
                            <i class="fas fa-star-half-alt"></i>
                            <% } %>
                        </td>
                        <td>
                            <% if (appInfo.getStatus() == 0) { %>
                            <%@ include file="/WEB-INF/pages/status/running.jsp"%>
                            <% } else if (appInfo.getStatus() == 1) { %>
                            <%@ include file="/WEB-INF/pages/status/maintainance.jsp"%>
                            <% } else if (appInfo.getStatus() == 2) { %>
                            <%@ include file="/WEB-INF/pages/status/stop.jsp"%>
                            <% } %>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/application" method="POST">
                                <input type="hidden" name="appid" value=<%= appInfo.getAppid().toString() %>>
                                <input class="w3-button w3-blue w3-round-large w3-hover-red " type="submit" name="Detail" value="Detail">
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>



        <br/>
        <%-- Playground --%>
        <div class="w3-card-4">

            <header class="w3-container w3-blue" >
                <h4><b><i class="fab fa-playstation"></i> Playground</b></h4>
            </header>

            <div class="w3-container">
                <div class="w3-row-padding w3-margin-bottom">
                    <h1>Today's Date</h1>
                    <%! private int count = 0; %>
                    <P>Hello! Today's date is
                        <%= new Date() %>
                    </p><p>
                    You have asked for the date
                    <%= ++count %> times since the
                    server was last restarted.
                </p>
                </div>
            </div>

        </div>

    </div>
</div>
</html>
