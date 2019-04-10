package hw4_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConn;

public class Main {

	public static void main(String[] args) {
		Main test=new Main();
		
		test.add("尼古拉斯",(float) 60.5);
		test.select("select * from students");
		test.update("尼古拉斯", "尼古拉斯·赵四");
		test.select("select * from students");
		test.del("尼古拉斯·赵四");
		test.select("select * from students");
		
		
		DBConn.close();
	}
	
	public void add(String name,float score) {

		String sql="insert into students(name,score) values('"+name+"','"+score+"')";
 
		try{
          PreparedStatement preStmt=(PreparedStatement)DBConn.getConnection().prepareStatement(sql);
          preStmt.executeUpdate();
          System.out.println("插入数据成功！");
          preStmt.close();
          }
		catch(Exception e){
			e.printStackTrace();
			}
		
	}
	
    public void del(String name){
        String sql="delete from students where name=?";
        try{
            PreparedStatement prestmt=(PreparedStatement)DBConn.getConnection().prepareStatement(sql);
            prestmt.setString(1, name);
            prestmt.executeUpdate();
            System.out.println("删除数据成功！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void update(String name1,String name2){
        
    	String sql="update students set name=? where name=?";
    	
        try{
            
        	PreparedStatement prestmt=(PreparedStatement)DBConn.getConnection().prepareStatement(sql);
            prestmt.setString(1,name2);
            prestmt.setString(2, name1);
            prestmt.executeUpdate();
            
            System.out.println("更改数据成功！");
            prestmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	public void select(String sql) {		
		     
        try{
            ResultSet rs=DBConn.getStatement().executeQuery(sql);//得到的是结果的集合
            while(rs.next()){
                //int id = rs.getInt("id");
                String name = rs.getString("name");
                float score = rs.getFloat("score");
                System.out.println( "【name】" + name + "\t【score】" + score);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
}
