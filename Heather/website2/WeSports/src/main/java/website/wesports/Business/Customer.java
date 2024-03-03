package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
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
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    /************* Properties *************/
    String CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustPassword, CustUsername, CustID;
    ProductList Cart, Order;

    /************* Constructors *************/
    public Customer() {
        CustEmail = "";
        CustFirstName = "";
        CustLastName = "";
        CustStreet = "";
        CustCity = "";
        CustState = "";
        CustZip = "";
        CustUsername = "";
        CustPassword = "";
        CustID = "";
        Order = new ProductList();
    }
    public Customer(String custEmail, String custFirstName, String custLastName, String custStreet, String custCity, String custState, String custZip, String custUsername, String custPassword, String custID, ProductList order) {
        CustEmail = custEmail;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustStreet = custStreet;
        CustCity = custCity;
        CustState = custState;
        CustZip = custZip;
        CustUsername = custUsername;
        CustPassword = custPassword;
        CustID = custID;
        Order = order;
    }

    /************* Behaviors *************/
    public void setCustID(String custID) { CustID = custID; }
    public String getCustID() { return CustID; }
    public void setCustPassword(String custPass) { CustPassword = custPass; }
    public String getCustPassword() { return CustPassword; }
    public void setCustUsername(String custUsername) { CustUsername = custUsername; }
    public String getCustUsername() { return CustUsername; }
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
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    public ProductList getCart() { return Cart; }
    public ProductList getOrder() { return Order; }

    /*************Check if Record Exists *************/
    public boolean customerExists(String cemail, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Customers WHERE CustEmail = '" + getCustEmail() + "'";
            //String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("Customer Email: " + cemail);
                //System.out.println("Customer ID: " + cid + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of customerExists()
        return exists;
    } // END recordExists()

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

    /************* Select from Database: Customers *************/
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
                String sql = "SELECT * FROM Customers WHERE CustEmail = '" + getCustEmail() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();

                setCustEmail(rs.getString("CustEmail"));
                setCustFirstName(rs.getString("CustFirstName"));
                setCustLastName(rs.getString("CustLastName"));
                setCustStreet(rs.getString("CustStreet"));
                setCustCity(rs.getString("CustCity"));
                setCustState(rs.getString("CustState"));
                setCustZip(rs.getString("CustZip"));
                setCustUsername(rs.getString("CustUsername"));
                setCustPassword(rs.getString("CustPassword"));
                setCustID(rs.getString("CustID"));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cem + " does NOT exist! *****");
            // Close Connection
            connection.close();
            getCartDB();
            getOrderDB();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectDB()

    //---using Username
    public void selectDBUN(String cun) {
        CustUsername = cun;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (customerExists(cun, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Customers WHERE CustUsername = '" + getCustUsername() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();

                setCustEmail(rs.getString("CustEmail"));
                setCustFirstName(rs.getString("CustFirstName"));
                setCustLastName(rs.getString("CustLastName"));
                setCustStreet(rs.getString("CustStreet"));
                setCustCity(rs.getString("CustCity"));
                setCustState(rs.getString("CustState"));
                setCustZip(rs.getString("CustZip"));
                setCustUsername(rs.getString("CustUsername"));
                setCustPassword(rs.getString("CustPassword"));
                setCustID(rs.getString("CustID"));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cun + " does NOT exist! *****");
            // Close Connection
            connection.close();
            getCartDB();
            getOrderDB();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectDB()

    //---using ID
    public void selectDBID(String cid) {
        CustID = cid;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (customerExists(cid, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();

                setCustEmail(rs.getString("CustEmail"));
                setCustFirstName(rs.getString("CustFirstName"));
                setCustLastName(rs.getString("CustLastName"));
                setCustStreet(rs.getString("CustStreet"));
                setCustCity(rs.getString("CustCity"));
                setCustState(rs.getString("CustState"));
                setCustZip(rs.getString("CustZip"));
                setCustUsername(rs.getString("CustUsername"));
                setCustPassword(rs.getString("CustPassword"));
                setCustID(rs.getString("CustID"));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer: " + cid + " does NOT exist! *****");
            // Close Connection
            connection.close();
            getCartDB();
            getOrderDB();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END selectDB()

    /************* Insert into Database *************/
    public void insertDB(String custEmail, String custFirstName, String custLastName, String custStreet, String custCity, String custState, String custZip, String custUsername, String custPassword, String custID) {

        //WIP

        setCustEmail(custEmail);
        setCustFirstName(custFirstName);
        setCustLastName(custLastName);
        setCustStreet(custStreet);
        setCustState(custState);
        setCustZip(custZip);
        setCustUsername(custUsername);
        setCustPassword(custPassword);
        setCustID(custID);

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!customerExists(custEmail, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Customers(CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustUsername, CustPassword, CustID) Values(?,?,?,?,?,?, ?, ?, ?)";

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
                pStmt.setString(8, CustUsername);
                pStmt.setString(9, CustPassword);
                pStmt.setString(10, ""); //pStmt.setString(10, CustID);

                /**
                pStmt.setString(1, getCustEmail());
                pStmt.setString(2, getCustFirstName());
                pStmt.setString(3, getCustLastName());
                pStmt.setString(4, getCustStreet());
                pStmt.setString(5, getCustCity());
                pStmt.setString(6, getCustState());
                pStmt.setString(7, getCustZip());
                pStmt.setString(8, getCustUsername());
                pStmt.setString(9, getCustPassword());
                pStmt.setString(10, getCustID());
                 **/

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert New Record! *****\n***** Customer ID: " + custEmail + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END insertDB()

    /************* Update Existing Record in Database *************/
    public void updateDB(String custEmail) {

        //WIP

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
            String sql = "UPDATE Customers SET CustFirstName = '" + getCustFirstName() + "',"
                    + " CustLastName = '" + getCustLastName() + "',"
                    + "CustStreet = '" + getCustStreet() + "',"
                    + "CustCity = '" + getCustCity() + "',"
                    + "CustState = '" + getCustState() + "',"
                    + "CustZip = '" + getCustZip() + "',"
                    + "CustUsername = '" + getCustUsername() + "',"
                    + "CustPassword = '" + getCustPassword() + "',"
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

    /************* Delete from Database *************/
    public void deleteDB(String cid) {

        //WIP

        CustID = cid;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL string
            String sql = "DELETE FROM Customers WHERE CustID = '" + getCustID() + "'";

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
}
