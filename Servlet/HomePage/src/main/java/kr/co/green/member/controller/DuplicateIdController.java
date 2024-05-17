package kr.co.green.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/duplicateId.do")
public class DuplicateIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuplicateIdController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		MemberServiceImpl memberService = new MemberServiceImpl();
		int duplicateCheck = memberService.duplicateId(id);
		
		if(duplicateCheck == 1) { // 중복O
			// ajax
			response.getWriter().write("bad");
		} else { // 중복X 
			response.getWriter().write("good");
		}
	}

}
