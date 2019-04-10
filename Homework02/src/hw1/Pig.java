package hw1;

public class Pig implements Animal{

	private String name = "pig";
	private int weight = 0;
	
	Pig(String nam,int x){
		weight = x;
		name = nam;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}
//	@Override
//	public void setWeight(int x) {
//		// TODO Auto-generated method stub
//		weight=x;
//		
//	}

}
