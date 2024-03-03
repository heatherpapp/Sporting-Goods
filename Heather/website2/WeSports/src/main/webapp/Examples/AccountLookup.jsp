<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab 6
    Author: Heather Papp
    I wrote this code myself...
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Account Lookup</title>
        <link rel="stylesheet" href="resources/css/stylesheet.css">
    </head>
    <body>
        <form name="AccountLookupForm" action="/account-lookup-servlet" method="post">
            <table class="center">
                <caption>Account Lookup</caption>
                <tr>
                    <td>Acct No:</td> <td> <input name="acctNo" id="acctNo" type="text"></td>
                </tr>
                <tr>
                    <td>CustID:</td> <td><input name="custID" id="custID" type="text"></td>
                </tr>
                <tr>
                    <td>Type:</td> <td> <input name="acctType" id="acctType" type="text"></td>
                </tr>
                <tr>
                    <td>Balance:</td> <td> <input name="balance" id="balance" type="text"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submitLookup" value="Retrieve">
                        <input type="reset" name="resetLookup" value="Clear">
                    </td>
                </tr>
            </table>
        </form>
        <div style="text-align: center">
            <br/>
            <%-- link to logout --%>
            <a href="logout.jsp">Logout</a>
            <%-- link to index.jsp --%>
            <a href="index.jsp">Chatt Bank Home</a>
        </div>
    </body>
</html>
