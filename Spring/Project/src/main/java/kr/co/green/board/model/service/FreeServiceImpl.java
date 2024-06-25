package kr.co.green.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.green.board.model.dao.FreeDao;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

@Service
public class FreeServiceImpl implements BoardService{
	
	private final FreeDao fDao;
	
	@Autowired
	public FreeServiceImpl(FreeDao fDao) {
		this.fDao = fDao;
	}

	@Override
	public List<FreeDto> getList(PageInfo pi, FreeDto fd) {
		return fDao.getList(pi, fd);
	}
	
	@Override
	public int getListCount(FreeDto fd) {
		return fDao.getListCount(fd);
	}

}
