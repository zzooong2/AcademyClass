package kr.co.green.member.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
	
	private String memberName, memberId, memberPassword, confirmPassword, memberIndate, memberType;
	private int memberNo;

}
