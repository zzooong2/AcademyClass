package kr.co.java.green;

public class Ex12_1_Plant extends Ex12_1_Organism {
	
	@Override
	public void eat() {
		System.out.println("광합성");
	}

	@Override
	public void breath() {
		System.out.println("교환기능");
	}	

}
