package hw2;

import java.io.Serializable;

/*
 * Student类实现Serializable接口
 */
public class Student2 implements Serializable{

	private String name;
	private double score;
	private String[] addresses;
	
	Student2(){
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
	
}