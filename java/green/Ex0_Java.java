package kr.co.green;

import java.util.Scanner;

public class Ex0_Java {

	public static void main(String[] args) {
		System.out.println("Hello World!!");
			
		
		int num; // 변수의 선언
		num = 100; // 변수의 초기화
		System.out.println(num);
		
		
		// 논리형 boolean : true or false
		boolean varBoolean;
		varBoolean = true;
		System.out.println("boolean: " + varBoolean);
		
		
		// 문자형 char : 문자 ('A', 'B', '가', '나')
		// 문자열형 varChar : 문자 ("AB", "CD", "가나", "다라")
		char varChar = 'A';
		System.out.println("char: " + varChar);
		
		
		// 정수형 : byte, short, int, long
		// 실수형 : double, float
		int num2 = 200; // 변수의 명시적초기화
		System.out.println(num2);
		long num3 = 9999999999999999L; // long 사용시 L 명시 (default = int)
		System.out.println(num3);
		
		
		byte varByte = 127;
		float varFloat = 1.123412341234f; // float 사용시 f 명시 (default = double)
		System.out.println("byte: " + varByte);
		System.out.println("float: " + varFloat); 
		
		
		double varDouble = 1.123412341234;
		System.out.println("double: " + varDouble);
		
		
		// 참조자료형(참조형변수)
		String str = "ABCDEFG";
		System.out.println("String: " + str);
		
		
		// 상수 선언
		final int FINAL_NUMBER = 10;
		System.out.println("final: " + FINAL_NUMBER);
		
		
		// 자동 형변환
		char ch = 'a'; // 아스키 코드 97
		int number = ch;
		System.out.println(number);
		
		
		// 강제 형변환
		double dNum = 12345.6;
		int iNum = (int)dNum;
		System.out.println(iNum);
		 
		// Scanner 사용
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.println("이름: " + name);
	
		
		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("나이: " + age);		
		
		
		// "\" 키워드 이용하여 특수문자 출력하기
		System.out.println("\"Hello, world!\"");	
		
		
	}

}


