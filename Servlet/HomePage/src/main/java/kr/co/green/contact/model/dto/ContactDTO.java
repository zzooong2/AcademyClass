package kr.co.green.contact.model.dto;

public class ContactDTO {
	
	// (문의) 번호, 내용, 작성자, 이메일, 작성일, 답변 여부
	private int inquiryNo;
	private String inquiryMessage;
	private String inquiryMemberName;
	private String inquiryMemberEmail;
	private String inquiryIndate;
	private String inquiryAnswerStatus;
	
	// (답변) 번호, 내용, 작성자, 작성일 
	private int answerNo;
	private String answerContent;
	private String answerWirter;
	private String answerIndate;
	
	// (회원) 번호
	private int memberNo;
	
	// 기본 생성자 (매개변수를 이용한 생성자를 사용하기 위해서는 기본 생성자를 만들어줘야함)
	public ContactDTO() {
		super(); // 생략가능 (컴파일시 자동생성)
	};
	
	// 매개변수 생성자
	public ContactDTO(String name, String email, String message, int memberNo) {
		super(); // 생략가능 (컴파일시 자동생성)
		this.inquiryMemberName = name;
		this.inquiryMemberEmail = email;
		this.inquiryMessage = message;
		this.memberNo = memberNo;
	}
	
	// Getter & Setter
	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getInquiryMessage() {
		return inquiryMessage;
	}

	public void setInquiryMessage(String inquiryMessage) {
		this.inquiryMessage = inquiryMessage;
	}

	public String getInquiryMemberName() {
		return inquiryMemberName;
	}

	public void setInquiryMemberName(String inquiryMemberName) {
		this.inquiryMemberName = inquiryMemberName;
	}

	public String getInquiryMemberEmail() {
		return inquiryMemberEmail;
	}

	public void setInquiryMemberEmail(String inquiryMemberEmail) {
		this.inquiryMemberEmail = inquiryMemberEmail;
	}

	public String getInquiryIndate() {
		return inquiryIndate;
	}

	public void setInquiryIndate(String inquiryIndate) {
		this.inquiryIndate = inquiryIndate;
	}

	public String getInquiryAnswerStatus() {
		return inquiryAnswerStatus;
	}

	public void setInquiryAnswerStatus(String inquiryAnswerStatus) {
		this.inquiryAnswerStatus = inquiryAnswerStatus;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerWirter() {
		return answerWirter;
	}

	public void setAnswerWirter(String answerWirter) {
		this.answerWirter = answerWirter;
	}

	public String getAnswerIndate() {
		return answerIndate;
	}

	public void setAnswerIndate(String answerIndate) {
		this.answerIndate = answerIndate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	};

	
}
