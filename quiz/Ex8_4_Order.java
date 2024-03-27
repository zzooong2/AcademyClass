package kr.co.quiz;

public class Ex8_4_Order {
	
	// 주문 번호(orderNumber)
	// 주문 금액(orderAmount)
	// 주문 상태(orderStatus)
	// 단, 위의 변수들은 모두 private으로 생성
	// Order 클래스에 모든 변수에 대한 getter, setter 생성
	
	// 변수 선언
	private String orderNumber, orderStatus;
	private double orderAmount;
	
	
	// 생성자
	public Ex8_4_Order(String orderNumber, double orderAmount, String orderStatus) {
		this.orderNumber = orderNumber;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
	}
	
	// Getter
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public double getOrderAmount() {
		return orderAmount;
	}
	
	
	// Setter
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	public void amountCheck() {
		if(orderAmount < 100) {
			System.out.println("유효하지 않은 금액입니다.");
		} else if (orderAmount >= 100) {
			System.out.println("주문번호: " + orderNumber);
			System.out.println("주문금액: " + orderAmount);
			System.out.println("주문상태: " + orderStatus);
		}
	}
	
	
}
