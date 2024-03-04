package hpapp.chattbank.Business;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab #4
 * Author: Heather Papp
 * I wrote this code myself...
 */

import java.sql.*;

public class Customer {

    /************* Properties *************/
    private String CustID, CustPassword;
    private String CustFirstName, CustLastName, CustAddress, CustEmail;
    public AccountList accountList = new AccountList();
    final static String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final static String DBLocation = "jdbc:ucanaccess://C:/Users/heath/OneDrive/Documents/Business/Chatt Tech/JAVA/ChattBank/src/main/resources/ChattBankACCDB.accdb;showSchema=true";


    /************* Constructors *************/
    public Customer() {
        CustID = "";
        CustPassword = "";
        CustFirstName = "";
        CustLastName = "";
        CustAddress = "";
        CustEmail = "";
    }
    public Customer(String cid, String cpw, String cfn, String cln, String cad, String cem) {
        CustID = cid;
        CustPassword = cpw;
        CustFirstName = cfn;
        CustLastName = cln;
        CustAddress = cad;
        CustEmail = cem;
    }

    /************* Behaviors *************/
    public void setCustID(String cid) { CustID = cid;}
    public String getCustID() { return CustID; }
    public void setCustPW(String cpw) { CustPassword = cpw;}
    public String getCustPW() { return CustPassword; }
    public void setFname(String cfn) { CustFirstName = cfn;}
    public String getFname() { return CustFirstName; }
    public void setLname(String cln) { CustLastName = cln;}
    public String getLname() { return CustLastName; }
    public void setAddr(String cad) { CustAddress = cad;}
    public String getAddr() { return CustAddress; }
    public void setEmail(String cem) { CustEmail = cem;}
    public String getEmail() { return CustEmail; }

    /*************Check if Record Exists *************/
    public boolean custIDExists(String cid, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("Customer ID: " + cid + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of recordExists()
        return exists;
    } // END recordExists()

    /************* Display Results *************/
    public void display() {
        if (CustID.isEmpty()) System.out.println("***** You must enter a Customer ID *****");
        System.out.println("=======================================================");
        System.out.println("Customer ID: " + getCustID());
        System.out.println("Customer PW: " + getCustPW());
        System.out.println("Customer FirstName: " + getFname());
        System.out.println("Customer LastName: " + getLname());
        System.out.println("Customer Address: " + getAddr());
        System.out.println("Customer Email: " + getEmail());
        accountList.displayList();
        System.out.println("=======================================================\n");
    } // END display()

    /************* Get Customer Accounts from Database Accounts *************/
    public void getAccounts() {
        // Accounts > 1AcctNo 2Cid 3Type 4Balance
        try {
            // Get connection to database
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for Accounts Retrieval *************");

            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT AcctNo FROM Accounts WHERE Cid = '" + getCustID() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);
            String acctNo;
            Account a1;

            while (rs.next()) {
                acctNo = rs.getString(1);
                System.out.println("AccountNo: " + acctNo);
                a1 = new Account();
                a1.selectADB(acctNo);
                accountList.addAccount(a1);
                System.out.println("Account added to Customer ID: " + getCustID() + "'s Account List");
            }
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception: " + e); }
    } // END getAccounts()

    /************* Select Customer from Database Customers *************/
    public void selectDB(String cid) {
        // Customers > 1CustID 2CustPassword 3CustFirstName 4CustLastName 5CustAddress 6CustEmail
        CustID = cid;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (custIDExists(cid, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Customers WHERE CustID = '" + getCustID() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();
                setCustPW(rs.getString(2));
                setFname(rs.getString(3));
                setLname(rs.getString(4));
                setAddr(rs.getString(5));
                setEmail(rs.getString(6));

            } else System.out.println("***** Customer Retrieval ERROR! ***** \n***** Customer ID: " + cid + " does NOT exist! *****");
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
        getAccounts();
    } // END selectDB()

    /************* Insert into Database *************/
    public void insertDB(String cid, String cpw, String cfn, String cln, String cad, String cem) {
        // Customers > 1CustID 2CustPassword 3CustFirstName 4CustLastName 5CustAddress 6CustEmail
        CustID = cid;
        CustPassword = cpw;
        CustFirstName = cfn;
        CustLastName = cln;
        CustAddress = cad;
        CustEmail = cem;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!custIDExists(cid, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Customers(CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail) Values(?,?,?,?,?,?)";

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

    /************* Main Method for Testing *************/
    public static void main(String[] args) {
        /*** Database Table Fields
         * Customers:
         * Customer c1 = new Customer(3007,     1234,       "Ima",      "Customer",  "Georgia", "imacustomer@mail.com");
         *                           CustID CustPassword CustFirstName CustLastName CustAddress      CustEmail
         *
         * Accounts:
         * Accounts a1 = new Account(97447, 3007, "SAV/CHK/MMA", $##.##);
         *                          AcctNo   Cid      Type       Balance
         */


/** Test selectDB

        Customer c1 = new Customer();
        c1.selectDB("3001");

        String idDB = c1.getCustID();
        String pwDB = c1.getCustPW();
        System.out.println("DBID: " + idDB + "\nDBPW: " + pwDB );

        c1.display();
 **/

/** Test insertDB

 Customer c2 = new Customer();
 c2.insertDB("3007", "1234", "Neil", "Fallon", "Maryland", "clutchofficial@gmail.com");
 c2.display();

 Customer c5 = new Customer();
 c5.insertDB("3008", "1234", "Jean-Paul", "Gaster", "Maryland", "clutchofficial4@gmail.com");
 c5.display();
 **/

/** Test updateDB

 Customer c3 = new Customer();
 c3.selectDB("3007");
 c3.setAddr("Oblivion");
 c3.updateDB("3007");
 c3.display();
 **/

/** Test deleteDB

 Customer c4 = new Customer();
 c4.selectDB("3008");
 c4.deleteDB("3008");
 **/

    } // END main
} //END class
