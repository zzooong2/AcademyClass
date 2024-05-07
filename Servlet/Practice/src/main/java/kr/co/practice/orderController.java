package kr.co.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getOrder")
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 선택
		String[] products = request.getParameterValues("product");
		// 포장 선택
		String[] packaging = request.getParameterValues("gift");
		// 배송정보
		String orderName = request.getParameter("orderName");
		String orderAddr = request.getParameter("orderAddress");
		String orderEmail = request.getParameter("email");
		String orderPhoneNumber = request.getParameter("phoneNumber");
		
		String object = "";
		String flag = "선물 포장 선택은 ";
		
		// 주문상품 출력
		for(String item : products) {
			if(item.equals("gift_3")) {
				String g3 = "선물용 3kg";
				object += g3;
			} else if (item.equals("gift_5")) {
				String g5 = "선물용 5kg";
				object += g5;
			} else if (item.equals("family_3")) {
				String f3 = "가정용 3kg"; 
				object += f3;
			} else if (item.equals("family_5")) {
				String f5 = "가정용 5kg";
				object += f5;
			}
		}
		
		// 포장유무 출력
		for(String item2 : packaging) {
			if(item2.equals("yes")) {
				String yes = "합니다.";
				flag = flag + yes;
			} else if (item2.equals("no")) {
				String no = "안합니다.";
				flag = flag + no;
			}
		}
		
		//배송정보 출력
		System.out.println(orderName + "님이 주문하신 상품은 " + object + "이며, " + flag);
		System.out.println("배송지: " + orderAddr);
		System.out.println("이메일: " + orderEmail);
		System.out.println("연락처: " + orderPhoneNumber);
		
		// orderName 변수 JSP 로 넘기기 위한 데이터 바인딩
		request.setAttribute("orderName", orderName);
		
		// RequestDispatcher는 JSP에게 응답하기 위해 필요한 객체
		// 응답할 JSP를 선택
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		
		// 포워딩
		view.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
