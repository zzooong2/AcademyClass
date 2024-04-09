package kr.co.problem;

public class Problem_3_10 {
	
	public static void main(String[] args) {
		
		Problem_3_10_SportsCar sCar = new Problem_3_10_SportsCar();
		
		Problem_3_10_RegularCar rCar = new Problem_3_10_RegularCar();
		
		sCar.start();
		sCar.acc();
		sCar.brake();
		
		rCar.start();
		rCar.acc();
		rCar.brake();
		
	}
	
}
