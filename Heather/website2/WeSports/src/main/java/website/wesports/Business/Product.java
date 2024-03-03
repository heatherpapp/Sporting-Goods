package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Product Business Object
 * Authors: Heather Papp
 *
 *
 *
 */

import java.io.File;
import java.sql.*;

/**
 *   Business Object for Product
 * @author Heather Papp
 */

public class Product {

    /************* Database *************/
    final String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final String DBLocation = "jdbc:ucanaccess://C:/WeSportsDB/WeSports.accdb/";

    /************* Properties *************/
    String ProductCode, ProductName, ProductDescription, QuantityPerUnit, AgeGroup, Gender;
    int ProductCategoryID;
    double UnitPrice;

    //ProductPhoto
    /**
     * need to figure out how to retrieve product image from database
     * jlabel.setIcon(new ImageIcon(getScaled(ImageIO.read(new ByteArrayInputStream(((Attachment[])result.getObject("attachment"))[0].getData())),120,120)));

    public void getImage() {
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");







        } catch (Exception e) { System.out.println("Exception" + e); }
    }
     *
     *
     */

    /************* Constructors *************/
    public Product() {
        ProductCode = "";
        ProductName = "";
        ProductDescription = "";
        UnitPrice = 0.00;
        QuantityPerUnit = "";
        ProductCategoryID = 0;
        AgeGroup = "";
        Gender = "";
        //ProductPhoto = attachment???;
    }
    public Product(String productCode, String productName, String productDescription, double unitPrice, String quantityPerUnit, int productCategoryID, String ageGroup, String gender) {
        ProductCode = productCode;
        ProductName = productName;
        ProductDescription = productDescription;
        UnitPrice = unitPrice;
        QuantityPerUnit = quantityPerUnit;
        ProductCategoryID = productCategoryID;
        AgeGroup = ageGroup;
        Gender = gender;
        //ProductPhoto = attachment???;
    }

    /************* Behaviors *************/
    public void setProductCode(String productCode) { ProductCode = productCode; }
    public String getProductCode() { return ProductCode; }
    public void setProductName(String productName) { ProductName = productName; }
    public String getProductName() { return ProductName; }
    public void setProductDescription(String productDescription) { ProductDescription = productDescription; }
    public String getProductDescription() { return ProductDescription; }
    public void setUnitPrice(double unitPrice) { UnitPrice = unitPrice; }
    public double getUnitPrice() { return UnitPrice; }
    public void setQuantityPerUnit(String quantityPerUnit) { QuantityPerUnit = quantityPerUnit; }
    public String getQuantityPerUnit() { return QuantityPerUnit; }
    public void setProductCategoryID(int productCategoryID) { ProductCategoryID = productCategoryID; }
    public int getProductCategoryID() { return ProductCategoryID; }
    public void setAgeGroup(String ageGroup) { AgeGroup = ageGroup; }
    public String getAgeGroup() { return AgeGroup; }
    public void setGender(String gender) { Gender = gender; }
    public String getGender() { return Gender; }

    // public void setProductPhoto(byte productPhoto) { ProductPhoto = productPhoto; }
    // public byte getProductPhoto() { return ProductPhoto; }


    /************* Display *************/
    public void display() {

        System.out.println("Product Code: " + getProductCode());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Description: " + getProductDescription());
        System.out.println("Unit Price" + getUnitPrice());
        System.out.println("Quantity Per Unit: " + getQuantityPerUnit());
        System.out.println("Product CategoryID: " + getProductCategoryID());
        System.out.println("Age Group: " + getAgeGroup());
        System.out.println("Gender: " + getGender());

    }

    /************* Select Product from Database: Products *************/
    public void selectPDB(String productCode) {
        ProductCode = productCode;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            //Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Products WHERE ProductCode = '" + getProductCode() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);

            // Info to retrieve
            rs.next();
            setProductCode(rs.getString("ProductCode"));
            setProductName(rs.getString("ProductName"));
            setProductDescription(rs.getString("ProductDescription"));
            setUnitPrice(rs.getDouble("UnitPrice"));
            setProductCategoryID(rs.getInt("ProductCategoryID"));
            setAgeGroup(rs.getString("AgeGroup"));
            setGender(rs.getString("Gender"));
            connection.close();
            display();
        } catch (Exception e) { System.out.println("Exception" + e); }

    } // END selectPDB

    /************* Insert Product from Database: Products *************/
    public void insertPDB(String productCode, String productName, String productDescription, double unitPrice, int productCategoryID, String ageGroup, String gender) {
        setProductCode(productCode);
        setProductName(productName);
        setProductDescription(productDescription);
        setUnitPrice(unitPrice);
        setProductCategoryID(productCategoryID);
        setAgeGroup(ageGroup);
        setGender(gender);

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!productExists(productCode, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Products(ProductCode, ProductName, ProductDescription, UnitPrice, ProductCategoryID, AgeGroup, Gender) Values(?,?,?,?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, productCode);
                pStmt.setString(2, productName);
                pStmt.setString(3, productDescription);
                pStmt.setDouble(4, unitPrice);
                pStmt.setInt(5, productCategoryID);
                pStmt.setString(6, ageGroup);
                pStmt.setString(7, gender);

                // Execute SQL Statement & Do Insert
                int n = pStmt.executeUpdate();

                // Verify Insert
                if (n == 1) System.out.println("..... INSERT Successful! .....");
                else System.out.println("***** INSERT FAILED! *****");
            } else System.out.println("***** ERROR! ***** Cannot Insert New Record! *****\n***** Customer ID: " + productCode + " already exists! *****");

            // Close connnection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }

    } // END insertPDB

    /************* Update Product from Database: Products *************/
    public void updatePDB(String productCode) {
        ProductCode = productCode;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL statement
            Statement stmt = connection.createStatement();

            // Create SQL string
            String sql = "UPDATE Products SET ProductName = '" + getProductName() + "',"
                    + " ProductDescription = '" + getProductDescription() + "',"
                    + " UnitPrice = '" + getUnitPrice() +"',"
                    + " ProductCategoryID = '" + getProductCategoryID() + "',"
                    + " AgeGroup = '" + getAgeGroup() + "',"
                    + " Gender = '" + getGender() + "'"
                    + " WHERE ProductCode = '" + getProductCode() + "'";

            // Execute SQL Statement & Do Update
            int n = stmt.executeUpdate(sql);
            System.out.println("SQL Statement: " + sql);

            // Verify Insert
            if (n == 1) System.out.println("..... UPDATE Successful! .....");
            else System.out.println("***** UPDATE FAILED! *****");

            // Close Connection
            connection.close();
        } catch (Exception e) { System.out.println("Exception" + e); }
    } // END updatePDB

    /************* Delete Product from Database: Products *************/
    public void deletePDB(String productCode) {
        ProductCode = productCode;
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Prepare SQL string
            String sql = "DELETE FROM Products WHERE ProductCode = '" + getProductCode() + "'";

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
    } // END deletePDB

    /*************Check if Record Exists *************/
    public boolean productExists(String productCode, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Customers WHERE ProductCode = '" + getProductCode() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("Customer ID: " + productCode + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of productExists
        return exists;
    } // END recordExists











}
