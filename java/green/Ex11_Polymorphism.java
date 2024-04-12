package kr.co.java.green;

import java.util.ArrayList;

public class Ex11_Polymorphism {

	public static void main(String[] args) {

		// 다형성
		Ex11_1_Animal dog = new Ex11_1_Dog();

		dog.makeSound();

		System.out.println("----------------");

		ArrayList<Ex11_1_Animal> list = new ArrayList();

		list.add(new Ex11_1_Dog());
		list.add(new Ex11_1_Cat());

		for (Ex11_1_Animal animal : list) {
			animal.makeSound();
		}

		System.out.println("----------------");

		// <참조변수 형변환>

		Ex11_1_Dog puppy = new Ex11_1_Dog();
		// 상속받은 메서드
		puppy.eat();
		puppy.sleep();
		puppy.makeSound(); // 오버라이딩 된 메서드

		// Ex11_1_Dog 클래스에 선언된 메서드
		puppy.bark();

		// 참조변수 형변환
		// 데이터 타입(클래스) 변수 = (변환할 타입) 변환할 변수;
		Ex11_1_Animal animal = (Ex11_1_Animal) puppy;
		// EX11_1_Animal 클래스에 선언된 메서드
		animal.eat();
		animal.sleep();
		animal.makeSound();

		// Ex11_1_Dog 클래스에 선언된 메서드
//		animal.bark();

		Ex11_1_Dog puppy2 = (Ex11_1_Dog) animal;
		// 상속받은 메서드
		puppy2.eat();
		puppy2.sleep();
		puppy2.makeSound();

		// Ex11_1_Dog 클래스에 선언된 메서드
		puppy2.bark();

	}

}
