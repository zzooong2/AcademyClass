package kr.co.green.board.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

@Repository 
public class FreeDao {
	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public FreeDao(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 게시글 리스트 가져오기
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto) {
		RowBounds rb = new RowBounds(pi.getOffset(), pi.getBoardLimit());

		return sqlSession.selectList("freeMapper.getList", bDto, rb);
	}

	// 게시글 수량 조회
	public int getListCount(BoardDto bDto) {
		return sqlSession.selectOne("freeMapper.getListCount", bDto);
	}
	
	// 게시글 상세 조회
	public BoardDto getDetail(BoardDto bDto) {
		return sqlSession.selectOne("freeMapper.getFreeDetail", bDto);
	}
	
	// 조회수 증가
	public int addViews(BoardDto bDto) {
		return sqlSession.update("freeMapper.addViews", bDto);
	}
	
	// 게시글 작성 비즈니스 로직
	public int setEnroll(BoardDto bDto) {
		return sqlSession.insert("freeMapper.setEnroll", bDto);
	}
	
	// 게시글 작성시 파일 업로드
	public int setUpload(BoardDto bDto) {
		return sqlSession.insert("freeMapper.setUpload", bDto);
	}
	
	// 게시글 삭제
	public int delete(int boardNo) {
		return sqlSession.insert("freeMapper.delete", boardNo);
	}
	
	// 게시글 수정 페이지 이동
	public BoardDto getEditForm(int boardNo) {
		return sqlSession.selectOne("freeMapper.getEditForm", boardNo);
	}
	
	// 게시글 수정
	public int edit(BoardDto bDto) {
		return sqlSession.update("freeMapper.edit", bDto);
	}
	
}
