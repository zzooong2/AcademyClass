package kr.co.green.common;

public class PageInfo {
	
	private int listCount; // 전체 게시글 수량 
	
	private int cPage; // 현재 페이지 (currentPage) 
	
	private int pageLimit; // 페이지 수량   
	
	private int boardLimit; // 하나의 페이지에 보여질 게시글의 수량
	
	private int maxPage; // 전체 페이지 수량
	
	private int startPage; // 시작 페이지
	
	private int endPage; // 마지막 페이지

	private int offset; // DB에서 가져올 데이터의 기준
	
	// Getter & Setter

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getcPage() {
		return cPage;
	}

	public void setcPage(int cPage) {
		this.cPage = cPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	// 생성자
	public PageInfo(int listCount, int cPage, int pageLimit, int boardLimit, int maxPage, 
					int startPage, int endPage, int offset) {
		super();
		this.listCount = listCount;
		this.cPage = cPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.offset = offset;
	}
	
	
	
	

}
