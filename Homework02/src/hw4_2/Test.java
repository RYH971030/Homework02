package hw4_2;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序 
			System.out.println("Success loading Mysql Driver!");
		     }
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
			}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bbcdb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","123456");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				}
			}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
			}
	}
	
}
