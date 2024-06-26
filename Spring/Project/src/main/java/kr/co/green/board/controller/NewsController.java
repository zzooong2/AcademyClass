package kr.co.green.board.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("row", row);
		
		return "board/news/newsList";
	}
	
	
	// 게시글 상세보기
	@GetMapping("/detail.do")
	public String getNewsDetail(Model model, BoardDto bd) {
		BoardDto detail = newsService.getDetail(bd);
		
		if(!Objects.isNull(detail)) {
			model.addAttribute("detail", detail);
			return "board/news/newsDetail";
		} else {
			return "common/error";
		}
		
	}
}
