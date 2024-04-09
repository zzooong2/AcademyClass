package kr.co.problem;

import java.util.ArrayList;
import java.util.Scanner;

//	2) CafeOrder 클래스를 생성하고 아래의 주석 내용을 구현하세요.

public class Problem_4_CafeOrder {

	public static void main(String[] args) {
		// ArrayList를 사용하며, OrderDTO 타입의 변수명 orderList를 생성
		ArrayList<Problem_4_OrderDTO> orderList = new ArrayList<>();

		// Scanner 객체 생성 (변수명 : sc)
		Scanner sc = new Scanner(System.in);

		int orderCounter = 1; // 주문 번호를 자동으로 증가시킬 변수

		while (true) {
			System.out.println("1. 주문 입력");
			System.out.println("2. 주문 목록 출력");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하세요: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
//     		주문자 이름과 주문 물품을 입력 받습니다.
				System.out.print("주문자 성함을 입력하세요: ");
				String customerName = sc.nextLine();

				System.out.print("주문할 물품을 입력하세요: ");
				String orderItem = sc.nextLine();

//     		OrderDTO 객체를 생성하며 생성자로 주문자 이름, 주문 번호, 주문 물품을 전달하여 저장합니다.
				Problem_4_OrderDTO dto = new Problem_4_OrderDTO(customerName, orderCounter, orderItem);

//      	orderList에 객체를 추가하고, orderCounter 값을 1증가합니다.
				orderList.add(dto);
				orderCounter++;

//      	“주문이 접수되었습니다.”를 출력하고 처음 매뉴로 돌아가세요.
				System.out.println("주문이 접수되었습니다.");
				break;

			case 2:
//			orderList가 비어있을 경우 “주문 목록이 비어 있습니다.” 출력
//			비어있지 않을 경우 전체 주문 목록(orderList)에 대해 주문자 이름, 주문 번호, 주문 물품을 출력합니다.
				if (orderList.isEmpty()) {
					System.out.println("주문 목록이 비어 있습니다."); 
				} else if (!orderList.isEmpty()) {
					for (int i = 0; i < orderList.size(); i++) {
						System.out.println("-------------------------");
						System.out.println("주문자: " + orderList.get(i).getCustomerName());
						System.out.println("주문번호: " + orderList.get(i).getOrderNumber());
						System.out.println("주문물품: " + orderList.get(i).getOrderItem());
						System.out.println("-------------------------");
					}
				}
				
				break;
			case 3:
//			“프로그램을 종료합니다.“ 출력 후 종료합니다.
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
				break;
			default:
//			“존재하지 않는 메뉴입니다.” 출력 후 처음 메뉴로 돌아갑니다
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}	
	}

}
