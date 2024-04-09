package kr.co.quiz;

public class Ex5_Method {

	public static void main(String[] args) {
		
		// 1번.
		// "자동차 엔진을 시작합니다." 출력
		// "자동차 엔진을 정지합니다." 출력
		// "자동차가 가속합니다." 출력
		// "자동차가 감속합니다." 출력
	
		Ex5_1_Car car = new Ex5_1_Car();
		
		car.start();
		car.stop();
		car.go();
		car.brake();
		
		System.out.println("------------------");
		
		
		// 2번.
		int[] arr = {10, 23, 64, 5, 100};
		
		// 객체 생성
		Ex5_2_Min_Max get = new Ex5_2_Min_Max();

		// 2-1. 최솟값을 구하는 메소드 호출
		// 2-2. 반환받은 최솟값을 변 minValue에 저장 후 출력
		int minValue = get.findMin(arr);
		
		System.out.println("최소 값: " + minValue);
		
		// 2-3. 최댓값을 구하는 메소드 호출
		// 2-4. 반환받은 최솟값을 변 maxValue에 저장 후 출력 
		int maxValue = get.findMax(arr);
		System.out.println("최대 값: " + maxValue);
		System.out.println("---------------------");
		
		// 3. 가변인자를 담은 메서드 호출
		get.varArgs(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		
	}

}
