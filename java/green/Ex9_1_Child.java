package kr.co.java.green;

public class Ex9_1_Child extends Ex9_1_Parent {
	
	public String childVar = "자식 변수";
	
	public void childMethod() {
		System.out.println("자식 클래스");
	}
	
	@Override
	public void parentMethod() {
		System.out.println("오버라이딩 된 메서드");
	}
	
	
}
