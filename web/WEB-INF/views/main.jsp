<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 13/03/2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div id="main" style="margin-left: 50px">

    <!-- Page content -->
    <div class="w3-container">

        <br/>
        <%-- Dashboard --%>
        <div class="w3-card-4">

            <header class="w3-container w3-blue" >
                <h3><b><i class="fas fa-braille"></i> Dashboard</b></h3>
            </header>

            <div class="w3-row-padding">
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fas fa-comment-dots w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>52</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Comments</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-margin-top w3-margin-bottom">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>99</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Apps</h4>
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

            <header class="w3-container w3-blue" >
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

            <header class="w3-container w3-blue" >
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
</html>
