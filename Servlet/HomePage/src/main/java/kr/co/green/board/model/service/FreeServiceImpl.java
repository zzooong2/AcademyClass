package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dao.FreeDAO;
import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.common.PageInfo;

public class FreeServiceImpl implements BoardService{
	
	// DAO 객체 생성
	FreeDAO freeDao;
	
	// 생성자를 이용하여 freeDao 인스턴스 변수로 선언
	public FreeServiceImpl() {
		freeDao = new FreeDAO();
	}
	
	// 게시글 리스트 조회
	@Override
	public ArrayList<FreeDTOImpl> getList(PageInfo pi) {
		return freeDao.getList(pi);
	}
	
	// 게시글 수량 조회
	@Override
	public int getListCount() {
		return freeDao.getListCount();
	}
	
	// 게시글 등록
	@Override
	public int enroll(BoardDTO boardDTO) {
		return freeDao.enroll(boardDTO);
	}
	
	// 게시글 수정
	
	
	// 게시글 삭제
}
