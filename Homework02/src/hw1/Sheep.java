package hw1;

public class Sheep implements Animal{

	private String name = "sheep";
	private int weight = 0;
	
	Sheep(String nam,int x){
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


}
