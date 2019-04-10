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
			//����sql��׺
			StringBuffer sqlSuffix = new StringBuffer();
			//����������Զ��ύ
			DBConn.getConnection().setAutoCommit(false);
			System.out.println("11111111111");
			PreparedStatement pst = DBConn.getConnection().prepareStatement(" ");  
			
            for (int i = 0; i < 100; i++) {  
                // �ڴ��ύ����  
                for (int j = 1; j <= 10000; j++) {  
                    // ����sql��׺  
                    sqlSuffix.append("('������" + (10000 * i + j) + "'," + di.getScore() + "),");  
                }  
                // ��������sql  
                String sql = sqlPrefix + sqlSuffix.substring(0, sqlSuffix.length() - 1);  
                // ���ִ��sql  
                pst.addBatch(sql);  
                // ִ�в���  
                pst.executeBatch();  
                // �ύ����  
                DBConn.getConnection().commit();  
                // �����һ����ӵ�����  
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
		
		float s = (float)Math.random()*99;//��ȡfloat�����������1-100֮��
		BigDecimal decimal=new BigDecimal(s);//�½���ʽ���������ø�ʽ
		s=decimal.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();//��������������Ϊ��λС����floatֵ
		
		return s;
	}

}
