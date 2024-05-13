package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/delete.do")
public class FreeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		FreeDTOImpl freeDTO = new FreeDTOImpl();
		freeDTO.setBoardNo(boardNo);
		
		FreeServiceImpl freeService = new FreeServiceImpl();
		
		int result = freeService.delete(freeDTO);
		
		if(result == 1) {
			response.sendRedirect("/freeBoard/list.do?cPage=1");
		}
		
		
	}

}
