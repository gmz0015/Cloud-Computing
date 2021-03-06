<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Cloud Base Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

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
  background-image: url('/image/111.jpg');
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
<div id="id01" class="w3-modal" style="padding-top: 10px">
  <div class="w3-modal-content w3-card-4 w3-animate-left" style="max-width:1000px">

    <div class="w3-center"><br>
      <span
              onclick="document.getElementById('id01').style.display='none'"
              class="w3-button w3-xlarge w3-transparent w3-display-topright"
              title="Close Modal">×</span>
      <h3>Welcome to Cloud Platform Registration page!</h3>
    </div>

    <form class="w3-container" action="${pageContext.request.contextPath}/login/register" enctype="multipart/form-data" method="post" name="form1">
      <input type="hidden" name="Referer" value=<%= request.getAttribute("Referer") %>>
      <div class="w3-row-padding">
        <div class="w3-half" style="border-right:1px dashed #dddddd">
          <h5>Notice:</h5>
          <ul>
            When you join us, you will receive <b>1000</b> peanuts as initial fund.
          </ul>

          <h5>User</h5>
          <ul>
            <li>The normal charge standard for using application is 5 peanuts. 3 for developer, 2 for service provider. (i.e. You will only need to <b>pay once for an application</b> within session lifecycle.) </li>
            <li>You can choose to become a developer any time.</li>
            <li><i class="fas fa-star" style="color: red"></i> Please look through <a class="w3-hover-text-blue" href="/guide#user-beforeUse" style="color: red">Before Use</a> in guide page.</li>
          </ul>

          <h5>Developer</h5>
          <ul>
            <li>For each visit, You can receive <b>3 peanuts</b> under normal charge standard.</li>
            <li>You will be <b>allocated a database</b> and you can view it under <b>application page</b>.
              Please remember to <span style="color: red">alter</span> your <b>database configurations</b>.</li>
            <li><i class="fas fa-star" style="color: red"></i> Please look through <a class="w3-hover-text-blue" href="/guide#developer-beforeUpload" style="color: red">Before Upload</a> in guide page.</li>
          </ul>

          <h6>For more information, please visit our <a class="w3-hover-text-blue" href="/guide"><b>guide page</b></a></h6>
        </div>
        <div class="w3-half">
          <div class="w3-section">
            <label><b>Username</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="username" required>
            <label><b>New Password</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Your New Password" name="psw" required>
            <label><b>New Password Again</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Your New Password Again" name="psw2" required>
            <label><b>Email</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Email Address" name="email" required>
            <label><b>Upload a custom avatar</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="file" name="avatar">
            <label><b>Become a</b></label>
            <div class="w3-row">
              <div class="w3-half"><input type="radio" checked="checked" name="role" value="USER" /><span style="padding-left:10px">User</span></div>
              <div class="w3-half"><input type="radio" name="role" value="DEVELOPER" /><span style="padding-left:10px">Developer</span></div>
            </div>
            <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">Register</button>
          </div>
        </div>
      </div>

    </form>

    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
      <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-black">Cancel</button>
      <!-- <span class="w3-right w3-padding w3-hide-small"><a href="#">Upload a custom avatar?</a></span> -->
    </div>

  </div>
</div>

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
		<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black w3-large">Register</button>
		<button onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-black w3-large">Login</button>
	</div>




  <div id="id02" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-right" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">x</span>
        <img src="/image/defaultAvatar.jpg" alt="Avatar" style="width:30%;height:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" action="${pageContext.request.contextPath}/login/login" method="post" name="form1">
        <input type="hidden" name="Referer" value=<%= request.getAttribute("Referer") %>>
        <div class="w3-section">
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="username" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="psw" required>
          <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" name="remember" value ="remember me" type="checkbox" checked="checked"> Remember me
        </div>
      </form>

    </div>
  </div>
</div>
<div class="w3-black w3-center w3-padding-24" style="margin-top:80px">
  <h6>Develop by Team 06</h6>
  <h6>111.jpg - <a href="https://www.w3schools.com/about/about_copyright.asp" class="w3-hover-text-green">Copyright 1999-2019</a> by Refsnes Data.</h6>
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


