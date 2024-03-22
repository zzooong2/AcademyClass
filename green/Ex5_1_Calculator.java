package kr.co.green;

// 계산기 설계도(틀)
public class Ex5_1_Calculator {

	// 덧셈 addition
	public void add(int a, int b) {
		System.out.println("덧셈 결과: " + (a+b));
	}
	
	// 뺄셈 subtraction
	public void sub(int a, int b) {
		System.out.println("뺄셈 결과: " + (a-b));
	}
	
	// 곱셈 multiplication
	public void mul(int a, int b) {
		System.out.println("곱셈 결과: " + (a*b));
	}
	
	// 나눗셈 division
	public void div(int a, int b) {
		System.out.println("나눗셈 결과: " + (a/b));
	}
	
}
