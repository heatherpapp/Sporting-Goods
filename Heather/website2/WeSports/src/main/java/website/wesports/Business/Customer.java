package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Customer Business Object
 * Authors: Heather Papp
 *
 *
 *
 */

import java.sql.*;

/**
 *   Business Object for Customer
 * @author Heather Papp
 */
public class Customer {

    /************* Database *************/
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/";

    /************* Properties *************/
    String CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustPassword;
    ProductList Cart, Order;
    public Long CustCartID;

    /************* Constructors *************/
    public Customer() {
        CustEmail = "";
        CustFirstName = "";
        CustLastName = "";
        CustStreet = "";
        CustCity = "";
        CustState = "";
        CustZip = "";
        CustPassword = "";
        //Order = new ProductList();
    }
    public Customer(String custEmail, String custFirstName, String custLastName, String custStreet, String custCity, String custState, String custZip, String custPassword, ProductList order) {
        CustEmail = custEmail;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustStreet = custStreet;
        CustCity = custCity;
        CustState = custState;
        CustZip = custZip;
        CustPassword = custPassword;
        //Order = order;
    }

    /************* Behaviors *************/

    public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    public void setCustFirstName(String custFirstName) { CustFirstName = custFirstName; }
    public String getCustFirstName() { return CustFirstName; }
    public void setCustLastName(String custLastName) { CustLastName = custLastName; }
    public String getCustLastName() { return CustLastName; }
    public void setCustStreet(String custStreet) { CustStreet = custStreet; }
    public String getCustStreet() { return CustStreet; }
    public void setCustCity(String custCity) { CustCity = custCity; }
    public String getCustCity() { return CustCity; }
    public void setCustState(String custState) { CustState = custState; }
    public String getCustState() { return CustState; }
    public void setCustZip(String custZip) { CustZip = custZip; }
    public String getCustZip() { return CustZip; }
    public void setCustPassword(String custPassword) { CustPassword = custPassword; }
    public String getCustPassword() { return CustPassword; }
    public ProductList getCart() { return Cart; }
    public ProductList getOrder() { return Order; }
    public void setCustCartID(Long custCartID) { CustCartID = custCartID; }
    public Long getCustCartID() { return CustCartID; }


