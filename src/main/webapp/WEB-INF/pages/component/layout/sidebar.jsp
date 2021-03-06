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
<aside class="w3-sidebar w3-flat-wet-asphalt w3-card-4 w3-animate-left"
     style="width:50px;z-index:4;background-color: #252a2f;"
       id="mySidebar">

    <div class="w3-bar-block">
        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue"
           onclick="w3_open()" style="height:50px">
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i id="open-icon" class="fas fa-indent"></i>
                    <%--<i id="close-icon" class="fas fa-outdentt" style="display: none"></i>--%>
                </div>
                <div id="sidebar-menu" class="w3-col w3-left w3-margin-left" style="width:80px;display:none">
                    Menu
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
             onclick="window.location.href='<%= request.getContextPath() + "/" %>'" >
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-home"></i>
                </div>
                <div id="sidebar-home" class="w3-col w3-left  w3-margin-left" style="width:80px;display:none">
                    <span>Home</span>
                </div>
            </div>
        </div>
        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
            onclick="window.location.href='<%= request.getContextPath() + "/console" %>'" >
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-code"></i>
                </div>
                <div id="sidebar-console" class="w3-col w3-left  w3-margin-left" style="width:80px;display:none">
                    <span>Console</span>
                </div>
            </div>
        </div>
        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
             onclick="window.location.href='<%= request.getContextPath() + "/application" %>'" >
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-th-large"></i>
                </div>
                <div id="sidebar-database" class="w3-col w3-left  w3-margin-left" style="width:80px;display:none">
                    <span>Application</span>
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
             onclick="window.location.href='<%= request.getContextPath() + "/guide" %>'">
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-book"></i>
                </div>
                <div id="sidebar-playground" class="w3-col w3-left w3-margin-left" style="width:80px;display:none">
                    <span>Guide</span>
                </div>
            </div>
        </div>

        <div class="w3-border-top w3-border-grey"></div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
             onclick="window.location.href='<%= request.getContextPath() + "/admin" %>'">
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-globe"></i>
                </div>
                <div id="sidebar-admin" class="w3-col w3-left w3-margin-left" style="width:80px;display:none">
                    <span>Admin</span>
                </div>
            </div>
        </div>

        <div class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-blue" style="height:50px"
             onclick="window.location.href='<%= request.getContextPath() + "/preference" %>'">
            <div class="w3-row">
                <div class="w3-col w3-center" style="width:20px">
                    <i class="fas fa-wrench"></i>
                </div>
                <div id="sidebar-setting" class="w3-col w3-left w3-margin-left" style="width:80px;display:none">
                    <span>Preferences</span>
                </div>
            </div>
        </div>
    </div>
</aside>
<script>
    function w3_open() {
        if (document.getElementById("mySidebar").style.width === "160px")
        {
            // document.getElementById("main").style.marginLeft = "50px";
            document.getElementById("mySidebar").style.width = "50px";
            document.getElementById("open-icon").className = "fas fa-indent";
            document.getElementById("sidebar-menu").style.display = "none";
            document.getElementById("sidebar-home").style.display = "none";
            document.getElementById("sidebar-console").style.display = "none";
            document.getElementById("sidebar-database").style.display = "none";
            document.getElementById("sidebar-playground").style.display = "none";
            document.getElementById("sidebar-admin").style.display = "none";
            document.getElementById("sidebar-setting").style.display = "none";
        }
        else
        {
            // document.getElementById("main").style.marginLeft = "150px";
            document.getElementById("mySidebar").style.width = "160px";
            document.getElementById("open-icon").className = "fas fa-outdent";
            document.getElementById("sidebar-menu").style.display = "block";
            document.getElementById("sidebar-home").style.display = "block";
            document.getElementById("sidebar-console").style.display = "block";
            document.getElementById("sidebar-database").style.display = "block";
            document.getElementById("sidebar-playground").style.display = "block";
            document.getElementById("sidebar-admin").style.display = "block";
            document.getElementById("sidebar-setting").style.display = "block";
        }
    }
</script>
</html>
