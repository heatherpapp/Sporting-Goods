package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
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
    Long CartID;


    /************* Constructors *************/
    public Cart() {
        CartID = 0L;
        CustEmail = "";
        ProductCode = "";
        Quantity = 0;
    }
    public Cart(Long cartID, String custEmail, String productCode, int quantity) {
        CartID = cartID;
        CustEmail = custEmail;
        ProductCode = productCode;
        Quantity = quantity;
    }


    /************* Behaviors *************/
    public void setCartID(Long cartID) { CartID = cartID; }
    public Long getCartID() { return CartID; }
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    public void setProductCode(String productCode) { ProductCode = productCode; }
    public String getProductCode() { return ProductCode; }
    public void setQuantity(int quantity) { Quantity = quantity; }
    public int getQuantity() { return Quantity; }


    /************* Display Results *************/
    public void display() {
        System.out.println("Customer Email: " + getCustEmail() + "\nProductCode: " + getProductCode() + "\nQuantity: " + getQuantity());
    } // END display()


    /*************Check if Cart Exists *************/
    public boolean cartExists(String cemail, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Carts WHERE CustEmail = '" + getCustEmail() + "'";

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


    // Entire Cart Methods //

    /************* Select from Database: Carts *************/

    public void getCustCartID(String cemail) {
        CustEmail = cemail;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (cartExists(cemail, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT CartID FROM Carts WHERE CustEmail = '" + getCustEmail() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                while (rs.next()) {
                    //Cart ID is autonumber
                    setCartID(rs.getLong("CartID"));
                }

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cemail + " does NOT exist! *****");
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectCDB

    public void selectCartDB(String cemail) {
        CustEmail = cemail;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (cartExists(cemail, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Carts WHERE CustEmail = '" + getCustEmail() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                while (rs.next()) {
                    //Cart ID is autonumber
                    setCartID(rs.getLong("CartID"));
                    setCustEmail(rs.getString("CustEmail"));
                    setProductCode(rs.getString("ProductCode"));
                    setQuantity(rs.getInt("Quantity"));
                }

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cemail + " does NOT exist! *****");
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectCDB


    /************* Insert New Cart into Database: Carts *************/
    public void insertCartDB(String cemail, String prodCode, int itemQuantity) {
        setCustEmail(cemail);
        setProductCode(prodCode);
        setQuantity(itemQuantity);

        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            if (cartExists(cemail, connection)) { //add to existing cart
                updateCartDB(cemail);
            } else { //create cart & add item --- get email on checkout
                String sql = "INSERT INTO Carts(CustEmail, ProductCode, Quantity) Values(?,?,?)";

                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                pStmt.setString(1, CustEmail);
                pStmt.setString(2, ProductCode);
                pStmt.setInt(3, Quantity);

                int n = pStmt.executeUpdate();
                if (n==1) System.out.println("..... Cart INSERT Successful");
                else System.out.println("!!!!! INSERT FAILED !!!!!");
            }
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END insertCDB


    /************* Delete Entire Cart from Database: Carts *************/
    // require user confirmation before performing this action



    // Cart Item Methods //

    /************* Insert Item to Existing Cart in Database: Carts *************/
    public void insertNewCart() {
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);

            String sql = "INSERT INTO Carts(CustEmail, ProductCode, Quantity) Values(?,?,?)";

            PreparedStatement pStmt = connection.prepareStatement(sql);
            System.out.println("SQL Statement: " + sql);

            pStmt.setString(2, CustEmail);
            pStmt.setString(3, ProductCode);
            pStmt.setInt(4, Quantity);

            int n = pStmt.executeUpdate();
            if (n==1) System.out.println("..... Cart INSERT Successful");
            else System.out.println("!!!!! INSERT FAILED !!!!!");

        } catch (Exception e) { System.out.println("Exception" + e); }
    }

    /************* Update Existing Items in Cart in Database: Carts *************/
    public void updateCart() {
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            Statement stmt = connection.createStatement();
            String sql = "UPDATE Carts SET"
                    + "CartID = '" + getCartID() + "',"
                    + "ProductCode = '" + getProductCode() + "',"
                    + "Quantity = '" + getQuantity() + "'"
                    + " WHERE CustEmail = '" + getCustEmail() + "'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    }


    /************* Update Existing Items in Cart in Database: Carts *************/
    public void updateCartDB(String custEmail) {
        CustEmail = custEmail;
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            Statement stmt = connection.createStatement();
            String sql = "UPDATE Carts SET"
                    + "CartID = '" + getCartID() + "',"
                    + "ProductCode = '" + getProductCode() + "',"
                    + "Quantity = '" + getQuantity() + "'"
                    + " WHERE CustEmail = '" + getCustEmail() + "'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END updateCDB


    /************* Delete Item in Cart from Database: Carts *************/
    public void deleteCartItemDB() {

    } // END deleteCDB

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.selectCartDB("TestEmail@mail.com");
        cart.setProductCode("002272904");
        cart.setQuantity(1);
        cart.updateCartDB("TestEmail@mail.com");
        cart.selectCartDB("TestEmail@mail.com");
        cart.display();
    }
}
