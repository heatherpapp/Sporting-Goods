package website.wesports.Examples.Serv;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab ###
 * Author: Heather Papp
 * I wrote this code myself...
 */

import hpapp.chattbank.Business.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet public class AccountLookupServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter pwOut = response.getWriter();

        String acctNoForm;
        acctNoForm = request.getParameter("acctNo");

        System.out.println("Input Acct #: " + acctNoForm);

        Account a1 = new Account();
        a1.selectADB(acctNoForm);
        a1.displayADB();

        HttpSession ses1 = request.getSession();
        ses1.setAttribute("a1", a1);

        RequestDispatcher rd = request.getRequestDispatcher("DisplayAccount.jsp");
        rd.forward(request, response);
    }
}
