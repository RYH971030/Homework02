package hw4_4;

import java.sql.ResultSet;
import java.util.Date;


import util.DBConn;

public class DataQuery {
	
	private static DataQuery dq = new DataQuery();
	
	public static void main(String[] args) {
		dq.dataQuery();
	}
	
	public void dataQuery() {
		
		//û�����������ԼΪ2600ms,��������֮��ԼΪ260ms
		
		String sql = "select * from students where name = '������20000'";
		
		try{
			
			Long begin = new Date().getTime();
			ResultSet rs = DBConn.getStatement().executeQuery(sql);//�õ����ǽ���ļ���
            Long end = new Date().getTime();
            System.out.println("cast:" + (end-begin) + "ms");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float score = rs.getFloat("score");
                System.out.println( "��id��" + id + "\t��name��" + name + "\t��score��" + score);
            }
        }
		catch(Exception e){
            e.printStackTrace();
        }
		
		
		
	}

}
