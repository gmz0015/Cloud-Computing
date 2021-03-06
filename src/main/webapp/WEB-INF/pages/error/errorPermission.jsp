<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 26/04/2019
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Error Permission --%>
<%-- 0 => No permission to access the application --%>
<% String error = request.getParameter("error");if (error != null){ if (error.equals("401.1")) { %>
<div id="errorPermission" class="w3-modal" style="display:block;">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <h2>Permission Denied - Logon Failed</h2>
        </header>
        <div class="w3-container">
            <h4>Sorry, you need to log on first.</h4>
            <button class="w3-button w3-blue w3-padding w3-round-large w3-hover-red w3-margin"
                    onclick="document.getElementById('errorPermission').style.display='none'">
                Close
            </button>
        </div>
    </div>
</div>
<% }else if(error.equals("401.4")) { %>
<div id="errorPermission" class="w3-modal" style="display:block;">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <h2>Permission Denied - Unauthorised</h2>
        </header>
        <div class="w3-container">
            <h4>Sorry, you have no access to the application.</h4>
            <button class="w3-button w3-blue w3-padding w3-round-large w3-hover-red w3-margin"
                    onclick="document.getElementById('errorPermission').style.display='none'">
                Close
            </button>
        </div>
    </div>
</div>
<% } else if(error.equals("401.2")) { %>
<div id="errorPermission" class="w3-modal" style="display:block;">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <h2>Change Denied - Form Error</h2>
        </header>
        <div class="w3-container">
            <h4>Sorry, you need to complete form.</h4>
            <button class="w3-button w3-blue w3-padding w3-round-large w3-hover-red w3-margin"
                    onclick="document.getElementById('errorPermission').style.display='none'">
                Close
            </button>
        </div>
    </div>
</div>
<% } } %>