    /*************Check if Customer Record Exists *************/
    public boolean Exists;
    public void setExists(boolean exists) { Exists = exists; }
    public boolean getExists() { return  Exists; }
    public boolean customerExists(String cem, Connection connection) {
        Exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Customer WHERE CustEmail = '" + getCustEmail() + "'";
            //System.out.println("Check Exists" + sql);

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                //if(rs.getInt(1) != 0)
                Exists = true;
                System.out.println("Customer Email: " + cem + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of customerExists()
        return Exists;
    } // END recordExists()

    /************* Display Results *************/
    public void display() {
        if (CustEmail.isEmpty()) System.out.println("***** You must enter a Customer Email *****");
        System.out.println("=======================================================");
        System.out.println("Customer Email: " + getCustEmail());
        System.out.println("Customer FirstName: " + getCustFirstName());
        System.out.println("Customer LastName: " + getCustLastName());
        System.out.println("Customer Address: " + getCustStreet() + "\n" + getCustCity() + ", " + getCustState() + " " + getCustZip());
        System.out.println("Customer PW: " + getCustPassword());
        System.out.println("Cart");
        if (Cart != null) {
            Cart.displayList();
        }
        System.out.println("Orders Awaiting Shipping");
        Order.displayList();
        System.out.println("=======================================================\n");
    } // END display()

    /************* Select from Database: Customer *************/
    //---using Email
    public void selectDB(String cem) {
        CustEmail = cem;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (customerExists(cem, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Customer WHERE CustEmail = '" + getCustEmail() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();
                setCustFirstName(rs.getString(2));
                setCustLastName(rs.getString(3));
                setCustStreet(rs.getString(4));
                setCustCity(rs.getString(5));
                setCustState(rs.getString(6));
                setCustZip(rs.getString(7));
                setCustPassword(rs.getString(8));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cem + " does NOT exist! *****");
            // Close Connection
            connection.close();
            getCartDB();
            getOrderDB();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectDB()


    /************* Insert into Database: Customer *************/
    public void insertDB(String custEmail, String custFirstName, String custLastName, String custStreet, String custCity, String custState, String custZip, String custPassword) {

        setCustEmail(custEmail);
        setCustFirstName(custFirstName);
        setCustLastName(custLastName);
        setCustStreet(custStreet);
        setCustCity(custCity);
        setCustState(custState);
        setCustZip(custZip);
        setCustPassword(custPassword);

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!customerExists(custEmail, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Customer(CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustPassword) Values(?,?,?,?,?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, CustEmail);
                pStmt.setString(2, CustFirstName);
                pStmt.setString(3, CustLastName);
                pStmt.setString(4, CustStreet);
                pStmt.setString(5, CustCity);
                pStmt.setString(6, CustState);
                pStmt.setString(7, CustZip);
                pStmt.setString(8, CustPassword);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert NEW Customer! *****\n***** Customer Email: " + custEmail + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END insertDB()

    /************* Update Existing Record in Database: Customer *************/
    public void updateDB(String custEmail) {

        setCustEmail(custEmail);
        // CustEmail = custEmail;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();

            // Create SQL string
            String sql = "UPDATE Customer SET CustFirstName = '" + getCustFirstName() + "',"
                    + "CustLastName = '" + getCustLastName() + "',"
                    + "CustStreet = '" + getCustStreet() + "',"
                    + "CustCity = '" + getCustCity() + "',"
                    + "CustState = '" + getCustState() + "',"
                    + "CustZip = '" + getCustZip() + "',"
                    + "CustPassword = '" + getCustPassword() + "'"
                    + "WHERE CustEmail = '" + getCustEmail() +"'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END updateDB()

    public void updateCustomer() {
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();
            String sql = "UPDATE Customer SET CustFirstName = '" + getCustFirstName() + "',"
                    + "CustLastName = '" + getCustLastName() + "',"
                    + "CustStreet = '" + getCustStreet() + "',"
                    + "CustCity = '" + getCustCity() + "',"
                    + "CustState = '" + getCustState() + "',"
                    + "CustZip = '" + getCustZip() + "',"
                    + "CustPassword = '" + getCustPassword() + "'"
                    + "WHERE CustEmail = '" + getCustEmail() +"'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");


        } catch (Exception e) { System.out.println("Exception" + e); }
    }

    public void updateName() {

    }

    public void updateAddress() {

    }
    /************* Delete from Database: Customer *************/
    public void deleteDB(String cemail) {


        CustEmail = cemail;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL string
            String sql = "DELETE FROM Customer WHERE CustEmail = '" + getCustEmail() + "'";

            // Create SQL statement
            Statement stmt = connection.createStatement();
            System.out.println("SQL Statement: " + sql);

            // Execute SQL statement
            int n = stmt.executeUpdate(sql);

            // Verify Delete
            if (n == 1)
                System.out.println("..... DELETE Successful!!! .....");
            else
                System.out.println("***** DELETE FAILED *****");

            //Close connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END deleteDB()

    /************* Get Customer Cart from Database: Carts *************/
    public void getCartDB()
    {


    } // END getCartDB

    /************* Get Customer Order from Database: Orders *************/
    public void getOrderDB() {
        //WIP
        Order = new ProductList();
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders WHERE CustEmail = '" + getCustEmail() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL: " +  sql);
            Product pro1;
            while (rs.next()) {
                pro1 = new Product();
                pro1.selectPDB(rs.getString("ProductCode"));
                pro1.setQuantity(rs.getInt("Quantity"));
                Order.addProducts(pro1);
            }
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END getOrderDB

    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.selectDB("cat@mail.com");
        //c1.deleteDB("Avery");
        //c1.insertDB("TestEmail@mail.com", "TestFN", "TestLN", "123 Main St", "Testcity", "TS", "12345", "password");
    }
}
