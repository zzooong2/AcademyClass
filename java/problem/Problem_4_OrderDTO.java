package kr.co.java.problem;

//1) OrderDTO 클래스를 생성하고 아래의 변수와 생성자, 메소드를 만드세요.
//- private String customerName (주문자 이름)
//- private int orderNumber (주문 번호)
//- private String orderItem (주문 물품)
//- 매개변수 있는 생성자 (주문자 이름, 주문 번호, 주문 물품)
//- 각 변수들에 대한 getter/setter

public class Problem_4_OrderDTO {

	// 주문자
	private String customerName;
	
	// 주문 번호
	private int orderNumber;
	
	// 주문 물품
	private String orderItem;
	
	// 매개변수 있는 생성자
	public Problem_4_OrderDTO(String cName, int oNum, String oItem) {
		this.customerName = cName;
		this.orderNumber = oNum;
		this.orderItem = oItem;
	}
	
	// Getter
	public String getCustomerName() {
		return customerName;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public String getOrderItem() {
		return orderItem;
	}
	
	// Setter
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	
}
