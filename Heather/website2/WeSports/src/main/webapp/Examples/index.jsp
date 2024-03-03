<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab 2
    Author: Heather Papp
    I wrote this code myself...
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Welcome to Chatt Bank</title>
        <link rel="stylesheet" href="resources/css/stylesheet.css">
    </head>
    <body>
        <div style="text-align: center;">
            <h1><%= "Welcome to Chatt Bank" %></h1>
            <img src="resources/img/genericbanklogo_small.jpg" />
            <br/>
            <a href="login.jsp">Login</a>
            <%-- temp link to logout.jsp --%>
            <a href="logout.jsp">Logout</a>
            <%-- temp link to AccountLookup.jsp --%>
            <a href="AccountLookup.jsp">Account Lookup</a>
            <%-- temp link to ErrorPage --%>
            <a href="ErrorPage.jsp">Error Page</a>

        </div>
    </body>
</html>