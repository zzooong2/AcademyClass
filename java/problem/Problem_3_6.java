package kr.co.problem;

public class Problem_3_6 {

//	2) 문자열과 반복 횟수를 입력받아 해당 문자열을 입력된 반복 횟수만큼 반복한 결과를 반환하는 repeatString 메서드를 작성하세요.
//	그리고 같은 이름의 메서드를 사용하여 문자열만 입력받았을 때는 한 번만 반복하도록 하고,
//	반복 횟수를 입력받지 않았을 때는 오류 메시지를 출력하도록 오버로딩하세요.
	
	public static void main(String[] args) {
		// 문자열과 반복 횟수를 입력받아 해당 문자열을 입력된 반복 횟수만큼 반복한 결과를 반환
		String repeatedString = repeatString("Hello ", 3);
		System.out.println(repeatedString); // 출력: Hello Hello Hello
		
		// 문자열만 입력받았을 때는 한 번만 반복하도록 오버로딩
		String singleRepeat = repeatString("Hi");
		System.out.println(singleRepeat); // 출력: Hi
		
		// 반복 횟수를 입력받지 않았을 때는 오류 메시지를 출력하도록 오버로딩
		String errorMessage = repeatString();
		System.out.println(errorMessage); // 출력: 반복 횟수를 입력해주세요.
	}
	
	public static String repeatString(String str1, int count) {
		for(int i=1; i<=count; i++) {
			System.out.print(str1);
			System.out.println();
		}
		return "";
	}
	
	public static String repeatString(String str1) {
		System.out.println(str1);
		return "";
	}
	
	public static String repeatString() {
		System.out.println("반복 횟수를 입력해주세요.");
		return "";
	}
	

}
