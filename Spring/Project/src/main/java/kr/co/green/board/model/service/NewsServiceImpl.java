package kr.co.green.board.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(NewsServiceImpl.class);
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
		
		logger.info("게시글 조회 요청: boardNo={}", bDto.getBoardNo());
		
		try {
			// 조회수 증가
			int result = 0;
			if(type.equals("detail")) {
				result = nDao.addViews(bDto);
			} else if (type.equals("edit")) {
				result = 1;
			}
			// 게시글 조회
			logger.info("게시글 상세 조회 성공: boardNo={}", bDto.getBoardNo());
			nDto = nDao.getDetail(bDto);
			return nDto;
		} catch(Exception e) {
			logger.info("게시글 상세 조회 실패: 결과 없음, boardNo={}", bDto.getBoardNo());
			logger.info("게시글 상세 조회 중 예외발생, Exception: ", e);
			System.out.println(e);
			return null;
		}
	}
	
	// 게시글 작성 비즈니스 로직
	@Override
	public int setEnroll(BoardDto bDto, MultipartFile upload, HttpSession session) {
		logger.info("게시글 등록 요청: BoardDto={}, MultipartFile={}", bDto, upload);
		
		if(dv.lengthCheck("boardContent", 300)) {
			// 게시글 작성
			int result = nDao.setEnroll(bDto);
			System.out.println(upload);
			logger.info("게시글 등록 및 파일 업로드 정보 저장 성공: boardNo={}", bDto.getBoardNo());
			
			if(result ==1 && !upload.isEmpty()) {
				// 첨부파일 올리기
				uf.upload(bDto, upload, session);
				logger.info("파일 업로드 성공 boardNo={}", bDto.getBoardNo());
				return nDao.setUpload(bDto);
			} else if (result == 1) 
				logger.info("게시글 등록 성공(업로드 파일 없음): boardNo={}", bDto.getBoardNo());
				return result;
			}
		logger.info("게시글 등록 실패: 제목길이 검증 실패");
		return 0;
	}
	
	// 게시글 삭제
	@Override
	public int delete(int boardNo, int memberNo, int loginMemberNo) {
		logger.info("게시글 삭제 요청: boardNo={}, memberNo={}, loginMemberNo={}", boardNo, memberNo, loginMemberNo);
		
		int result = 0;
		BoardDto bDto = nDao.getFileName(boardNo);
		// 1. 작성자 맞는지 확인
		if(memberNo == loginMemberNo) {
			// 2. 파일 삭제(없으면 패스)
			if(bDto != null) {
				// uploads경로에 있는 파일 삭제
				boolean uploadDeleteResult = uf.deleteFile(bDto);
				// DB 데이터 삭제
				int fileDeleteResult = nDao.deleteBoardData(boardNo);
				
				if(uploadDeleteResult == true && fileDeleteResult == 1) {
					logger.info("파일 삭제 성공: boardNo={}, boardUploadName={}", boardNo, bDto.getUploadName());
				} else {
					logger.info("파일 삭제 실패: boardNo={}, boardUploadName={}", boardNo, bDto.getUploadName());
				}
				
			}
			// 3. 게시글 삭제
			result = nDao.deleteBoard(boardNo);
			if(result == 1) {
				logger.info("게시글 삭제 성공: boardNo={}", boardNo);
			} else {
				logger.info("게시글 삭제 실패: boardNo={}", boardNo);
			}
		} else {
			logger.info("게시글 삭제 실패: 사용자 검증 실패");
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
		logger.info("게시글 수정 요청: BoardDto={}, loginMemberNo={}", bDto, loginMemberNo);
		
		// 1. 사용자 검증
		// 2. 유효성 검사 (제목: 최대 300Byte)
		int updateResult = 0;
		if(bDto.getMemberNo() == loginMemberNo && 
		   dv.lengthCheck(bDto.getBoardTitle(), 300) && 
		   !bDto.getBoardTitle().equals("") && 
		   !bDto.getBoardContent().equals("")) {
			// 3. 제목, 내용 수정
			updateResult = nDao.edit(bDto);
			logger.info("게시글 수정 성공: boardNo={}", bDto.getBoardNo());
			
			// 4. 파일 있을 때: 기존 파일 삭제, 새 파일 업로드, 데이터 변경
			if(updateResult == 1 && !upload.isEmpty()) {
				BoardDto getFileName = nDao.getFileName(bDto.getBoardNo());
				uf.upload(bDto, upload, null);
				logger.info("새로운 파일 업로드 성공: boardNo={}, boardUploadName={}", bDto.getBoardNo(), bDto.getUploadName());
				
				if(uf.deleteFile(getFileName) && bDto.getUploadName() != null) {
					logger.info("기존 파일 삭제 성공: boardNo={}, boardUploadName={}", bDto.getBoardNo(), bDto.getUploadName());
					return nDao.setNewsUploadUpdate(bDto) == 1 ? 1 : 0;
				} else {
					logger.info("기존 파일 삭제 실패: boardNo={}, boardUploadName={}", bDto.getBoardNo(), bDto.getUploadName());
				}
			} else {
				if(bDto.getUploadName() != null) {
					logger.info("새로운 파일 업로드 실패: boardNo={}, boardUploadName={}", bDto.getBoardNo(), bDto.getUploadName());
				}
			}
		} else {
			// 5. 파일 없을 때: 새 파일 업로드 or 아무것도 안함
			logger.info("게시글 수정 실패: 제목 길이 검증 실패");
		}
		return updateResult;
	}
}

