package kr.co.green;

public class Ex8_1_Calculator {
	
	// 인스턴스 변수는 생성자 호출과 동시에 초기화 진행
	int num;
	int age;
	String name;
	
	// 기본 생성자
	public Ex8_1_Calculator() {
		num = 100;
		System.out.println("기본 생성자가 생성되었습니다.");
	}
	
	// 매개변수 선언자
	public Ex8_1_Calculator(int num, int age, String name) {
		this.num = num;
		this.age = age;
		this.name = name;
		
		information();
	}
	
	public void information() {
		System.out.println("체력: " + num);
		System.out.println("나이: " + age);
		System.out.println("이름: " + name);
	}
	
	/*
	public void add( ) {
		// 지역변수는 반드시 초기화 진행 해줘야함
		int localVar;
		System.out.println(localVar); // 에러 발생
		System.out.println(num);
	}
	*/
}

