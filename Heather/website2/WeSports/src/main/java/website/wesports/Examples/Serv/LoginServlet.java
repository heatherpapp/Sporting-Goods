package website.wesports.Examples.Serv;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab 3
 * Author: Heather Papp
 */

import hpapp.chattbank.Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private String message;
    private static final String DBLocation = "jdbc:ucanaccess://C:/Users/heath/OneDrive/Documents/Business/Chatt Tech/JAVA/databaseFiles/ChattBankACCDB.accdb/";
    private static final String Driver = "net.ucanaccess.jdbc.UcanaccessDriver";

    public void init() throws ServletException {
        message = "Valid Login";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        /*
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>LoginServlet is running...</h1>");
        out.println("</body>");
        out.println("</html>");
         */

        String id, pw;
        id = request.getParameter("customerID"); //CustID form textbox
        pw = request.getParameter("password"); //CustPassword form textbox
        System.out.println("CustomerID: " + id + "\nCustomerPassword: " + pw + "\n");

        Customer c1 = new Customer();
        c1.selectDB(id);

        String idDB = c1.getCustID();
        String pwDB = c1.getCustPW();
        System.out.println("DBID: " + idDB + "\nDBPW: " + pwDB );

        HttpSession ses1 = request.getSession();
        ses1.setAttribute("c1", c1);

        String url;
        RequestDispatcher rdObj;

        if (pwDB.equals(pw)) {
            // Successful login forward to DisplayAccount.jsp
            out.println("<h1>Account Login Successful!\nRedirecting....</h1>");
            url = "/DisplayAccount.jsp";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);

        } else {
            // Failed login forward to ErrorPage.jsp
            out.println("<h1>Account Login Failed!\nRedirecting....</h1>");
            url = "/ErrorPage.jsp";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);
        }





    }

    public void destroy() {}

}