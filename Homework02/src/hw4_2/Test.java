package hw4_2;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC�������� 
			System.out.println("Success loading Mysql Driver!");
		     }
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
			}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bbcdb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","123456");
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

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
