package kr.co.problem;

public class Problem_3_12_CarDto {
	
	boolean isRunning = false; // 운행 상태 여부
	
	int speed = 0; // 자동차의 속도
	
	// Getter
	public boolean isRunning() {
		return isRunning;
	}

	public int getSpeed() {
		return speed;
	}

	
	// Setter
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
