package website.wesports.Examples.Serv;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab 2
 * Author: Heather Papp
 * I wrote this code myself...
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", value = "/index-servlet")
public class IndexServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException { message = "Welcome to Chatt Bank"; }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Welcome
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
