package hw2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExternalizableTest {

	public static final String FILE = "student2.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Student2 forS2 = new Student2();
		
		ExternalizableTest.WriteObject(FILE, forS2);
		Student2 bakS2 = ExternalizableTest.ReadObject(FILE);
		System.out.println("反序列化之后：\n" + bakS2.ToString());
		
		
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
	private static Student2 ReadObject(String fName) throws IOException, ClassNotFoundException {
		
		Student2 s2 = new Student2();
		
		File f2 = new File(fName);
		FileInputStream fis2 = new FileInputStream(f2);
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		ois2.readObject();
		System.out.println("Student对象反序列化成功！");
		ois2.close();
		return s2;
	}
	
}
