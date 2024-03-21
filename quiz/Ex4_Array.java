package kr.co.quiz;

import java.util.Arrays;

public class Ex4_Array {

	public static void main(String[] args) {
		
		// 1-1번 : 국어, 영어, 수학, 과학 점수를 배열에 입력하시오.
		int[] score = {90, 70, 90, 60};
		
		// 1-2번 : 평균 점수를 출력하시오.
		
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
		int avg = ((score[0] + score[1] + score[2] + score[3]) / 4);
		System.out.println("평균 점수: " + avg);
		
		System.out.println("----------------------------");
		
		
		// 2-1번 : 5만큼의 길이를 가진 배열을 선언 및 할당하세요.
//		String[] arr = new String[5];
		
		// 2-2번 : 위에서 선언 및 할당한 배열에 "A", "B", "CD", "E", "FG" 값으로 초기화 하세요.
		String[] arr = {"A", "B", "CD", "E", "FG"};
		
		for(int j=0; j<arr.length; j++) {
			System.out.println(arr[j]);
		}
			
		System.out.println(Arrays.toString(arr));
	
		
	}

}
