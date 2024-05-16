package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dao.ContactDAO;
import kr.co.green.contact.model.dto.ContactDTO;

public class ContactServiceImpl implements ContactService {
	
	ContactDAO contactDAO = new ContactDAO();
	
	// 문의글 등록 
	@Override
	public int enroll(ContactDTO contactDTO) {
		return contactDAO.enroll(contactDTO);
	}
	
	// 문의글 목록조회
	@Override
	public ArrayList<ContactDTO> getList(PageInfo pi) {
		return contactDAO.getList(pi);
	}

	// 문의글 수량조회
	@Override
	public int getListCount() {
		return contactDAO.getListCount();
	}
	
	// 문의글 상세조회
	public ContactDTO getDetail(int inquiryNo) {
		return contactDAO.getDetail(inquiryNo);
	}
	
	// 문의글 삭제
	public int delete(int inquiryNo) {
		return contactDAO.delete(inquiryNo);
	}
	
	// 문의글 답변달기 페이지
	public ContactDTO getAnswer(int inquiryNo) {
		return contactDAO.getAnswer(inquiryNo);
	}
	
	// 문의글 답변달기
	public int setAnswer(ContactDTO contactDTO) {
		
		int set = contactDAO.setAnswer(contactDTO);
		
		if (set == 1) {
			return contactDAO.setStatus(contactDTO); 
		}
		return 0;
	}
	
}
