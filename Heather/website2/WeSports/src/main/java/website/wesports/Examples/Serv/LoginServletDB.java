package website.wesports.Examples.Serv;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab 3
 * Author: Heather Papp
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServletDB")
public class LoginServletDB extends HttpServlet {

    public LoginServletDB() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String id = request.getParameter("customerID");
        String pw = request.getParameter("password");

        try {
            //load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            // get connection
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/heath/OneDrive/Documents/Business/Chatt Tech/JAVA/databaseFiles/ChattBankACCDB.accdb");
            System.out.println("Database connected\n--------------------------------------------------");

            PreparedStatement ppstmt = connection.prepareStatement("SELECT * FROM Customers WHERE CustID=? AND CustPassword=?");
            ppstmt.setString(1, id);
            ppstmt.setString(2,pw);

            ResultSet resultSet = ppstmt.executeQuery();
            boolean status = resultSet.next();

            if (status) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>LoginServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Valid Login</h2>");
                out.println("</body>");
                out.println("</html>");
                out.println("Valid Login");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>LoginServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Invalid Login</h2>");
                out.println("</body>");
                out.println("</html>");
            }



        } catch (Exception e) {
            System.out.println("Oops..." + e);
        }
    }

}
