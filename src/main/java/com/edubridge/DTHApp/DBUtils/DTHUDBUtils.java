package com.edubridge.DTHApp.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DTHUDBUtils {
	public static Connection getConnection() {
		Connection con=null;
		String driver="com.mysql.cj.jdbc.Driver";
	   String  url ="jdbc:mysql://localhost:3306/db11976";
		String user="root";
		String password="root";
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}try {
			con=DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return con;
		
	}

}

