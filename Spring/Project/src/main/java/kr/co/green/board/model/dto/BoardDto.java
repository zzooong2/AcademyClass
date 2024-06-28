package kr.co.green.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 변수가 매개변수에 들어가있는 생성자
public class BoardDto {
	private int boardNo, boardViews, memberNo;
	private String boardTitle, boardContent, boardIndate, boardUpdate, boardDelete, memberName;
	
	private String category = "";
	private String searchText = "";
	
	private String uploadNo, uploadPath, uploadName, uploadOriginName;
}
