package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dto.ContactDTO;

public interface ContactService {
	
	// 문의글 등록
	public int enroll(ContactDTO contactDTO);
	
	// 문의글 목록조회
	public ArrayList<ContactDTO> getList(PageInfo pi);
	
	// 문의글 수량조회
	public int getListCount();
	
	// 문의글 상세조회
	public ContactDTO getDetail(int inquiryNo);
	
	// 문의글 삭제
	public int delete(int inquiryNo);
	
	// 문의글 답변달기 페이지
	public ContactDTO getAnswer(int inquiryNo);
	
	// 문의글 답변달기
	public int setAnswer(ContactDTO contactDTO);
}



