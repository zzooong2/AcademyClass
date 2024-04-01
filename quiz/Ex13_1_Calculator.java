package kr.co.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex13_1_Calculator {
	
	public static void method() {
		throw new NullPointerException();
	}

	public static void main(String[] args) {
		
		// throw: 의도적으로 예외를 발생시키는 키워드
		try {
//			throw new NullPointerException();
			Ex13_1_Calculator.method();
		} catch(NullPointerException e) {
			System.out.println("예외 발생");
		}
		
		
		

		// 정수 2개를 사용자로부터 입력받으세요.
		// 입력받은 두 값을 나눗셈 하는 코드를 작성하세요.
		// InputMismatchException을 처리하세요.
		// ArithmeticException을 처리하세요.

		Scanner sc = new Scanner(System.in);

		try {

			System.out.print("첫번째 숫자를 입력하세요: ");
			int num1 = sc.nextInt(); // 예외 발생가능 지점1

			System.out.print("두번째 숫자를 입력하세요: ");
			int num2 = sc.nextInt(); // 예외 발생가능 지점1

			System.out.println(num1 + "/" + num2 + " = " + (num1 / num2)); // 예외 발생가능 지점1
			
			String str = null;
			System.out.println(str.length());
			
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		} catch (NullPointerException e) {
			System.out.println("객체가 비어있습니다.");
		} finally {
			sc.close(); // Scanner 를 닫는 메서드
		}

	}

}
