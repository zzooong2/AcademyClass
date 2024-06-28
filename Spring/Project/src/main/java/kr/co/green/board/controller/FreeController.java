package kr.co.green.board.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.board.model.service.FreeServiceImpl;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.paging.Pagination;

@Controller
@RequestMapping("/free") // GET + POST
public class FreeController {
	// (2) new 키워드를 사용하지 않고 Autowired 어노테이션으로 자동생성 가능(불변성이 없다는 단점이 존재)
//	@Autowired 
//	private FreeDto fd;

	// (3) 불변성이 없다는 단점을 보완하기 위해 상수 + 생성자 이용
	private final FreeServiceImpl freeService;

	@Autowired
	public FreeController(FreeServiceImpl freeService) {
		this.freeService = freeService;
	}

	// 게시글 리스트 조회
	@GetMapping("/list.do")
	// @RequestParam: spring에서 쿼리스트링을 받을 때 사용 / value = key
	public String getFreeList(Model model, @RequestParam(value = "cpage", defaultValue = "1") int cpage, FreeDto fd) {
		// (1) DTO 객체 생성, Service 호출
//		FreeDto fd = new FreeDto();
//		FreeServiceImpl freeService = new FreeServiceImpl();

		// 페이지처리
		// 1. 전체 게시글 수 구하기
		int listCount = freeService.getListCount(fd);
		int pageLimit = 5; // 1~5 6~10 11~15 16~20
		int boardLimit = 5; // 한 페이지에 보여질 게시글 수
		int row = listCount - (cpage - 1) * boardLimit;

		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);

		List<BoardDto> list = freeService.getList(pi, fd);

		// 데이터 바인딩
		model.addAttribute("row", row);
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);

		// src > main > webapp > WEB-INF > spring > appServlet
		// 위 경로에 위치한 servlet-context.xml 파일에 19~20 열에 기재되어 있기에 "/WEB-INF/views/", ".jsp"
		// 생략 가능
		return "board/free/freeList";
	}

	// 게시글 상세보기
	@GetMapping("/detail.do")
	public String getDetail(Model model, BoardDto fd) {
		BoardDto detail = freeService.getDetail(fd);
		
		if (!Objects.isNull(detail)) {
			if (detail.getUploadPath() != null && detail.getUploadNo() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				detail.setUploadPath(path);
			}
			model.addAttribute("detail", detail);
			return "board/free/freeDetail";
		}
		return "common/error";
	}

	// 게시글 작성 페이지 이동
	@GetMapping("/enrollForm.do")
	public String getEnroll(HttpSession session) {
		Object memberNo = session.getAttribute("memberNo");

		if (memberNo != null) {
			return "board/free/freeEnroll";
		} else {
			return "common/error";
		}
	}

	// 게시글 작성 로직
	@PostMapping("/enroll.do")
	public String setEnroll(BoardDto bDto, MultipartFile upload ,HttpSession session) {
		bDto.setMemberNo((int) session.getAttribute("memberNo"));
		int result = freeService.setEnroll(bDto, upload, session);

		if (result == 1) {
			return "redirect:/free/list.do";
		} else {
			return "common/error";
		}
	}

	// 게시글 삭제
	@GetMapping("/delete.do")
	public String delete(int boardNo) {
		int result = freeService.delete(boardNo);

		if (result == 1) {
			return "redirect:/free/list.do";
		} else {
			return "common/error";
		}
	}
	
	// 게시글 수정 페이지 이동
	@GetMapping("/editForm.do")
	public String getEditForm(Model model, int boardNo) {
		BoardDto result = freeService.getEditForm(boardNo);
		
		model.addAttribute("result", result);
		
		return "board/free/freeEdit";
	}
	
	// 게시글 수정 비즈니스 로직
	@PostMapping("/edit.do")
	public String edit(BoardDto bd) {
		int result = freeService.edit(bd);
		
		if(result == 1) {
			return "redirect:/free/detail.do?boardNo=" + bd.getBoardNo();
		} else {
			return "common/error";
		}
	}

}
