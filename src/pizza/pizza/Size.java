package pizza.pizza;

public enum Size {

	Small(7), Normal(10), XXL(12);
	
	private final int max;
	
	private Size(int max){
		this.max = max;
	}
	
	public int getMax(){
		return max;
	}
}
