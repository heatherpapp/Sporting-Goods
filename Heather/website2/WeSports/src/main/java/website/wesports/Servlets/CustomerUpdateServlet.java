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

    public void init() throws ServletException {}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Customer c1 = (Customer) session.getAttribute("c1");
        try (PrintWriter out = response.getWriter()) {
            //get values from form and assign to local variables
            String email = request.getParameter("custEmail");
            String firstName = request.getParameter("updateFirstName");
            String lastName = request.getParameter("updateLastName");
            String street = request.getParameter("updateStreet");
            String city = request.getParameter("updateCity");
            String state = request.getParameter("updateState");
            String zip = request.getParameter("updateZip");
            String newPassword = request.getParameter("updateNewPassword");
            String confirmNewPassword = request.getParameter("updateConfirmNewPassword");
            System.out.println("Form Data: " + firstName + " " + lastName + "\n" + street + "\n" + city + ", " + state + " " + zip + "\n" + email);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/");
            Statement stmt = conn.createStatement();
            if (!c1.getCustPassword().equals(newPassword)) {
                String setNewPW;
                if (newPassword.equals(confirmNewPassword)) {
                    setNewPW = newPassword;
                    try {
                        String sql = "UPDATE Customer SET CustFirstName = '" + firstName + "',"
                                + "CustLastName = '" + lastName + "',"
                                + "CustStreet = '" + street + "',"
                                + "CustCity = '" + city + "',"
                                + "CustState = '" + state + "',"
                                + "CustZip = '" + zip + "',"
                                + "CustPassword = '" + setNewPW + "'"
                                + "WHERE CustEmail = '" + email + "'";
                        System.out.println(sql);
                        int n1 = stmt.executeUpdate(sql);
                        if (n1 == 1) {
                            System.out.println("Customer updated!");
                        } else {
                            System.out.println("!!!!!!!!!!!INSERT FAILED!!!!!!!!!!!!!");
                        }
                        conn.close();
                        String CustEmail = c1.getCustEmail();
                        c1.selectDB(CustEmail);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                try {
                    String sql = "UPDATE Customer SET CustFirstName = '" + firstName + "',"
                            + "CustLastName = '" + lastName + "',"
                            + "CustStreet = '" + street + "',"
                            + "CustCity = '" + city + "',"
                            + "CustState = '" + state + "',"
                            + "CustZip = '" + zip + "',"
                            + "CustPassword = '" + c1.getCustPassword() + "'"
                            + "WHERE CustEmail = '" + email + "'";
                    System.out.println(sql);
                    int n1 = stmt.executeUpdate(sql);
                    if (n1 == 1) {
                        System.out.println("Customer updated!");
                    } else {
                        System.out.println("!!!!!!!!!!!INSERT FAILED!!!!!!!!!!!!!");
                    }
                    conn.close();
                    String CustEmail = c1.getCustEmail();
                    c1.selectDB(CustEmail);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            c1.selectDB(email);
            session.setAttribute("c1", c1);
            RequestDispatcher rd = request.getRequestDispatcher("/customer/CustomerProfile.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void destroy() {}


}
