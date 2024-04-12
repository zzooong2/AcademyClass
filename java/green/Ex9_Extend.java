package kr.co.java.green;

public class Ex9_Extend {
	public static void main(String[] args) {
		
	Ex9_1_Child child = new Ex9_1_Child();
	
	child.parentMethod();
	System.out.println(child.parentVar);
	
	child.childMethod();
	System.out.println(child.childVar);
	
	
	}
}
