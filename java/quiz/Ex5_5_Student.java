package kr.co.quiz;

import java.util.Scanner;

public class Ex5_5_Student {
	
	// 학생
	String name;
	
	// 과목
	int kor;
	int eng;
	int mat;
	int sci;
	
	// 학생들 성적
	double STUDENT_A_AVG = 93.5;
	double STUDENT_B_AVG = 56.0;
	double STUDENT_C_AVG = 68.5;
	double STUDENT_D_AVG = 80.5;
	double STUDENT_E_AVG = 73.5;
	
	double sum;
	static double avg;
	
	public void getSum() {
		sum = kor + eng + mat + sci;
		System.out.println(name + "님의 합계 점수는 " + sum + "점 입니다.");
	}
	
	public double getAvg() {
		avg = sum / 4;
		System.out.println(name + "님의 평균 점수는 " + avg + "점 입니다.");
		
		return avg;
	}
	
	
	public void getRank(double avg) {
		double[] arr = {STUDENT_A_AVG, STUDENT_B_AVG, STUDENT_C_AVG, STUDENT_D_AVG, STUDENT_E_AVG};
		
		int count = 1;
		
		for(int i=1; i<arr.length; i++) {
			if (arr[i] > avg) {
				count++;
			} else if(arr[i] < avg) {
				count += 0;
			}
		}
		System.out.println(count + "등");
	}
	
}
