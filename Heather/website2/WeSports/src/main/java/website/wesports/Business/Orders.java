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
import jakarta.persistence.criteria.Order;

import java.sql.*;

/**
 *   Business Object for Orders
 * @author Heather Papp
 */
public class Orders {
    /************* Database *************/
    /**
     * Database Column Names, Type, and Order
     * OrderID : autonumber
     * CustEmail : short text
     * ProductCode : short text
     * Quantity : number
     * OrderDate : Date/Time
     * OrderStatus : short text
     * FulfillmentDate : Date/Time
     * DistUsername : short text
     */
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb;showSchema=true";

    /************* Properties *************/
    int OrderID, Quantity;
    String CustEmail, ProductCode, OrderStatus, DistUsername;
    Timestamp OrderDate; // current date and time order is placed
    Date FulfillmentDate; // current date only order is fulfilled
    boolean Exists;


    /************* Constructors *************/
    public Orders(){
        OrderID = 0;
        CustEmail = "";
        ProductCode = "";
        Quantity = 0;
        OrderDate = ;
        OrderStatus = "";
        FulfillmentDate = ;
        DistUsername = "";
    }
    public Orders(int orderID, String custEmail, String productCode, int quantity, Timestamp orderDate, String orderStatus, Date fulfillmentDate, String distUsername) {
        OrderID = orderID;
        CustEmail = custEmail;
        ProductCode = productCode;
        Quantity = quantity;
        OrderDate = orderDate;
        OrderStatus = orderStatus;
        FulfillmentDate = fulfillmentDate;
        DistUsername = distUsername;
    }

    /************* Behaviors *************/
    public void setOrderID(int orderID) { OrderID = orderID; }
    public int getOrderID() { return OrderID; }
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    public void setProductCode(String productCode) { ProductCode = productCode; }
    public String getProductCode() { return ProductCode; }
    public void setQuantity(int quantity) { Quantity = quantity; }
    public int getQuantity() { return Quantity; }
    public void setOrderDate(Timestamp orderDate) { OrderDate = orderDate; }
    public Timestamp getOrderDate() { return OrderDate; }
    public void setOrderStatus(String orderStatus) { OrderStatus = orderStatus; }
    public String getOrderStatus() { return OrderStatus; }
    public void setFulfillmentDate(Date fulfillmentDate) { FulfillmentDate = fulfillmentDate; }
    public Date getFulfillmentDate() { return FulfillmentDate; }
    public void setDistUsername(String distUsername) { DistUsername = distUsername; }
    public String getDistUsername() { return DistUsername; }
    public void setExists(boolean exists) { Exists = exists; }
    public boolean getExists() { return  Exists; }

    /*************Check if Order Record Exists *************/
    public boolean orderExists(int oid, Connection connection) {
        Exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders WHERE OrderID = '" + getOrderID() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) Exists = true;
                System.out.println("Customer ID: " + oid + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of recordExists()
        return Exists;
    } // END orderExists


    /************* Display Results *************/
    public void display() {
        if (OrderID == 0) System.out.println("!!!!! You must enter an OrderID !!!!!");
        System.out.println("=======================================================");
        System.out.println("OrderID\tCustEmail\t\t\tProductCode\tQuantity\tOrderDate\tOrderStatus\tFulfillmentDate\tDistUsername\n");
        /**
         * each OrderID may have multiple entries, due to each row in orderID representing one item set in an order
         * perhaps a foreach loop here to show column headers above, then loop through each order?
         */
        System.out.println(getOrderID()+getCustEmail()+getProductCode()+getQuantity()+getOrderDate()+getOrderStatus()+getFulfillmentDate()+getDistUsername());
        System.out.println("=======================================================\n");
    }

    /************* SELECT All Orders from Database: Orders : ORDER BY OrderID *************/
    //All orders, sorted by OrderID
    public void selectAllOrders() {
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            //Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders ORDER BY OrderID";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);

            // Info to retrieve
            rs.next();

            setOrderID(rs.getInt("OrderID"));
            setCustEmail(rs.getString("CustEmail"));
            setProductCode(rs.getString("ProductCode"));
            setQuantity(rs.getInt("Quantity"));
            setOrderDate(rs.getTimestamp("OrderDate"));
            setOrderStatus(rs.getString("OrderStatus"));
            setFulfillmentDate(rs.getDate("FulfillmentDate"));
            setDistUsername(rs.getString("DistUsername"));

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } //END selectAllOrders

    /************* SELECT All Open Orders from Database: Orders *************/
    // OrderStatus = Open
    public void selectOpenOrders() {
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            //System.out.println("Database Connected");

            //Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders WHERE OrderStatus=Open";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);

            // Info to retrieve
            rs.next();

            setOrderID(rs.getInt("OrderID"));
            setCustEmail(rs.getString("CustEmail"));
            setProductCode(rs.getString("ProductCode"));
            setQuantity(rs.getInt("Quantity"));
            setOrderDate(rs.getTimestamp("OrderDate"));
            setOrderStatus(rs.getString("OrderStatus"));
            setFulfillmentDate(rs.getDate("FulfillmentDate"));
            setDistUsername(rs.getString("DistUsername"));

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } //END selectPendingOrders


    /************* SELECT All Shipped Orders from Database: Orders *************/
    // OrderStatus = Shipped
    public void selectShippedOrders() {
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            //System.out.println("Database Connected");

            //Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Orders WHERE OrderStatus=Shipped";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);

            // Info to retrieve
            rs.next();

            setOrderID(rs.getInt("OrderID"));
            setCustEmail(rs.getString("CustEmail"));
            setProductCode(rs.getString("ProductCode"));
            setQuantity(rs.getInt("Quantity"));
            setOrderDate(rs.getTimestamp("OrderDate"));
            setOrderStatus(rs.getString("OrderStatus"));
            setFulfillmentDate(rs.getDate("FulfillmentDate"));
            setDistUsername(rs.getString("DistUsername"));

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } //END selectCompleteOrders



    /************* INSERT New Order into Database: Orders *************/
    public void insertNewOrder(int orderID, String custEmail, String productCode, int quantity, Timestamp orderDate, String orderStatus, Date fulfillmentDate, String distUsername) {
        setOrderID(orderID);
        setCustEmail(custEmail);
        setProductCode(productCode);
        setQuantity(quantity);
        setOrderDate(orderDate);
        setOrderStatus(orderStatus); 
        setFulfillmentDate(fulfillmentDate);
        setDistUsername(distUsername);

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!orderExists(orderID, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Orders(OrderID, CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername) Values(?,?,?,?,?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setInt(1, OrderID);
                pStmt.setString(2, CustEmail);
                pStmt.setString(3, ProductCode);
                pStmt.setInt(4, Quantity);
                pStmt.setTimestamp(5, OrderDate);
                pStmt.setString(6, OrderStatus);
                pStmt.setDate(7, FulfillmentDate);
                pStmt.setString(8, DistUsername);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert NEW Customer! *****\n***** Customer Email: " + custEmail + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } //END insertNewOrder

    /**
     * NO UPDATE --- Orders placed are not to be modified --- Cancel/Delete ONLY
     */

    /************* DELETE Selected Order from Database: Orders *************/
    public void deleteOrder() {

    }

}
