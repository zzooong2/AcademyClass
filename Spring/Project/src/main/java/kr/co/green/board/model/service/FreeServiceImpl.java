package kr.co.green.board.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public BoardDto getDetail(BoardDto bDto, String type) {
		
		try{
			// 조회수 증가
			int result = 0;
			if(type.equals("detail")) {
				result = fDao.addViews(bDto);
			} else if(type.equals("edit")) {
				result = 1;
			}
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
		if(dv.lengthCheck(bDto.getBoardTitle(), 300) ) {

			int result = fDao.setEnroll(bDto);
			
			if(result == 1 &&  !upload.isEmpty() ) {
				uf.upload(bDto, upload, session);
				return fDao.setUpload(bDto);
			} else if(result == 1) {
				return result;
			}
		}
		return 0;
	}

	// 게시글 삭제
	@Override
//	public int delete(int boardNo, int memberNo, HttpSession session) {
	public int delete(int boardNo, int memberNo, @SessionAttribute("memberNo") int loginMemberNo) {
		// 삭제 요청한 사람이 작성자가 맞는지 검증
//		if(memberNo == (int)session.getAttribute("memberNo")) {
		if(memberNo == loginMemberNo) {
			int result = fDao.delete(boardNo);
			if(result == 1) {
				// 파일 이름 가져오기
				BoardDto bDto = fDao.getFileName(boardNo);
				
				// 파일 삭제
				return uf.deleteFile(bDto) ? 1 : 0;
			}
		}
		return 0;
	}
	
	// 게시글 수정 페이지 이동
	@Override
	public BoardDto getEditForm(BoardDto bd) {
		return fDao.getEditForm(bd);
	}
	
	// 게시글 수정
	@Override
	public int edit(BoardDto bDto, MultipartFile upload, int loginMemberNo) {
		int updateResult = 0;
		// 1. 사용자 검증
		// 2. 유효성 검사 (제목: 최대 300byte)
		if(bDto.getMemberNo() == loginMemberNo && dv.lengthCheck(bDto.getBoardTitle(), 300)) {
			// 3. 제목, 내용 수정 
			updateResult = fDao.edit(bDto);
			
			// 4. 파일 있을 때: 기존 파일 삭제, 새 파일 업로드, 데이터 변경
			if(updateResult == 1 && !upload.isEmpty()) {
				BoardDto getFileName = fDao.getFileName(bDto.getBoardNo());
				uf.upload(bDto, upload, null);
				
				if(uf.deleteFile(getFileName) && bDto.getUploadName() != null) {
					return fDao.setUploadUpdate(bDto) == 1 ? 1 : 0;
				}
			}
			// 5. 파일 없을 때 : 새 파일 업로드 or 아무것도 안함
		}
		return updateResult;
	}
}
