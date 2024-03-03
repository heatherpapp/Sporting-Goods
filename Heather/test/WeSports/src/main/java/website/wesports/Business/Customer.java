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

    /************* Properties *************/
    String CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustPassword, CustUsername, CustID;

    ProductList cart;
    ProductList order;

    //public AccountList accountList = new AccountList();

    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

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
    }
    public Customer(String custID, String custEmail, String custFirstName, String custLastName, String custStreet, String custCity, String custState, int custZip, String custUsername, String custPassword) {
        CustID = "";
        CustEmail = "";
        CustFirstName = "";
        CustLastName = "";
        CustStreet = "";
        CustCity = "";
        CustState = "";
        CustZip = "";
        CustUsername = "";
        CustPassword = "";
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
        System.out.println("Customer Email: " + getCustID());
        //accountList.displayList();
        System.out.println("=======================================================\n");
    } // END display()

    /************* Select from Database: Customers *************/
    public void selectDB(String cem) {
        CustEmail = cem;
        //CustID = cid;
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
                //String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();

                setCustEmail(rs.getString(2));
                setCustFirstName(rs.getString(3));
                setCustLastName(rs.getString(4));
                setCustStreet(rs.getString(5));
                setCustCity(rs.getString(6));
                setCustState(rs.getString(7));
                setCustZip(rs.getString(8));
                setCustUsername(rs.getString(9));
                setCustPassword(rs.getString(10));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer ID: " + cid + " does NOT exist! *****");
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
        /**
        getAccounts();
         **/
    } // END selectDB()

    /************* Insert into Database *************/
    public void insertDB(String cid, String cpassword, String cfirstname, String clastname, String cstreet, String ccity, String cstate, String czip, String cemail) {
        // Customers > 1CustID 2CustPassword 3CustFirstName 4CustLastName 5CustAddress 6CustEmail
        CustID = cid;
        CustPassword = cpassword;
        CustFirstName = cfirstname;
        CustLastName = clastname;
        CustStreet = cstreet;
        CustCity = ccity;
        CustState = cstate;
        CustZip = czip;
        CustEmail = cemail;

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!customerExists(cid, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Customers(CustID, CustEmail, CustFirstName, CustLastName, CustStreet, CustCity, CustState, CustZip, CustUsername, CustPassword) Values(?,?,?,?,?,?, ?, ?, ?, ?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, cid);
                pStmt.setString(2, cpw);
                pStmt.setString(3, cfn);
                pStmt.setString(4, cln);
                pStmt.setString(5, cad);
                pStmt.setString(6, cem);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert New Record! *****\n***** Customer ID: " + cid + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END insertDB()

    /************* Update Existing Record in Database *************/
    public void updateDB(String cid) {
        // Customers > 1CustID 2CustPassword 3CustFirstName 4CustLastName 5CustAddress 6CustEmail
        CustID = cid;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();

            // Create SQL string
            String sql = "UPDATE Customers SET CustPassword = '" + getCustPW() + "',"
                    + " CustFirstName = '" + getFname() + "',"
                    + " CustLastName = '" + getLname() +"',"
                    + " CustAddress = '" + getAddr() + "',"
                    + " CustEmail = '" + getEmail() + "'"
                    + " WHERE CustID = '" + getCustID() + "'";

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
        // Customers > 1CustID 2CustPassword 3CustFirstName 4CustLastName 5CustAddress 6CustEmail
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
