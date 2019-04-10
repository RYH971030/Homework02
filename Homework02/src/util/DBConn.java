package util;

import java.sql.*;

public class DBConn {
	private static Connection connect;
	private static Statement stmt;
		
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");   //MySQL jdbc驱动加载
		    System.out.println("Success loading Mysql Driver!");
		    }
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		    }
		try {
	    	connect = DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/bbcdb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&autoReconnect=true","root","123456");
	    	System.out.println("Success connect Mysql server!");
	    	stmt= connect.createStatement();
		    }
	    catch (Exception e) {
	    	System.out.print("get data error!");
	    	e.printStackTrace();
	    	}
	}
	
	public static Connection getConnection() {
		return  connect;
	}
	
	public static Statement getStatement() {
		return  stmt;
	}
	
	public static void close() {
		
		if(stmt != null) {
			try {
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(connect != null) {
			try {
				connect.close();
				System.out.println("Success close the connection!");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}
