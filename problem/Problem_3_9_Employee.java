package kr.co.problem;

public class Problem_3_9_Employee {
	
	private String name, position; // 이름, 직급
	private double salary; // 연봉
	
	// 생성자
	public Problem_3_9_Employee(String name, String position, double salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	// 연봉인상 메서드
	public void raiseSalary(double percentage) {
		salary += percentage;
	}
	
	// 직원정보 출력 메서드
	public void displayEmployeeInfo() {
		System.out.println("이름: " + name);
		System.out.println("직책: " + position);
		System.out.println("연봉: " + salary);
		
	}
	
	// 메인메서드
	public static void main(String[] args) {
		// 직원 생성
		Problem_3_9_Employee emp1 = new Problem_3_9_Employee("John", "Manager", 50000);
		Problem_3_9_Employee emp2 = new Problem_3_9_Employee("Jane", "Developer", 40000);
		
		// 직원정보 출력
		System.out.println("-----직원1 정보-----");
		emp1.displayEmployeeInfo();
		System.out.println();
		
		System.out.println("-----직원2 정보-----");
		emp2.displayEmployeeInfo();
		System.out.println();
		
		// 연봉인상
		emp1.raiseSalary(30000);
		
		System.out.println("-----연봉 인상 후-----");
		System.out.println("-----직원1 정보-----");
		emp1.displayEmployeeInfo();
		System.out.println();
	}

}
