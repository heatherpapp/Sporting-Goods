package website.wesports.Servlets;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Product Business Object
 * Authors: Heather Papp
 *
 *
 *
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *   Servlet for Checkout
 * @author Heather Papp
 */

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {
    /************* Database *************/
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        try (PrintWriter out = response.getWriter())
        {

            Customer c1 = new Customer();
            String name = request.getParameter("userName");
            c1.selectDB(name);

            if (c1.getUsername().equals("guest@guest.com"))
            {
                RequestDispatcher rd = request.getRequestDispatcher("/customer/Register.html");
                rd.forward(request, response);
            }

            else
            {


                try
                {

                    Class.forName(DBDriver);
                    Connection connection = DriverManager.getConnection(DBLocation);
                    Statement stmt = connection.createStatement();
                    String sqldel = "delete from carts where customerid = '" + c1.getId() + "'";
                    String sql = "Insert into Orders (customerid, productid, quantity) select customerid, productid, quantity from Carts where customerid = '" + c1.getId() + "'";
                    System.out.println(sql);
                    int n1 = stmt.executeUpdate(sql);
                    if (n1>0)
                        stmt.execute(sqldel);
                    else
                        System.out.println("Unable to add to cart!!!");
                    connection.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                c1.selectDB(c1.username);

                //add customer c1 to session
                HttpSession session1;
                session1 = request.getSession();
                session1.setAttribute("c1", c1);

                //forward control back to Display Cart
                RequestDispatcher rd = request.getRequestDispatcher("/customer/customer_orders.jsp");
                rd.forward(request, response);
            }
        }

         */
    }
}
