<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 05/04/2019
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Team 06 - Guide</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<%@ include file="/WEB-INF/pages/component/layout/navigation.jsp"%>

<%@ include file="/WEB-INF/pages/component/layout/sidebar.jsp"%>
<section style="background-color:rgb(234, 237, 241);min-height: 700px;margin-top: 45px;padding-bottom: 20px">

    <div id="main" style="margin-left: 50px">
        <div class="w3-container">
            <div class="w3-row-padding" >

                <%-- Memory --%>
                <div class="w3-quarter">
                    <div class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Content</span>
                    </div>
                    <div class="w3-left" style="">
                        <ul>
                            <li><a class="w3-hover-text-blue" href="#introduction">Introduction</a></li>
                            <ul>
                                <li><a class="w3-hover-text-blue" href="#intro-app">How to Use Application</a></li>
                                <li>
                                    <a class="w3-hover-text-blue" href="#intro-charge">How about the Charge and Payment</a>
                                    <ul>
                                        <li><a class="w3-hover-text-blue" href="#intro-charge-charge">Charge</a></li>
                                        <li><a class="w3-hover-text-blue" href="#intro-charge-payment">Payment</a></li>
                                    </ul>
                                </li>
                                <li><a class="w3-hover-text-blue" href="#intro-app">How about the transaction history</a></li>
                            </ul>
                            <li><a class="w3-hover-text-blue" href="#guest">As Guest</a></li>
                            <li><a class="w3-hover-text-blue" href="#user">As User</a></li>
                            <ul>
                                <li><a class="w3-hover-text-blue" href="#user-app">How to Use Application</a></li>
                                <li><a class="w3-hover-text-blue" href="#user-charge">How about the Charge</a></li>
                                <li><a class="w3-hover-text-blue" href="#user-developer">How to Become a Developer</a></li>
                                <li><a class="w3-hover-text-blue" href="#user-personal">How to Change Personal Information</a></li>
                            </ul>
                            <li><a class="w3-hover-text-blue" href="#developer">As Developer</a></li>
                            <ul>
                                <li><a class="w3-hover-text-blue" href="#developer-database">How to Use Database</a></li>
                                <li><a class="w3-hover-text-blue" href="#developer-create">How to Create Application</a></li>
                                <li><a class="w3-hover-text-blue" href="#developer-status">How about the Application Status</a></li>
                                <li><a class="w3-hover-text-blue" href="#developer-charge">How about the Charge</a></li>
                                <li><a class="w3-hover-text-blue" href="#developer-personal">How to Change Personal Information</a></li>
                                <li><a class="w3-hover-text-blue" href="#developer-metadata">How to Change Application's Meta-data</a></li>
                            </ul>

                            <li><a class="w3-hover-text-blue" href="#admin">As Admin</a></li>
                            <ul>
                                <li>How to Manager Application</li>
                                <li>How to Manager Database</li>
                            </ul>

                            <li><a class="w3-hover-text-blue" href="#reference">Reference</a></li>
                            <ul>
                                <li>
                                    <a class="w3-hover-text-blue" href="#reference-api">How to Send an API Request</a>
                                    <ul>
                                        <li><a class="w3-hover-text-blue" href="#reference-api-get">GET Request</a></li>
                                        <li><a class="w3-hover-text-blue" href="#reference-api-post">POST Request</a></li>
                                    </ul>
                                </li>
                                <li><a class="w3-hover-text-blue" href="reference-transaction">Transaction Type</a></li>
                                <li><a class="w3-hover-text-blue" href="#reference-authority">Authority List</a></li>
                            </ul>
                        </ul>
                    </div>
                </div>

                <div class="w3-threequarter">
                    <%-- Platform Introduction --%>
                    <div id="introduction" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Platform Introduction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <h2>
                                Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                            </h2>
                            <p>
                                We provide login service and bank service.
                            </p>

                            <hr size="20" />
                            <h3 id="intro-app">How to Use Application</h3>
                            <p>
                                Each application can only be visited after logon. For more information, please refer to
                                <a class="w3-text-blue w3-hover-text-green" href="#user">User Instruction</a> - <a class="w3-text-blue w3-hover-text-green" href="#user-app">How to Use Application</a>.
                            </p>

                            <hr size="20" />
                            <h3 id="intro-charge">How about the Charge and Payment</h3>
                            <p>
                            <h4 id="intro-charge-charge">Charge</h4>
                            Within the normal charge standard, a visit of an application will charge <b>5 peanuts</b>.
                            <ul>
                                <li><b>3 peanuts</b> will be credited to application's developer</li>
                                <li><b>1 peanut</b> will be credited to sign-in micro-service's provider</li>
                                <li><b>1 peanut</b> will be credited to charging and payment micro-service's provider</li>
                            </ul>
                            <span style="color: red">Notice:</span> It won't charge again within the session.
                            <b>i.e.</b> Once the user log in, the visit of an application will charge only one time.
                            <b>Moreover</b>, if the user logout and login again, the visit of an application will charge again.
                            </p>

                            <p>
                            <h4 id="intro-charge-payment">Payment</h4>
                            The consumption within a application will link to the platform account.
                            The application's developers are responsible for transferring the consumption within their application.
                            </p>
                        </div>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">

                        </div>
                    </div>

                    <%-- As Guest --%>
                    <br/>
                    <div id="guest" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Guest Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <p>
                                A guest can look through all application
                            </p>
                        </div>
                    </div>

                    <%-- As User --%>
                    <br/>
                    <div id="user" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">User Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <h3 id="user-app">How to Use Application</h3>
                            <p>
                                Each application can only be visited after logon.
                            </p>

                            <hr size="20" />
                            <h3 id="user-charge">How about the Charge</h3>
                            <p>
                                Within the normal charge standard, a visit of an application will charge <b>5 peanuts</b>.
                            <ul>
                                <li><b>3 peanuts</b> will be credited to application's developer</li>
                                <li><b>1 peanut</b> will be credited to sign-in micro-service's provider</li>
                                <li><b>1 peanut</b> will be credited to charging and payment micro-service's provider</li>
                            </ul>
                            <span style="color: red">Notice:</span> It won't charge again within the session.
                            <b>i.e.</b> Once the user log in, the visit of an application will charge only one time.
                            <b>Moreover</b>, if the user logout and login again, the visit of an application will charge again.
                            </p>

                            <hr size="20" />
                            <h3 id="user-developer">How to Become a Developer</h3>
                            <p>
                                In order to save place in database, we don't created the personal database, database username and database password for user.
                                There will be a button at <a class="w3-text-blue w3-hover-text-green" href="/console">console page</a>. After click it and confim, a user can become a developer.
                            </p>

                            <hr size="20" />
                            <h3 id="user-personal">How to Change Personal Information</h3>
                            <p>
                                The users can change their personal infomation(password, email, avatar) at <a class="w3-text-blue w3-hover-text-green" href="/console">console page</a>.
                            </p>
                        </div>
                    </div>

                    <%-- As Developer --%>
                    <br/>
                    <div id="developer" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Developer Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <h3 id="developer-database">How to Use Database</h3>
                            <p>
                                We will create the <b>database</b>, <b>database username</b> and <b>database password</b> at the first login.
                                You can get your <b>database name</b>, <b>username</b> and <b>password</b> at the <i>application page</i>.
                            </p>
                            <p>
                                If you need to access database within your application, please remember to <b>alter</b> your database configurations.
                            </p>

                            <hr size="20" />
                            <h3 id="developer-create">How to Create Application</h3>
                            <p>
                                You can upload your application at the <i>application page</i>.
                                <br/><span style="color: red">Notice:</span> Your must pack your application into <b>war</b> file before uploading.
                                For now, we cannot process <b>jar</b> file.
                            </p>
                            <p>
                                After uploading your war file of application, your application will appear at the <i>home page</i>, <i>console page</i> and <i>application page</i>.
                            </p>

                            <hr size="20" />
                            <h3 id="developer-status">How about the Application Stauts</h3>
                            <p>
                                There are three status:
                            <ul>
                                <li><span class="w3-text-green">running</span></li>
                                <ul>
                                    <li>This application's status is running and can be visited by URL</li>
                                </ul>
                                <li><span class="w3-text-red">stop</span></li>
                                <ul>
                                    <li>This application has URL, but it is unvisitable</li>
                                    <li>This application can start anytime.</li>
                                </ul>
                                <li><span class="w3-text-amber">undeploy</span></li>
                                <ul>
                                    <li>This application's status is undeploy.</li>
                                    <li>All files of this application have been deleted <b>except database and war file</b>.</li>
                                    <li>This application can deploy anytime.</li>
                                </ul>
                            </ul>
                            </p>

                            <hr size="20" />
                            <h3 id="developer-charge">How about the Charge</h3>
                            <p>
                                Within the normal charge standard, a visit of an application will charge <b>5 peanuts</b>.
                            <ul>
                                <li><b>3 peanuts</b> will be credited to application's developer</li>
                                <li><b>1 peanut</b> will be credited to sign-in micro-service's provider</li>
                                <li><b>1 peanut</b> will be credited to charging and payment micro-service's provider</li>
                            </ul>
                            <span style="color: red">Notice:</span> It won't charge again within the session.
                            <b>i.e.</b> Once the user log in, the visit of an application will charge only one time.
                            <b>Moreover</b>, if the user logout and login again, the visit of an application will charge again.
                            </p>

                            <hr size="20" />
                            <h3 id="developer-personal">How to Change Personal Information</h3>
                            <p>
                                The developers can change their personal infomation(password, email, avatar) at <a class="w3-text-blue w3-hover-text-green" href="/console">console page</a>.
                            </p>

                            <hr size="20" />
                            <h3 id="developer-metadata">How to Change Application's Meta-data</h3>
                            <p>
                                The developers can change their application's meta-data(name, icon, description) at <a class="w3-text-blue w3-hover-text-green" href="/application">application</a> - detail page.
                            </p>
                        </div>
                    </div>

                    <%-- As Admin --%>
                    <br/>
                    <div id="admin" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Admin Instruction</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <p>
                                Welcome to team 06 platform. Our platform is on top of an existing Infrastructure-as-a-Service (Iaas).
                            </p>
                            <p>
                                We provide login service and bank service.
                            </p>
                        </div>
                    </div>

                    <%-- Reference --%>
                    <br/>
                    <div id="reference" class="w3-panel w3-leftbar w3-border-blue">
                        <span style="font-size: 16px">Reference</span>
                    </div>
                    <div class="w3-card" style="background-color:white">
                        <div class="w3-container">
                            <h3 id="reference-api">How to Send an API Request</h3>
                            <p>
                                We provide kinds of API for retrieving infomation.
                                Here is a demo code about how to send request to our API and retrieve data.
                            </p>
                            <p>
                            <h5 id="reference-api-get">GET Request</h5>
                            <div class="w3-code javaHigh notranslate" >
                                /**<br/>
                                * send a get request to a URL and receive response data<br/>
                                * @return the request result<br/>
                                */<br/>
                                public static String sendGetRequest() {<br/>
                                &nbsp;&nbsp;/* Initial Parameter */<br/>
                                &nbsp;&nbsp;String urlParam ="http://localhost:9527/api/account/balance/345897325";<br/>
                                &nbsp;&nbsp;URLConnection con = null;<br/>
                                &nbsp;&nbsp;BufferedReader buffer = null;<br/>
                                &nbsp;&nbsp;StringBuffer resultBuffer = null;<br/>
                                <br/>
                                &nbsp;&nbsp;try {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Open Connection */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;URL url = new URL(urlParam);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con = url.openConnection();<br/>
                                <br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Set Request Parameter */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setRequestProperty("Content-Type", "text/plain;charset=GBK");<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setDoOutput(true);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setDoInput(true);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setUseCaches(false);<br/>
                                <br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Receive Response Stream */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;InputStream inputStream = con.getInputStream();<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;resultBuffer = new StringBuffer(); // convert stream into string<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;String line;<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;while ((line = buffer.readLine()) != null) {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;resultBuffer.append(line);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;return resultBuffer.toString(); // return request result as successful<br/>

                                &nbsp;&nbsp;}catch(Exception e) {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();<br/>
                                &nbsp;&nbsp;}<br/>

                                &nbsp;&nbsp;return ""; // return request result as failed<br/>
                                }<br/>
                                <br/>
                            </div>
                            </p>
                            <p>
                            <h5 id="reference-api-post">POST Request</h5>
                            <div class="w3-code javaHigh notranslate">
                                /**<br/>
                                * send a post request to a URL and receive response data<br/>
                                * @return the request result<br/>
                                */<br/>
                                public static String sendPostRequest() {<br/>
                                &nbsp;&nbsp;/* Initial Parameter */<br/>
                                &nbsp;&nbsp;String urlParam ="http://localhost:9527/api/account/balance/345897325";<br/>
                                &nbsp;&nbsp;URLConnection con = null;<br/>
                                &nbsp;&nbsp;PrintWriter out = null;<br/>
                                &nbsp;&nbsp;BufferedReader buffer = null;<br/>
                                &nbsp;&nbsp;StringBuffer resultBuffer = null;<br/>
                                <br/>
                                &nbsp;&nbsp;try {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Open Connection */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;URL url = new URL(urlParam);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con = url.openConnection();<br/>
                                <br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Set Request Parameter */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setRequestProperty("accept", "*/*");<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;// IMPORTANT<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setDoOutput(true);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setDoInput(true);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;con.setUseCaches(false);<br/>
                                <br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Write Request Data */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;// get output stream of URLConnection<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;out = new PrintWriter(con.getOutputStream());<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;// send post data<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;out.print("fromUserId=345897325&toUserId=392849790&amount=5&appId=0");<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;// flush<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;out.flush();<br/>
                                <br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;/* Receive Response Stream */<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;InputStream inputStream = con.getInputStream();<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;resultBuffer = new StringBuffer(); // convert stream into string<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;String line;<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;while ((line = buffer.readLine()) != null) {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;resultBuffer.append(line);<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;return resultBuffer.toString(); // return request result as successful<br/>

                                &nbsp;&nbsp;}catch(Exception e) {<br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();<br/>
                                &nbsp;&nbsp;}<br/>

                                &nbsp;&nbsp;return ""; // return request result as failed<br/>
                                }<br/>
                            </div>
                            </p>

                            <hr size="20" />
                            <h3 id="reference-transaction">Transaction Type</h3>
                            <p>
                                There are two transaction types showed in transaction history at <a class="w3-text-blue w3-hover-text-green" href="/account">account page</a>.
                            <ul>
                                <li><b>Royalties:</b> the charge of visiting a application</li>
                                <li><b>Application:</b> Consumption: the consumption within a application</li>
                            </ul>
                            </p>

                            <hr size="20" />
                            <h3 id="reference-authority">Authority List</h3>
                            <table class="w3-table w3-hoverable w3-centered w3-striped w3-bordered">
                                <tr class="w3-black">
                                    <th>Web Page</th>
                                    <th>Guest</th>
                                    <th>User</th>
                                    <th>Developer</th>
                                    <th>Admin</th>
                                </tr>
                                <tr>
                                    <td>Home</td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Guide</td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Console</td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Account</td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Preference</td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Application</td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Application Detail</td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">check</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                                <tr>
                                    <td>Admin</td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">close</i></td>
                                    <td><i class="material-icons">check</i></td>
                                </tr>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>


<script src="https://www.w3schools.com/lib/w3codecolor.js"></script>

<script>
    w3CodeColor();
</script>
<%@ include file="/WEB-INF/pages/component/layout/footer.jsp"%>

<style>
    a {
        text-decoration:none
    }
</style>
</html>

