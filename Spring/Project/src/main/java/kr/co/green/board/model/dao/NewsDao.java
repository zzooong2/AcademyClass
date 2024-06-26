package kr.co.green.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
