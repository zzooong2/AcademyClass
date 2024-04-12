package kr.co.java.problem;

import java.util.Scanner;

public class Problem_3_11_MemberInfo {
	
	static String userId;
	static String userPw;
	
	
	public static void main(String[] args) {
		
		// 사용자로부터 아이디와 비밀번호를 입력받으세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디를 입력하세요: ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호를 입력하세요: ");
		String pw = sc.nextLine();		
		
		
		userId = id;
		userPw = pw;
		
		Problem_3_11_Login login = new Problem_3_11_Login();
		login.login(id, pw);
	}
	

}
