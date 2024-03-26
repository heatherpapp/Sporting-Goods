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
    final String DBLocation = "jdbc:ucanaccess://C://WeSportsDB//WeSports.accdb/";

    /************* Properties *************/
    String ProductCode, ProductName, ProductDescription; // primary product info
    String AgeGroup, Gender, Department, Section; // search tags
    int Quantity;
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
        Department = "";
        Section = "";
        AgeGroup = "";
        Gender = "";
        Quantity = 0;
        //ProductPhoto = attachment???;
    }
    public Product(String productCode, String productName, String productDescription, double unitPrice, String department, String section, String ageGroup, String gender, int quantity) {
        ProductCode = productCode;
        ProductName = productName;
        ProductDescription = productDescription;
        UnitPrice = unitPrice;
        Department = department;
        Section = section;
        AgeGroup = ageGroup;
        Gender = gender;
        Quantity = quantity;
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
    public void setDepartment(String department) { Department = department; }
    public String getDepartment() { return Department; }
    public void setSection(String section) { Section = section; }
    public String getSection() { return Section; }
    public void setAgeGroup(String ageGroup) { AgeGroup = ageGroup; }
    public String getAgeGroup() { return AgeGroup; }
    public void setGender(String gender) { Gender = gender; }
    public String getGender() { return Gender; }
    public void setQuantity(int quantity) { Quantity = quantity; }
    public int getQuantity() { return  Quantity; }

    // public void setProductPhoto(byte productPhoto) { ProductPhoto = productPhoto; }
    // public byte getProductPhoto() { return ProductPhoto; }


    /************* Display *************/
    public void display() {

        System.out.println("Product Code: " + getProductCode());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Description: " + getProductDescription());
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("Department: " + getDepartment());
        System.out.println("Section: " + getSection());
        System.out.println("Age Group: " + getAgeGroup());
        System.out.println("Gender: " + getGender());
        System.out.println("Quantity: " + getQuantity());

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
            setDepartment(rs.getString("Department"));
            setSection(rs.getString("Section"));
            setAgeGroup(rs.getString("AgeGroup"));
            setGender(rs.getString("Gender"));
            setQuantity(rs.getInt("Quantity"));
            connection.close();
            display();
        } catch (Exception e) { System.out.println("Exception" + e); }

    } // END selectPDB

    /************* Insert Product from Database: Products *************/
    public void insertPDB(String productCode, String productName, String productDescription, double unitPrice, String department, String section, String ageGroup, String gender, int quantity) {
        setProductCode(productCode);
        setProductName(productName);
        setProductDescription(productDescription);
        setUnitPrice(unitPrice);
        setDepartment(department);
        setSection(section);
        setAgeGroup(ageGroup);
        setGender(gender);
        setQuantity(quantity);

        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            // Check if CustID record exists
            if (!productExists(productCode, connection)) {
                // Create SQL string
                String sql = "INSERT INTO Products(ProductCode, ProductName, ProductDescription, UnitPrice, Department, Section, AgeGroup, Gender, Quantity) Values(?,?,?,?,?,?,?,?,?)";

                // Prepare SQL statement
                PreparedStatement pStmt = connection.prepareStatement(sql);
                System.out.println("SQL Statement: " + sql);

                // Info to insert
                pStmt.setString(1, productCode);
                pStmt.setString(2, productName);
                pStmt.setString(3, productDescription);
                pStmt.setDouble(4, unitPrice);
                pStmt.setString(5, department);
                pStmt.setString(6, section);
                pStmt.setString(7, ageGroup);
                pStmt.setString(8, gender);
                pStmt.setInt(9, quantity);

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
            String sql = "UPDATE Products SET ProductName= '" + getProductName() + "',"
                    + " ProductDescription = '" + getProductDescription() + "',"
                    + " UnitPrice = '" + getUnitPrice() +"',"
                    + " Department = '" + getDepartment() + "',"
                    + " Section = '" + getSection() + "',"
                    + " AgeGroup = '" + getAgeGroup() + "',"
                    + " Gender = '" + getGender() + "',"
                    + " Quantity = '" + getQuantity() + "'"
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
            String sql = "DELETE FROM Products WHERE ProductCode= '" + getProductCode() + "'";

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

    /*************Check if Product Exists *************/
    public boolean productExists(String productCode, Connection connection) {
        boolean exists = false;
        try {
            // Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Products WHERE ProductCode= '" + getProductCode() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);

            // Check if CustID record exists
            if (rs.next()) {
                if(rs.getInt(1) != 0) exists = true;
                System.out.println("ProductCode: " + productCode + " Exists");
            }
        } catch (Exception e) { System.out.println("Exception: " + e); }
        // Return boolean result of productExists
        return exists;
    } // END recordExists

    public void searchProducts(String query) {
        //SELECT * FROM Products WHERE ProductCode=" +query+
        //  OR ProductName LIKE '%" +query+ "%'
        //  OR ProductDescription LIKE '%" +query+ "%'
        //  OR Department LIKE '%" +query+ "%'
        //  OR Section LIKE '%" +query+ "%'
        //  OR Age Group LIKE '%" +query+ "%'
        //  OR Gender LIKE '%" +query+ "%'"
    }

    public void getDeptProducts(String dept) {
        //like getAccounts from Customer in Chatt Bank, but for a list of all products in given department
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            //Create SQL statement & string
            Statement stmt = connection.createStatement();
            String sql = "SELECT ProductCode FROM Products WHERE Department = '" + getDepartment() + "'";

            // Execute SQL Query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Query: " + sql);
            String deptName;
            Product p1;

            while (rs.next()) {


            }
            connection.close();

                setProductCode(rs.getString("ProductCode"));
                setProductName(rs.getString("ProductName"));
                setProductDescription(rs.getString("ProductDescription"));
                setUnitPrice(rs.getDouble("UnitPrice"));
                setDepartment(rs.getString("Department"));
                setSection(rs.getString("Section"));
                setAgeGroup(rs.getString("AgeGroup"));
                setGender(rs.getString("Gender"));
                setQuantity(rs.getInt("Quantity"));
                connection.close();
                display();

        } catch (Exception e) { System.out.println("Exception" + e); }
    }

    public static void main(String[] args) {
        Product p1 = new Product();
        p1.selectPDB("002272904");
        //p1.selectDept("Baseball");
        //p1.display();
    }
}
