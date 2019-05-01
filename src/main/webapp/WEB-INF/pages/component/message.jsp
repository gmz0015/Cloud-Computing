<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 06/04/2019
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (request.getAttribute("message") != null) { %>
<div id="message" class="w3-modal" style="display: block">
    <div class="w3-modal-content">

        <header class="w3-container w3-teal">
      <span onclick="document.getElementById('message').style.display='none'"
            class="w3-button w3-display-topright">&times;</span>
            <h2>Operation Result</h2>
        </header>

        <div class="w3-container">
            <p><%= request.getAttribute("message") %></p>
        </div>

    </div>
</div>
<% request.setAttribute("message", null); } %>
