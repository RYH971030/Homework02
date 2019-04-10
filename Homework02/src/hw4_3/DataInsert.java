package hw4_3;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import util.DBConn;

public class DataInsert {
	
	static DataInsert di = new DataInsert();
	
	public static void main(String[] args) {
		di.dataInsert();
	}
	
	public void dataInsert() {
		Long begin = new Date().getTime();
		
		String sqlPrefix = "insert into students(name,score) values ";
		try {
			//保存sql后缀
			StringBuffer sqlSuffix = new StringBuffer();
			//设置事务非自动提交
			DBConn.getConnection().setAutoCommit(false);
			System.out.println("11111111111");
			PreparedStatement pst = DBConn.getConnection().prepareStatement(" ");  
			
            for (int i = 0; i < 100; i++) {  
                // 第次提交步长  
                for (int j = 1; j <= 10000; j++) {  
                    // 构建sql后缀  
                    sqlSuffix.append("('刘建国" + (10000 * i + j) + "'," + di.getScore() + "),");  
                }  
                // 构建完整sql  
                String sql = sqlPrefix + sqlSuffix.substring(0, sqlSuffix.length() - 1);  
                // 添加执行sql  
                pst.addBatch(sql);  
                // 执行操作  
                pst.executeBatch();  
                // 提交事务  
                DBConn.getConnection().commit();  
                // 清空上一次添加的数据  
                sqlSuffix = new StringBuffer();  
            }
            pst.close();
		}
		catch(SQLException e){
			e.printStackTrace();  
		}
		Long end = new Date().getTime();
		System.out.println("cast:" + (end-begin)/1000 + "s");
	}
	
	public float getScore() {
		
		float s = (float)Math.random()*99;//获取float型随机数，在1-100之间
		BigDecimal decimal=new BigDecimal(s);//新建格式化器，设置格式
		s=decimal.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();//将数据四舍五入为两位小数的float值
		
		return s;
	}

}
