package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.contact.model.dto.ContactDTO;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contactEnroll.do")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 이름, 이메일, 메시지 데이터 받아서 변수에 저장
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		// 세션에 받아온 데이터 저장
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");

		ContactDTO contactDTO = new ContactDTO(name, email, message, memberNo);
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		int result = contactService.enroll(contactDTO);
		
		if(result == 1) {
			response.sendRedirect("/");
		}
		
	}

}
