package kr.co.green.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;

public class FreeDAO {
	private DatabaseConnection dc;
	private Connection con;
	private PreparedStatement pstmt;
	
	// DB 연결
	public FreeDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 게시글 목록 가져오기
	public ArrayList<FreeDTOImpl> getList(PageInfo pi) {
		// 쿼리문 실행결과 담을 객체 생성
		ArrayList<FreeDTOImpl> result = new ArrayList();
		
		String query = "SELECT * FROM (SELECT fb.FB_NO,\n"
  					 + " fb.fb_title,\n"
					 + " fb.fb_content,\n"
					 + " fb.fb_views,\n"
					 + " fb.fb_indate,\n"
					 + " m.m_no,\n"
					 + " m.m_name,\n"
					 + " ROW_NUMBER() OVER(ORDER BY fb.fb_indate DESC) AS row_num \n"
					 + " FROM FREE_BOARD fb\n"
					 + " JOIN \"MEMBER\" m ON m.M_NO = fb.M_NO)\n"
					 + " WHERE row_num > ? AND row_num <= ?"; 
		
		try {
			// 쿼리 실행준비
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pi.getOffset());
			pstmt.setInt(2, pi.getOffset()+pi.getBoardLimit());
			
			// 쿼리 실행
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("FB_NO");
				int views = rs.getInt("FB_VIEWS");
				int memberNo = rs.getInt("M_NO");
				String title = rs.getString("FB_TITLE");
				String content = rs.getString("FB_CONTENT");
				String indate = rs.getString("FB_INDATE");
				String memberName = rs.getString("M_NAME");
				
				// while 문 안에 객체 생성을 함으로써 while문이 실행될때마다 새로운 주소값을 가진 저장소에 데이터를 담음
				FreeDTOImpl freeDto = new FreeDTOImpl();
				freeDto.setBoardNo(no);
				freeDto.setBoardViews(views);
				freeDto.setMemberNo(memberNo);
				freeDto.setBoardTitle(title);
				freeDto.setBoardContent(content);
				freeDto.setBoardIndate(indate);
				freeDto.setMemberName(memberName);
				
				result.add(freeDto);
			} 
			// 쿼리문 종료
			pstmt.close();
			
			// DB 연결 해제
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 게시글 수량 조회
	public int getListCount() {
		String query = "SELECT COUNT(*) AS cnt FROM FREE_BOARD";
		
		try {
			// 쿼리 실행 준비
			pstmt = con.prepareStatement(query);
			
			// 쿼리 실행
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("cnt");
				return result;
			}
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// try 문에서 오류가 발생되지 않는다면 while 문 안에 있는 return 문장에서 메서드 종료
		return 0;
	}
	
	// 게시글 등록
	public int enroll(BoardDTO boardDTO) {
		String query = "INSERT INTO FREE_BOARD VALUES(FREE_BOARD_SEQ.nextval,?,?,DEFAULT, DEFAULT, null, null,DEFAULT,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, boardDTO.getBoardTitle());
			pstmt.setString(2, boardDTO.getBoardContent());
			pstmt.setInt(3, boardDTO.getMemberNo());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
