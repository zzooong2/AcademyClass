package kr.co.green.board.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dao.NewsDao;
import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.NewsDto;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.upload.UploadFile;
import kr.co.green.common.validation.DataValidation;

@Service
public class NewsServiceImpl implements BoardService {
	
	// 객체 생성
	private final NewsDao nDao;
	private final UploadFile uf;
	private final DataValidation dv;
	private BoardDto nDto; 
	
	@Autowired
	public NewsServiceImpl(NewsDao nDao, UploadFile upload, DataValidation dv) {
		this.nDao = nDao;
		this.uf = upload;
		this.dv = dv;
		this.nDto = new NewsDto();
	}

	// 게시글 리스트 가져오기
	@Override
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		return nDao.getList(pi, bDto);
	}

	// 게시글 수량 조회
	@Override
	public int getListCount(BoardDto bDto) {
		return nDao.getListCount(bDto);
	}

	// 게시글 상세보기
	@Override
	public BoardDto getDetail(BoardDto bDto, String type) {
		try {
			// 조회수 증가
			int result = 0;
			if(type.equals("detail")) {
				result = nDao.addViews(bDto);
			} else if (type.equals("edit")) {
				result = 1;
			}
			// 게시글 조회
			nDto = nDao.getDetail(bDto);
			return nDto;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// 게시글 작성 비즈니스 로직
	@Override
	public int setEnroll(BoardDto bDto, MultipartFile upload, HttpSession session) {
		if(dv.lengthCheck("boardContent", 300)) {
			// 게시글 작성
			int result = nDao.setEnroll(bDto);
			System.out.println(upload);
			
			if(result ==1 && !upload.isEmpty()) {
				// 첨부파일 올리기
				uf.upload(bDto, upload, session);
				return nDao.setUpload(bDto);
			} else if (result == 1) 
				return result;
			}
		return 0;
	}
	
	// 게시글 삭제
	@Override
	public int delete(int boardNo, int memberNo, int loginMemberNo) {
		int result = 0;
		// 1. 작성자 맞는지 확인
		if(memberNo == loginMemberNo) {
			// 2. 파일 삭제(없으면 패스)
			BoardDto bDto = nDao.getFileName(boardNo);
			if(bDto != null) {
				// uploads경로에 있는 파일 삭제
				uf.deleteFile(bDto);
				// DB 데이터 삭제
				nDao.deleteBoardData(boardNo);
			}
			// 3. 게시글 삭제
			result = nDao.deleteBoard(boardNo);
		} else {
			return 0;
		}
		return result;
	}
	
	// 게시글 수정 페이지 이동
	@Override
	public BoardDto getEditForm(BoardDto bd) {
		return null;
	}

	// 게시글 수정 비즈니스 로직
	@Override
	public int edit(BoardDto bDto, MultipartFile upload, int loginMemberNo) {
		// 1. 사용자 검증
		// 2. 유효성 검사 (제목: 최대 300Byte)
		int updateResult = 0;
		if(bDto.getMemberNo() == loginMemberNo && dv.lengthCheck(bDto.getBoardTitle(), 300)) {
			// 3. 제목, 내용 수정
			updateResult = nDao.edit(bDto);
			
			// 4. 파일 있을 때: 기존 파일 삭제, 새 파일 업로드, 데이터 변경
			if(updateResult == 1 && !upload.isEmpty()) {
				BoardDto getFileName = nDao.getFileName(bDto.getBoardNo());
				uf.upload(bDto, upload, null);
				
				if(uf.deleteFile(getFileName) && bDto.getUploadName() != null) {
					return nDao.setNewsUploadUpdate(bDto) == 1 ? 1 : 0;
				}
			} 
		}
		// 5. 파일 없을 때: 새 파일 업로드 or 아무것도 안함
		return updateResult;
	}
}

