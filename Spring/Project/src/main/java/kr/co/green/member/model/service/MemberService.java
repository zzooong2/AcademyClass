package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.MemberDto;

public interface MemberService {

	// 아이디 중복검사
	public int checkId(MemberDto md);
	public int checkId(String memberId);
	
	// 회원가입
	public int setRegister(MemberDto md);
	
	// 로그인
	public MemberDto login(MemberDto md);
	
	// 회원정보 찾기
	public MemberDto getMemberInfo(String memberId);
	
	// 회원 삭제
	public int deleteMember(String memberId);
}
