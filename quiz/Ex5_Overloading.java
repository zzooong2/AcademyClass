package kr.co.quiz;

public class Ex5_Overloading {

	public static void main(String[] args) {
		
		// 객체 생성
		Ex5_Overloading get = new Ex5_Overloading();
		
		get.add(10, 10);
		get.add(10, 5.5);
		get.add(7.5, 10);
		get.add(2.3, 4.5);
		get.add(10, 20, 30);

	}
	
	// 오버로딩 활용하여 매개변수를 더하고 출력하는 메소드 5개 생성
	
	public void add(int a, int b) {
		System.out.println(a + "+" + b + " = " + (a+b));
	}
	
	public void add(int a, double b) {
		System.out.println(a + "+" + b + " = " + (a+b));
	}
	
	public void add(double a, int b) {
		System.out.println(a + "+" + b + " = " + (a+b));
	}
	
	public void add(double a, double b) {
		System.out.println(a + "+" + b + " = " + (a+b));
	}
	
	public void add(int a, int b, int c) {
		System.out.println(a + "+" + b + "+" + c + " = " + (a+b+c));
	}
}
