package kr.co.java.problem;

public interface Problem_3_12_Car {

	public void start(Problem_3_12_CarDto dto);
	
	public void stop(Problem_3_12_CarDto dto);
	
	public void acc(Problem_3_12_CarDto dto, int speed);
	
	public void brake(Problem_3_12_CarDto dto);
	
	public void getInfo(Problem_3_12_CarDto dto);
}
