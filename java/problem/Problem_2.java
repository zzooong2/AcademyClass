package kr.co.problem;

import java.util.Scanner;

public class Problem_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("제목: ");
		String setTitle = sc.nextLine();

		System.out.print("내용 : ");
		String setText = sc.nextLine();

		System.out.print("작성자: ");
		String setWriter = sc.nextLine();

		System.out.print("작성일: ");
		String setDate = sc.nextLine();

		Problem_2_FreeBoard freeBoard = new Problem_2_FreeBoard(setTitle, setText, setWriter, setDate);

		Problem_2_NoticeBoard noticeBoard = new Problem_2_NoticeBoard(setTitle, setText, setWriter, setDate);

		freeBoard.intsert();
		System.out.println("등록 되었습니다.");

		noticeBoard.edit();
		System.out.println("수정 되었습니다.");

	}

}
