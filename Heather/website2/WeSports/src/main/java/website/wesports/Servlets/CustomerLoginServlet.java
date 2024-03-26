package website.wesports.Servlets;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Customer Login Servlet
 * Authors: Heather Papp
 *
 *
 *
 */

import website.wesports.Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *   Servlet for Customer Login Page
 * @author Heather Papp
 */

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    private String message;
    private static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public void init() throws ServletException {
        message = "Valid Login";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String emailTextbox, passwordTextbox;
        emailTextbox = request.getParameter("Email"); //Email form textbox
        passwordTextbox = request.getParameter("Password"); //CustPassword form textbox
        System.out.println("Username: " + emailTextbox + "\nCustomerPassword: " + passwordTextbox + "\n");

        Customer c1 = new Customer();
        c1.selectDB(emailTextbox);

        String unDB = c1.getCustEmail();
        String pwDB = c1.getCustPassword();
        System.out.println("DBID: " + unDB + "\nDBPW: " + pwDB );

        HttpSession ses1 = request.getSession();
        ses1.setAttribute("c1", c1);

        String url;
        RequestDispatcher rdObj;

        if (pwDB.equals(passwordTextbox)) {
            // Successful login forward to DisplayAccount.jsp CHANGE THIS
            url = "/CustomerProfile.html";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);

        } else {
            // Failed login forward to ErrorPage.jsp
            url = "/ErrorPage.jsp";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);
        }





    }

    public void destroy() {}

}