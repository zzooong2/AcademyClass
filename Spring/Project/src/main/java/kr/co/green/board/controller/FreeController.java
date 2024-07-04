package kr.co.green.board.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	private static final Logger logger = LogManager.getLogger(FreeController.class);

	@Autowired
	public FreeController(FreeServiceImpl freeService) {
		this.freeService = freeService;
	}

	// 게시글 리스트 조회
	@GetMapping("/list.do")
	// @RequestParam: spring에서 쿼리스트링을 받을 때 사용 / value = key
	public String getFreeList(Model model, @RequestParam(value = "cpage", defaultValue = "1") int cpage, FreeDto fd, HttpSession session) {
		// (1) DTO 객체 생성, Service 호출
//		FreeDto fd = new FreeDto();
//		FreeServiceImpl freeService = new FreeServiceImpl();
		
		logger.info("/free/list.do 호출완료: cpage={}, memberNo={}", cpage, session.getAttribute("memberNo"));
		
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

		// debug, info, error
		// debug: 어떤 변수를 확인하거나, 값이 잘 들어 왔는지 확인
		// info: 게시글 조회 요청(boardNo=3), 게시글 등록 성공
		// error: 예외 발생, 게시글 등록 실패, 사용자 검증 실패, 게시글 제목이 너무 길때
		logger.debug("호출된 게시글: list size={}", list.size());
		
		// src > main > webapp > WEB-INF > spring > appServlet
		// 위 경로에 위치한 servlet-context.xml 파일에 19~20 열에 기재되어 있기에 "/WEB-INF/views/", ".jsp"
		// 생략 가능
		return "board/free/freeList";
	}

	// 게시글 상세보기
	@GetMapping("/detail.do")
	public String getDetail(Model model, BoardDto fd, @SessionAttribute("memberNo")int loginMemberNo) {
		BoardDto detail = freeService.getDetail(fd, "detail");
		
		if (!Objects.isNull(detail)) {
			if (detail.getUploadPath() != null && detail.getUploadNo() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				detail.setUploadPath(path);
			}
			model.addAttribute("detail", detail);
			model.addAttribute("loginMemberNo", loginMemberNo);
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
//	public String delete(int boardNo, int memberNo, HttpSession session) {
	public String delete(int boardNo, int memberNo, @SessionAttribute("memberNo") int loginMemberNo) {
		int result = freeService.delete(boardNo, memberNo, loginMemberNo);
		
		if (result == 1) {
			return "redirect:/free/list.do";
		} else {
			return "common/error";
		}
	}
	
	// 게시글 수정 페이지 이동
	@GetMapping("/editForm.do")
	public String getEditForm(Model model, BoardDto fd, HttpSession session) {
		BoardDto detail = freeService.getDetail(fd, "edit");
		
		if (!Objects.isNull(detail)) {
			if (detail.getUploadPath() != null && detail.getUploadNo() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				detail.setUploadPath(path);
			}
			model.addAttribute("detail", detail);
			return "board/free/freeEdit";
		}
		return "common/error";
		
	}
	
	// 게시글 수정 비즈니스 로직
	@PostMapping("/edit.do")
	public String edit(BoardDto bd, MultipartFile upload, @SessionAttribute("memberNo") int loginMemberNo) {
		int result = freeService.edit(bd, upload, loginMemberNo);
		
		if(result == 1) {
			return "redirect:/free/detail.do?boardNo=" + bd.getBoardNo();
		} else {
			return "/common/error";
		}
	}

}
