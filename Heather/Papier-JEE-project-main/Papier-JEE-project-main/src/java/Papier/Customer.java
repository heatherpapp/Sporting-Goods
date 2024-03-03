package Papier;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * Customer class for CIST 2931 project
 * @author Jason Arnold
 */
public class Customer {
    final String DBPATH = "jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb";
    String id;
    String fName;
    String lName;
    String username;
    String password;
    String email;
    String street;
    String city;
    String state;
    String zipcode;
    ProductList cart;
    ProductList order;
    
    // no arg constructor
    public Customer()
    {
        id = "";
        fName = "";
        lName = "";
        username = "";
        password = "";
        email = "";
        street = "";
        city = "";
        state = "";
        zipcode = "";
        order = new ProductList();
        
    }
    
    // arg constructor
    public Customer(String Id, String Fname, String Lname, String Username, String Password, String Email, String Street, String City, String State, String Zipcode, ProductList Order)
    {
        id = Id;
        fName = Fname;
        lName = Lname;
        username = Username;
        password = Password;
        email = Email;
        street = Street;
        city = City;
        state = State;
        zipcode = Zipcode;
        order = Order;
    }
    
    
        //setters and getters
    public void setId(String ID)
    {
        id = ID;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setFname(String Fname)
    {
        fName = Fname;
    }
    
    public String getFname()
    {
        return fName;
    }
    
    public void setLname(String Lname)
    {
        lName = Lname;
    }
    
    public String getLname()
    {
        return lName;
    }
    
    public void setUsername(String Username)
    {
        username = Username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPassword(String Password)
    {
        password = Password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setEmail(String Email)
    {
        email = Email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setStreet(String Street)
    {
        street = Street;
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public void setCity(String City)
    {
        city = City;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setState(String State)
    {
        state = State;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setZipcode(String Zipcode)
    {
        zipcode = Zipcode;
    }
    
    public String getZipcode()
    {
        return zipcode;
    }
    
    public ProductList getCart()
    {
        return cart;
    }
    
    public ProductList getOrder()
    {
        return order;
    }
    
    
    // display method
    public void display()
    {
        System.out.println("ID:              " + getId());
        System.out.println("First Name:      " + getFname());
        System.out.println("Last Name:       " + getLname());
        System.out.println("Username:        " + getUsername());
        System.out.println("Password:        " + getPassword());
        System.out.println("Street Address:  " + getStreet());
        System.out.println("City:            " + getCity());
        System.out.println("State:           " + getState());
        System.out.println("Zip Code         " + getZipcode());
        System.out.println("Current Cart");
        cart.displayList();
        System.out.println("Current Order pending shipping");
        order.displayList();
    }
    
    // fill attributes from database
    public void selectDB(String Username)
    {
        username = Username;
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Customers where username = '" + username + "'";
            System.out.println(sql);
            ResultSet result = stmt.executeQuery(sql);
            result.next();
            setId(result.getString("id"));
            setFname(result.getString("fname"));
            setLname(result.getString("lname"));
            setPassword(result.getString("password"));
            setEmail(result.getString("email"));
            setStreet(result.getString("street"));
            setCity(result.getString("city"));
            setState(result.getString("state"));
            setZipcode(result.getString("zipcode"));
            con.close();
            getCartDB();
            getOrderDB();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } //end selectDB()
    
    // fill attributes from database using id
    public void selectDBID(String ID)
    {
        id = ID;
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Customers where id = '" + getId() + "'";
            System.out.println(sql);
            ResultSet result = stmt.executeQuery(sql);
            result.next();
            setUsername(result.getString("username"));
            setFname(result.getString("fname"));
            setLname(result.getString("lname"));
            setPassword(result.getString("password"));
            setEmail(result.getString("email"));
            setStreet(result.getString("street"));
            setCity(result.getString("city"));
            setState(result.getString("state"));
            setZipcode(result.getString("zipcode"));
            con.close();
            getCartDB();
            getOrderDB();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } //end selectDB()
    
    // Add new customer to database
    public void insertDB(String Fname, String Lname, String Username, String Password, String Email, String Street, String City, String State, String Zipcode)
    {
        setFname(Fname);
        setLname(Lname);
        setUsername(Username);
        setPassword(Password);
        setEmail(Email);
        setStreet(Street);
        setCity(City);
        setState(State);
        setZipcode(Zipcode);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(DBPATH);
            Statement stmt = conn.createStatement();
            String sql = "Insert into Customers (fname, lname, username, password, email, street, city, state, zipcode) values ('" + getFname() + "', " +
                                                                                                                               "'" + getLname() + "', " +
                                                                                                                               "'" + getUsername() + "', " +
                                                                                                                               "'" + getPassword() + "', " +
                                                                                                                               "'" + getEmail() + "', " +
                                                                                                                               "'" + getStreet() + "', " +
                                                                                                                               "'" + getCity() + "', " +
                                                                                                                               "'" + getState() + "', " +
                                                                                                                               "'" + getZipcode() + "')" ;
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
        
    } //end insertDB()
    
    
    // Update Database for existing customer
    public void updateDB(String Fname, String Lname, String Username, String Password, String Email, String Street, String City, String State, String Zipcode)
    {
        selectDB(Username);
        setFname(Fname);
        setLname(Lname);
        setUsername(Username);
        setPassword(Password);
        setEmail(Email);
        setStreet(Street);
        setCity(City);
        setState(State);
        setZipcode(Zipcode);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Update Customers set fname = '" + getFname() +  
                         "', lname = " + "'" + getLname() +  
                         "', username = " + "'" + getUsername() +
                         "', password = " + "'" + getPassword() +
                         "', street = " + "'" + getStreet() +  
                         "', city = " + "'" + getCity() +  
                         "', state = " + "'" + getState() + 
                         "', zipcode = "+ "'" + getZipcode() +
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
    } //end updateDB()
    
    //remove customer from datanase
    public void deleteDB()
    {
         
       
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Delete from Customers where ID = '" + getId() + "'";
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
      
    }//end deleteDB()
    
    //retrieve current cart
    public void getCartDB()
    {
        cart = new ProductList();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Carts where customerId = '" + getId() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            Product p1;
            while (rs.next())
                    {
                        p1 = new Product();
                        p1.selectDB(rs.getString("productid"));
                        p1.setQuantity(rs.getString("quantity"));
                        cart.addProducts(p1);
                    }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//end getCart() 

    //retrieve current order
    public void getOrderDB()
    {
        order = new ProductList();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Orders where customerId = '" + getId() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            Product p1;
            while (rs.next())
                    {
                        p1 = new Product();
                        p1.selectDB(rs.getString("productid"));
                        p1.setQuantity(rs.getString("quantity"));
                        order.addProducts(p1);
                    }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        Customer c1 = new Customer();
        c1.selectDB("bigjimslade@email.com");
        c1.display();
    }
}
