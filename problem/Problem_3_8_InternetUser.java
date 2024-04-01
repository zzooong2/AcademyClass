package kr.co.problem;

public class Problem_3_8_InternetUser {

//	4) 사용자의 정보를 출력하는 프로그램을 작성하세요.

	// 인터넷 사용자 클래스

	private String username;
	private String email;

	public Problem_3_8_InternetUser() {}
	
	// 생성자
	public Problem_3_8_InternetUser(String username, String email) {
		this.username = username;
		this.email = email;
	}

	// 사용자 정보 출력 메서드
	public void displayUserInfo() {
		System.out.println("username: " + username);
		System.out.println("email: " + email);
	}
	
	// Getter 
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	// Setter
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
