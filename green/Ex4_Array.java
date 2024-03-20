package kr.co.green;

public class Ex4_Array {
	public static void main(String[] args) {
		
		/*
		
		< 배열 >
		- 같은 자료형을 가진 변수를 하나로 묶어 관리
		- 참조형 변수이므로 힙 영역에 값을 저장함 (주소값)
		
		< 인덱스 >
		- 배열 내의 각 요소에 접근하기 위해 사용
		- 0부터 시작
		
		*/
		
		// < 배열의 선언 >
		// 1. 자료형[] 배열명;
		// 2. 자료형 배열명[];
		
		int[] numbers;
		
		// < 배열의 할당 > - 배열의 크기를 정하는 것
		// 1. 자료형[] 배열명 = new 자료형[배열크기];
		// 2. 자료형 배열명[] = new 자료형[배열크기];
		
		int[] members = new int[5];
		
	
		// < 배열의 초기화 > - 배열의 값을 정하는 것
		// 배열명[인덱스] = 원하는 값;
		//	members[0] = 10;
		//	members[1] = 20;
		//	members[2] = 30;
		//	members[3] = 40;
		//	members[4] = 50;
		
		// for 문을 이용한 배열의 할당		
		int value = 10;
		for(int i=0; i<5; i++) {
			members[i] = value;
			value += 10;
		}
		
		// 배열의 출력
		for(int i=0; i<members.length; i++) {
			System.out.println(members[i]);
		}
		
		System.out.println("---------------");
		
		
		// for 문을 이용한 배열의 할당
		String[] friend = new String[4];
		
		for (int j=0; j<=3; j++) {
			if(j == 0) {
				friend[j] = "현중";
			} else if (j == 1) {
				friend[j] = "민수";
			} else if (j == 2) {
				friend[j] = "해연";
			} else if (j == 3) {
				friend[j] = "승표";
			}
		}
		
		for (int k=0; k<friend.length; k++) {
			System.out.println(friend[k]);
		}
		
		
		System.out.println("---------------");
		
		
		// <배열의 명시적 초기화>
		
		int[] arr = {7, 4, 11};
		System.out.println(arr[0]);
		
				
		System.out.println("---------------");
		
	}

}
