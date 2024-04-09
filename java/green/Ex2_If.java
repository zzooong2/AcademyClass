package kr.co.green;

import java.util.Scanner;

public class Ex2_If {
	public static void main(String[] args) {
		
		int num1 = 100;
		int num2 = 200;
		
		if(num1 < 200) {
			System.out.println(num1 + "은 " + num2 + "보다 작다");
		} 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		if(num == 100) {
			System.out.println("100이다.");
		} else if (num == 200) {
			System.out.println("200이다.");
		} else if (num == 300) {
			System.out.println("300이다.");
		} else {
			System.out.println("오류");
		}
		

		// 짝수, 홀수 구하기
		int number = 10;
		
		if(number % 2 == 0) {
			System.out.println("짝수");
		} else if (number % 2 == 1) {
			System.out.println("홀수");
		}
		
		
		// 배수 구하기
		if(number % 10 == 0) {
			System.out.println("배수");
		}
		
	}

}
