package kr.co.green;

import java.util.Iterator;

public class Ex5_Method {
	
	public static void main(String[] args) {
	
		// 객체 생성 (인스턴스화)
		// 클래스를 메모리에 올리는 과정
		
		// 계산하기
		// 클래스명 변수명 = new 클래스명();
		Ex5_1_Calculator method = new Ex5_1_Calculator();
	
		// 변수명.메소드명();
		method.add(10, 20);
		method.sub(10, 20);
		method.mul(10, 20);
		method.div(10, 20);
	
		System.out.println("-----------");
		
		// 리턴값 받아오기
		int resultAdd = method.addition(100, 50);
		System.out.println("더한 값: " + resultAdd);
		
		int resultSub = method.subtraction(200, 100);
		System.out.println("뺀 값: " + resultSub);
		
		int resultMul = method.multiplication(10000, 23);
		System.out.println("곱한 값: " + resultMul);
		
		int resultDiv = method.division(777, 5);
		System.out.println("나눈 값: " + resultDiv);
		
		System.out.println("-----------");
		
		// 동물 소리내기
		Ex5_2_Animal animal = new Ex5_2_Animal();
		animal.dog();
		animal.cat();
		animal.pig();		
		
		System.out.println("-----------");
		
		// 동물 행위 출력하기 + 리턴값 받아오기
		String eat = animal.eat("1");
		System.out.print("리턴값: " + eat);
		System.out.println();
		
		String sleep = animal.sleep("1");
		System.out.print("리턴값: " + sleep);
		System.out.println();
		
		System.out.println("-----------");
	}

}
