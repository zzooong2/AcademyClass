package kr.co.green.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.green.board.model.dao.NewsDao;
import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.board.model.dto.NewsDto;
import kr.co.green.common.paging.PageInfo;

@Service
public class NewsServiceImpl implements BoardService {
	
	// 객체 생성
	private final NewsDao nDao;
	private BoardDto nDto; 
	
	@Autowired
	public NewsServiceImpl(NewsDao nDao) {
		this.nDao = nDao;
		this.nDto = new NewsDto();
	}

	// 게시글 리스트 가져오기
	@Override
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		return nDao.getList(pi, bDto);
	}

	@Override
	public int getListCount(BoardDto bDto) {
		return nDao.getListCount(bDto);
	}

	@Override
	public BoardDto getDetail(BoardDto bDto) {
		
		try {
			int result = nDao.addViews(bDto);
			nDto = nDao.getDetail(bDto);
			return nDto;
		} catch(Exception e) {
			return null;
		}
	}
	
}

