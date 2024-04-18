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

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public AddToCartServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            Customer c1 = (Customer) session.getAttribute("c1");
            Cart cart = new Cart();

            // Check if customer is logged in
            if (c1 != null) { // Logged in customer
                String email = c1.getCustEmail();
                c1.selectDB(email);

                // Check for existing cartID attached to email
                cart.getCustCartID(email);
                if (!cart.Exists) { // CustEmail does NOT have a CartID
                    cart.assignNextCartID();
                }

                String productCode = request.getParameter("ProductCode");
                String quantity = request.getParameter("Quantity");

                if (Integer.parseInt(quantity) > 0) {
                    try {
                        cart.insertCartDB(cart.getNextCartID(), email, productCode, Integer.parseInt(quantity));
                        request.setAttribute("CartID", cart.getNextCartID());
                        RequestDispatcher rd = request.getRequestDispatcher("/customer/AddToCartConfirmation.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                        RequestDispatcher rd = request.getRequestDispatcher("/shop/ErrorPage.html");
                        rd.forward(request, response);
                    }
                }

            } else { // Non-logged in customer
                if (!cart.Exists) {  // Empty cart
                    cart.assignNextCartID();
                }

                String productCode = request.getParameter("ProductCode");
                String quantity = request.getParameter("Quantity");
                if (Integer.parseInt(quantity) > 0) {
                    try {
                        cart.insertCartDB(cart.getNextCartID(), "guest", productCode, Integer.parseInt(quantity));
                        request.setAttribute("CartID", cart.getNextCartID());
                        RequestDispatcher rd = request.getRequestDispatcher("/customer/AddToCartConfirmation.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                        RequestDispatcher rd = request.getRequestDispatcher("/shop/ErrorPage.html");
                        rd.forward(request, response);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
