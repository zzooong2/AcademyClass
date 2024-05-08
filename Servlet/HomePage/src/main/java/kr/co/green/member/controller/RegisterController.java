package kr.co.green.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

// 회원가입 로직
@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 데이터 받아서 변수에 저장
		String userName = request.getParameter("new-username");
		String userId = request.getParameter("new-userid");
		String userPwd = request.getParameter("new-password");
		String confirmPwd = request.getParameter("confirm-password");
		
		// Member DTO 이용하여 객체 생성
		Member member = new Member();
		
		// 생성한 객체에 받아온 데이터 삽입
		member.setUserName(userName);
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setConfirmPwd(confirmPwd);
		
		// 회원가입 로직 구현 객체 생성 후 메서드 호출
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.register(member);
		
		if(result == 1) {
			RequestDispatcher view = request.getRequestDispatcher("/views/member/login.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/member/register.jsp");
			view.forward(request, response);
		}
	}

}
