package kr.co.green.contact.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;
import kr.co.green.contact.model.dto.ContactDTO;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/list.do")
public class ContactListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServiceImpl contactService = new ContactServiceImpl();
		
		// 페이징 처리
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		int listCount = contactService.getListCount();
		int pageLimit = 5; // 보여질 페이지의 수
		int boardLimit = 5; // 한 페이지에 보여질 게시글의 수
		int row = listCount - (cPage-1) * boardLimit; // 게시글 번호 구하기
		
		PageInfo pi = Pagination.getPageInfo(listCount, cPage, pageLimit, boardLimit);
		
		ArrayList<ContactDTO> list = contactService.getList(pi);
		
		// 데이터 바인딩
		request.setAttribute("list", list);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
