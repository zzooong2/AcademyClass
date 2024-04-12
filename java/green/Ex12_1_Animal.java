package kr.co.java.green;

public class Ex12_1_Animal extends Ex12_1_Organism {

	@Override
	public void eat() {
		System.out.println("먹기");
	}
	
	@Override
	public void breath() {
		System.out.println("숨쉬기");
	}

}
