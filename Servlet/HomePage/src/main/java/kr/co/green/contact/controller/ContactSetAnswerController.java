package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.contact.model.dto.ContactDTO;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/setAnswer.do")
public class ContactSetAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactSetAnswerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String answerMessage = request.getParameter("answerMessage");
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		
		// 세션에서 값 가져오기
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		
		ContactDTO contactDTO = new ContactDTO();
		
		contactDTO.setAnswerContent(answerMessage);
		contactDTO.setAnswerWirter(userName);
		contactDTO.setInquiryNo(inquiryNo);
		
		int result = contactService.setAnswer(contactDTO);
		
		if(result==1) {
			response.sendRedirect("/contact/list.do?cPage=1");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactAnswer.jsp");
			view.forward(request, response);
		}
	}

}
