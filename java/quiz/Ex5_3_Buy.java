package kr.co.java.quiz;

public class Ex5_3_Buy {
		
		// 초기자금
		int balance = 100000; // 10만원
		
		// 제품가격
		final int MONITOR = 20000;
		final int MOUSE = 18000;
		final int COMPUTER = 70000;
		
		// 모니터 구입
		public void buyMonitor() {
			balance -= MONITOR;
			
			if(balance >= 0) {
				System.out.print("모니터를 구입하였습니다.");
				checkBalance();
			} else if (balance < 0) {
				minusBalance();
			}
			
		}
		
		// 마우스 구입
		public void buyMouse() {
			balance -= MOUSE;
			if(balance >= 0) {
				System.out.print("마우스를 구입하였습니다.");
				checkBalance();	
			} else if (balance < 0) {
				minusBalance();
			}
			
		}
		
		// 컴퓨터 구입
		public void buyComputer() {
			balance -= COMPUTER;
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
