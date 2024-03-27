package kr.co.quiz;

public class Ex9_Extend {

	public static void main(String[] args) {
		// Ex9_1
		
		Ex9_1_Student student = new Ex9_1_Student();
		
		student.studentInfo();
		student.study();
		
		// Ex9_2
		
		Ex9_2_Dog dog = new Ex9_2_Dog("백재롱", 12);
		Ex9_2_Cat cat = new Ex9_2_Cat("김시카", 5);
		
		dog.eat();
		dog.sleep();
		dog.bark();
		
		cat.eat();
		cat.sleep();
		cat.meow();
		
	}

}
