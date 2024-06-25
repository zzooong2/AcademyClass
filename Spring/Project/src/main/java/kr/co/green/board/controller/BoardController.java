package kr.co.green.board.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.board.model.service.FreeServiceImpl;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.paging.Pagination;

@Controller 
@RequestMapping("/free") // GET + POST
public class BoardController {
	// (2) new 키워드를 사용하지 않고 Autowired 어노테이션으로 자동생성 가능(불변성이 없다는 단점이 존재)
//	@Autowired 
//	private FreeDto fd;
	
	// (3) 불변성이 없다는 단점을 보완하기 위해 상수 + 생성자 이용
	private final FreeServiceImpl freeService;
	
	@Autowired
	public BoardController(FreeServiceImpl freeService) {
		this.freeService = freeService;
	}
	
	
	@GetMapping("/list.do")
	// @RequestParam: spring에서 쿼리스트링을 받을 때 사용 / value = key 
	public String getFreeList(Model model, 
			                  @RequestParam(value="cpage", defaultValue="1")int cpage, 
			                  FreeDto fd) {
		// (1) DTO 객체 생성, Service 호출
//		FreeDto fd = new FreeDto();
//		FreeServiceImpl freeService = new FreeServiceImpl();
		
		// 페이지처리
		// 1. 전체 게시글 수 구하기
		int listCount = freeService.getListCount(fd);
		int pageLimit = 5; // 1~5 6~10 11~15 16~20
		int boardLimit = 5; // 한 페이지에 보여질 게시글 수
		int row = listCount - (cpage-1) * boardLimit;
		
		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		List<FreeDto> list = freeService.getList(pi, fd);
		
		// 데이터 바인딩
		model.addAttribute("row", row);
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		// src > main > webapp > WEB-INF > spring > appServlet
		// 위 경로에 위치한 servlet-context.xml 파일에 19~20 열에 기재되어 있기에 "/WEB-INF/views/", ".jsp" 생략 가능
		return "board/free/freeList";
	}
	
}
