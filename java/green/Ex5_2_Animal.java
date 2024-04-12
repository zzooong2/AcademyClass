package kr.co.java.green;

public class Ex5_2_Animal {
	
	// 강아지 
	public void dog() {
		System.out.println("멍멍");
	}
	
	// 고양이
	public void cat() {
		System.out.println("야옹");
	}
	
	// 돼지
	public void pig() {
		System.out.println("꿀꿀");
	}
	
	
	public String eat(String a) {
		System.out.print("먹는중 ");
		return a;
	}
	
	public String sleep(String a) {
		System.out.print("자는중 ");
		return a;
	}
}
