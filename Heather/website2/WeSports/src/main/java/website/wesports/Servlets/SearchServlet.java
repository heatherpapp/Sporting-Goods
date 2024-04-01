package website.wesports.Servlets;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
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
import website.wesports.Business.Product;
import website.wesports.Business.ProductList;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *   Servlet for Search
 * @author Heather Papp
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    private String message;

    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/";

    public void init() throws ServletException {
        message = "Search Results";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        // Call a method to fetch products based on the search query
        List<Product> products = searchProducts(query);

        request.setAttribute("products", products);
        request.getRequestDispatcher("shop/SearchResults.jsp").forward(request, response);
    }

    private List<Product> searchProducts(String query) {

        List<Product> productList = new ArrayList<>();

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT ProductCode FROM Products WHERE ProductName LIKE '%" + query + "%' "
                    + "OR ProductDescription LIKE '%" + query + "%' "
                    + "OR Department LIKE '%" + query + "%' "
                    + "OR Section LIKE '%" + query + "%' "
                    + "OR AgeGroup LIKE '%" + query + "%' "
                    + "OR Gender LIKE '%" + query + "%' ";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);

            String prodCode;

            Product product;

            while (rs.next()) {
                prodCode = rs.getString(1);
                product = new Product();
                product.selectPDB(prodCode);
                productList.add(product);
                product.productList.displayList();
            }
            connection.close();

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

        return productList;
    }

}