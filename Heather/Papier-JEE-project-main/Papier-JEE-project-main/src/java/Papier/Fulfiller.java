package Papier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Fulfiller Class for CIST Project
 * @author Jason Arnold
 */
public class Fulfiller {
    final String DBPATH = "jdbc:ucanaccess://C://CIST-Team-1-Project//PapierDB.mdb";
    String id;
    String fName;
    String lName;
    String username;
    String password;
    
    //no arg constructor
    public Fulfiller()
    {
        id = "";
        fName = "";
        lName = "";
        username = "";
        password = "";
    }
    
    //arg constructor
    public Fulfiller (String ID, String Fname, String Lname, String User, String Pass)
    {
     id = ID;
     fName = Fname;
     lName = Lname;
     username = User;
     password = Pass;     
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
    
    public void setFName(String Fname)
    {
        fName = Fname;
    }
    
    public String getFName()
    {
        return fName;
    }
    
    public void setLName(String Lname)
    {
        lName = Lname;
    }
    
    public String getLName()
    {
        return lName;
    }
    
    public void setUsername(String User)
    {
        username = User;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPassword(String Pass)
    {
        password = Pass;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    //display fulfiller attributes
    public void display()
    {
    System.out.println("Fulfiller ID:        " + id);
    System.out.println("First Name:          " + fName);
    System.out.println("Last Name:           " + lName);
    System.out.println("Username:            " + username);
    System.out.println("Current Password:    " + password);
    }
    //get fulfiler info from database
    public void selectDB(String Username)
    {
        username = Username;
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);
            Statement stmt = con.createStatement();
            String sql = "Select * from Fulfillers where username = '" + getUsername() + "'";
            System.out.println(sql);
            ResultSet result = stmt.executeQuery(sql);
            result.next();
            setId(result.getString("id"));
            setFName(result.getString("fname"));
            setLName(result.getString("lname"));
            setPassword(result.getString("password"));
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } //end selectDB()
    
    // Add new Fulfiller to database
    public void insertDB(String Fname, String Lname, String Username, String Password)
    {
        //setId(ID);
        setFName(Fname);
        setLName(Lname);
        setUsername(Username);
        setPassword(Password);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(DBPATH);
            Statement stmt = conn.createStatement();
            String sql = "Insert into Fulfillers (fname, lname, username, password) values ('" + getFName() + "', " +
                                                                                           "'" + getLName() + "', " +
                                                                                           "'" + getUsername() + "', " +
                                                                                           "'" + getPassword() + "')" ;
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
    
    // Update Database for existing Fulfiller
    public void updateDB(String Fname, String Lname, String Username, String Password, String Email, String Street, String City, String State, String Zipcode)
    {
        selectDB(Username);
        setFName(Fname);
        setLName(Lname);
        setUsername(Username);
        setPassword(Password);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Update Fulfillers set fname = '" + getFName() +  
                         "', lname = " + "'" + getLName() +  
                         "', username = " + "'" + getUsername() +
                         "', password = " + "'" + getPassword() +
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
    public void deleteDB(String Username)
    {
        selectDB(Username);
        
       
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(DBPATH);            
            Statement stmt = con.createStatement();
            String sql = "Delete from Fulfillers where ID = '" + getId() + "'";
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
    
    public static void main(String args[])
    {
        Fulfiller f1 = new Fulfiller();
        f1.insertDB("Jason", "Arnold", "jason", "arnold");
        f1.selectDB("ptworker");
        f1.selectDB("jason");
        f1.display();
    }
}
