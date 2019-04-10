package hw2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

/*
 * Student类实现Serializable接口
 */
public class Student2 implements Externalizable{

	private String name;
	private double score;
	private String[] addresses;
	
	public Student2(){
		this.name = " 尼古拉斯";
		this.score = 99.5;
		this.addresses = new String [2];
		this.addresses [0] = "住址#1";
		this.addresses [1] = "住址#2";
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public String[] getAddresses() {
		return this.addresses;
	}
	
	public String ToString() {
		return "姓名" + name + "  分数" + score + "  地址" + Arrays.toString(addresses) ;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
        out.writeObject(name);
        out.writeDouble(score);
        out.writeObject(addresses);
		
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		score = in.readDouble();
		addresses = (String[]) in.readObject();
		
	}
	
}