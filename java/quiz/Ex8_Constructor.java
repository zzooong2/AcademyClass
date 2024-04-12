package kr.co.java.quiz;

public class Ex8_Constructor {

	public static void main(String[] args) {

		// Ex8_1_Product
		Ex8_1_Product product = new Ex8_1_Product();
		
		System.out.println(product.name);
		System.out.println(product.price);
		System.out.println(product.count);
		
		System.out.println();
		
		Ex8_1_Product product2 = new Ex8_1_Product("칸쵸", 2000, 6);
		
		System.out.println();
		
		Ex8_1_Product product3 = new Ex8_1_Product("다이제", 4000);
		
		System.out.println("---------------------------------------");
		
		// Ex8_2_Buy
		Ex8_2_Buy buy = new Ex8_2_Buy(200000, 130000, 50000, 150000);
		
		buy.buyMonitor();
		
		buy.buyMouse();
		
		buy.buyComputer();		
		
		System.out.println();		
		System.out.println("---------------------------------------");
		
		// Ex8_3_Student
		Ex8_3_Student student = new Ex8_3_Student();
		
		System.out.println("---------------------------------------");
		
		// Ex8_4_Order
		// 기본생성자 X -> Getter, Setter 이용
		// 주문 번호(orderNumber) ->  ORD123
		// 주문 금액(orderAmount) ->  100.5
		// 주문 상태(orderStatus) ->  처리중
		Ex8_4_Order order = new Ex8_4_Order("ORD123", 100.5, "처리중" );
		
		System.out.println(order.getOrderNumber());
		System.out.println(order.getOrderAmount());
		System.out.println(order.getOrderStatus());
		
		order.setOrderAmount(80);
		
		System.out.println("---------------------------------------");
		
		// 메소드 생성 및 출력
		// 주문금액 100 미만이면 "유효하지 않은 금액입니다" 출력
		// 주문금액 100 이상이면 주문번호, 금액, 상태 출력
		order.amountCheck();
	}	
	
	

}
