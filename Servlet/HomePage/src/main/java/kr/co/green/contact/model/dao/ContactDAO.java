package kr.co.green.contact.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dto.ContactDTO;

public class ContactDAO {
	
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement ps;
	
	// DB 연결
	public ContactDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 문의글 등록
	public int enroll(ContactDTO contactDTO) {
		String query = "INSERT INTO INQUIRY_BOARD VALUES(INQUIRY_BOARD_SEQ.nextval, ?, ?, ?, DEFAULT, DEFAULT, ?)";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, contactDTO.getInquiryMessage());
			ps.setString(2, contactDTO.getInquiryMemberName());
			ps.setString(3, contactDTO.getInquiryMemberEmail());
			ps.setInt(4, contactDTO.getMemberNo());
			
			int result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 문의글 목록 조회
	public ArrayList<ContactDTO> getList(PageInfo pi) {
		String query = "SELECT * FROM (SELECT IB_NO, IB_CONTENT, IB_WRITER, IB_WRITER_EMAIL, IB_INDATE, IB_ANSWER_STATUS, M_NO,"
					+  " ROW_NUMBER() OVER(ORDER BY IB.IB_INDATE DESC) AS ROW_NUM "
					+  " FROM INQUIRY_BOARD IB) "
					+  " WHERE ROW_NUM > ? AND ROW_NUM <= ?";
		
		ArrayList<ContactDTO> result = new ArrayList();
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setInt(1, pi.getOffset());
			ps.setInt(2, pi.getOffset() + pi.getBoardLimit());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ibNo = rs.getInt("IB_NO");
				int memberNo = rs.getInt("M_NO");
				String ibMessage = rs.getString("IB_CONTENT");
				String ibWriter = rs.getString("IB_WRITER");
				String ibWriterEmail = rs.getString("IB_WRITER_EMAIL");
				String ibIndate = rs.getString("IB_INDATE");
				String ibAnswerStatus = rs.getString("IB_ANSWER_STATUS");
				
				ContactDTO contactDTO = new ContactDTO();
				
				contactDTO.setInquiryNo(ibNo);
				contactDTO.setMemberNo(memberNo);
				contactDTO.setInquiryMessage(ibMessage);
				contactDTO.setInquiryMemberName(ibWriter);
				contactDTO.setInquiryMemberEmail(ibWriterEmail);
				contactDTO.setInquiryIndate(ibIndate);
				contactDTO.setInquiryAnswerStatus(ibAnswerStatus);
				
				result.add(contactDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 문의글 수량 조회
	public int getListCount() {
		String query = "SELECT COUNT(*) AS cnt FROM INQUIRY_BOARD";
		
		try {
			ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 문의글 상세 조회
	public ContactDTO getDetail(int inquiryNo) {
		String query = "SELECT * FROM INQUIRY_BOARD WHERE IB_NO = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, inquiryNo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ibNo = rs.getInt("IB_NO");
				int mNo = rs.getInt("M_NO");
				String ibName = rs.getString("IB_WRITER");
				String ibMessage = rs.getString("IB_CONTENT");
				String ibWriterEmail = rs.getString("IB_WRITER_EMAIL");
				String ibIndate = rs.getString("IB_INDATE");
				String ibAnswerStatus = rs.getString("IB_ANSWER_STATUS");
				
				ContactDTO contactDTO = new ContactDTO();
				contactDTO.setInquiryNo(ibNo);
				contactDTO.setInquiryMemberName(ibName);
				contactDTO.setInquiryMemberEmail(ibWriterEmail);
				contactDTO.setInquiryMessage(ibMessage);
				contactDTO.setInquiryIndate(ibIndate);
				contactDTO.setInquiryAnswerStatus(ibAnswerStatus);
				
				ps.close();
				con.close();
				
				return contactDTO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 문의글 삭제
	public int delete(int inquiryNo) {
		String query = "DELETE INQUIRY_BOARD WHERE IB_NO = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, inquiryNo);
			
			int result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	// 문의글 답변달기 페이지
	public ContactDTO getAnswer(int inquiryNo) {
		String query = "SELECT * FROM INQUIRY_BOARD WHERE IB_NO = ?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setInt(1, inquiryNo);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ibNo = rs.getInt("IB_NO");
				String ibWriter = rs.getString("IB_WRITER");
				String ibEmail = rs.getString("IB_WRITER_EMAIL");
				String ibIndate = rs.getString("IB_INDATE");
				String ibContent = rs.getString("IB_CONTENT");
				
				ContactDTO contactDTO = new ContactDTO();
				contactDTO.setInquiryNo(inquiryNo);
				contactDTO.setInquiryMemberName(ibWriter);
				contactDTO.setInquiryMemberEmail(ibEmail);
				contactDTO.setInquiryIndate(ibIndate);
				contactDTO.setInquiryMessage(ibContent);
				
				return contactDTO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 문의글 답변달기
	public int setAnswer(ContactDTO contactDTO) {
		String query = "INSERT INTO ANSWER_BOARD VALUES(ANSWER_BOARD_SEQ.nextval,?,DEFAULT,?,?)";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, contactDTO.getAnswerContent());
			ps.setString(2, contactDTO.getAnswerWirter());
			ps.setInt(3, contactDTO.getInquiryNo());
			
			int result = ps.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 문의글 답변 상태 변경
	public int setStatus(ContactDTO contactDTO) {
		String query = "UPDATE INQUIRY_BOARD SET IB_ANSWER_STATUS = 'Y' WHERE IB_NO = ?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setInt(1, contactDTO.getInquiryNo());
			
			int result = ps.executeUpdate();
			
			ps.close();
			con.close();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
