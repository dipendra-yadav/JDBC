package com.deependra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class BasicJDBCDemo {

	Connection conn;

	public BasicJDBCDemo() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/javabase";
			conn = DriverManager.getConnection(url, "root", "");
			doTests();
			conn.close();
		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		new BasicJDBCDemo();
	}

	private void doTests() {
		//doSelectTest();
		

		doSelectTest();
		System.out.println("\n\n--------------");
		//doInsertTest();
		System.out.println("\n\n--------------");
		doUpdateTest();

		//doSelectTest();
		System.out.println("\n\n--------------");
		doDeleteTest();

		//doSelectTest();
	}

	private void doSelectTest() {
		System.out.println("[OUTPUT FROM SELECT]");
		String query = "SELECT *FROM USERS";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String date_created = rs.getString("date_created");
				String is_admin = rs.getString("is_admin");
				int num_points = rs.getInt(6);
				System.out.format("%s,%s,%s,%s,%d\n", first_name, last_name, date_created, is_admin, num_points);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doInsertTest() {
		System.out.print("\n[Performing INSERT] ... ");
		try {
			Statement st = conn.createStatement();
			
		    st.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
	          +"VALUES ('Malshree', 'lastName', true, 1)");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doUpdateTest() {
		System.out.print("\n[Performing UPDATE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE USERS SET first_name='hari' WHERE id=5");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doDeleteTest() {
		System.out.print("\n[Performing DELETE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM USERS WHERE id=5");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
