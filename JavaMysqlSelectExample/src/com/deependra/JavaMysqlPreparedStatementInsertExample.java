package com.deependra;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class JavaMysqlPreparedStatementInsertExample {

	public static void main(String[] args) {
		
		
		try
	    {
	      // create a mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/javabase";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      Calendar calendar = Calendar.getInstance();
	      //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	      Date startDate=new Date(calendar.getTime().getTime());

	      // the mysql insert statement
	      String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
	        + " values (?, ?, ?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, "Anuradha");
	      preparedStmt.setString (2, "Lastname");
	      preparedStmt.setDate   (3, startDate);
	      preparedStmt.setBoolean(4, false);
	      preparedStmt.setInt    (5, 5000);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      System.out.println("record inserted sucessfully*******");
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }
		
		
	}

