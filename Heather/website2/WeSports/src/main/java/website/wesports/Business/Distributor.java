package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Distributor Business Object
 * Authors: Heather Papp
 *
 *
 *
 */

import java.sql.*;

/**
 *   Business Object for Distributor
 * @author Heather Papp
 */

public class Distributor {


    private String DistPass, DistUsername;
    private String DistFirstName, DistLastName, DistEmail;
    final static String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/";

    /************* Constructors *************/
    public Distributor() {
        DistUsername = "";
        DistPass = "";
        DistFirstName = "";
        DistLastName = "";
        DistEmail = "";
    }
    public Distributor(String dun, String dpw, String dfn, String dln, String dem) {
        DistUsername = dun;
        DistPass = dpw;
        DistFirstName = dfn;
        DistLastName = dln;
        DistEmail = dem;
    }

    /************* Behaviors *************/
    public void setDistUsername(String dun) { DistUsername = dun; }
    public String getDistUsername() { return DistUsername; }
    public void setDistPW(String dpw) { DistPass = dpw; }
    public String getDistPW() { return DistPass; }
    public void setDistFname(String dfn) { DistFirstName = dfn; }
    public String getDistFname() { return DistFirstName; }
    public void setDistLname(String dln) { DistLastName = dln; }
    public String getDistLname() { return DistLastName; }
    public void setDistEmail(String dem) { DistEmail = dem; }
    public String getDistEmail() { return DistEmail; }

    /*************Check if Distributor Record Exists *************/
    public boolean Exists;
    public void setExists(boolean exists) { Exists = exists; }
    public boolean getExists() { return  Exists; }
    public boolean distUserNameExists(String dun, Connection connection) {
        Exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Distributor WHERE DistUsername = '" + getDistUsername() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                Exists = true;
                System.out.println("Distributor ID: " + dun + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of recordExists()
        return Exists;
    } // END recordExists()

    /************* Display Results *************/
    public void display() {
        if (DistUsername.isEmpty()) System.out.println("***** You must enter a Distributor Username *****");
        System.out.println("=======================================================");
        System.out.println("Distributor Username: " + getDistUsername());
        System.out.println("Distributor PW: " + getDistPW());
        System.out.println("Distributor FirstName: " + getDistFname());
        System.out.println("Distributor LastName: " + getDistLname());
        System.out.println("Distributor Email: " + getDistEmail());
        //accountList.displayList();
        /**
         * ? Show Order List? Or nothing here???
         */
        System.out.println("=======================================================\n");
    } // END display()

    /************* Get Unfulfilled Orders from Database Orders *************/ //think this goes in Orders
    /*
    public void getOrders() {
        // Accounts > 1AcctNo 2Cid 3Type 4Balance
        try {
            // Get connection to database
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected\n************* Ready for Orders Retrieval *************");

            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders WHERE OrderStatus = Placed;

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


*/
    /************* Select Distributor from Database Distributor *************/
    public void selectDB(String dun) {
        DistUsername = dun;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (distUserNameExists(dun, connection)) {
                //Create SQL statement & string
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM Distributor WHERE DistUsername = '" + getDistUsername() + "'";

                // Execute SQL Query
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL Query: " + sql);

                // Info to retrieve
                rs.next();
                setDistPW(rs.getString(2));
                setDistFname(rs.getString(3));
                setDistLname(rs.getString(4));
                setDistEmail(rs.getString(5));

            } else System.out.println("***** Distributor Retrieval ERROR! ***** \n***** Distributor ID: " + dun + " does NOT exist! *****");
            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
        //getAccounts();
        //getOrders();
    } // END selectDB()

    /************* Insert into Database *************/
    public void insertDB(String dun, String dpw, String dfn, String dln, String dem) {

        DistUsername = dun;
        DistPass = dpw;
        DistFirstName = dfn;
        DistLastName = dln;
        DistEmail = dem;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!distUserNameExists(dun, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Distributor(DistUserName, DistPass, DistFirstName, DistEmail) Values(?,?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, dun);
                pStmt.setString(2, dpw);
                pStmt.setString(3, dfn);
                pStmt.setString(4, dln);
                pStmt.setString(5, dem);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert New Record! *****\n***** Distributor ID: " + dun + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END insertDB()

    /************* Update Existing Record in Database *************/
    public void updateDB(String dun) {
        DistUsername = dun;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();

            // Create SQL string
            String sql = "UPDATE Distributor SET DistPassword = '" + getDistPW() + "',"
                    + " DistFirstName = '" + getDistFname() + "',"
                    + " DistLastName = '" + getDistLname() +"',"
                    + " DistEmail = '" + getDistEmail() + "'"
                    + " WHERE DistUsername = '" + getDistUsername() + "'";

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
    public void deleteDB(String dun) {
        DistUsername = dun;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL string
            String sql = "DELETE FROM Distributor WHERE DistUsername = '" + getDistUsername() + "'";

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


    public static void main(String[] args) {
        Distributor d1 = new Distributor();
        d1.selectDB("hpapp");
        d1.display();
    }
}
