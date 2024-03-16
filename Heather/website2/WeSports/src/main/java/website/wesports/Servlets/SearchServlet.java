package website.wesports.Servlets;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Search Servlet
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
/**
 *   Servlet for Search
 * @author Heather Papp
 */
@WebServlet public class SearchServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException { message = "Search Results"; }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

    }

    public void destroy() {}

}
