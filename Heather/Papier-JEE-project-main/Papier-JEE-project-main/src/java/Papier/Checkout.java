
package Papier;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to move customer order from cart to processing for fulfillers.
 * @author Jason Arnold
 */
@WebServlet(name = "Checkout", urlPatterns = {"/Checkout"})
public class Checkout extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            Customer c1 = new Customer();
            String name = request.getParameter("userName");
            c1.selectDB(name);
            
            if (c1.getUsername().equals("guest@guest.com"))
            {
                RequestDispatcher rd = request.getRequestDispatcher("/customer/customer_register.html");
                rd.forward(request, response);
            }
            
            else
            {
            
                
                try
                {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb");
                    Statement stmt = conn.createStatement();
                    String sqldel = "delete from carts where customerid = '" + c1.getId() + "'";
                    String sql = "Insert into Orders (customerid, productid, quantity) select customerid, productid, quantity from Carts where customerid = '" + c1.getId() + "'";
                    System.out.println(sql);
                    int n1 = stmt.executeUpdate(sql);
                    if (n1>0)
                        stmt.execute(sqldel);
                    else
                        System.out.println("Unable to add to cart!!!");
                    conn.close();
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
        return "Short description";
    }// </editor-fold>

}
