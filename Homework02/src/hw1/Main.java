package hw1;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		GenericBubbleSorter<Animal> gbs = new GenericBubbleSorter<Animal>();
		List<Animal> list = gbs.getArr();	
		
		Sheep s1=new Sheep("s1",266);
		Sheep s2=new Sheep("s2",245);
		Sheep s3=new Sheep("s3",200);
		Pig p1=new Pig("p1",400);
		Pig p2=new Pig("p2",386);
		Pig p3=new Pig("p3",587);
		
		gbs.add(s1);
		gbs.add(s2);
		gbs.add(s3);
		gbs.add(p1);
		gbs.add(p2);
		gbs.add(p3);
		
		System.out.println("***********≈≈–Ú«∞£∫********************");
		gbs.display(list);
		gbs.sort(list);
		System.out.println("***********≈≈–Ú∫Û£∫********************");
		gbs.display(list);
	}
	
}
