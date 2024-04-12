package kr.co.java.quiz;

public class Ex9_1_Student extends Ex9_1_Person {
	
	// 학번 변수 선언하기
	public String studentId;
	
	
	// 공부시작 출력하는 메소드 만들기 
	public void study() {
		System.out.println("공부 시작");
	}
	
	
	// 학생 정보 출력하는 메소드 만들기
	public void studentInfo() {
		System.out.println("학번: " + this.studentId);
		System.out.println("이름: " + super.name);
		System.out.println("나이: " + super.age);
	}
	
	@Override
	public void displayInfo(String name, int age) {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("학번: " + studentId);
	}
	
	
}
