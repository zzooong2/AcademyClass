package kr.co.green.member.model.service;

import kr.co.green.member.model.dao.MemberDAO;
import kr.co.green.member.model.dto.Member;

public class MemberServiceImpl implements MemberService{

	// dao 객체 인스턴스 변수로 선언
	private MemberDAO dao;
	
	// 생성자
	public MemberServiceImpl() {
		dao = new MemberDAO();
	};
	
	// 회원가입 구현 메서드
	@Override
	public int register(Member member) {
		return dao.register(member);
	}
	
	// 로그인 구현 메서드
	@Override
	public Member login(Member member) {
		return dao.login(member);
	}
	
}
