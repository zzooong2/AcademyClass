package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/edit.do")
public class FreeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FreeEditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		FreeDTOImpl freeDTO = new FreeDTOImpl();
		
		freeDTO.setBoardNo(boardNo);
		freeDTO.setBoardTitle(boardTitle);
		freeDTO.setBoardContent(boardContent);
		
		FreeServiceImpl freeService = new FreeServiceImpl();
		
		int result = freeService.setEdit(freeDTO);
		
		if(result == 1) {
			response.sendRedirect("/freeBoard/detail.do?boardNo=" + boardNo);
		}
	}

}
