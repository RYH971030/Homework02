package hw2;

import java.io.Serializable;

/*
 * Student类实现Serializable接口
 */
public class Student1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double score;
	private String[] addresses;
	
	public Student1(){
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
		return "姓名" + name + "  分数" + score + "  地址" + addresses[0] ;
	}
}
