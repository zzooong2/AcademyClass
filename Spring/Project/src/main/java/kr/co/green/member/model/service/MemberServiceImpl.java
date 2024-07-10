package kr.co.green.member.model.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.green.member.model.dao.MemberDao;
import kr.co.green.member.model.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	// 객체 생성
	private final MemberDao mDao; 
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberServiceImpl(MemberDao mDao, BCryptPasswordEncoder passwordEncoder) {
		this.mDao = mDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	// 아이디 중복검사
	@Override
	public int checkId(MemberDto md) {
		return mDao.checkId(md);
	}
	
	// 아이디 중복검사
	@Override
	public int checkId(String memberId) {
		return mDao.checkId(memberId);
	}
	
	// 회원가입
	@Override
	public int setRegister(MemberDto md) {
		// 이름 유효성 검사
		String name = md.getMemberName();;
		String nameRegex = "^[가-힣]+$";
		
		if(name.matches(nameRegex)) {
			// 패스워드 암호화
			String password = passwordEncoder.encode(md.getMemberPassword());
			md.setMemberPassword(password);
			return mDao.setRegister(md);
		} else {
			return 0;
		}
	}
	
	// 로그인
	@Override
	public MemberDto login(MemberDto md) {
		MemberDto result = mDao.getInfo(md);
		
		// 쿼리문 결과가 Null인지, PW가 DB에 있는 데이터와 일치하는지 확인
		if(!Objects.isNull(result) && passwordEncoder.matches(md.getMemberPassword(), result.getMemberPassword())) {
			return result;
		} else {
			return null;
		}
	}
	
	// 회원정보 찾기
	@Override
	public MemberDto getMemberInfo(String memberId) {
		MemberDto result = mDao.getMemberInfo(memberId);
		
		if(result != null) {
			return result;
		} else {
			return null;
		}
	}
	
	// 회원 삭제
	@Override
	public int deleteMember(String memberId) {
		int result = mDao.deleteMember(memberId);
		
		 if(result == 1) {
		 	 return result;
		 } else {
			 return 0;
		 }
	}
}
