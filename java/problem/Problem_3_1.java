package kr.co.java.problem;

public class Problem_3_1 {

	public static void main(String[] args) {
		
//		Ex 1 - 변수
//		1) 정수형 변수 age를 선언하고 값 25를 할당하세요.
		int age = 25;
		
//		2) 실수형 변수 weight를 선언하고 값 68.5를 할당하세요.
		double weight = 68.5;
		
//		3) 문자형 변수 grade를 선언하고 값 'A'를 할당하세요.
		char grade = 'A';
		
//		4) 논리형 변수 isMale를 선언하고 값 true를 할당하세요.
		boolean isMale = true;
		
//		5) 문자열 변수 name을 선언하고 값 "John Doe"를 할당하세요.
		String name = "John Doe";
		
//	    -> 문자열의 길이를 출력하세요.
		System.out.println(name.length());
		
//	    -> 문자열의 첫 번째 문자를 출력하세요.
		System.out.println(name.charAt(0));
		
//	    -> 문자열을 모두 대문자로 변환하여 출력하세요.
		System.out.println(name.toUpperCase());
		
	}

}
