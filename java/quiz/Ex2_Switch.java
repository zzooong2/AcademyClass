package kr.co.java.quiz;
import java.util.Scanner;

public class Ex2_Switch {
	public static void main(String[] args) {
		
		// 1번 : 1부터 7사이의 숫자를 입력 받아 주말, Switch 문을 이용하여 평일을 출력하는 프로그램을 작성하시오
		// ex) 1~5 = 평일, 6~7 = 주말
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 ~ 5 = 평일");
		System.out.println("6 ~ 7 = 주말");
		System.out.println("숫자를 입력하세요: ");
		int day = sc.nextInt();
		
		switch(day) {
		case 1 : 
		case 2 : 
		case 3 : 
		case 4 : 
		case 5 : 
			System.out.println("평일");
			break;
		case 6 : 
		case 7 : 
			System.out.println("주말");
			break;
		}
	}

}
