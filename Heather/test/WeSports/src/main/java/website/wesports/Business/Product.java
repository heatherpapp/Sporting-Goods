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
    int ProductID, ProductCategoryID;
    String ProductCode, ProductName, ProductDescription, QuantityPerUnit, AgeGroup, Gender;
    double UnitPrice;


    public void getImage() {
        try {
            // Get connection to database
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBLocation);
            System.out.println("Database Connected");

            File file = new File()





        } catch (Exception e) { System.out.println("Exception" + e); }
    }


}
