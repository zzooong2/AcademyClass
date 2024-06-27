package kr.co.green.board.model.service;

import java.util.List;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 가져오기
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto);
	
	// 게시글 수량 조회
	public int getListCount(BoardDto bDto);
	
	// 게시글 상세 조회(조회수 증가)
	public BoardDto getDetail(BoardDto bDto);
	
	// 게시글 작성
	public int setEnroll(BoardDto bDto);
	
	// 게시글 삭제
	public int delete(int boardNo);
}
