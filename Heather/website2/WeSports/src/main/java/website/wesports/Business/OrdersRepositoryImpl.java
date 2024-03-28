package website.wesports.Business;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Order Repository Implementation
 * Authors: Heather Papp
 *
 *
 *
 */
import website.wesports.Business.Orders;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *   OrdersRepository Implementation for Orders
 * @author Heather Papp
 */
public class OrdersRepositoryImpl implements OrdersRepository {
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/";
    private static final String FIND_ALL_SQL = "SELECT OrderID, CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername";
    private static final String INSERT_SQL = "INSERT INTO Orders(CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername) values(?,?,?,?,?,?,?)";
    private Connection connection;

    public OrdersRepositoryImpl(DriverManager driverManager) throws SQLException {
        this.connection = driverManager.getConnection(DBLocation);
    }

    public OrdersRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> result = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
            while (rs.next()) {
                Long OrderID = rs.getLong("OrderID");
                String CustEmail = rs.getString("CustEmail");
                String ProductCode = rs.getString("ProductCode");
                int Quantity = rs.getInt("Quantity");
                Timestamp OrderDate = rs.getTimestamp("OrderDate");
                String OrderStatus = rs.getString("OrderStatus");
                Date FulfillmentDate = rs.getDate("FulfillmentDate");
                String DistUsername = rs.getString("DistUsername");
                result.add(new Orders(OrderID, CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername));
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Orders orders) {
        if (orders != null) {
            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, orders.getCustEmail());
                ps.setString(2, orders.getProductCode());
                ps.setInt(3, orders.getQuantity());
                ps.setTimestamp(4, orders.getOrderDate());
                ps.setString(5, orders.getOrderStatus());
                ps.setDate(6, orders.getFulfillmentDate());
                ps.setString(7, orders.getDistUsername());
                int numRowsAffected = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        orders.setOrderID(rs.getLong(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * Original way of accessing and inserting to database below
 * Testing alternative above
 */
//
//    /*************Check if Order Record Exists *************/
//    public boolean orderExists(Long oid, Connection connection) {
//        Exists = false;
//        try {
//            // Create SQL statement & string
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT * FROM Orders WHERE OrderID = '" + getOrderID() + "'";
//
//            // Execute SQL Query
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // Check if CustID record exists
//            if (rs.next()) {
//                if(rs.getInt(1) != 0) Exists = true;
//                System.out.println("Customer ID: " + oid + " Exists");
//            }
//        } catch (Exception e) { System.out.println("Exception: " + e); }
//        // Return boolean result of recordExists()
//        return Exists;
//    } // END orderExists
//
//
//    /************* Display Results *************/
//    public void display() {
//        if (OrderID == 0) System.out.println("!!!!! You must enter an OrderID !!!!!");
//        System.out.println("=======================================================");
//        System.out.println("OrderID\tCustEmail\t\t\tProductCode\tQuantity\tOrderDate\tOrderStatus\tFulfillmentDate\tDistUsername\n");
//        /**
//         * each OrderID may have multiple entries, due to each row in orderID representing one item set in an order
//         * perhaps a foreach loop here to show column headers above, then loop through each order?
//         */
//        System.out.println(getOrderID()+getCustEmail()+getProductCode()+getQuantity()+getOrderDate()+getOrderStatus()+getFulfillmentDate()+getDistUsername());
//        System.out.println("=======================================================\n");
//    }
//
//    /************* SELECT All Orders from Database: Orders : ORDER BY OrderID *************/
//    //All orders, sorted by OrderID
//    public void selectAllOrders() {
//        try {
//            // Get connection to database
//            Class.forName(DBDriver);
//            Connection connection = DriverManager.getConnection(DBLocation);
//            System.out.println("Database Connected");
//
//            //Create SQL statement & string
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT * FROM Orders ORDER BY OrderID";
//
//            // Execute SQL Query
//            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println("SQL Query: " + sql);
//
//            // Info to retrieve
//            rs.next();
//
//            setOrderID(rs.getLong("OrderID"));
//            setCustEmail(rs.getString("CustEmail"));
//            setProductCode(rs.getString("ProductCode"));
//            setQuantity(rs.getInt("Quantity"));
//            setOrderDate(rs.getTimestamp("OrderDate"));
//            setOrderStatus(rs.getString("OrderStatus"));
//            setFulfillmentDate(rs.getDate("FulfillmentDate"));
//            setDistUsername(rs.getString("DistUsername"));
//
//            // Close Connection
//            connection.close();
//        } catch (Exception e) { System.out.println("Exception" + e); }
//    } //END selectAllOrders
//
//    /************* SELECT All Open Orders from Database: Orders *************/
//    // OrderStatus = Open
//    public void selectOpenOrders() {
//        try {
//            // Get connection to database
//            Class.forName(DBDriver);
//            Connection connection = DriverManager.getConnection(DBLocation);
//            //System.out.println("Database Connected");
//
//            //Create SQL statement & string
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT * FROM Orders WHERE OrderStatus=Open";
//
//            // Execute SQL Query
//            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println("SQL Query: " + sql);
//
//            // Info to retrieve
//            rs.next();
//
//            setOrderID(rs.getLong("OrderID"));
//            setCustEmail(rs.getString("CustEmail"));
//            setProductCode(rs.getString("ProductCode"));
//            setQuantity(rs.getInt("Quantity"));
//            setOrderDate(rs.getTimestamp("OrderDate"));
//            setOrderStatus(rs.getString("OrderStatus"));
//            setFulfillmentDate(rs.getDate("FulfillmentDate"));
//            setDistUsername(rs.getString("DistUsername"));
//
//            // Close Connection
//            connection.close();
//        } catch (Exception e) { System.out.println("Exception" + e); }
//    } //END selectPendingOrders
//
//
//    /************* SELECT All Shipped Orders from Database: Orders *************/
//    // OrderStatus = Shipped
//    public void selectShippedOrders() {
//        try {
//            // Get connection to database
//            Class.forName(DBDriver);
//            Connection connection = DriverManager.getConnection(DBLocation);
//            //System.out.println("Database Connected");
//
//            //Create SQL statement & string
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT * FROM Orders WHERE OrderStatus=Shipped";
//
//            // Execute SQL Query
//            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println("SQL Query: " + sql);
//
//            // Info to retrieve
//            rs.next();
//
//            setOrderID(rs.getLong("OrderID"));
//            setCustEmail(rs.getString("CustEmail"));
//            setProductCode(rs.getString("ProductCode"));
//            setQuantity(rs.getInt("Quantity"));
//            setOrderDate(rs.getTimestamp("OrderDate"));
//            setOrderStatus(rs.getString("OrderStatus"));
//            setFulfillmentDate(rs.getDate("FulfillmentDate"));
//            setDistUsername(rs.getString("DistUsername"));
//
//            // Close Connection
//            connection.close();
//        } catch (Exception e) { System.out.println("Exception" + e); }
//    } //END selectCompleteOrders
//
//
//
//    /************* INSERT New Order into Database: Orders *************/
//    public void insertNewOrder(Long orderID, String custEmail, String productCode, int quantity, Timestamp orderDate, String orderStatus, Date fulfillmentDate, String distUsername) {
//        setOrderID(orderID);
//        setCustEmail(custEmail);
//        setProductCode(productCode);
//        setQuantity(quantity);
//        setOrderDate(orderDate);
//        setOrderStatus(orderStatus);
//        setFulfillmentDate(fulfillmentDate);
//        setDistUsername(distUsername);
//
//        try {
//            // Get connection to database
//            Class.forName(DBDriver);
//            Connection connection = DriverManager.getConnection(DBLocation);
//            System.out.println("Database Connected");
//
//            // Check if CustID record exists
//            if (!orderExists(orderID, connection)) {
//                // Create SQL string
//                //String sql = "INSERT INTO Orders(OrderID, CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername) Values(?,?,?,?,?,?,?,?)";
//                String sql = "INSERT INTO Orders(CustEmail, ProductCode, Quantity, OrderDate, OrderStatus, FulfillmentDate, DistUsername) Values(?,?,?,?,?,?,?)";
//
//                // Prepare SQL statement
//                PreparedStatement pStmt = connection.prepareStatement(sql);
//                System.out.println("SQL Statement: " + sql);
//
//                // Info to insert
//                //pStmt.setInt(1, null); //autonumber, set empty
//                pStmt.setString(2, CustEmail); //get from Cart
//                pStmt.setString(3, ProductCode); //get from Cart
//                pStmt.setInt(4, Quantity); //get from Cart
//                pStmt.setTimestamp(5, OrderDate); //set this to current Date & Time in ddmmyyyy 00:00 format
//                pStmt.setString(6, "Open"); //set to OPEN, this is a new order
//                pStmt.setDate(7, FulfillmentDate); //set empty, order is OPEN
//                pStmt.setString(8, ""); //set empty, order is OPEN, no one has SHIPPED yet
//
//                // Execute SQL Statement & Do Insert
//                int n = pStmt.executeUpdate();
//
//                // Verify Insert
//                if (n == 1) System.out.println("..... INSERT Successful! .....");
//                else System.out.println("***** INSERT FAILED! *****");
//            } else System.out.println("***** ERROR! ***** Cannot Insert NEW Customer! *****\n***** Customer Email: " + custEmail + " already exists! *****");
//
//            // Close connnection
//            connection.close();
//        } catch (Exception e) { System.out.println("Exception" + e); }
//    } //END insertNewOrder
//
//    /**
//     * NO UPDATE --- Orders placed are not to be modified --- Cancel/Delete ONLY
//     */
//
//    /************* DELETE Selected Order from Database: Orders *************/
//    public void deleteOrder() {
//
//    }


