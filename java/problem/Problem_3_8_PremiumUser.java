package kr.co.problem;

// 프리미엄 사용자 클래스 (인터넷 사용자 클래스를 상속해야 함)

public class Problem_3_8_PremiumUser extends Problem_3_8_InternetUser {
	
	private int membershipPeriod;
	
	public Problem_3_8_PremiumUser() {}
	
	// 생성자
	public Problem_3_8_PremiumUser(String username, String email, int membershipPeriod) {
		super.setUsername(username);
		super.setEmail(email);
		this.membershipPeriod = membershipPeriod;
	}

	// 멤버쉽 기간 출력 메서
	public void displayMembershipPeriod(Problem_3_8_InternetUser iu) {
		
		System.out.println("username: " + iu.getUsername());
		System.out.println("email: " + iu.getEmail());
		System.out.println("membershipPeriod: " + membershipPeriod);
	}
	
	
}
