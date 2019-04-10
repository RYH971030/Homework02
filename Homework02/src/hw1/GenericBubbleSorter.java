package hw1;

import java.util.ArrayList;
import java.util.List;

public class GenericBubbleSorter<T extends Animal> {
	
	List<T> list = new ArrayList<T>();
	
	public List<T> getArr() {
		return list;
	}
	
	public void add(T t) {
		list.add(t);
	}
	
	public int getWeight() {
		// TODO Auto-generated method stub
		return T.weight;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return T.name;
	}
	
	public void sort(List<T> list) {
		
		for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
                if (list.get(j).getWeight() > list.get(j+1).getWeight()){
                    T tmp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                }
            }
        }
	}

	public  void display(List<T> list){
		for (T t :list) {
			System.out.println("种类"+t.getName()+ "\t重量"+t.getWeight());
	    }
		System.out.println();
	}
	
}
