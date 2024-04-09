package kr.co.problem;

public class Problem_3_5 {

//		1) 문자열 두 개를 결합하는 메서드 concat(String str1, String str2) 
//		문자열 세 개를 결합하는 메서드 concat(String str1, String str2, String str3)를 정의하고, 
//		각각의 메서드를 활용하여 문자열을 결합하여 출력하는 프로그램을 작성하세요.
	
	public static void concat(String str1, String str2) {
		System.out.println(str1 + str2); 
	}
	
	public static void concat(String str1, String str2, String str3) {
		System.out.println(str1 + str2 + str3);
	}
	
	public static void main(String[] args) {
		concat("김현중 ", "공부해라");
		concat("김현중 ", "열심히 ", "공부해라");
	}

}
