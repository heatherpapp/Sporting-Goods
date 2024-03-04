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

@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {

        message = "Go Sportsballs!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Welcome
        PrintWriter out = response.getWriter();

        System.out.println("Go Sportsballs!");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    // called only after servlet init() has completed successfully
    public void destroy() {}

}
