package kr.co.green.member.model.dto;

public class Member {
	private int userNumber;
	private String userName;
	private String userId;
	private String userPwd;
	private String confirmPwd;
	
	// Getter 
	public int getUserNumber() {
		return userNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public String getConfirmPwd() {
		return confirmPwd;
	}
	
	// Setter
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
}
