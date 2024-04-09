package kr.co.green;

public class Ex1_Operator {

	public static void main(String[] args) {

		// 연산자
		int result;
		int aNum = 30;
		int bNum = 20;
		
		result = bNum + aNum;
		System.out.println("덧셈 결과: " + result);
		
		result = aNum - 10;
		System.out.println("덧셈 결과: " + result);
		
		
		// 전위 증감 연산자
		int x = 10;
		// 1 증가
		System.out.println(++x);
		// 1 감소
		System.out.println(--x);
				
				
		// 후위 증감 연산자 (연산을 마지막 진행)
		int z = 10;
		System.out.println(z++); // z의 값 10 출력 이후 연산진행 (z = z+1)
		System.out.println(z--); // z의 값 11 출력 이후 연산진행 (z = z-1)
		System.out.println(z); // z의 값 10 출력
		
		
		// 비교 연산자
		System.out.println("비교 연산자");
		System.out.println(aNum < bNum);
		System.out.println(aNum > bNum);
		System.out.println(aNum == bNum);
		
		String str1 = "hi";
		String str2 = new String("hi");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2)); // 문자열 비교할 때 .equals 메소드 사용
		
		
		// 논리 부정 연산자
		System.out.println("논리부정 연산자");
		boolean isTrue = true;
		System.out.println(!isTrue);
		
		
		// 논리 연산자 
		// && (and 연산자) - 조건이 모두 참이여야 참, 하나라도 거짓이면 거짓
		// || (or 연산자) - 조건이 하나라도 참이면 참, 왼쪽 조건이 참이면 오른쪽 조건 연산 진행안함
		System.out.println("논리 연산자");
		System.out.println(10 < 5 && 20 == 20);
		System.out.println(10 < 5 || 20 == 20);
		
		
		// 삼항 연산자
		// 조건식을 간단하게 줄여 사용하기 위한 방식
		int a = 10;
		int b = 20;
		
		// 조건이 true이면 ?, false이면 :
		System.out.println(a > b ? a+15 : b-5); // 15
		
	}

}