package kr.co.quiz;

public class Ex9_2_Dog extends Ex9_2_Animal{
	
	// 매개변수가 존재하는 생성자 작성
	public Ex9_2_Dog(String name, int age) {
		super(name,age);  
	}
	
	// 강아지가 소리내는 메소드 작성
	public void bark() {
		System.out.println("왈왈");
	}
}
