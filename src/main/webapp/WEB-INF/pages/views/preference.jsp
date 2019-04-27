<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 28/04/2019
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Java Bean --%>
<jsp:useBean id="preferenceBean" scope="page" class="team06.platform.web.bean.PreferenceBean" />
<% preferenceBean.getInfo(request); %>

<html>
<title>Team 06 - Admin</title>
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
            <form class="w3-container" action="/change?type=password" method="post" style="padding-top: 20px">
                <label><b>Please Enter Your Old Password.</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Old Password" name="psw0" required>
                <label><b>Please Enter Your New Password</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Password" name="psw1" required>
                <label><b>Please Enter Your New Password Again</b></label>
                <input class="w3-input w3-border" type="text" placeholder="Enter New Password Again" name="psw2" required>
                <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
            </form>
        <div class="w3-section w3-bottombar w3-padding-16"></div>
            <form class="w3-container" action="/change?type=email" method="post" style="padding-top: 20px">
                <div class="w3-section">
                    <label><b>Please Enter Your Password</b></label>
                    <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Password" name="psw" required>
                    <label><b>Please Enter Your New Email. Your Old Email: </b><%= preferenceBean.getUser().getEmail() %></label>
                    <input class="w3-input w3-border" type="text" placeholder="Enter New Email" name="email" required>
                    <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
                </div>
            </form>
        <div class="w3-section w3-bottombar w3-padding-16"></div>
            <form class="w3-container" action="/change?type=avatar" enctype="multipart/form-data" method="post"style="padding-top: 20px">
                <div class="w3-section">
                    <label><b>Please Enter Your Password</b></label>
                    <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Password" name="psw" required>
                    <label><b>Please Upload Your New Avatar. Your Old Avatar: </b><%= preferenceBean.getUser().getAvatar() %></label>
                    <input class="w3-input w3-border w3-margin-bottom" type="file" name="avatar">
                    <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Change</button>
                </div>
            </form>
    </div>

</section>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>
</html>
