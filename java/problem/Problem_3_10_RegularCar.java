package kr.co.problem;

public class Problem_3_10_RegularCar implements Problem_3_10_Car {

	@Override
	public void start() {
		System.out.println("일반 자동차를 시동합니다.");
	}
	
	@Override
	public void acc() {
		System.out.println("일반 자동차를 가속합니다.");
	}
	
	@Override
	public void brake() {
		System.out.println("일반 자동차를 감속합니다.");
	}
	
	
}
