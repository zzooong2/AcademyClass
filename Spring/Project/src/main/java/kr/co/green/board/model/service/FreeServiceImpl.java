package kr.co.green.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.green.board.model.dao.FreeDao;
import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

@Service
public class FreeServiceImpl implements BoardService{
	
	private final FreeDao fDao;
	private BoardDto fDto;
	
	@Autowired
	public FreeServiceImpl(FreeDao fDao) {
		this.fDao = fDao;
		this.fDto = new FreeDto();
	}
	
	// 전체 게시글 조회
	@Override
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		return fDao.getList(pi, bDto);
	}
	
	// 게시글 수량 조회
	@Override
	public int getListCount(BoardDto bDto) {
		return fDao.getListCount(bDto);
	}
	
	// 게시글 상세보기
	@Override
	public BoardDto getDetail(BoardDto bDto) {
		
		try{
			// 조회수 증가
			int result = fDao.addViews(bDto);
			// 게시글 조회
			fDto = fDao.getDetail(bDto);
			return fDto;
		} catch(Exception e) {
			return null;
		}
	}
	
	// 게시글 작성 비즈니스 로직
	@Override
	public int setEnroll(BoardDto bDto) {
		return fDao.setEnroll(bDto);
	}
	
	// 게시글 삭제
	@Override
	public int delete(int boardNo) {
		return fDao.delete(boardNo);
	}
}
