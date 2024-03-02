<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab 2
    Author: Heather Papp
    I wrote this code myself...
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="resources/css/stylesheet.css">

    <script type="text/javascript">

        //function to validate customerID input
        function validateUserID() {
            var a;
            a = document.UserLoginForm.customerID.value;

            /* allow admin ***** enabling this breaks the if statements to check ID
            apw = document.UserLoginForm.password.value;
            if (a === "admin" && apw === "123") {
                <form action="LoginServlet" method="post"></form>
            }
            ******/

            if (a < 3000 || a > 3999 || isNaN(a) || a < 0 || a === "") {
                alert("CustomerID is a number between 3000-3999");
                document.UserLoginForm.customerID.focus();
                document.UserLoginForm.customerID.value = "";
            }
        } //End validateUserID()

    </script>

</head>
<body>
<div style="text-align: center;">
    <h1><%= "Welcome to Chatt Bank!" %></h1>
    <h2><%= "Please enter your CustomerID and password below."%></h2>
    <form name="UserLoginForm" action="LoginServlet" method="post">
        Customer ID <input autofocus name="customerID" id="customerID" type="text" onblur="validateUserID()" required />
        <br/>
        Password <input name="password" id="password" type="password" required/>
        <br/>
        <input type="submit" name="Submit" value="Login" />
        <input type="reset" name="Reset" value="Clear" />
    </form>
    <br/>
    <%-- link to index.jsp --%>
    <a href="index.jsp">Chatt Bank Home</a>
</div>
</body>
</html>
