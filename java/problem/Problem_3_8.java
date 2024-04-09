package kr.co.problem;

public class Problem_3_8 {
	
	public static void main(String[] args) {
		
		// 인터넷 사용자 생성
		Problem_3_8_InternetUser iu = new Problem_3_8_InternetUser("User1", "user1@naver.com");
		iu.displayUserInfo();
		System.out.println();
		
		// 프리미엄 멤버십 사용자 생성
		Problem_3_8_PremiumUser pIu = new Problem_3_8_PremiumUser("PremiumUser1", "premiumuser1@example.com", 12);
		pIu.displayUserInfo();
		System.out.println();
		
		pIu.displayMembershipPeriod(pIu);
		
	}

}
