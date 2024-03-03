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
 * Servlet to update customer database information
 * @author Jason Arnold
 */
@WebServlet(name = "CustomerUpdateServlet", urlPatterns = {"/CustomerUpdateServlet"})
public class CustomerUpdateServlet extends HttpServlet {

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
        
        String id;
        String fName;
        String lName;
        String email;
        String street;
        String city;
        String state;
        String zipcode;
        String username;
        
        try (PrintWriter out = response.getWriter()) {
            
            //create new customer
            Customer c1 = new Customer();
            c1.selectDB(request.getParameter("username"));
            
            //get customer info from update jsp
            id = request.getParameter("id");
            username = request.getParameter("username");
            fName = request.getParameter("fname");
            lName = request.getParameter("lname");
            email = request.getParameter("email");
            street = request.getParameter("street");
            city = request.getParameter("city");
            state = request.getParameter("state");
            zipcode = request.getParameter("zip");
            
            
            //update database with new customer information
           try
                {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb");
                Statement stmt = conn.createStatement();
                String sql = "Update Customers set fname='" + fName + "', lname='" + lName + "', email='" + email +"', street='" + street +"',"
                        + " city='" + city +"', state='" + state +"', zipcode='" + zipcode + "' where id=" + id + ";" ;
                System.out.println(sql);
                int n1 = stmt.executeUpdate(sql);
                if (n1==1)
                {
                    System.out.println("Customer updated!");
                    //c1.getCurrentOrder();
                }
                else
                {
                    System.out.println("!!!!!!!!!!!INSERT FAILED!!!!!!!!!!!!!");
                }
                
                conn.close();
                String name = c1.getUsername();
                c1.selectDB(name);
                
                }
            catch(Exception e)
                {
                    System.out.println(e);
                }
            
            //retrieve updated customer info for display
            c1.selectDB(username);
            HttpSession session1;
            session1 = request.getSession();
            session1.setAttribute("c1", c1);
            
            //forward control back to Display Customer
            RequestDispatcher rd = request.getRequestDispatcher("/customer/customer_profile.jsp");
                rd.forward(request, response);
            
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
