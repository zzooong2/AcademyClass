package kr.co.problem;

public class Problem_3_7 {

//	3). 계산기 만들기
//	1. int[] numbers = {50, 5, 8, 132, 15} 배열을 활용
	
	static int[] numbers = {50, 5, 8, 132, 15};
	static int sum = 0;
	static int mul = 1;
	static int min = numbers[0];
	static int max = numbers[0];
	
	
	public static void main(String[] args) {
		
		sum();
		product();
		max();
		min();
		
	}
	
//	2. numbers의 모든 정수의 합을 반환하는 int sum() 메소드 생성
	public static void sum() {
		for(int item : numbers) {
			sum += item;
		}
		System.out.println("합계: " + sum);
	}

//	3. numbers의 모든 정수의 곱을 반환하는 int product() 메소드 생성
	public static void product() {
		for(int item : numbers) {
			mul *= item;
		}
		System.out.println("모든 정수의 곱: " + mul);
	}
	
//	4. numbers의 가장 큰 정수를 반환하는 int max() 메소드 생성
	public static void max() {
		for(int i=0; i<numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		System.out.println("가장 큰 정수: " + max);
	}
	
//	5. numbers의 가장 작은 정수를 반환하는 int min() 메소드 생성
	public static void min() {
		for(int i=0; i<numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		System.out.println("가장 작은 정수: " + min);
	}
	
}
