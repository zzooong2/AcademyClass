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

	@Override
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		return fDao.getList(pi, bDto);
	}
	
	@Override
	public int getListCount(BoardDto bDto) {
		return fDao.getListCount(bDto);
	}
	
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

}
