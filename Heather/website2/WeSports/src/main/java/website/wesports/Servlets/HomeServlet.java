package website.wesports.Servlets;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Home Servlet
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

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet public class HomeServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException { message = "Welcome to WeSports"; }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Welcome
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("</body></html>");
    }

    public void destroy() {}


}
