package kr.co.green;

import java.util.ArrayList;

public class Ex14_Collection {

	public static void main(String[] args) {
      ArrayList<Integer> integerList = new ArrayList<>();
      // add(값) : 데이터 추가
      integerList.add(10);
      integerList.add(20);
      integerList.add(20);
      System.out.println(integerList);
      
      // size() : ArrayList의 길이
      for(int i = 0; i < integerList.size(); i++) {
         // 원래 썼던 배열 : 변수명[인덱스];
         // ArrayList : 변수명.get(인덱스);
         System.out.println(integerList.get(i));
      }
      
      for(Integer item : integerList) {
         System.out.println(item);
      }
      
      // set(인덱스, 값) : 데이터 수정
      integerList.set(1, 50);
      System.out.println(integerList);
      
      // remove(인덱스) : 데이터(요소)삭제
      integerList.remove(1);
      System.out.println(integerList);
      
      // clear() : 전체 삭제
      integerList.clear();
      System.out.println(integerList);
      
      // isEmpty() : 배열이 비어져 있으면 true, 비어져 있지 않으면 false
      System.out.println(integerList.isEmpty());
   }

}