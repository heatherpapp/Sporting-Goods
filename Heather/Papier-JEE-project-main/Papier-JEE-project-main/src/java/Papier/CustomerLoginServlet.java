package Papier;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet for customer login
 * @author Jason Arnold
 */
@WebServlet(urlPatterns = {"/CustomerLoginServlet"})
public class CustomerLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username;
        String password;
        try (PrintWriter out = response.getWriter()) {
            
            //get login information from HTML
            username = request.getParameter("username");
            password = request.getParameter("password");
            
            //create Customer
            Customer c1 = new Customer();
            c1.selectDB(username);
            
            //add customer p1 to session
            HttpSession session1;
            session1 = request.getSession();
            session1.setAttribute("c1", c1);
            System.out.println(password);
            System.out.println(c1.getPassword());
            
            //compare retrieved form data to database
            if (password.equals(c1.getPassword()))
            {
                //success, pass to customer display page
                RequestDispatcher rd = request.getRequestDispatcher("/customer/customer_profile.jsp");
                rd.forward(request, response);
            }
            else
            {
                //failure, pass to error page
                RequestDispatcher rd = request.getRequestDispatcher("/customer/customer_login_error.html");
                rd.forward(request, response);  
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "CUstomer Login Servlet for Papier office supplies";
    }// </editor-fold>

}
