package kr.co.problem;

public class Problem_3_11_Login implements Problem_3_11_LoginInterface {

	String memberId = "id";

	String memberPw = "qw12";

	Problem_3_11_MemberInfo mi = new Problem_3_11_MemberInfo();

	@Override
	public String login(String id, String pw) {
		if (!memberId.equals(mi.userId)) {
			System.out.println("아이디가 틀렸습니다.");
		} else if (!memberPw.equals(mi.userPw)) {
			System.out.println("패스워드가 틀렸습니다.");
		} else if (memberId.equals(mi.userId) && memberPw.equals(mi.userPw)) {
			System.out.println("로그인 되었습니다.");
		}
		return "환영합니다.";
	}
}
