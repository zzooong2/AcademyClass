package kr.co.java.green;

import java.util.Scanner;

public class Ex3_DoWhile {

	public static void main(String[] args) {
		
		// do-while 문
		// do 안의 로직은 조건식과 상관없이 1번은 무조건 실행
		// while 문의 조건식이 참이면 다시 do 문장 쪽으로 이동
		// do 안의 로직 실행
		// 반복
		// while 문의 조건식이 거짓이면 실행종료
		
		int x = 10;
		int y = 13;
		
		do {
			x++;
			System.out.println("실행" + x);
		} while(x < y);
		
		
		// 변수에 반드시 0이 들어오는 로직을 do-while 문으로 작성
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		do {
			System.out.print("0을 입력하세요: ");
			num = sc.nextInt();
		} while (num != 0); {
			System.out.println("로직 종료.");
		}		
		

	}

}
