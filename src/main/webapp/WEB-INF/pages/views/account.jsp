<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 26/03/2019
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- import --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="team06.platform.domain.Transaction" %>

<%-- Java Bean --%>
<jsp:useBean id="accountBean" scope="page" class="team06.platform.web.bean.AccountBean" />
<jsp:setProperty name="accountBean" property="userId" value='<%= session.getAttribute("userid") %>'/>

<%-- Authentication --%>

<%-- Message --%>
<%@ include file="/WEB-INF/pages/component/message.jsp"%>

<!DOCTYPE HTML>
<html xmlns:jsp="http://java.sun.com/JSP/Page">

<title>Team 06 - Application</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<%@ include file="/WEB-INF/pages/component/layout/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/layout/sidebar.jsp"%>
<section style="background-color:rgb(234, 237, 241);min-height: 700px;margin-top: 45px;padding-bottom: 20px">

    <div id="main" style="margin-left: 50px">

        <!-- Overview -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
                <span style="font-size: 16px">Overview</span>
            </div>
            <div class="w3-row-padding" >
                <%-- Account Overview --%>
                <div class="w3-third">
                    <div class="w3-card" style="background-color:white;position:relative">

                        <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                            <span style="font-size: 20px">Account</span>
                        </header>

                        <div class="w3-row" style="height:100px">
                            <div class="w3-half w3-padding" style="border-right:1px dashed #dddddd">
                                <div class="" style="background-color: #F5F5F6;text-align: center;height: 80px;">
                                    <div class="w3-row w3-container w3-padding w3-left" style="color: #666">
                                        Balance
                                    </div>
                                    <div class="w3-row" style="text-align: center;vertical-align: middle">
                                        <span style="color:#9B9EA0;font-size:18px">
                                            <%= accountBean.getBalance() %>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="w3-half">
                                <div class="w3-row" style=";margin-top: 10px;margin-bottom: 5px;margin-right: 10px;margin-left: 10px;">
                                    <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan"
                                         style="background-color: #F5F5F6;height:35px;text-align: center;">
                                        <span style="vertical-align: middle;color: #666;">Charge</span>
                                        <span style="vertical-align: middle;color: #666;">3.45/hour</span>
                                    </div>
                                </div>

                                <div class="w3-row" style=";margin-top: 5px;margin-bottom: 10px;margin-right: 10px;margin-left: 10px;">
                                    <div class="w3-border w3-border-white w3-hover-white w3-hover-border-cyan" style="background-color: #F5F5F6;height:35px;text-align: center;">
                                        <span style="vertical-align: middle;color: #666;">Earn Peanut</span>
                                        <span style="vertical-align: middle;color: #666;">4.2/hour</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Database -->
        <div class="w3-container">

            <div class="w3-panel w3-leftbar w3-border-blue" style="height:27px">
                <span style="font-size: 16px">Database</span>
            </div>

            <div class="w3-row-padding">
                <div class="w3-card" style="background-color:white;margin-top:20px;margin-left:8px;margin-right:8px">

                    <header class="w3-container w3-padding" style="color: #333333;text-align: center;background-color: #f9f9f9">
                        <span style="font-size: 20px">Transaction</span>
                    </header>

                    <div style="">
                        <table class="w3-table w3-bordered">
                            <tr>
                                <th>Index</th>
                                <th>From User Name</th>
                                <th>To User Name</th>
                                <th>Type</th>
                                <th>Application</th>
                                <th>Amount</th>
                                <th>Time</th>
                            </tr>
                            <%
                                int i = 0;
                                List<Transaction> transactions = accountBean.getTransaction();
                                for (Transaction transaction: transactions) {
                            %>
                            <tr style="text-align: center">
                                <td><%= i++ %></td>
                                <td><%= transaction.getFromUserName() %></td>
                                <td><%= transaction.getToUserName() %></td>
                                <td><%= transaction.getType() %></td>
                                <td><%= transaction.getAppId() %></td>
                                <td><%= transaction.getAmount() %></td>
                                <td><%= transaction.getTime() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>
</html>