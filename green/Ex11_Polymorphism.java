package kr.co.green;

import java.util.ArrayList;

public class Ex11_Polymorphism {

	public static void main(String[] args) {
		
		Ex11_1_Animal dog = new Ex11_1_Dog();
		
		dog.makeSound();
		
		System.out.println("----------------");
		
		ArrayList<Ex11_1_Animal> list = new ArrayList();
		
		list.add(new Ex11_1_Dog());
		list.add(new Ex11_1_Cat());
		
		for(Ex11_1_Animal animal : list) {
			animal.makeSound();
		}
	}

}
