package com.deependra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//NSERT example (using Statement)
public class JavaMysqlInsertExample {
	public static void main(String[] args)
	  {
	    try
	    {
	      // create a mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/javabase";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      Statement st = conn.createStatement();

	      // note that i'm leaving "date_created" out of this insert statement
	      st.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
	          +"VALUES ('Malshree', 'lastName', true, 9000)");

	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }

	  }
}
