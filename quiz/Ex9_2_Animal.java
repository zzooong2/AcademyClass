package kr.co.quiz;

public class Ex9_2_Animal {
	
	// 동물 정보 변수생성
	public String name;
	public int age;
	
	// 매개변수가 존재하는 생성자 작성
	public Ex9_2_Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println(name + "(" + age + ")" + "이(가) 먹는중입니다.");
	}

	public void sleep() {
		System.out.println(name + "(" + age + ")" + "이(가) 자는중입니다.");
	}
	
}
