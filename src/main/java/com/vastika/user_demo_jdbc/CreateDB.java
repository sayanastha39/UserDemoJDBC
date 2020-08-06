package com.vastika.user_demo_jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		String qry = "create database user_db";
		
		try {
			//1. register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. get connection object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=UTC", "root", "TapHouse123");
			
			//3.get statement object
			st = con.createStatement();
			
			//4.execute query
			st.executeUpdate(qry);
			System.out.println("Database created!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				//5. Close the connection
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
