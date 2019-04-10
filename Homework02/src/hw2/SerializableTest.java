package hw2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
	
	public static final String FILE = "student1.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Student1 s1 = new Student1();
		System.out.println("序列化之前：" + s1);
		
		SerializableTest.WriteObject(FILE, s1);
		SerializableTest.ReadObject(FILE);
		System.out.println("序列化之前：" + s1);
		
		
	}
	
	
	/*
	 * 对象序列化
	 */
	public static void WriteObject(String fName,Serializable s) throws IOException {
		
		File f = new File(fName);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		
		oos.close();
	}
	
	/*
	 * 对象反序列化
	 */
	public static void ReadObject(String fName) throws IOException, ClassNotFoundException {
		
		File f = new File(fName);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ois.readObject();
		
		ois.close();		
	}
	
}
