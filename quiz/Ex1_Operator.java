package kr.co.quiz;

import java.util.Scanner;

public class Ex1_Operator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 이름을 입력하세요: ");
		String name = sc.nextLine();
		
		System.out.print("국어 점수: ");
		int kor = sc.nextInt();
		
		System.out.print("영어 점수: ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수: ");
		int mat = sc.nextInt();
		
		System.out.print("과학 점수: ");
		int sci = sc.nextInt();
		
		
		// 1번 : 본인 확인 후 "본인 입니다." or "본인이 아닙니다." 출력
		System.out.println(name.equals("김현중") ? "\"본인 입니다.\"" : "\"본인이 아닙니다.\"");
		
		
		// 2번 : 국어, 영어, 수학, 과학의 합계 점수와 평균 점수 출력
		int sum = kor + eng + mat + sci;
		int avg = sum / 4;
		System.out.println("합계: " + sum + "점");
		System.out.println("평균: " + avg + "점");

	}

}
