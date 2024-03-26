package kr.co.test;

public class Test_01 {

	/* 	
	● int[] arr = {10, 34, 59, 20, 22, 66, 88, 65, 1, 99};

	주어진 배열을 생성하고 아래의 조건에 만족하는 값을 출력하는 프로그램을 작성하세요.

		1-1) 배열 요소의 합계를 출력하세요.
		1-2) 배열의 요소 중 짝수가 몇 개인지 출력하세요.
		1-3) 배열의 요소 중 3의 배수를 모두 출력하세요.
		1-4) 배열의 요소 중 가장 작은 값을 출력하세요.
		1-5) 1-4에서 확인한 가장 작은 값이 몇 번 인덱스에 있는지 출력하세요.
	 */	
	
	public static void main(String[] args) {
		
		int[] arr = {10, 34, 59, 20, 22, 66, 88, 65, 1, 99};
		
		int sum = 0;
		int evenNumber = 0;
		int drainage;
		int min = 100;
		
		// 1-1
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("1-1(합계): " + sum);
				
		
		// 1-2
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 2 == 0) {
				evenNumber++;
			}
		}
		System.out.println("1-2(짝수 수량): " + evenNumber + "ea");
		
		
		// 1-3
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 3 == 0) {
				drainage = arr[i];
				System.out.println("1-3(3의 배수): " + drainage);
			}	
		}
		
		
		// 1-4
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("1-4(최솟값): " + min);
		
		
		// 1-5
		for(int i=0; i<arr.length; i++) {
			if(min == arr[i]) {
				System.out.println("1-5(최솟값의 인덱스): arr[" + i + "]");
			}
		}
		
		
	}

}
