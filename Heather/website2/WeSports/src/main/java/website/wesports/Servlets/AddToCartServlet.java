package website.wesports.Servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import website.wesports.Business.Customer;
import website.wesports.Business.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


@WebServlet (name = "AddToCartServlet", urlPatterns = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public AddToCartServlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        /**
         * on customer click add to cart:
         * check if logged in
         * if not: add to carts and get cartID from db
         * if logged in: add to cart linked to email & get cartID
         *
         * do not redirect! customer should remain on same product page
         *
         */

        PrintWriter out = response.getWriter();

        try {
            Customer c1 = new Customer();
            if (request.getParameter("userName") == null) {
                c1.selectDB("guest");
            } else {
                c1.selectDB(request.getParameter("userName"));
            }

            Product p1 = new Product();
            p1.selectPDB(request.getParameter("ProductCode"));
            String quantity = request.getParameter("Quantity");
            p1.setQuantity(Integer.parseInt(quantity));
            boolean add = false;
            if (Integer.parseInt(quantity) > 0) {
                try {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/");
                    Statement stmt = conn.createStatement();
                    String sql = "INSERT INTO Carts (CustEmail, ProductCode, Quantity) values ('" + c1.getCustEmail() + "', '" + p1.getProductCode() + "', '" + quantity + "')";
                    System.out.println(sql);
                    int n1 = stmt.executeUpdate(sql);
                    if (n1 == 1) {
                        System.out.println("Added to cart!");
                        add = true;
                    } else {
                        System.out.println("!!!!!!!!!!!INSERT FAILED!!!!!!!!!!!!!");
                    }

                    conn.close();
                    String name = c1.getCustEmail();
                    c1.selectDB(name);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            HttpSession session1 = request.getSession();
            session1.setAttribute("c1", c1);
            RequestDispatcher rd;
            if (add) {
                rd = request.getRequestDispatcher("/shop/products.jsp");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("/shop/products.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

}
