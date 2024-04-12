package kr.co.java.quiz;

public class Ex9_Extend {

	public static void main(String[] args) {
		// Ex9_1
		
		Ex9_1_Student student = new Ex9_1_Student();
		
		student.name = "김현중";
		student.age = 31;
		student.studentId = "13-76089921";
		
		student.studentInfo();
		System.out.println();
		student.study();
		System.out.println();

		// 오버라이딩 된 메소드 출력
		student.displayInfo("김현중", 31);
		
		System.out.println("-----------------------");
		
		// Ex9_2
		
		Ex9_2_Dog dog = new Ex9_2_Dog("백재롱", 12);
		Ex9_2_Cat cat = new Ex9_2_Cat("김시카", 5);
		
		dog.eat();
		dog.sleep();
		dog.bark();
		dog.makeSound("멍!");
		
		System.out.println("-----------------------");
		
		cat.eat();
		cat.sleep();
		cat.makeSound("야옹");
		cat.meow();
		
		
	}

}
