package website.wesports.Servlets;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Distributor Login Servlet
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
import website.wesports.Business.Distributor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *   Servlet for Distributor Login Page
 * @author Heather Papp
 */

@WebServlet(name = "DistributorLoginServlet", urlPatterns = {"/DistributorLoginServlet"})
public class DistributorLoginServlet extends HttpServlet {

    private String message;
    private static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public void init() throws ServletException {
        message = "Valid Login";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String distID, distPW;
        distID = request.getParameter("distUserNameInput"); //CustID form textbox
        distPW = request.getParameter("distPasswordInput"); //CustPassword form textbox
        System.out.println("DistributorID: " + distID + "\nDistributorPassword: " + distPW + "\n");

        Distributor d1 = new Distributor();
        d1.selectDB(distID);

        String idDB = d1.getDistUsername();
        String pwDB = d1.getDistPW();
        System.out.println("DBID: " + idDB + "\nDBPW: " + pwDB );

        HttpSession ses1 = request.getSession();
        ses1.setAttribute("d1", d1);

        String url;
        RequestDispatcher rdObj;

        if (pwDB.equals(distPW)) {
            // Successful login forward to DisplayAccount.jsp CHANGE THIS
            url = "/DisplayAccount.jsp";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);

        } else {
            // Failed login forward to ErrorPage.jsp
            url = "/ErrorPage.jsp";
            rdObj = request.getRequestDispatcher(url);
            rdObj.forward(request, response);
        }





    }

    public void destroy() {}

}