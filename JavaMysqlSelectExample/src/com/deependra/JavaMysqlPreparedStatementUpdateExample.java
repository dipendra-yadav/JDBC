package com.deependra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JavaMysqlPreparedStatementUpdateExample {

	public static void main(String[] args) {
		try {
			// create a java mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/javabase";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// create the java mysql update preparedstatement
			//String query=update users set num_points = 6000 where id = 2;
			String query = "update users set num_points = ? where first_name = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 6000);
			preparedStmt.setString(2, "Deependra");

			// execute the java preparedstatement
			preparedStmt.executeUpdate();
			System.out.println("Updated sucessfylly********");

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
