<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab 7
    Author: Heather Papp
    I wrote this code myself...
--%>
<%@ page import="hpapp.chattbank.Business.Customer" %>
<%@ page import="hpapp.chattbank.Business.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Display Account</title>
    </head>
    <body>

        <%

            Customer customer;
            customer = (Customer) session.getAttribute("c1");
            System.out.println("DisplayAccount.jsp retrieves attribute c1 from LoginServlet.jsp");
            customer.display();

            customer.accountList.displayList();

        %>

        <h1> Account List for: <%=customer.getFname() + " " + customer.getLname() %> </h1>
        <table>
            <tr>
                <th>Account No.</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>

            <%
                Account account = null;
                int c1 = customer.accountList.count;
                for (int i = 0; i < c1; i++) {
                    account = customer.accountList.accountArray[i];
            %>

            <tr>
                <td><input type="text" name="acctNoText" value="<%=account.getAcctNo()%>" /></td>
                <td><input type="text" name="acctTypeText" value="<%=account.getAcctType()%>" /></td>
                <td><input type="text" name="acctBalText" value="<%=account.getBalance()%>" /></td>
            </tr>

            <%
                }
            %>

        </table>

        <a href="UserInfo.jsp">

        </a>
    </body>
</html>
