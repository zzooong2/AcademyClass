package kr.co.green;

public class Ex8_2_Student {

	// private : 같은 클래스에서만 접근가능
	private String name, studentNumber;
	private int age, grade;

	public Ex8_2_Student() {
		this("이름 없음", 0, 0, "00000000");
		
	}
	
	public Ex8_2_Student(String name, int age, int grade, String sNum) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNumber = sNum;
		
	}
	
	// getter : 값을 가져올 때 사용
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	
	// setter : 값을 입력할 때 사용
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	
	
}
