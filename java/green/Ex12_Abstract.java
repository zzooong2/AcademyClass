package kr.co.green;

public class Ex12_Abstract {

	public static void main(String[] args) {

		// 추상 클래스는 객체 생성불가
//		Ex12_1_Organism organism = new Ex12_1_Organism();

		Ex12_1_Animal animal = new Ex12_1_Animal();

		Ex12_1_Plant plant = new Ex12_1_Plant();

		animal.eat();
		animal.breath();

		plant.eat();
		plant.breath();

	}

}
