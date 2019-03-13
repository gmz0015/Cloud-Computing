<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="main">

    <%-- Navigation --%>
    <div class="w3-bar w3-blue w3-card w3-large" style="z-index:4">
        <a id="sidebar-open"
           class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-black"
           onclick="w3_open()"><i class="fas fa-indent"></i> Menu</a>
        <a id="sidebar-close"
           class="w3-bar-item w3-button w3-hover-none w3-text-white w3-hover-text-black"
           onclick="w3_close()" style="display:none"><i class="fas fa-outdent"></i> Menu</a>
        <a href="#" class="w3-bar-item w3-button w3-right">Log out</a>
        <a href="#" class="w3-bar-item w3-button w3-right">Account</a>
    </div>

    <!-- Page content -->
    <div class="w3-container">

        <br/>
        <%-- Dashboard --%>
        <div class="w3-card-4">

            <header class="w3-container w3-light-blue" >
                <h3><b><i class="fas fa-braille"></i> Dashboard</b></h3>
            </header>

            <div class="w3-row-padding">
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>52</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Messages</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>99</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Views</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-teal w3-padding-16">
                        <div class="w3-left"><i class="fa fa-share-alt w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>23</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Shares</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>50</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Users</h4>
                    </div>
                </div>
            </div>

        </div>

        <br/>
        <%-- Applications --%>
        <div class="w3-card-4">

            <header class="w3-container w3-light-blue" >
                <h3><b><i class="fas fa-th"></i> Applications</b></h3>
            </header>

            <div class="w3-row-padding">
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-red w3-padding-16">
                        <h4 class="w3-button" onclick="loadXMLDoc()">App 1</h4>
                    </div>
                    <div id="app1-div">
                        <h5>Using Ajax to change this text.</h5>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-blue w3-padding-16">
                        <h4>App 2</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-teal w3-padding-16">
                        <h4>App 3</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <h4>App 4</h4>
                    </div>
                </div>
            </div>

        </div>

        <br/>
        <%-- Playground --%>
        <div class="w3-card-4">

            <header class="w3-container w3-light-blue" >
                <h3><b><i class="fab fa-playstation"></i> Playground</b></h3>
            </header>

            <div class="w3-container">
                <div class="w3-row-padding w3-margin-bottom">
                    <%@ page import="java.util.Date" %>
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

<!-- JS to open and close sidebar with overlay effect -->
<script>
    function w3_open() {
        document.getElementById("main").style.marginLeft = "15%";
        document.getElementById("mySidebar").style.width = "15%";
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("sidebar-open").style.display = "none";
        document.getElementById("sidebar-close").style.display = "block";
    }

    function w3_close() {
        document.getElementById("main").style.marginLeft = "0%";
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("sidebar-close").style.display = "none";
        document.getElementById("sidebar-open").style.display = "block";
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
</script>
</body>
</html>
