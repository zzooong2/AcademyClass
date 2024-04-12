package kr.co.java.green;

import java.util.Scanner;

public class Ex3_For {
	public static void main(String[] args) {
		
		// for 문
		// 초기식, 조건식, 증감식으로 구성되며 반복할 횟수를 알고 있는 경우에 사용
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반복할 횟수를 입력하세요: ");
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			System.out.println("현재 숫자는 " +  i + "입니다.");
			
			if (i >= 2) {
				System.out.println("i가 2이상 입니다.");
			}
		}
		
		
		for(int i=10; i>0; i--) {
			System.out.println("현재 숫자는 " + i + "입니다.");
		}
		
		sc.nextLine();
		
		System.out.print("문자열을 입력하세요: ");
		String str = sc.nextLine();
		
		for(int j=0; j<str.length(); j++) {
			System.out.println("현재 반복 횟수는 " + j + "입니다.");
		}

		
		for(int a=0; a<2; a++) {
			System.out.println();
			System.out.println("a: " + a);
			for(int b=10; b<15; b++) {
				System.out.println("b: " + b);
			}
		}
		
	}
}
