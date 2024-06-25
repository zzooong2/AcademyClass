package kr.co.green.board.model.service;

import java.util.List;

import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 가져오기
	public List<FreeDto> getList(PageInfo pi, FreeDto fd);
	
	// 게시글 수량 조회
	public int getListCount(FreeDto fd);

}
