package kr.co.green.member.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.green.member.model.dto.MemberDto;
import kr.co.green.member.model.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	// 서비스 객체 생성
	private final MemberServiceImpl memberService;
	
	@Autowired
	public MemberController(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	// 회원가입 페이지 이동
	@GetMapping("/registerForm.do")
	public String getRegisterForm() {
		return "member/register";
	}

	// 회원가입 로직
	@PostMapping("/register.do")
	public String setRegister(MemberDto member) {
		int result = memberService.setRegister(member);
		
		if(result == 1) {
			return "member/login";
		}
		return "common/error";
	}
	
	// 이메일 중복 검사
	@PostMapping("/checkId.do")
	@ResponseBody
	public String checkId(MemberDto md) {
		int result = memberService.checkId(md);
		
		if(result == 1) {
			return "false"; 
		} else {
			return "true";
		}
	}
	
	// 로그인 페이지 이동
	@GetMapping("/loginForm.do")
	public String loginForm() {
		return "member/login";
	}
	
	// 로그인
	@PostMapping("/login.do")
	public String login(MemberDto md, HttpSession session) {
		MemberDto loginUser = memberService.login(md);
		
		if(!Objects.isNull(loginUser)) {
			session.setAttribute("memberNo", loginUser.getMemberNo());
			session.setAttribute("memberName", loginUser.getMemberName());
			session.setAttribute("memberId", loginUser.getMemberId());
			session.setAttribute("memberIndate", loginUser.getMemberIndate());
			session.setAttribute("memberType", loginUser.getMemberType());

			// Controller -> jsp 
			return "home";
			
			// Controller -> Controller
//			return "redirect:/free/list.do"
		} else {
			return "common/error";
		}
	}
	
//	// 로그아웃 ver1
//	@GetMapping("/logout.do")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "home";
//	}
	
	// 로그아웃 ver2
	@GetMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		// 현재 세션이 있으면 세션 가져오고, 없으면 null 반환
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			return "home";
		}
		return null;
	}
}
