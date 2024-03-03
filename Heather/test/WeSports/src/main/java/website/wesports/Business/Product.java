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

    public void selectDB(String productCode) {

    }

    public void insertDB() {

    }

    public void updateDB() {

    }

    public void deleteDB() {

    }













}
