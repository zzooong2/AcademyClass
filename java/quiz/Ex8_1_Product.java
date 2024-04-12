package kr.co.java.quiz;

public class Ex8_1_Product {
	
	// 인스턴스 변수 선언
	String name;
	int price, count;
	
	// 기본 생성자
	public Ex8_1_Product() {};
	
	// 모든 인스턴스 변수를 매개변수로 받는 생성자 
	public Ex8_1_Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;	
		
		information();
	}
	
	// 일부 인스턴스 변수를 매개변수로 받는 생성자
	public Ex8_1_Product(String name, int price) {
		this.name = name;
		this.price = price;
		
		information();
	}
	
	public void information() {
		System.out.println("이름: " + name);
		System.out.println("가격: " + price);
		System.out.println("수량: " + count);
	}

}
