package kr.co.quiz;

public class Ex5_2_Min_Max {
	
	// 1. 최솟값을 구하는 메서드를 작성하시오.
	public int findMin(int[] arr){
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	// 2. 최댓값을 구하는 메서드를 작성하시오.
	public int findMax(int[] arr) {
		int max = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	
}
