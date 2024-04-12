package kr.co.java.quiz;

public class Ex3_For2 {
	public static void main(String[] args) {
		
		// 1번 : 중첩 for문을 사용하여 구구단 프로그램을 작성하시오.
		for(int a=1; a<10; a++) {
			System.out.println("<" + a + "단>");
			for(int b=1; b<10; b++) {
				System.out.println(a + "x" + b + " = " + a*b);
			}
		}
		System.out.println("--------");
		
		// 2번 : 별 찍기 프로그램을 작성하시오.
		for(int i=1; i<6; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------");

	}
}
