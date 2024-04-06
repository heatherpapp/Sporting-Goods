package website.wesports.Servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import website.wesports.Business.Cart;
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
            HttpSession session = request.getSession();
            Customer c1 = (Customer) session.getAttribute("c1");
            Cart cart = new Cart();
            Long CartID;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/");
            Statement stmt = conn.createStatement();
            Product p1 = new Product();
            p1.selectPDB(request.getParameter("ProductCode"));
            String quantity = request.getParameter("Quantity");
            p1.setQuantity(Integer.parseInt(quantity));

            //Establish CartID
            if (request.getAttribute("CustEmail") == null) { //non-logged in customer
                if (request.getAttribute("CartID") == null) {  //empty cart
                    cart.assignNextCartID();
                    CartID = cart.getNextCartID();
                    System.out.println("Non-registered customer CartID: " + CartID);
                    request.setAttribute("CartID", CartID);
                } else { //add to established cart, non-registered customer CartID
                    request.getAttribute("CartID");
                    CartID = cart.getCartID();
                    request.setAttribute("CartID", CartID);
                }
                boolean add = false;
                if (Integer.parseInt(quantity) > 0) {
                    try {
                        cart.insertCart(CartID, "guest", p1.getProductCode(), p1.getQuantity());
                        add = true;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    RequestDispatcher rd;
                    if (add) {
                        rd = request.getRequestDispatcher("/customer/AddToCartConfirmation.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/shop/ErrorPage.html");
                        rd.forward(request, response);
                    }
                }

            } else { //logged in customer
                String email = request.getParameter("CustEmail");
                c1.selectDB(email);
                //check for existing cartID attached to email
                cart.getCustCartID(email);
                if (cart.Exists) { //custEmail already has a CartID
                    CartID = cart.getCartID();
                    request.setAttribute("CartID", CartID);
                    System.out.println("Existing CartID: " + CartID + " already assigned to CustEmail: " + email);
                } else { //custEmail does NOT have a CartID
                    cart.assignNextCartID();
                    CartID = cart.getNextCartID();
                    request.setAttribute("CartID", CartID);
                    //cart.insertCartDB(c1.getCustEmail(), p1.getProductCode(), p1.getQuantity());
                    System.out.println("New CartID: " + CartID + " assigned to CustEmail: " + email);

                }
                boolean add = false;
                if (Integer.parseInt(quantity) > 0) {
                    try {
                        cart.insertCart(CartID, c1.getCustEmail(), p1.getProductCode(), p1.getQuantity());
                        add = true;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    String name = c1.getCustEmail();
                    c1.selectDB(name);
                    RequestDispatcher rd;
                    if (add) {
                        rd = request.getRequestDispatcher("/customer/AddToCartConfirmation.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/shop/ErrorPage.html");
                        rd.forward(request, response);
                    }
                }
                HttpSession session1 = request.getSession();
                session1.setAttribute("c1", c1);
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
