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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.NewsDto;
import kr.co.green.board.model.service.NewsServiceImpl;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.paging.Pagination;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private final NewsServiceImpl newsService;
	private static final Logger logger = LogManager.getLogger(NewsController.class);
	
	@Autowired
	public NewsController (NewsServiceImpl newsService) {
		this.newsService = newsService;
	}
	
	// 게시글 리스트 가져오기
	@GetMapping("/list.do")
	public String getNewsList(Model model,
							  @RequestParam(value="cpage", defaultValue="1")int cpage,
							  NewsDto nd) {
		int listCount = newsService.getListCount(nd);
		int pageLimit = 3;
		int boardLimit = 6;
		int row = listCount - (cpage-1) * boardLimit;
		
		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		List<BoardDto> list = newsService.getList(pi, nd);
		for(BoardDto item : list) {
			if(item.getUploadPath() != null) {
				int pathIndex = item.getUploadPath().lastIndexOf("resources");
				String path = "/" + item.getUploadPath().substring(pathIndex);
				
				item.setUploadPath(path);
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("row", row);
		
		return "board/news/newsList";
	}
	
	
	// 게시글 상세보기
	@GetMapping("/detail.do")
	public String getNewsDetail(Model model, BoardDto bd, HttpSession session) {
//	public String getNewsDetail(Model model, BoardDto bd, HttpServletRequest request) {
//		String referer = request.getHeader("referer");
//		System.out.println("referer: " + referer);
//		
//		if(referer == null || !referer.endsWith("/list.do")) {
//			return "common/error";
//		}
		
		logger.info("상세 조회 요청: boardNo={}, memberNo={}", bd.getBoardNo(), session.getAttribute("memberNo"));
		
		BoardDto detail = newsService.getDetail(bd, "detail");
		
		if(!Objects.isNull(detail)) {
			
			if(detail.getUploadPath() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null && detail.getUploadNo() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				
				detail.setUploadPath(path);
				
				logger.info("상세 조회 성공: boardNo={}", bd.getBoardNo());
			}
			model.addAttribute("detail", detail);
			return "board/news/newsDetail";
		} else {
			
			logger.info("상세 조회 실패: boardNo={}", bd.getBoardNo());
			return "common/error";
		}
	}
	
	
	// 게시글 등록 페이지 이동
	@GetMapping("/enrollForm.do")
	public String toEnrollPage() {
		return "board/news/newsEnroll";
	}
	
	// 게시글 등록 비즈니스 로직
	@PostMapping("/enroll.do")
	public String enroll(BoardDto bDto, MultipartFile upload, HttpSession session, RedirectAttributes redirectAttributes, @SessionAttribute("memberNo")int loginMemberNo) {
		bDto.setMemberNo((int)session.getAttribute("memberNo"));
		int enrollResult = newsService.setEnroll(bDto, upload, session);
		
		logger.info("[뉴스게시판] 게시글 등록 요청: memberNo={}", loginMemberNo);
		
		if(enrollResult == 1) {
			
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "success");
			redirectAttributes.addFlashAttribute("title", "게시글 등록 성공");
			redirectAttributes.addFlashAttribute("text", "게시글이 등록되었습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 등록 성공: boardNo={}", bDto.getBoardNo());
			
			return "redirect:/news/list.do";
		} else {
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "error");
			redirectAttributes.addFlashAttribute("title", "게시글 등록 실패");
			redirectAttributes.addFlashAttribute("text", "게시글 등록에 실패했습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 등록 실패: boardNo={}", bDto.getBoardNo());
			
			return "redirect:/error/accessDenied";
		}
	}
	
	// 게시글 수정 페이지 이동
	@GetMapping("/editForm.do")
	public String getEdit(Model model, BoardDto bd) {
		BoardDto detail = newsService.getDetail(bd, "edit");
		
		if(!Objects.isNull(detail)) {
			if(detail.getUploadPath() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null && detail.getUploadNo() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				detail.setUploadPath(path);
			}
			model.addAttribute("detail", detail);
			return "board/news/newsEdit";
		}
		return "common/error";
	}
	
	// 게시글 수정 비즈니스 로직
	@PostMapping("/edit.do")
	public String edit(BoardDto bd, MultipartFile upload, @SessionAttribute("memberNo")int loginMemberNo, RedirectAttributes redirectAttributes) {
		int result = newsService.edit(bd, upload, loginMemberNo);
		
		logger.info("[뉴스게시판] 게시글 수정 요청: boardNo={}, memberNo={}", bd.getBoardNo(), loginMemberNo);
		
		if(result == 1) {
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "success");
			redirectAttributes.addFlashAttribute("title", "게시글 수정 성공");
			redirectAttributes.addFlashAttribute("text", "게시글이 수정되었습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 수정 성공: boardNo={}", bd.getBoardNo());
			
			return "redirect:/news/list.do?boardNo="+bd.getBoardNo();
		} else {
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "error");
			redirectAttributes.addFlashAttribute("title", "게시글 수정 실패");
			redirectAttributes.addFlashAttribute("text", "게시글 수정에 실패했습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 수정 실패: boardNo={}", bd.getBoardNo());
			
			return "redirect:/error/accessDenied";
		}
	}
	
	// 게시글 삭제 비즈니스 로직
	@GetMapping("/delete.do")
	public String delete(int boardNo, int memberNo, @SessionAttribute("memberNo") int loginMemberNo, RedirectAttributes redirectAttributes) {
		int result = newsService.delete(boardNo, memberNo, loginMemberNo);
		
		logger.info("[뉴스게시판] 게시글 삭제 요청: memberNo={}", loginMemberNo);
		
		if(result == 1) {
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "success");
			redirectAttributes.addFlashAttribute("title", "게시글 삭제 성공");
			redirectAttributes.addFlashAttribute("text", "게시글이 삭제되었습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 삭제 성공: boardNo={}", boardNo);
			
			return "redirect:/news/list.do";
		} else {
			// SweetAlert
			redirectAttributes.addFlashAttribute("icon", "error");
			redirectAttributes.addFlashAttribute("title", "게시글 삭제 실패");
			redirectAttributes.addFlashAttribute("text", "게시글 삭제에 실패했습니다.");
			
			// Log4j
			logger.info("[뉴스게시판] 게시글 삭제 실패: boardNo={}", boardNo);
			return "redirect:/error/accessDenied";
		}
	}
}
