package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 페이지 이동시 주소창에 명시되는 폴더루트를 숨김
@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UTF-8 문자코드를 사용 선언
		response.setContentType("text/html; charset=utf-8");
		
		// .getPathInfo(): 요청이 들어온 URL에 추가되어 있는 부가적인 경로 정보 리턴
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/registerForm.do")) {
			nextPage = "/views/member/register.jsp";
		} else if (action.equals("/loginForm.do")) {
			nextPage = "/views/member/login.jsp";
		}
		
		// nextPage가 null이 아니거나, 비어있지 않을 경우만 코딩이 실행되게 처리
		if(nextPage != null && !nextPage.isEmpty()){
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
