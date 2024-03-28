package website.wesports.Servlets;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Customer Update Servlet
 * Authors: Heather Papp
 *
 *
 *
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import website.wesports.Business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 *   Customer Update Servlet
 * @author Heather Papp
 */

@WebServlet(name = "CustomerUpdateServlet", urlPatterns = "/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {

    private static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public void init() throws ServletException {}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            Customer c1 = new Customer();
            //get values from form and assign to local variables
            String firstName = request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            String street = request.getParameter("Street");
            String city = request.getParameter("City");
            String state = request.getParameter("State");
            String zip = request.getParameter("Zip");
            String newPassword = request.getParameter("NewPassword");
            String confirmNewPassword = request.getParameter("ConfirmNewPassword");
            System.out.println("Form Data: " + firstName + lastName + "\n" + street + "\n" + city + ", " + state + " " + zip);

            try {

                String currentPassword = request.getParameter(c1.getCustPassword());
                if (!currentPassword.equals(newPassword)) {
                    if (newPassword.equals(confirmNewPassword)) {
                        c1.setCustPassword(newPassword);
                        c1.updateCustomer();
                    }
                }

                if (!c1.getCustFirstName().equals(firstName)) {
                    c1.setCustFirstName(firstName);
                }





            }
            catch(Exception e) {
                System.out.println(e);
            }

            //add customer c1 to session
            HttpSession session;
            session = request.getSession();
            session.setAttribute("c1", c1);

            //forward control back to Display Cart
            RequestDispatcher rd = request.getRequestDispatcher("/customer/CustomerProfile.jsp");
            rd.forward(request, response);
        }
    }

    public void destroy() {}


}
