package kr.co.green;

public class Ex8_Constructor {

	public static void main(String[] args) {
		
		Ex8_1_Calculator cal = new Ex8_1_Calculator(40, 31, "김현중");
		
		
		Ex8_2_Student student = new Ex8_2_Student();
		
		System.out.println(student.getName());
		
		student.setName("김현중");
		
		System.out.println(student.getName());
		
	}

}
