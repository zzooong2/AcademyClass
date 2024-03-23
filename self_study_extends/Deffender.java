package kr.co.self_study_extends;

public class Deffender extends Player {
	
	String role;
	int roleNumber;
	
	public Deffender(String name, String position, int backNumber, String role, int roleNumber) {
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
		
		this.role = role;
		this.roleNumber = roleNumber;
	}
	
	
	public void deffenderRole() {
		playerInfo();
		
		System.out.println("선수 역할: " + role);
		System.out.println("부여된 롤: " + roleNumber + " 번");
	}
}
