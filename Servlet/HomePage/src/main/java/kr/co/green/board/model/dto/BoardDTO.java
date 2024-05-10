package kr.co.green.board.model.dto;

public class BoardDTO {

	private int boardNo; // 게시글 번호 (PK)
	private String boardTitle; // 제목
	private String boardContent; // 내용
	private int boardViews; // 조회수
	private String boardIndate; // 생성날짜
	private String boardUpdate; // 수정날짜
	private String boardDelete; // 삭제날짜
	private char boardDeleteStatus; // 삭제 여부
	private int memberNo; // 회원 번호 (FK)
	private String memberName; // 회원 이름
	
	 
	// Getter & Setter
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}
	public String getBoardIndate() {
		return boardIndate;
	}
	public void setBoardIndate(String boardIndate) {
		this.boardIndate = boardIndate;
	}
	public String getBoardUpdate() {
		return boardUpdate;
	}
	public void setBoardUpdate(String boardUpdate) {
		this.boardUpdate = boardUpdate;
	}
	public String getBoardDelete() {
		return boardDelete;
	}
	public void setBoardDelete(String boardDelete) {
		this.boardDelete = boardDelete;
	}
	public char getBoardDeleteStatus() {
		return boardDeleteStatus;
	}
	public void setBoardDeleteStatus(char boardDeleteStatus) {
		this.boardDeleteStatus = boardDeleteStatus;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
}
