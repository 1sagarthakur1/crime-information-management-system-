package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GetConnectionFromDBMS {
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle rBundle = ResourceBundle.getBundle("dbdetails");
		drivername = rBundle.getString("db.drivername");
		url        = rBundle.getString("db.url");
		username   = rBundle.getString("db.username");
		password   = rBundle.getString("db.password");
	}
	
	public static Connection tackConnection() {
		Connection connection = null;
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
//		String url	 = "jdbc:mysql://localhost:3306/crims";
		
		try {
		  connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
