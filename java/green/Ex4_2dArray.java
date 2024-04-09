package kr.co.green;

import java.util.Arrays;

public class Ex4_2dArray {

	public static void main(String[] args) {
		
		// < 2차원 배열 >
		
		int[][] arr = new int[3][2];
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;
		arr[1][1] = 200;
		
		System.out.println(arr[1][1]);
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = j;
			}
		}
		
		// 2차원 배열의 명시적 초기화
		
		int[][] arr2 = { 
						
						{10, 20, 30}, 
						{100, 200, 300}
						
						};
		
		
	}

}
