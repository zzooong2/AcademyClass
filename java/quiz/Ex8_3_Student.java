package kr.co.java.quiz;

public class Ex8_3_Student {
	
	//  1. 아래의 변수들을 선언하세요.
		// name : 학생 이름
		// age :학생 나이
		// grade : 학년
		// studentNumber : 학번 (ex. 23052112)
	public String name, studentNumber;
	public int age, grade;
	
	
	//2. Student 클래스에 기본 생성자와 매개변수가 있는 생성자를 만드세요.
	//3. 매개변수 있는 생성자는 1개 (name, age, grade, studentNumber 4개를 받음)
	public Ex8_3_Student() {
		this("이름 없음", 0, 0, "00000000");
		
	}
	
	public Ex8_3_Student(String name, int age, int grade, String sNum) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNumber = sNum;
		
		info();
	}
	
	//4. 기본 생성자를 호출했을 때 아래가 출력되게 하세요. 
	//--> 참조변수 this와 생성자 this() 한번씩 사용해보기
		// name : 이름 없음
		// age : 0
		// grade : 0
		// studentNumber 00000000
	
	public void info() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("grade : " + grade);
		System.out.println("studentNumber : " + studentNumber);
	}
}
