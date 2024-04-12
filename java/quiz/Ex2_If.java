package kr.co.java.quiz;

import java.util.Scanner;

public class Ex2_If {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1번 : 입력 받은 값이 0 또는 12 이상일 경우, "값이 너무 크거나 작습니다" 출력
		System.out.println("숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		if(num == 0 || num >= 12) {
			System.out.println("값이 너무 크거나 작습니다.");
			System.out.println("----------------------");
		}
		
		
		
		// 2번 : Scanner 활용하여 몇 월인지 입력 받으시오.
		System.out.println("몇 월인지 입력하세요: ");
		int month = sc.nextInt();
		
		// 3번 : 입력 받은 월에 따라 계절을 출력 하시오. (그 외 : 해당하는 계절이 없습니다) 
		//       단, && 또는 || 연산자를 활용하여 풀이하시오.
		// 봄 : 3, 4, 5
		// 여름 : 6, 7, 8
		// 가을 : 9, 10, 11
		// 겨울 : 12, 1, 2
		
		
		if (month >= 3 && month < 6 ) {
			System.out.println("봄");
		} else if (month >= 6 && month < 9 ) {
			System.out.println("여름");
		} else if (month >= 9 && month < 12 ) {
			System.out.println("가을");
		} else if (month >= 9 && month < 12 ) {
			System.out.println("겨울");
		} else {
			System.out.println("해당 계절이 없습니다.");
		}
		System.out.println("----------------------");
		
		// 4번
		// 나이가 18세 미만이면 "미성년자" 출력
		// 나이가 18세 이상 65세 미만이면 "성인" 출력
		// 그 외에는 "노인"을 출력
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		if(age < 18 ) {
			System.out.println("미성년자");
		} else if (age >= 18 && age < 65) {
			System.out.println("성인");
		} else {
			System.out.println("노인");
		}
		System.out.println("----------------------");
		
		// 5번
		// 아래의 코드를 참고하여 계산기 프로그램을 작성하세요.
		// ex) 사용자가 1번을 입력하면  firstNumber와 secondNumber를 더한 값을 출력합니다.
		// ex) 사용자가 4번을 입력하면 firstNumber와 secondNumber를 나눈 값(몫)을 출력합니다.
		int firstNumber = 1000;
		int secondNumber = 20;
		
		System.out.println("계산기 프로그램");
		System.out.println("1. 더하기");
		System.out.println("2. 빼기");
		System.out.println("3. 곱하기");
		System.out.println("4. 나누기(몫)");
		System.out.println("5. 나누기(나머지)");
		
		System.out.println("번호를 입력하세요: ");
		int userSelect = sc.nextInt();
		
		if(userSelect == 1) {
			System.out.println("더한 값: " + (firstNumber + secondNumber));
		} else if (userSelect == 2) {
			System.out.println("뺀 값: " + (firstNumber - secondNumber));
		} else if (userSelect == 3) {
			System.out.println("곱한 값: " + (firstNumber * secondNumber));
		} else if (userSelect == 4) {
			System.out.println("나눈 값: " + (firstNumber / secondNumber));
		} else if (userSelect == 5) {
			System.out.println("나머지 값: " + (firstNumber % secondNumber));
		}
		
		
		
	}

}
