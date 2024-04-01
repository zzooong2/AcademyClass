package kr.co.problem;

public class Problem_3_10_SportsCar implements Problem_3_10_Car {

	@Override
	public void start() {
		System.out.println("스포츠카를 시동합니다.");
	}
	
	@Override
	public void acc() {
		System.out.println("스포츠카를 가속합니다.");
	}
	
	@Override
	public void brake() {
		System.out.println("스포츠카를 감속합니다.");
	}
	
	
}
