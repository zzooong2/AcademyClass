package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/detail.do")
public class FreeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글의 번호 불러오기 (request.getParameter 의 기본값은 String이므로 형변환)
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 서비스 객체 생성
		FreeServiceImpl freeService = new FreeServiceImpl();
		
		// 서비스 객체로 getDetail 메서드 실행 (매개변수로 입력한 게시글번호를 넘겨주어 SQL문장 실행)
		FreeDTOImpl result = freeService.getDetail(boardNo);
		result.setBoardViews(result.getBoardViews()+1);
		request.setAttribute("result", result);
	
		// 1. 불러온 게시글 번호를 이용해 게시글 상세조회하기 -> 필요정보: 제목, 내용, 작성일, 조회수, 작성자
		RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeDetail.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
