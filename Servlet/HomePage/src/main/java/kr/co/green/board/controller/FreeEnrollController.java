package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/enroll.do")
public class FreeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 데이터 받아서 변수에 저장
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 게시글 작성자 확인
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		
		// DTO 정보저장
		FreeDTOImpl freeDTO = new FreeDTOImpl();
		freeDTO.setBoardTitle(title);
		freeDTO.setBoardContent(content);
		freeDTO.setMemberNo(memberNo);
		
		// 서비스 호출
		FreeServiceImpl freeService = new FreeServiceImpl();
		
		int result = freeService.enroll(freeDTO);
		
		if(result == 1) {
			response.sendRedirect("/freeBoard/list.do?cPage=1");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeEnroll.jsp");
			view.forward(request, response);
		}
	}

}
