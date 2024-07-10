package kr.co.green.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.green.member.model.dto.MemberDto;

@Repository
public class MemberDao {
	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public MemberDao(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 아이디 중복검사
	public int checkId(MemberDto md) {
		return sqlSession.selectOne("memberMapper.checkId", md);
	}
	
	// 아이디 중복검사
	public int checkId(String memberId) {
		return sqlSession.selectOne("memberMapper.checkMemberId", memberId);
	}
	
	// 회원가입
	public int setRegister(MemberDto md) {
		return sqlSession.insert("memberMapper.setRegister", md);
	}
	
	// 정보확인
	public MemberDto getInfo(MemberDto md) {
		return sqlSession.selectOne("memberMapper.getInfo", md);
	}
	
	// 회원정보 가져오기
	public MemberDto getMemberInfo(String memberId) {
		return sqlSession.selectOne("memberMapper.getmemberInfo", memberId);
	}
	
	// 회원 삭제
	public int deleteMember(String memberId) {
		return sqlSession.delete("memberMapper.deleteMember", memberId);
	}

}
