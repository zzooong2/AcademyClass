package kr.co.quiz;

import java.util.Random;
import java.util.Scanner;

public class Ex3_For {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// 1번 : 숫자 1부터 사용자가 입력한 값 만큼 숫자를 출력하는 프로그램을 작성하시오
		
		System.out.println("숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			System.out.println(i);
		}
		System.out.println("--------------------");
		
		
		// 2번 : 1~20 숫자 중, 짝수를 출력하는 프로그램을 작성하시오.
		// j를 2씩 증가시키는 방법도 있음
		
		for (int j=1; j<21; j++) {
			if(j%2 == 0) {
				System.out.println(j);
			}
		}
		System.out.println("--------------------");
		
		
		// 3번 : 로또 번호를 생성하는 프로그램을 작성하시오. 		

		// rd.nextInt(45) = 0 ~ 44
		// rd.nextInt(45) + 1 = 1 ~ 45		
		System.out.println("<1회 로또 당첨번호>");
		for(int k=1; k<=6; k++) {
			Random rd = new Random();
			int lottoNumber = rd.nextInt(45) + 1;
			System.out.print(lottoNumber + " " + '\n'); 
		}
		System.out.println("--------------------");
		
		
		
		// 4번 : 1부터 100까지의 숫자 중 3과 5의 공배수를 출력하시오.
		
		for(int l=1; l<101; l++) {
			if((l%3 == 0) && (l%5 == 0)){
				System.out.println(l);
			}
		}
		System.out.println("--------------------");
		
		
		// 5번 : 10 팩토리얼 값을 출력하시오.
		
		int factorial = 1;
		for (int x=1; x<11; x++) {
			factorial = x * factorial;
		}
		System.out.println(factorial);
		System.out.println("--------------------");
		
	}
}
