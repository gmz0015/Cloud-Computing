<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Sidebar -->
<div class="w3-sidebar w3-flat-wet-asphalt w3-card-4 w3-animate-left"
     style="width:50px;z-index:4" id="mySidebar">

    <%--<div class="w3-row">--%>
        <%--<tr>--%>
            <%--<th><i class="fas fa-indent"></i></th>--%>
            <%--<th><i class="fas fa-database"></i></th>--%>
            <%--<th><i class="fab fa-playstation"></i></th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<th><span>Menu</span></th>--%>
            <%--<th><span>Database</span></th>--%>
            <%--<th><span>Playground</span></th>--%>
        <%--</tr>--%>
    <%--</div>--%>

    <%-- Sidebar Closed --%>
    <div class="w3-bar-block">
        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue"
           onclick="w3_open()">
            <div class="w3-row">
                <div class="w3-col s2 w3-center">
                    <i class="fas fa-indent"></i>
                </div>
                <div id="sidebar-menu" class="w3-col s9 w3-center" style="display:none">
                    Menu
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue"
             onclick=window.location.href="../../../index.jsp">
            <div class="w3-row">
                <div class="w3-col s2 w3-center">
                    <i class="fas fa-home"></i>
                </div>
                <div id="sidebar-home" class="w3-col s9 w3-center" style="display:none">
                    Home
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue">
            <div class="w3-row">
                <div class="w3-col s2 w3-center">
                    <i class="fas fa-database"></i>
                </div>
                <div id="sidebar-database" class="w3-col s9 w3-center" style="display:none">
                    <a>Database</a>
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue">
            <div class="w3-row">
                <div class="w3-col s2 w3-center">
                    <i class="fab fa-playstation"></i>
                </div>
                <div id="sidebar-playground" class="w3-col s9 w3-center" style="display:none">
                    Upload
                </div>
            </div>
        </div>
    </div>
</div>
</html>
