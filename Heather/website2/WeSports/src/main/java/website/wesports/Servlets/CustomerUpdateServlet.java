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

        PrintWriter out = response.getWriter();

        //declare local variables
        String firstName, lastName, street, city, state, zip, newPassword, confirmNewPassword;

        //get values from form and assign to local variables
        firstName = request.getParameter("FirstName");
        lastName = request.getParameter("LastName");
        street = request.getParameter("Street");
        city = request.getParameter("City");
        state = request.getParameter("State");
        zip = request.getParameter("Zip");
        newPassword = request.getParameter("NewPassword");
        confirmNewPassword = request.getParameter("ConfirmNewPassword");

        HttpSession session = request.getSession();
        Customer c1 = (Customer) session.getAttribute("c1");

        c1.setCustFirstName(firstName);
        c1.setCustLastName(lastName);
        c1.setCustStreet(street);
        c1.setCustCity(city);
        c1.setCustState(state);
        c1.setCustZip(zip);

        String currentPassword = c1.getCustPassword();

        if (currentPassword != newPassword) {
            if (newPassword.equals(confirmNewPassword)) {
                c1.setCustPassword(newPassword);
            }
        }

        c1.updateDB(c1.getCustEmail());





    }

    public void destroy() {}


}
