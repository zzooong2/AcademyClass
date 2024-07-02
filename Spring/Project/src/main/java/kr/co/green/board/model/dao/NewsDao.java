package kr.co.green.board.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.common.paging.PageInfo;

@Repository
public class NewsDao {
	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public NewsDao(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 게시글 리스트 가져오기
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		RowBounds rb = new RowBounds(pi.getOffset(), pi.getBoardLimit());
		
		return sqlSession.selectList("newsMapper.getList", bDto, rb);
	}
	
	// 게시글 수량 조회
	public int getListCount(BoardDto bDto) {
		return sqlSession.selectOne("newsMapper.getListCount", bDto);
	}
	
	// 게시글 상세 조회
	public BoardDto getDetail(BoardDto bDto) {
		return sqlSession.selectOne("newsMapper.getNewsDetail", bDto);
	}
	
	// 조회수 증가
	public int addViews(BoardDto bDto) {
		return sqlSession.update("newsMapper.addViews", bDto);
	}
	
	// 게시글 작성
	public int setEnroll(BoardDto bDto) {
		return sqlSession.insert("newsMapper.setEnroll", bDto);
	}

	// 파일 업로드
	public int setUpload(BoardDto bDto) {
		return sqlSession.insert("newsMapper.setUpload", bDto);
	}
	
	// 게시글 수정
	public int edit(BoardDto bDto) {
		return sqlSession.update("newsMapper.updateBoard", bDto);
	}

	// 파일 이름 가져오기
	public BoardDto getFileName(int boardNo) {
		return sqlSession.selectOne("newsMapper.getFileName", boardNo);
	}
	
	// 파일 새로고침
	public int setNewsUploadUpdate(BoardDto bDto) {
		return sqlSession.update("newsMapper.setNewsUploadUpdate", bDto);
	}
	
	// 게시글 삭제
	public int deleteBoard(int boardNo) {
		return sqlSession.delete("newsMapper.deleteBoard", boardNo);
	}
	
	// 게시글에 첨부된 데이터 삭제 (DB)
	public int deleteBoardData(int boardNo) {
		return sqlSession.delete("newsMapper.deleteBoardData", boardNo);
	}
	
}
