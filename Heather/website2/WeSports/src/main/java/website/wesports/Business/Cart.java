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
import java.util.ArrayList;
import java.util.List;

/**
 *   Business Object for Checkout
 * @author Heather Papp, Alexander Thurmond
 */
public class Cart {


    /************* Database *************/
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    public CartList cartList = new CartList();

    /************* Properties *************/
    String CustEmail, ProductCode;
    int Quantity;
    public Long CartID;
    private List<Product> products;

    public int count = 0;
    public Product productArray[] = new Product[500];
    public void addProducts(Product product) {
        this.products.add(product);
        System.out.println("Product added to productList: " + product.getProductName()); // Debug
    }

    /************* Constructors *************/
    public Cart() {
        CartID = 0L;
        CustEmail = "";
        ProductCode = "";
        Quantity = 0;
        this.products = new ArrayList<>();
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


    public boolean Exists;
    public void setExists(boolean exists) { Exists = exists; }
    public boolean getExists() { return  Exists; }
    /*************Check if Cart Exists *************/
    public boolean cartExists(String cemail, Connection connection) {
        Exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Carts WHERE CustEmail = '" + getCustEmail() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                Exists = true;
                System.out.println("Customer Email: " + cemail);
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of customerExists()
        return Exists;
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
    public void insertCart(String cemail, String prodCode, int itemQuantity) {
        setCustEmail(cemail);
        setProductCode(prodCode);
        setQuantity(itemQuantity);

        Connection connection = null;
        PreparedStatement pStmt = null;

        try {
            assignNextCartID();

            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBLocation);


            if (cartExists(cemail, connection)) { // add to existing cart
                updateCartDB(cemail, prodCode, itemQuantity);
            } else { // create cart & add item
                String sql = "INSERT INTO Carts(CustEmail, ProductCode, Quantity) VALUES (?, ?, ?)";
                pStmt = connection.prepareStatement(sql);

                pStmt.setString(1, CustEmail);
                pStmt.setString(2, ProductCode);
                pStmt.setInt(3, Quantity);

                int n = pStmt.executeUpdate();
                if (n == 1) {
                    System.out.println("..... Cart INSERT Successful");
                } else {
                    System.out.println("!!!!! INSERT FAILED !!!!!");
                }
            }


            // Commit the changes
            connection.commit();

        } catch (Exception e) {
            System.out.println("Exception: " + e);

            // Rollback the changes if an exception occurs
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.out.println("Rollback Exception: " + ex);
                }
            }
        } finally {
            try {
                if (pStmt != null) pStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Close Exception: " + e);
            }
        }
    } // END insertCDB
    public void insertCartDB(Long cartID, String cemail, String prodCode, int itemQuantity) {
        setCustEmail(cemail);
        setProductCode(prodCode);
        setQuantity(itemQuantity);

        Connection connection = null;
        PreparedStatement pStmt = null;

        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBLocation);

            String sql = "INSERT INTO Carts(CartID, CustEmail, ProductCode, Quantity) VALUES (?, ?, ?, ?)";
            pStmt = connection.prepareStatement(sql);

            pStmt.setLong(1, cartID);
            pStmt.setString(2, cemail);
            pStmt.setString(3, prodCode);
            pStmt.setInt(4, itemQuantity);

            int n = pStmt.executeUpdate();
            if (n == 1) {
                System.out.println("..... Cart INSERT Successful");
            } else {
                System.out.println("!!!!! INSERT FAILED !!!!!");
            }

            // Commit the changes
            connection.commit();

        } catch (Exception e) {
            System.out.println("Exception: " + e);

            // Rollback the changes if an exception occurs
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.out.println("Rollback Exception: " + ex);
                }
            }
        } finally {
            try {
                if (pStmt != null) pStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Close Exception: " + e);
            }
        }
    }

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
    public void updateCartDB(String custEmail, String productCode, int quantity) {
        setCustEmail(custEmail);
        setProductCode(productCode);
        setQuantity(quantity);

        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            if (cartExists(custEmail, connection)) { // Check if cart exists
                // Create SQL statement & string
                String sql = "INSERT INTO Carts(CustEmail, ProductCode, Quantity) Values(?,?,?)";

                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                pStmt.setString(1, CustEmail);
                pStmt.setString(2, ProductCode);
                pStmt.setInt(3, Quantity);

                int n = pStmt.executeUpdate();
                if (n == 1) {
                    System.out.println("..... Product added to Cart Successful");
                } else {
                    System.out.println("!!!!! Product add FAILED !!!!!");
                }
            } else {
                System.out.println("***** Cart does NOT exist for CustEmail: " + custEmail + " *****");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    } // END updateCDB


    /************* Delete Item in Cart from Database: Carts *************/
    public void deleteCartItemDB() {}


    /************* Get Max CartID from Database: Carts *************/
    public Long MaxCartID;
    public void setMaxCartID(Long maxCartID) { MaxCartID = maxCartID; }
    public Long getMaxCartID() { return MaxCartID; }
    public Long lookupMaxCartID() {
        Long maxID = null;
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");
            stmt = connection.createStatement();

            String getMaxCartID = "SELECT MAX(CartID) AS MaxID FROM Carts;";

            rs = stmt.executeQuery(getMaxCartID);
            System.out.println("SQL Query: " + getMaxCartID);

            // Info to retrieve
            if (rs.next()) {
                maxID = rs.getLong("MaxID");
                if (maxID == 0) {
                    System.out.println("No CartID found in database.");
                } else {
                    System.out.println("Max CartID found: " + maxID);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Close Exception: " + e);
            }
        }

        return maxID != null ? maxID : -1L;
    }


    /************* Get Next CartID from Database: Carts *************/
    public Long NextCartID;
    public void setNextCartID(Long nextCartID) { NextCartID = nextCartID; }
    public Long getNextCartID() { return NextCartID; }
    public void assignNextCartID() {
        try {
            Long maxID = lookupMaxCartID();

            if (maxID != -1L) {
                NextCartID = maxID + 1;
                System.out.println("Next Cart ID: " + NextCartID);
            } else {
                System.out.println("Max Cart ID not found.");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    // Retrieve cart products by customer email from the database
    public void getCartByCustomerEmail(String customerEmail) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            conn = DriverManager.getConnection(DBLocation);
            String sql = "SELECT * FROM Carts WHERE CustEmail = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerEmail);
            System.out.println("Executing getCartByCustomerEmail() with email: " + customerEmail);

            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                do {
                    String productCode = rs.getString("ProductCode");
                    int quantity = rs.getInt("Quantity");

                    System.out.println("Retrieved Product: " + productCode + ", Quantity: " + quantity); // Debug

                    Product product = new Product();
                    product.selectPDB(productCode);
                    product.setQuantity(quantity);

                    addProducts(product);
                } while (rs.next());
            } else {
                System.out.println("ResultSet is null or empty.");
            }

            List<Product> debugProductList = getProductArray();
            System.out.println("Product List Size in getCartByCustomerEmail: " + (debugProductList != null ? debugProductList.size() : "null")); // Debug

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error in getCartByCustomerEmail(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Retrieve cart products by cart ID from the database
    public void getCartByCartID(Long cartID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DBLocation);
            String sql = "SELECT * FROM Carts WHERE CartID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, cartID);
            System.out.println("Executing getCartByCartID() with cartID: " + cartID);


            System.out.println("SQL Query: " + sql);
            while (rs.next()) {
                System.out.println("Debug Cart by CartID: " + rs.getLong("CartID") + ", " + rs.getString("CustEmail") + ", " + rs.getString("ProductCode") + ", " + rs.getInt("Quantity"));
                //System.out.println("Retrieved Product Code: " + rs.getString("ProductCode"));  // Debugging
                Product product = new Product();
                product.selectPDB(rs.getString("ProductCode"));  // Assuming selectPDB method populates the product object
                addProducts(product);
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.selectPDB(rs.getString("ProductCode"));
                product.setQuantity(rs.getInt("Quantity"));
                addProducts(product);
            }
        } catch (SQLException e) {
            System.out.println("Error in getCartByCartID(): " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public List<Product> getProductArray() {
        //System.out.println("Product Array Size: " + products.size());
        return this.products;
    }

    // Get total price of all products in cart
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : this.products) {
            totalPrice += product.getQuantity() * product.getUnitPrice();
        }
        return totalPrice;
    }



    public static void main(String[] args) {
        /*
        Cart cart = new Cart();
        cart.selectCartDB("TestEmail@mail.com");
        cart.setProductCode("002272904");
        cart.setQuantity(1);
        cart.updateCartDB("TestEmail@mail.com");
        cart.selectCartDB("TestEmail@mail.com");
        cart.display();
        */

        /* test cart max lookup
        Cart cart = new Cart();
        cart.lookupMaxCartID();
        System.out.println(cart.MaxCartID);
        */

        /* insert test cart
        Cart cart = new Cart();
        cart.insertCartDB("Test", "002272904", 1);
        */

    }
}
