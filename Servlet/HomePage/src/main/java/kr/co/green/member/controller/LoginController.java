package kr.co.green.member.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/loginForm.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받아서 변수에 저장
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("password");
		
		// memeber 객체 생성
		Member member = new Member();
		
		// 받아온 데이터 세팅
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		Member result = memberService.login(member);
		// 입력받은 데이터와 DB 데이터 비교
		if(Objects.isNull(result.getUserName())) {
			response.sendRedirect("/views/common/error.jsp");
		} else {
			// 세션생성 (세션에 저장되어있는 정보를 계속 활용)
			HttpSession session = request.getSession();
			// 가져온 데이터를 각 별칭에 저장
			session.setAttribute("userNo", result.getUserNumber());
			session.setAttribute("userName", result.getUserName());
			
			// web.xml 파일에 설정되어있기에 "/" 라고 선언하면 index.jsp가 호출됨
			RequestDispatcher view = request.getRequestDispatcher("/");
			view.forward(request, response);
		}
	}

}
