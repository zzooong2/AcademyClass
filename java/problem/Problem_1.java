package kr.co.java.problem;

import java.util.Scanner;

public class Problem_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String inputName = sc.nextLine();
		
		System.out.print("국어: ");
		int inputKor = sc.nextInt();

		System.out.print("영어: ");
		int inputEng = sc.nextInt();
		
		System.out.print("수학: ");
		int inputMat = sc.nextInt();
		
		System.out.print("과학: ");
		int inputSci = sc.nextInt();
		
		Problem_1_Student student = new Problem_1_Student(inputName, inputKor, inputEng, inputMat, inputSci);
		
		student.getSum();
		
		int resultAvg = student.getAvg();
		
		student.getRank(resultAvg);
	
	}
	

}
