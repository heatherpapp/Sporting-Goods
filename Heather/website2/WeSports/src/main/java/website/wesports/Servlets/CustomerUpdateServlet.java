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

        HttpSession session = request.getSession();
        Customer c1 = (Customer) session.getAttribute("c1");
        
        try (PrintWriter out = response.getWriter()) {

            //get values from form and assign to local variables
            String firstName = request.getParameter("updateFirstName");
            String lastName = request.getParameter("updateLastName");
            String street = request.getParameter("updateStreet");
            String city = request.getParameter("updateCity");
            String state = request.getParameter("updateState");
            String zip = request.getParameter("updateZip");
            String newPassword = request.getParameter("updateNewPassword");
            String confirmNewPassword = request.getParameter("updateConfirmNewPassword");
            System.out.println("Form Data: " + firstName + " " + lastName + "\n" + street + "\n" + city + ", " + state + " " + zip);

            try {

                if (!c1.getCustPassword().equals(newPassword)) {
                    if (newPassword.equals(confirmNewPassword)) {
                        c1.setCustPassword(newPassword);
                        c1.updateCustomer();
                    }
                }

                if (!c1.getCustFirstName().equals(firstName)) {
                    c1.setCustFirstName(firstName);
                    c1.updateCustomer();
                }

                if (!c1.getCustLastName().equals(lastName)) {
                    c1.setCustLastName(lastName);
                    c1.updateCustomer();
                }

                if (!c1.getCustStreet().equals(street)) {
                    c1.setCustStreet(street);
                    c1.updateCustomer();
                }

                if (!c1.getCustCity().equals(city)) {
                    c1.setCustCity(city);
                    c1.updateCustomer();
                }

                if (!c1.getCustState().equals(state)) {
                    c1.setCustState(state);
                    c1.updateCustomer();
                }

                if (!c1.getCustZip().equals(zip)) {
                    c1.setCustZip(zip);
                    c1.updateCustomer();
                }

            }
            catch(Exception e) {
                System.out.println(e);
            }

            //add customer c1 to session
            HttpSession session2 = request.getSession();
            session2.setAttribute("c1", c1);

            //forward control back to Display Cart
            RequestDispatcher rd = request.getRequestDispatcher("/customer/CustomerProfile.jsp");
            rd.forward(request, response);
        }
    }

    public void destroy() {}


}
