package kr.co.green.common.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {
	
	private int listCount; // 전체 게시글 수
	private int cpage; // 현재 페이지
	private int pageLimit; // 페이지 수
	private int boardLimit; // 하나의 페이지에 보여질 게시글의 수

	private int maxPage; // 전체 페이지 수 
	private int startPage; // 시작 페이지
	private int endPage; // 마지막 페이지

	private int offset; // DB에서 가져올 데이터의 기준
}
