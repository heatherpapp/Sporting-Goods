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
public class Customer {

    private String CustID, CustPass, CustUserName;
    private String CustFirstName, CustLastName, CustAddress, CustEmail;
    final static String DBDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    final static String DBLocation = "jdbc:ucanaccess://C:/Users/heath/OneDrive/Documents/Business/Chatt Tech/JAVA/ChattBank/src/main/resources/ChattBankACCDB.accdb;showSchema=true";


}
