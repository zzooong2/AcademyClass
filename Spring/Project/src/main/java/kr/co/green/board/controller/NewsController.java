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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.NewsDto;
import kr.co.green.board.model.service.NewsServiceImpl;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.paging.Pagination;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private final NewsServiceImpl newsService;
	
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
//			int pathIndex = list.getUploadPath().lastIndexOf("resources");
//			String path = "/" + list.getUploadPath().substring(pathIndex);
//			
//			list.setUploadPath(path);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("row", row);
		
		return "board/news/newsList";
	}
	
	
	// 게시글 상세보기
	@GetMapping("/detail.do")
	public String getNewsDetail(Model model, BoardDto bd) {
		BoardDto detail = newsService.getDetail(bd, "detail");

		if(!Objects.isNull(detail)) {
			
			if(detail.getUploadPath() != null && detail.getUploadName() != null && detail.getUploadOriginName() != null && detail.getUploadNo() != null) {
				int pathIndex = detail.getUploadPath().lastIndexOf("resources");
				String path = "/" + detail.getUploadPath().substring(pathIndex);
				
				detail.setUploadPath(path);
			}
			model.addAttribute("detail", detail);
			return "board/news/newsDetail";
		} else {
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
	public String enroll(BoardDto bDto, MultipartFile upload, HttpSession session) {
		bDto.setMemberNo((int)session.getAttribute("memberNo"));
		int enrollResult = newsService.setEnroll(bDto, upload, session);
		
		if(enrollResult == 1) {
			return "redirect:/news/list.do";
		} else {
			return "common/error";
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
	public String edit(BoardDto bd, MultipartFile upload, @SessionAttribute("memberNo")int loginMemberNo) {
		int result = newsService.edit(bd, upload, loginMemberNo);
		
		if(result == 1) {
			return "redirect:/news/list.do?boardNo="+bd.getBoardNo();
		} else {
		return "common/error";
		}
	}
	
	// 게시글 삭제 비즈니스 로직
	@GetMapping("/delete.do")
	public String delete(int boardNo, int memberNo, @SessionAttribute("memberNo") int loginMemberNo) {
		int result = newsService.delete(boardNo, memberNo, loginMemberNo);
		
		if(result == 1) {
			return "redirect:/news/list.do";
		} else {
			return "common/error";
		}
	}
}
