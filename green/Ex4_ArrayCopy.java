package kr.co.green;

import java.util.Arrays;

public class Ex4_ArrayCopy {

	public static void main(String[] args) {

		// 얕은 복사
		// 주소값을 복사하는 방식 -> 값이 바뀌면 원본, 복사본 모두 값이 바뀐다.
		
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		int[] copyArr = arr;
		
		copyArr[1] = 999;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr));
		
		System.out.println("--------------");
		
		// 깊은 복사
		// 새로운 배열을 생성하고 데이터만 넣는 방식
		
		int[] arr2 = {10, 20, 30}; // 배열의 명시적 초기화
		
		int[] deepCopyArr = new int[arr2.length]; // 배열 선언 및 할당
		
		arr2[0] = deepCopyArr[0];
		arr2[1] = deepCopyArr[1];
		arr2[2] = deepCopyArr[2];
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(deepCopyArr));
		
		
		// arraycopy() 이용
		// System.arraycopy(원본배열, 복사 시작 인덱스, 저장배열, 저장 시작 인덱스, 복사 개수)
		
		System.arraycopy(arr2, 0, deepCopyArr, 0, arr2.length);
		
	}

}
