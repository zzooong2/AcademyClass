package kr.co.java.green;

public class Ex14_Generic {

	public static void main(String[] args) {
		
		// 제네릭: 컴파일 단계에서 자료형을 체크
		Person<String> p1 = new Person();
		
		p1.var = "String";
		
		System.out.println(p1.var);
		
		p1.method("A");
		
		
		Person<Boolean> p2 = new Person();
		
		p2.var = true;
		
		System.out.println(p2.var);
		
		p2.method(true);
		
	}
	
}

class Person<T> {
//	public String var;
	public T var;
	
//	public void method(String str)
	public void method(T str) {
		System.out.println(str);
		
		if(str instanceof String) {
			System.out.println("String입니다.");
		} else {
			System.out.println("String이 아닙니다." + str.getClass());
		}
	}
}
