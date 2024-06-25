package kr.co.green.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<FreeDto> getList(PageInfo pi, FreeDto fd) {
		RowBounds rb = new RowBounds(pi.getOffset(), pi.getBoardLimit());

		return sqlSession.selectList("freeMapper.getList", fd, rb);
	}

	// 게시글 수량 조회
	public int getListCount(FreeDto fd) {
		return sqlSession.selectOne("freeMapper.getListCount", fd);
	}
}
