package kr.co.java.green;

import java.util.Scanner;

public class Ex2_Switch {
	public static void main(String[] args) {
		
		
		// Switch 문
		// 특정 숫자, 문자에 대한 값을 받을 때 주로 사용함
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1: 아이스 아메리카노");
		System.out.println("2: 카페라떼");
		System.out.println("3: 아포가토");
		System.out.println("4: 팥빙수");
		System.out.println("5: 파니니");
		System.out.println();
		System.out.println("메뉴를 입력하세요: ");
		
		int num = sc.nextInt();
		
		switch(num) {
		case 1 :
			System.out.println("아이스 아메리카노를 선택하셨습니다.");
			break;
		case 2 :
			System.out.println("카페라떼를 선택하셨습니다.");
			break;
		case 3 :
			System.out.println("아포가토를 선택하셨습니다.");
			break;
		case 4 :
			System.out.println("팥빙수를 선택하셨습니다.");
			break;
		case 5 :
			System.out.println("파니니를 선택하셨습니다.");
			break;
		default : 
			System.out.println("해당 메뉴가 없습니다.");
		}
		
		
				
		
	}

}
