package website.wesports.Servlets;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Register Servlet
 * Authors: Heather Papp
 *
 *
 *
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import website.wesports.Business.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 *   New Customer Servlet
 * @author Heather Papp
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            Customer c1 = new Customer();
            String newEmail = request.getParameter("newEmail");
            System.out.println(newEmail);
            c1.insertDB(request.getParameter("newFName"), request.getParameter("newLName"), request.getParameter("newPass"),
                    request.getParameter("newEmail"), request.getParameter("newStreet"), request.getParameter("newCity"), request.getParameter("newState"), request.getParameter("newZip"));
            c1.selectDB(newEmail);
            c1.display();

            try
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/");
                Statement stmt = conn.createStatement();
                String sqlUpdateCart = "INSERT INTO Carts SET CustEmail = " +c1.getCustEmail();
                System.out.println(sqlUpdateCart);
                int num = stmt.executeUpdate(sqlUpdateCart);

                conn.close();

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            c1.selectDB(newEmail);



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
