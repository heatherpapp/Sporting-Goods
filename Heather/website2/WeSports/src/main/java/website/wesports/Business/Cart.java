package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Cart Business Object
 * Authors: Heather Papp, Alexander Thurmond
 *
 *
 *
 */

import java.sql.*;

/**
 *   Business Object for Checkout
 * @author Heather Papp, Alexander Thurmond
 */
public class Cart {


    /** Alex
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Add to cart
    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    // Remove from cart
    public void removeItem(Product product) {
        items.remove(product);
        System.out.println(product.getName() + " removed from the cart.");
    }

    // Retrieve Cart
    public List<Product> getItems() {
        return items;
    }

    // Empty Cart
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");
    }
     **/

    /************* Database *************/
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    /************* Properties *************/
    String CustEmail, ProductCode;
    int Quantity;

    /************* Constructors *************/
    public Cart() {
        CustEmail = "";
        ProductCode = "";
        Quantity = 0;
    }
    public Cart(String custEmail, String productCode, int quantity) {
        CustEmail = custEmail;
        ProductCode = productCode;
        Quantity = quantity;
    }

    /************* Behaviors *************/
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    public void setProductCode(String productCode) { ProductCode = productCode; }
    public String getProductCode() { return ProductCode; }
    public void setQuantity(int quantity) { Quantity = quantity; }
    public int getQuantity() { return Quantity; }

    /************* Display Results *************/
    public void display() {
        if (CustID.isEmpty()) System.out.println("***** You must enter a Customer ID *****");
        System.out.println("=======================================================");
        System.out.println("Customer Email: " + getCustEmail());
        System.out.println("Customer FirstName: " + getCustFirstName());
        System.out.println("Customer LastName: " + getCustLastName());
        System.out.println("Customer Address: " + getCustStreet() + "\n" + getCustCity() + " ," + getCustState() + " " + getCustZip());
        System.out.println("Customer Username: " + getCustUsername());
        System.out.println("Customer PW: " + getCustPassword());
        System.out.println("Customer ID: " + getCustID());
        System.out.println("Cart");
        Cart.displayList();
        System.out.println("Orders Awaiting Shipping");
        Order.displayList();
        System.out.println("=======================================================\n");
    } // END display()

    /*************Check if Cart Exists *************/
    public boolean cartExists(String cemail, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Carts WHERE CustEmail = '" + getCustEmail() + "'";
            //String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("Customer Email: " + cemail);
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of customerExists()
        return exists;
    } // END recordExists()

}
