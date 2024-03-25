package kr.co.quiz;

import java.util.Scanner;

public class Ex5_Field {

	public static void main(String[] args) {	
		
		// 모니터, 마우스, 컴퓨터를 구매하는 로직을 작성하시오
		Ex5_3_Buy get = new Ex5_3_Buy();
		
		get.buyMonitor();		
		get.buyMouse();
		get.buyComputer();
		
		System.out.println();
		System.out.println("-------------------");
		
		
		// 평균 평점을 반환하시오
		double userRating;
		Scanner sc = new Scanner(System.in);
		System.out.print("평점을 입력하세요: ");
		userRating = sc.nextDouble();
		System.out.println();
		
		
		Ex5_4_Rating cal = new Ex5_4_Rating();
		
		cal.getAvgRating(userRating);
		System.out.println("-------------------");
		
		
		// 성적의 합계, 평균, 등수를 구하시오
		Ex5_5_Student student = new Ex5_5_Student();
		
		System.out.print("국어 점수를 입력하세요: ");
		student.kor = sc.nextInt();
		System.out.println();
		
		System.out.print("영어 점수를 입력하세요: ");
		student.eng = sc.nextInt();
		System.out.println();
		
		System.out.print("수학 점수를 입력하세요: ");
		student.mat = sc.nextInt();
		System.out.println();
		
		System.out.print("과학 점수를 입력하세요: ");
		student.sci = sc.nextInt();
		System.out.println();
		
		sc.nextLine();
		System.out.print("이름을 입력하세요: ");
		student.name = sc.nextLine();
		System.out.println();
		
		student.getSum();
		student.getAvg();
		student.getRank(Ex5_5_Student.avg);
		
	}

}
