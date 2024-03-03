package Papier;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Product Object
 * @author Jason Arnold
 */
public class Product {
    
    final String DBPATH = "jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb";
    String id;
    String name;
    String desc;
    String quantity;
    double price;
    
    //no arg constructor
    public Product()
    {
        id = "";
        name = "";
        desc = "";
        quantity = "";
        price = 0;
    }
    
    //arg constructor
    public Product(String Id, String Name, String Desc, String Quantity, double Price)
    {
        id = Id;
        name = Name;
        desc = Desc;
        quantity = Quantity;
        price = Price;
    }
    
    //setters and getters
    
    public void setId(String Id)
    {
        id = Id;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setName(String Name)
    {
        name = Name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setDesc(String Desc)
    {
        desc = Desc;
    }
    
    public String getDesc()
    {
        return desc;
    }
    
    public void setQuantity(String Quantity)
    {
        quantity = Quantity;
    }
    
    public String getQuantity()
    {
        return quantity;
    }
    
    public void setPrice(double Price)
    {
        price = Price;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    //display method
    public void display()
    {
        System.out.println("Id:                 " +getId());
        System.out.println("Name:               " +getName());
        System.out.println("Desc:               " +getDesc());
        System.out.println("Quantity:           " +getQuantity());
        System.out.println("Price:              $" +getPrice());
    }
    
    //get data from database
    public void selectDB(String Id)
    {
        id = Id;
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Products where id = '" + getId() + "'";
            System.out.println(sql);
            ResultSet result = stmt.executeQuery(sql);
            result.next();
            setId(result.getString("id"));
            setName(result.getString("pname"));
            setDesc(result.getString("pdesc"));
            setQuantity(result.getString("quantity"));
            setPrice(result.getDouble("price"));
            con.close();
            display();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//end selectDB
    
    //add new product to database
    public void insertDB(String Id, String Name, String Desc, String Quantity, Double Price)
    {
        setId(Id);
        setName(Name);
        setDesc(Desc);
        setQuantity(Quantity);
        setPrice(Price);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(DBPATH);
            Statement stmt = conn.createStatement();
            String sql = "Insert into Products (pname, pdesc, quantity, price) values ('" + getName() + "', " +
                                                                                      "'" + getDesc() + "', " +
                                                                                      "'" + getQuantity() + "', " +                                                       
                                                                                      "'" + getPrice() + "')" ;
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("Record inserted Successfully!");
            else
                System.out.println("!!!!!!!!!!!INSERT FAILED!!!!!!!!!!!!!");
            conn.close();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//end insertDB
    
    //update databse for existing product
    public void updateDB(String Id, String Name, String Desc, String Quantity, double Price)
    {
        setId(Id);
        setName(Name);
        setDesc(Desc);
        setQuantity(Quantity);
        setPrice(Price);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Update Products set pname = '" + getName() +  
                         "', desc = " + "'" + getDesc() +  
                         "', quantity = " + "'" + getQuantity() +
                         "', price = " + "'" + getPrice() +
                         "' where id = '" + getId() + "'"; 
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("Record updated Successfully!");
            else
                System.out.println("!!!!!!!!!!!UPDATE FAILED!!!!!!!!!!!!!");
            con.close();
        }
        catch(Exception e1)
        {
            System.out.println(e1);
        }
    }//end updateDB
    
    //remove product from database
    public void deleteDB()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Delete from Products where ID = '" + getId() + "'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("Record Deleted.");
            else
                System.out.println("!!!!!!!!!!DELETE FAILED!!!!!!!!!!");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    //main method
    public static void main(String args[])
    {
        Product p1 = new Product();
        p1.selectDB("1");
        
    }
    
}
