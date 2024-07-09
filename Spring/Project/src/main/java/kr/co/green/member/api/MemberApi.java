package kr.co.green.member.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.green.member.model.dto.MemberDto;
import kr.co.green.member.model.service.MemberServiceImpl;

// RestController: Controller + ResponseBody -> MemberController의 아이디 중복검사(비동기) 할 때 사용했었음
// ResponseBody를 사용하면 view resolver를 거치지 않음(응답을 패킷에 넣어서 바로 전달)
@RestController
@RequestMapping("/api/member")
public class MemberApi {
	
	private final MemberServiceImpl memberService;
	
	public MemberApi(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	// ResponseEntity: 적절한 상태 코드와 응답 헤더 및 응답 본문을 생성하여 클라이언트에게 전달
	// @PathVariable: 경로 변수를 표시하기 위해 메서드의 매개변수에 사용 (localhost/api/member/abc -> {id} 값에 abc가 저장됨)
	@GetMapping("/{id}")
	public ResponseEntity getInfo(@PathVariable("id")String id) {
		// id에 대한 회원을 조회하는 로직
		MemberDto result = memberService.getMemberInfo(id);
		
//		MemberDto md = new MemberDto();
//		md.setMemberIndate("2024-07-08");
//		md.setMemberName("홍길동");
//		md.setMemberType("일반회원");
		
		// 조회한 데이터를 반환
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	
	// 회원삭제
	@DeleteMapping("/{id}")
	public ResponseEntity deleteMember(@PathVariable("id") String id) {
		// 일치하는 ID를 가진 회원 삭제
		int result = memberService.deleteMember(id);
		
		if(result ==1 ) {
			return new ResponseEntity("success", HttpStatus.OK);
		} else {
			return new ResponseEntity("failed", HttpStatus.OK);
		}
		
	}
	
	
	// 회원 수정
	@PutMapping
	public ResponseEntity editMemberInfo(@RequestBody MemberDto member) {
		System.out.println("hi");
		
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberName());
		System.out.println(member.getMemberPassword());
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
