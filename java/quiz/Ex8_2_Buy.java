package kr.co.java.quiz;

public class Ex8_2_Buy {
	
	public int balance, monitor, mouse, computer;
	
	// 기본 생성자
	public Ex8_2_Buy() {}
	
	
	// 매개변수 생성자 
	public Ex8_2_Buy(int balance, int monitor, int mouse, int computer) {
		this.balance = balance;
		this.monitor = monitor;
		this.mouse = mouse;
		this.computer = computer;
	}
	
	
	// 모니터 구입
	public void buyMonitor() {
		balance -= monitor;
		
		if(balance >= 0) {
			System.out.print("모니터를 구입하였습니다.");
			checkBalance();
		} else if (balance < 0) {
			minusBalance();
		}
		
	}
	
	// 마우스 구입
	public void buyMouse() {
		balance -= mouse;
		if(balance >= 0) {
			System.out.print("마우스를 구입하였습니다.");
			checkBalance();	
		} else if (balance < 0) {
			minusBalance();
		}
		
	}
	
	// 컴퓨터 구입
	public void buyComputer() {
		balance -= computer;
		if(balance >= 0) {
			System.out.print("컴퓨터를 구입하였습니다.");
			checkBalance();
		} else if (balance < 0) {
			minusBalance();
		}
		
	}
	
	// 잔액 확인
	public void checkBalance() {
		System.out.println("남은 금액은 " + balance + "입니다.");
		System.out.println();
	}
	
	// 오류 문자
	public void minusBalance() {
		System.out.print("잔액이 부족합니다.");
	}



}
