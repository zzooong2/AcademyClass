package kr.co.green;

import java.util.Arrays;

public class Ex7_CallStack {
	
	public static void main(String[] args) {          
		
	      Ex7_CallStack cs = new Ex7_CallStack();
	      
	      
	      // 기본 자료형 변수 : 값을 전달
	      int num = 10;
	      System.out.println("메소드 호출 전 : " + num);
	      cs.changeInt(num);
	      System.out.println("메소드 호출 후 : " + num);
	      
	      System.out.println("------------------------");
	      
	      
	      // 참조형 변수 : 주소값을 전달
	      int[] numArr = {10, 20, 30};
	      System.out.println("메소드 호출 전 : " + Arrays.toString(numArr));
	      cs.changeArr(numArr);
	      System.out.println("메소드 호출 후 : " + Arrays.toString(numArr));
	   }
	   
	
	   public void changeArr(int[] numArr) {
	      numArr[1] = 1000;
	      System.out.println("changeArr 메소드 호출 : " + Arrays.toString(numArr));
	   }
	   
	   
	   public void changeInt(int num) {
	      num = 1000;
	      System.out.println("changeInt 메소드 호출 : " + num);
	   }
	   

	}


