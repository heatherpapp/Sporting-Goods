package website.wesports.Examples.BO;
/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab #4
 * Author: Heather Papp
 * I wrote this code myself...
 */

import java.sql.*;

public class Account {

    /************* Properties *************/
    private String AcctNo, Cid, Type;
    private double Balance;
    final static String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final static String DBLocation = "jdbc:ucanaccess://Sporting-Goods/Database/WeSports.accdb;showSchema=true";

    /************* Constructors *************/
    public Account() {
        AcctNo = "";
        Cid = "";
        Type = "";
        Balance = 0.00;
    }
    public Account(String acN, String cid, String tpe, double bal) {
        AcctNo = acN;
        Cid = cid;
        Type = tpe;
        Balance = bal;
    }

    /************* Behaviors *************/
    public void setAcctNo(String acN) { AcctNo = acN; }
    public String getAcctNo() { return AcctNo; }
    public void setCid(String cid) { Cid = cid; }
    public String getCid() { return Cid; }
    public void setAcctType(String tpe){ Type = tpe; }
    public String getAcctType() { return Type; }
    public void setBalance(double bal) { Balance = bal; }
    public double getBalance() { return Balance; }

    /************* Check if Record Exists *************/
    public boolean acctExists(String acN, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Accounts WHERE AcctNo = '" + getAcctNo() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("Account No: " + acN + " Exists");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return exists;
    } // END acctExists()

    /************* Display Results *************/
    public void displayADB() {
        System.out.println("=======================================================");
        System.out.println("Account No.: " + getAcctNo());
        System.out.println("Customer ID: " + getCid());
        System.out.println("Account Type: " + getAcctType());
        System.out.println("Account Balance: " + getBalance());
        System.out.println("=======================================================\n");
    } // END displayADB()

    /*************Select Account from Database Accounts *************/
    public void selectADB(String acN) {
        AcctNo = acN;
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for Account Select *************");

            // Check if CustID record exists
            if (acctExists(acN, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Accounts WHERE AcctNo = '" + getAcctNo() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                while (rs.next()) {
                    setCid(rs.getString(2));
                    setAcctType(rs.getString(3));
                    setBalance(rs.getDouble(4));
                }
            } else System.out.println("***** Account Retrieval ERROR! *****\n***** Account No: " + acN + " does NOT exist! *****");
            // Close connection
            connection.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    } // END selectADB()

    /************* Insert into Database *************/
    public void insertADB(String acN, String cid, String tpe, double bal) {
        AcctNo = acN;
        Cid = cid;
        Type = tpe;
        Balance = bal;
        try {
            // Get connection to database
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for New Account Insert *************");

            // Check if CustID record exists
            if (!acctExists(cid, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Accounts(AcctNo, Cid, Type, Balance) Values(?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, acN);
                pStmt.setString(2, cid);
                pStmt.setString(3, tpe);
                pStmt.setDouble(4, bal);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            }else System.out.println("***** ERROR! ***** Cannot Insert New Record! *****\n***** Account No: " + acN + " already exists! *****");
        } catch (Exception e) { System.out.println("Exception: " + e); }
    } // END insertADB()

    /************* Update Existing Record in Database *************/
    public void updateADB(String acN) {
        AcctNo = acN;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for Update *************");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();

            // Create SQL string
            String sql = "UPDATE Accounts SET "
                    + " Cid = '" + getCid() + "',"
                    + " Type = '" + getAcctType() + "',"
                    + " Balance = '" + getBalance() + "'"
                    + " WHERE AcctNo = '" + getAcctNo() + "'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END updateADB()

    /************* Delete from Database *************/
    public void deleteADB(String acN) {
        AcctNo = acN;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for Delete *************");

            // Prepare SQL string
            String sql = "DELETE FROM Accounts WHERE AcctNo = '" + getAcctNo() + "'";

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
    } // END deleteADB()

    /************* Main Method for Testing *************/
    public static void main(String[] args) {

/** Test code for selectADB()
 **/
        Account a1 = new Account();
        a1.selectADB("90006");
        a1.displayADB();


/** Test code for insertADB()

 Account a2 = new Account();
 a2.insertADB("99900", "3005", "CHK", 300.00);
 a2.displayADB();
 Account a5 = new Account();
 a5.insertADB("10101", "3007", "CHK", 300.00);
 a5.displayADB();
 **/

/** Test UpdateADB()

 Account a4 = new Account();
 a4.selectADB("90001");
 a4.setAcctType("SAV");
 a4.updateADB("90001");
 a4.displayADB();
 **/

/** Test deleteADB()

 Account a3 = new Account();
 a3.selectADB("99900");
 a3.deleteADB("99900");
 **/


    } // END main
} // END class
