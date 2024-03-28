package kr.co.green;

public class Ex10_Static_Final {
	public static void main(String[] args) {
		
		System.out.println(Ex10_Static.str);
		
		Ex10_Static.staticMethod();
		
	}
}

// 스태틱 선언은 클래스명으로 호출 가능
class Ex10_Static {
	public static String str = "ABC";
	
	public static void staticMethod() {
		System.out.println("출력");
	}
}
