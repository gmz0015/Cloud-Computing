<%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 22/03/2019
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="w3-card-4 w3-margin">

    <header class="w3-container w3-blue" >
        <h3><b><i class="fab fa-playstation"></i> Playground</b></h3>
    </header>

    <%--<jsp:useBean id="userBean" scope="session" class="javabean.UserControllerController" />--%>
    <%--<jsp:setProperty name="userBean" property="*" />--%>
    <form type="post" action="account.jsp">
                    <span><br />Please enter item to add or remove:
                        <br />Add Item:</span>
        <select name="userNameList">
            <%@ page import="java.util.Map" %>
            <%@ page import="java.util.Iterator" %>
            <%
                Map<String, String> usersName = userBean.getUsersName();
                Iterator<Map.Entry<String, String>> usersNameIterator = usersName.entrySet().iterator();
                while (usersNameIterator.hasNext()) {
                    Map.Entry<String, String> userName = usersNameIterator.next();
            %>
            <option value =<%= userName.getKey() %>> <%= userName.getValue() %> </option>
            <% } %>
        </select>
        <br /><br />
        <input type="submit" name="submit" value="switch User" />
    </form>
</div>
</html>
