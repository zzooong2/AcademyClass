package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.member.model.dto.Member;

public class MemberDAO {
	
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		// 객체를 생성하여 DB에 연결, 연결정보를 con 객체에 초기화
		dc = new DatabaseConnection();
		con = dc.connDB();
	};
	
	// 회원가입
	public int register(Member member) {
		// member 테이블에 데이터 삽입 쿼리문 작성
		String query = "INSERT INTO member VALUES(member_seq.nextval,?,?,?,default)";
		int result = 0;
		
		// .prepareStatement: 예외처리 필수, SQL 인젝션 방어하기 위한 방안이기도함
		try {
			// .Statement: 쿼리를 실행하는 객체 (실행할 때마다 모든 단계를 거침)
			// .prepareStatement: 쿼리문에 ? 삽입하여 원하는 값을 저장할 수 있음 (캐시에 담아뒀다가 재사용)
			pstmt = con.prepareStatement(query);
			// 1, 2, 3 = 첫번째, 두번째, 세번째 물음표
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getUserPwd());
			
			// .executeUpdate: 쿼리문 실행 결과로 영향을 받은 레코드 수를 반환 (INSERT, UPDATE, DELETE)
			// .executeQuery: SELECT 문에서 사용 -> ResultSet 을 반환
			result = pstmt.executeUpdate();
			
			// SQL 쿼리문 종료
			pstmt.close();
			
			// DB 연결 종료
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	};
	
	// 로그인
	public Member login(Member member) {
		String query = "SELECT M_NO, M_NAME FROM MEMBER"
					 + " WHERE M_ID = ?"
					 + " AND M_PWD = ?";
		
		Member result = new Member();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			
			ResultSet rs=  pstmt.executeQuery();
			
			// .next(): 다음 값이 있으면 true, 없으면 false
			while(rs.next()) {
				int userNo = rs.getInt("M_NO");
				String userName = rs.getString("M_NAME");
				
				result.setUserNumber(userNo);
				result.setUserName(userName);
			}
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
