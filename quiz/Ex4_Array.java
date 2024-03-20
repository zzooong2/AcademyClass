package kr.co.quiz;

public class Ex4_Array {

	public static void main(String[] args) {
		
		// 1-1번 : 국어, 영어, 수학, 과학 점수를 배열에 입력하시오.
		int[] score = {90, 70, 90, 60};
		
		// 1-2번 : 평균 점수를 출력하시오.
		int avg = ((score[0] + score[1] + score[2] + score[3]) / 4);
		
		for(int i=0; i<score.length; i++) {
			if(i == 0) { 
			System.out.println("국어 점수: " + score[i]);
			} else if (i == 1) {
			System.out.println("영어 점수: " + score[i]);
			} else if (i == 2) {
			System.out.println("수학 점수: " + score[i]);
			} else if (i == 3) {
			System.out.println("과학 점수: " + score[i]);
			}
		} 
		System.out.println("평균 점수: " + avg);
		
	}

}
