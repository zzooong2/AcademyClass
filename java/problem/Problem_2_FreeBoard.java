package kr.co.java.problem;

public class Problem_2_FreeBoard implements Problem_2_Board {

	public String title, text, writer, date;

	public Problem_2_FreeBoard(String setTitle, String setText, String setWriter, String setDate) {
		this.title = setTitle;
		this.text = setText;
		this.writer = setWriter;
		this.date = setDate;
	}

	@Override
	public void intsert() {
		if (writer.equals(WRITER)) {
			System.out.println("제목: " + title);
			System.out.println("내용: " + text);
			System.out.println("작성자: " + writer);
			System.out.println("날짜: " + date);
		} else {
			System.out.println("작성자가 상이합니다.");
		}
	}

	@Override
	public void edit() {
		if (writer.equals(WRITER)) {
			System.out.println("수정된 제목: " + title);
			System.out.println("수정된 내용: " + text);
			System.out.println("수정한 사람: " + writer);
			System.out.println("수정한 날짜: " + date);
		} else {
			System.out.println("작성자가 상이합니다.");
		}
	}

	@Override
	public void delete() {
		if (writer.equals(WRITER)) {
			System.out.println("자유 게시판에 글이 삭제 되었습니다.");
		}
	}
}
