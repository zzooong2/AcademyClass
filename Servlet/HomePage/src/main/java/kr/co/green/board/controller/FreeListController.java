package kr.co.green.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;
import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;

@WebServlet("/freeBoard/list.do")
public class FreeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메서드를 구현하는 객체 생성
		FreeServiceImpl freeService = new FreeServiceImpl();

		// 페이징 처리 
		int cPage = Integer.parseInt(request.getParameter("cPage")); // .getParameter(): String형 값을 반환
		
		int listCount = freeService.getListCount(); // 전체 게시글 수 구하기
		
		int pageLimit = 5; // 보여질 페이지 수
		
		int boardLimit = 5; // 한 페이지에 보여질 게시글의 수
		
		int row = listCount - (cPage-1) * boardLimit; // 게시글 번호 구하기
		
		

		PageInfo pi = Pagination.getPageInfo(listCount, cPage, pageLimit, boardLimit);
		
		// 게시글 목록 불러오기
		ArrayList<FreeDTOImpl> list = freeService.getList(pi);
		
//			// 데이터 잘 받아오는지 확인
//			for(FreeDTOImpl item : list) {
//				System.out.println(item.getBoardNo());
//			}
		
		// 데이터바인딩(to JSP)
		request.setAttribute("list", list); // 게시글 목록
		request.setAttribute("row", row); // 게시글 번호
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
