package kr.co.green.board.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dao.FreeDao;
import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.upload.UploadFile;
import kr.co.green.common.validation.DataValidation;

@Service
public class FreeServiceImpl implements BoardService{
	
	private final FreeDao fDao;
	private final DataValidation dv;
	private final UploadFile uf;
	private BoardDto fDto;
	
	@Autowired
	public FreeServiceImpl(FreeDao fDao, DataValidation dv, UploadFile uf) {
		this.fDao = fDao;
		this.dv = dv;
		this.uf = uf;
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
			System.out.println(e);
			return null;
		}
	}
	
	// 게시글 작성 비즈니스 로직
	@Override
	public int setEnroll(BoardDto bDto, MultipartFile upload, HttpSession session) {
		if(dv.lengthCheck(bDto.getBoardTitle(), 300) && dv.lengthCheck(bDto.getBoardContent(), 1000)) {
			uf.upload(bDto, upload, session);
			
			int result = fDao.setEnroll(bDto);
			int result2 = 0;
			if(result == 1) {
				result2 = fDao.setUpload(bDto);
			}
			return result2;
		} else {
			return 0;
		}
	}

	// 게시글 삭제
	@Override
	public int delete(int boardNo) {
		return fDao.delete(boardNo);
	}
	
	// 게시글 수정 페이지 이동
	@Override
	public BoardDto getEditForm(int boardNo) {
		return fDao.getEditForm(boardNo);
	}
	
	// 게시글 수정
	@Override
	public int edit(BoardDto bDto) {
		return fDao.edit(bDto);
	}
}
