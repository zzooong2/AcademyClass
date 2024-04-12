package kr.co.java.quiz;

public abstract class Ex12_1_Item {
	
	public String name;
	public double price;
	
	public void Ex12_1_Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract void use();
}
