package kr.co.java.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex13_2_Calculator {

	// 1. 실행할 때 예외가 생김. 해결
	// 2. 예외 발생 가능성이 있는 부분들을 try-catch 문으로 "예외 발생" 출력

	public static void main(String[] args) {

		CalcProgram cp = new CalcProgram();
		CalcDto cd = new CalcDto();
//		Scanner sc = null;
		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;
		int choice = -1;

		while (isTrue) {
			// 1. 예외가 발생할 가능성이 있는 코드가 어디인지?
			// 2. 어떤 예외가 발생할것으로 추측되는지?
			// 3. 예외가 발생했을 때 어떤 처리를 할것인지?

			System.out.println("계산기 프로그램");
			System.out.println("1. 덧셈 ");
			System.out.println("2. 뺄셈 ");
			System.out.println("3. 곱셈 ");
			System.out.println("4. 나눗셈(몫) ");
			System.out.println("5. 나눗셈(나머지) ");
			System.out.println("0. 종료");
			System.out.print("원하는 작업을 선택하세요 : ");
			try {
			choice = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				sc.nextLine();
			}
			
			switch (choice) {
			case 1:
				cp.inputNum(cd);
				cp.add(cd);
				break;
			case 2:
				cp.inputNum(cd);
				cp.sub(cd);
				break;
			case 3:
				cp.inputNum(cd);
				cp.mul(cd);
				break;
			case 4:
				cp.inputNum(cd);
				cp.divShare(cd);
				break;
			case 5:
				cp.inputNum(cd);
				cp.divRemain(cd);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				isTrue = false;
				break;
			default:
				System.out.println("올바른 번호를 선택하세요.");
			}
			System.out.println("--------------------------");
		}
	}

}

// 클래스 작성
class CalcDto {
	int getFirstNum;
	int getSecondNum;

	// Getter
	public int getFirstNum() {
		return getFirstNum;
	}

	public int getSecondNum() {
		return getSecondNum;
	}

	// Setter
	public void setFirstNum(int firstNum) {
		this.getFirstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.getSecondNum = secondNum;
	}

}

// 인터페이스 작성
interface CalcInterface {
	public void add(CalcDto cd);

	public void sub(CalcDto cd);

	public void mul(CalcDto cd);

	public void divShare(CalcDto cd); // 나눗셈, 몫

	public void divRemain(CalcDto cd); // 나눗셈, 나머지
}

// 인터페이스 구현한 클래스 작성
class CalcProgram implements CalcInterface {
	public void inputNum(CalcDto cd) {
		// 사용자로부터 두 개의 숫자를 입력받는 코드 작성
		Scanner sc = new Scanner(System.in);

		// 입력받은 두 개의 숫자는 CalcDto에 저장
		try {
		System.out.print("첫번째 숫자를 입력하세요: ");
		int firstNum = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요: ");
		int secondNum = sc.nextInt();
		
		cd.setFirstNum(firstNum);
		cd.setSecondNum(secondNum);
		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		}
	}

	// 오버라이딩하여 계산 로직 작성
	@Override
	public void add(CalcDto cd) {
		System.out.println(cd.getFirstNum() + cd.getSecondNum());
	}

	@Override
	public void sub(CalcDto cd) {
		System.out.println(cd.getFirstNum - cd.getSecondNum);
	}

	@Override
	public void mul(CalcDto cd) {
		System.out.println(cd.getFirstNum * cd.getSecondNum);
	}

	@Override
	public void divShare(CalcDto cd) {
		try {
			System.out.println(cd.getFirstNum % cd.getSecondNum);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

	@Override
	public void divRemain(CalcDto cd) {
		try {
			System.out.println(cd.getFirstNum / cd.getSecondNum);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

}
