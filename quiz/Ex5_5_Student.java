package kr.co.quiz;

import java.util.Scanner;

public class Ex5_5_Student {
	
	// 학생
	static String name;
	
	// 과목
	static int kor;
	static int eng;
	static int mat;
	static int sci;
	
	// 학생들 성적
	double STUDENT_A_AVG = 93.5;
	double STUDENT_B_AVG = 56.0;
	double STUDENT_C_AVG = 68.5;
	double STUDENT_D_AVG = 80.5;
	double STUDENT_E_AVG = 73.5;
	
	
	int sum;
	static int avg;
	
	public void getSum() {
		sum = kor + eng + mat + sci;
		System.out.println(name + "님의 합계 점수는 " + sum + "점 입니다.");
	}
	
	public int getAvg() {
		avg = sum / 4;
		System.out.println(name + "님의 평균 점수는 " + avg + "점 입니다.");
		
		return avg;
	}
	
	public void getRank() {
		
		if(avg > 93.5) {
			System.out.println("1등");
		} else if (avg > 80.5) {
			System.out.println("2등");
		} else if (avg > 73.5) {
			System.out.println("3등");
		} else if (avg > 68.5) { 
			System.out.println("4등");
		} else if (avg > 56.0) {
			System.out.println("5등");
		} else if (avg < 56.0) {
			System.out.println("6등");
		}
		
	}
	
}
