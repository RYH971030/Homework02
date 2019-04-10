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
		
		Student1 forS1 = new Student1();
		
		SerializableTest.WriteObject(FILE, forS1);
		Student1 bakS1 = SerializableTest.ReadObject(FILE);
		System.out.println("反序列化之后：\n" + bakS1.ToString());
		
		
	}
	
	
	/*
	 * 对象序列化
	 */
	private static void WriteObject(String fName,Serializable s) throws IOException {
		
		File f = new File(fName);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		System.out.println("Student对象序列化成功！");
		oos.close();
	}
	
	/*
	 * 对象反序列化
	 */
	private static Student1 ReadObject(String fName) throws IOException, ClassNotFoundException {
		
		Student1 s1 = new Student1();
		
		File f = new File(fName);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ois.readObject();
		System.out.println("Student对象反序列化成功！");
		ois.close();
		return s1;
	}
	
}
