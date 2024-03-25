package kr.co.green;

public class Ex5_Field {

	// 멤버 변수 (인스턴스, 클래스)
	// 1. 클래스 영역에 있는 변수
	int num = 10; // 인스턴스 변수
	static int classNum = 100; // 클래스 변수
	
	// 지역 변수
	// 1. 메서드나 생성자 내부에 있는 변수
	// 2. {} 블록 안에 선언한 변수
	public void add() {
		int localNum = 100; // 지역 변수
	}
	
	public static void main(String[] args) {
		
		// Person 클래스에 대한 객체 생성(인스턴스화)
		Ex5_3_Person person = new Ex5_3_Person();
	
		System.out.println("이름: " + person.name);
		System.out.println("나이: " + person.age);
		person.walk();
		person.run();
		System.out.println(Ex5_3_Person.phoneNumber);
	
	}
}
