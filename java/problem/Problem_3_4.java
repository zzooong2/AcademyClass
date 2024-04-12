package kr.co.java.problem;

public class Problem_3_4 {

	public static void main(String[] args) {

//		Ex 4 - 반복문
//		1) hieght = 5 일 때 아래의 별찍기를 구현하세요.
//		*
//		**
//		***
//		****
//		*****
		
		for(int i=1; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		
	}

}
