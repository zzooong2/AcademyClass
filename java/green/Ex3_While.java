package kr.co.java.green;

import java.util.Scanner;

public class Ex3_While {
	public static void main(String[] args) {
		
		// while 문 
		// 조건식으로 구성되며 반복할 횟수를 알고 있는 경우에 사용
		// 비교연산자를 조건으로 두었다면 증감식 필수!  
		// 무한루프가 발생할 가능성이 매우 높으므로 사용에 주의
		
		
		int cnt = 0;
		while(cnt < 10) {
			System.out.println("현재 반복 횟수: " + cnt);
			cnt++;
		}
		
		
		// 변수에 반드시 0이 들어오는 로직
		Scanner sc = new Scanner(System.in);
		System.out.print("0을 입력하세요: ");
		int num = sc.nextInt();
		
		while(num != 0) {
			System.out.print("다시 입력하세요: ");
			num = sc.nextInt();
		}
				
		
		
		// 1~100 사이의 짝수 구하기		

		int num3 = 1;
		while(num3 <= 100) {
			if(num3 % 2 == 0) {
				System.out.println(num3);	
			}
			num3++;
		}
		
		
	}
}
