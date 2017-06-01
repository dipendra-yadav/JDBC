package com.deependra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JavaMysqlDeleteExample {

public static void main(String[] args) {
		
		
		try
	    {
	      // create the mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/javabase";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "2", which corresponds to my
	      // "Malashree" record.
	      String query = "delete from users where id = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt(1, 3);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      System.out.println("Record deleted**********");
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }

	  }
		
		
	}

