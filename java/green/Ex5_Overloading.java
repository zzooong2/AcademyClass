package kr.co.green;

public class Ex5_Overloading {

	public static void main(String[] args) {
		
		Ex5_Overloading me = new Ex5_Overloading();
		
		// 오버로딩 : 메소드 이름을 동일하게 선언하고 매개변수의 수, 자료형을 다르게 선언하여 사용
		
		me.overloading("김현중");
		me.overloading(31);
		me.overloading(70, 167);
		

	}
	
	public void overloading(String name) {
		System.out.println("제 이름은 " + name + " 입니다.");
	}
	
	public void overloading(int age) {
		System.out.println("제 나이는 " + age +  "살 입니다.");
	}
	
	public void overloading(int weight, int height) {
		System.out.println("제 몸무게는 " + weight + "kg 입니다.");
		System.out.println("제 키는 " + height + "cm 입니다.");
	}
	

}
