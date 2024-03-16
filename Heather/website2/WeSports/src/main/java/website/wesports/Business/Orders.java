package website.wesports.Business;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Orders Business Object
 * Authors: Heather Papp
 *
 *
 *
 */
import jakarta.persistence.criteria.Order;

import java.sql.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    /************* Properties *************/
    Long OrderID;
    int Quantity;
    String CustEmail, ProductCode, OrderStatus, DistUsername;
    Timestamp OrderDate; // current date and time order is placed
    Date FulfillmentDate; // current date only order is fulfilled
    boolean Exists;


    /************* Constructors *************/
    public Orders(String custEmail, String productCode, int quantity, Timestamp orderDate, String orderStatus, Date fulfillmentDate, String distUsername) {
        this(null, custEmail, productCode, quantity, orderDate, orderStatus, fulfillmentDate, distUsername);
    }
    public Orders(Long orderID, String custEmail, String productCode, int quantity, Timestamp orderDate, String orderStatus, Date fulfillmentDate, String distUsername) {
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
    public void setOrderID(Long orderID) { OrderID = orderID; }
    public Long getOrderID() { return OrderID; }
    //public void setCustEmail(String custEmail) { CustEmail = custEmail; }
    public String getCustEmail() { return CustEmail; }
    //public void setProductCode(String productCode) { ProductCode = productCode; }
    public String getProductCode() { return ProductCode; }
    //public void setQuantity(int quantity) { Quantity = quantity; }
    public int getQuantity() { return Quantity; }
    //public void setOrderDate(Timestamp orderDate) { OrderDate = orderDate; }
    public Timestamp getOrderDate() { return OrderDate; }
    //public void setOrderStatus(String orderStatus) { OrderStatus = orderStatus; }
    public String getOrderStatus() { return OrderStatus; }
    //public void setFulfillmentDate(Date fulfillmentDate) { FulfillmentDate = fulfillmentDate; }
    public Date getFulfillmentDate() { return FulfillmentDate; }
    //public void setDistUsername(String distUsername) { DistUsername = distUsername; }
    public String getDistUsername() { return DistUsername; }
    public void setExists(boolean exists) { Exists = exists; }
    public boolean getExists() { return  Exists; }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("OrderID", OrderID)
                .append("CustEmail", CustEmail)
                .append("ProductCode", ProductCode)
                .append("Quantity", Quantity)
                .append("OrderDate", OrderDate)
                .append("OrderStatus", OrderStatus)
                .append("FulfillmentDate", FulfillmentDate)
                .append("DistUsername", DistUsername)
                .toString();


    }
}
