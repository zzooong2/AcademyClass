package kr.co.java.problem;

public class Problem_3_12_CarImpl implements Problem_3_12_Car {

	@Override
	public void start(Problem_3_12_CarDto dto) {
		if (dto.isRunning == false) {
			System.out.println("자동차 엔진이 구동되었습니다.");
		} else if (dto.isRunning == true) {
			System.out.println("자동차 엔진이 이미 구동중입니다.");
		}
	}

	@Override
	public void stop(Problem_3_12_CarDto dto) {
		if (dto.isRunning == true) {
			dto.setSpeed(0);
			System.out.println("자동차가 정지되었습니다.");
		} else if (dto.isRunning == false) {
			System.out.println("자동차가 이미 정지상태입니다.");
		}
	}

	@Override
	public void acc(Problem_3_12_CarDto dto, int speed) {
		if (dto.isRunning == true) {
			dto.setSpeed(dto.getSpeed() + speed);
			System.out.println("자동차가 " + dto.speed + "km/h로 가속 중입니다.");
		} else if (dto.isRunning == false) {
			System.out.println("자동차가 정지상태입니다. 시동을 걸어주세요.");
		}
	}

	@Override
	public void brake(Problem_3_12_CarDto dto) {
		if (dto.isRunning == true && dto.speed > 0) {
			dto.setSpeed(dto.getSpeed() - 10);
			System.out.println("자동차가 감속중입니다.");
		} else if (dto.getSpeed() >= 0) {
			System.out.println("자동차가 이미 정지 상태입니다.");
		} else {
			System.out.println("자동차가 정지 상태입니다. 시동을 걸어주세요.");
		}
	}

	@Override
	public void getInfo(Problem_3_12_CarDto dto) {
		String status = "";
		if(dto.isRunning == true) {
			status = "운행중";
		} else if(dto.isRunning == false) {
			status = "운행종료";
		}
	}
}
