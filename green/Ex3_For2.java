package kr.co.green;

public class Ex3_For2 {

	public static void main(String[] args) {
		
		String[] arr = {"A", "B", "CD", "E", "FG"};
		
		
//		일반 for 문
//		for(int j=0; j<arr.length; j++) {
//			System.out.println(arr[j]);
//		}
		
		// 향상된 for문 (for-each문)
		for(String str : arr) {
			System.out.println(str);
		}
		

	}

}
