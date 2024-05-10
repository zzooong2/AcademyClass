package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.common.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 조회
	public ArrayList<FreeDTOImpl> getList(PageInfo pi);
	
	// 게시글 수량 조회
	public int getListCount();
	
	// 게시글 등록
	public int enroll(BoardDTO boardDTO);
	
	// 게시글 수정
	
	
	// 게시글 삭제

}
