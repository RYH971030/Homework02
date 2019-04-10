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
		
		//没用索引的情况约为2600ms,建立索引之后约为260ms
		
		String sql = "select * from students where name = '刘建国20000'";
		
		try{
			
			Long begin = new Date().getTime();
			ResultSet rs = DBConn.getStatement().executeQuery(sql);//得到的是结果的集合
            Long end = new Date().getTime();
            System.out.println("cast:" + (end-begin) + "ms");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float score = rs.getFloat("score");
                System.out.println( "【id】" + id + "\t【name】" + name + "\t【score】" + score);
            }
        }
		catch(Exception e){
            e.printStackTrace();
        }
		
		
		
	}

}
