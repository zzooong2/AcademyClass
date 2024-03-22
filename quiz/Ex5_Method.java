package kr.co.quiz;

public class Ex5_Method {

	public static void main(String[] args) {
		
		// Ex5_1_Car 클래스 생성
		// "자동차 엔진을 시작합니다." 출력
		// "자동차 엔진을 정지합니다." 출력
		// "자동차가 가속합니다." 출력
		// "자동차가 감속합니다." 출력
		
		// 객체 생성 후 4개 메소드 호출
		Ex5_1_Car car = new Ex5_1_Car();
		
		car.start();
		car.stop();
		car.go();
		car.brake();
		
		
	}

}
