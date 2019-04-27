<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 22/03/2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Cloud Base Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

    /* Create a Parallax Effect */
    .bgimg-1{
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }

    /* First image (Logo. Full height) */
    .bgimg-1 {
        background-image: url('/image/6.jpg');
        min-height: 100%;
    }

    .w3-wide {letter-spacing: 10px;}

    /* Turn off parallax scrolling for tablets and phones */
    @media only screen and (max-device-width: 1600px) {
        .bgimg-1 {
            background-attachment: scroll;
            min-height: 400px;
        }
    }
</style>
<body>
<div>
    <div class="w3-bar" id="myNavbar">
        <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);" onclick="toggleFunction()" title="Toggle Navigation Menu">
            <i class="fa fa-bars"></i>
        </a>
        <a href="/" class="w3-bar-item w3-button">HOME</a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
        <a href="/" class="w3-bar-item w3-button">HOME</a>
    </div>
</div>

<!-- First Parallax Image with Logo Text -->
<div class="bgimg-1 w3-display-container w3-opacity-min" id="home">
    <div class="w3-display-middle" style="white-space:nowrap;">
        <span class="w3-center w3-padding-large w3-black w3-xlarge w3-wide w3-animate-opacity">CLOUD <span class="w3-hide-small">WEBSITE</span> LOGIN</span>
    </div>
</div>

<div class="w3-container ">
    <h2 class="w3-center">Cloud Register and Login Modal</h2>
    <div class="w3-center">
        <button onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-black w3-large">Login</button>
    </div>

    <div id="id02" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-right" style="max-width:600px">

            <div class="w3-center"><br>
                <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">x</span>
                <img src="/image/avatar/avatar.jpg" alt="Avatar" style="width:30%;height:30%" class="w3-circle w3-margin-top">
            </div>

            <form class="w3-container" method="POST" name="login" action="j_security_check" enctype="application/x-www-form-urlencoded">
                <div class="w3-section">
                    <label><b>Username</b></label>
                    <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="j_username" required>
                    <label><b>Password</b></label>
                    <input class="w3-input w3-border" type="text" placeholder="Enter Password" name="j_password" required>
                    <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">Login</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    // Modal Image Gallery
    function onClick(element) {
        document.getElementById("img01").src = element.src;
        document.getElementById("modal01").style.display = "block";
        var captionText = document.getElementById("caption");
        captionText.innerHTML = element.alt;
    }

    // Used to toggle the menu on small screens when clicking on the menu button
    function toggleFunction() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>
</body>

</html>



