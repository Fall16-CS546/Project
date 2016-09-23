package com.service.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDML {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/groupdiscussion";
	
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
public String insert(UserDetails user) {
	Connection conn = null;
	Statement stmt = null;
    
	try {  
		//STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		
	    //STEP 3: Open a connection
	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    ResultSet rs = stmt.executeQuery("SELECT Count(id) FROM userregistration WHERE userEmail ="+user.getEmail());
	    if(rs.getInt(1) == 0){
	         //Retrieve by column name
	          return "Email already exists.";
	   }
	    else {
	    	//Get the count of no.of users in the database.
		    String sqlForUserCount = "SELECT COUNT(Id) FROM userregistration";
		    System.out.println(sqlForUserCount);
		    rs = stmt.executeQuery(sqlForUserCount);
		    
		    System.out.println("ResultSet: "+rs);
		    int id = 1;
		   //STEP 5: Extract data from result set
		   while(rs.next()){
		         //Retrieve by column name
		          id = rs.getInt(1)+1;
		   }
		    String sql;
		    
		    sql = "INSERT INTO userregistration " + "VALUES ("+id+","+"'"+user.getName()+"'"+","+"'"+user.getPhone()+"'"+","+"'"+user.getEmail()+"'"+","+"'"+user.getPassword()+"'"+")";
		    System.out.println(sql);
		    stmt.executeUpdate(sql);
		    return "Signup Success!";
	    }
	    

    } catch (Exception  e) {
    	//Handle errors for JDBC
			e.printStackTrace();
		}
	return "Operation Failed";
	}
}
