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
 *   Servlet for adding products to customer shopping cart
 * @author Jason Arnold
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            Customer c1 = new Customer();
            if (request.getParameter("userName") == null)
                    {
                        c1.selectDB("guest");
                    }
            else
                c1.selectDB(request.getParameter("userName"));
            Product p1 = new Product();
            p1.selectDB(request.getParameter("itemNo"));
            String quantity = request.getParameter("quantity");
            p1.setQuantity(quantity);
            int add = 0;
            
            if (Integer.parseInt(quantity) > 0)
            {
            try
                {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb");
                Statement stmt = conn.createStatement();
                String sql = "Insert into Carts (customerid, productid, quantity) values ('" + c1.getId()+ "', " +
                                                                                           "'" + p1.getId()+ "', " +
                                                                                           "'" + quantity + "')" ;
                System.out.println(sql);
                int n1 = stmt.executeUpdate(sql);
                if (n1==1)
                {
                    System.out.println("Added to cart!");
                    add = 1;
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
            }
            
            //add customer p1 to session
            HttpSession session1;
            session1 = request.getSession();
            session1.setAttribute("c1", c1);
            
            if (add == 1)
            {
            //forward control back to Display Cart
                RequestDispatcher rd = request.getRequestDispatcher("/shop/products.jsp");
                rd.forward(request, response);
            }
            else
            {
            //forward control back to products page
                RequestDispatcher rd = request.getRequestDispatcher("/shop/products.jsp");
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
