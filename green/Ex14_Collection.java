package kr.co.green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Ex14_Collection {

	public static void main(String[] args) {

//		ArrayList 사용해보기
//		1. 기본형 변수 사용불가, 참조형 변수 타입으로 사용
//		2. 추가/삭제 느림
//		3. 조회 빠름

		ArrayList<Integer> integerList = new ArrayList<>();
		// add(값) : 데이터 추가
		integerList.add(10);
		integerList.add(20);
		integerList.add(20);
		System.out.println(integerList);

		// size() : ArrayList의 길이
		for (int i = 0; i < integerList.size(); i++) {
			// 원래 썼던 배열 : 변수명[인덱스];
			// ArrayList : 변수명.get(인덱스);
			System.out.println(integerList.get(i));
		}

		for (Integer item : integerList) {
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

		System.out.println("------------------------------");

//		LinkedList 사용해보기
//		1. 데이터에 다음 데이터에 대한 위치를 가지고 있음
//		2. 추가/삭제에 용이함

		LinkedList<Integer> linked = new LinkedList<>();

		linked.add(10);
		linked.add(20);

		linked.addFirst(100);
		linked.addLast(200);
		linked.add(1, 30);

		System.out.println(linked);

		System.out.println("------------------------------");

//		HashSet 사용해보기
//		1. 순서가 보장되지 않음
//		2. 중복을 허용하지 않음

		HashSet<Integer> hashSet = new HashSet<>();

		hashSet.add(10);
		hashSet.add(10);
		hashSet.add(20);
		hashSet.add(20);
		hashSet.add(30);
		hashSet.add(30);
		hashSet.add(40);

		System.out.println(hashSet);

		System.out.println("------------------------------");
		
//		HashMap 사용해보기
//		1. Key, Value 형태를 가짐
//		2. key 중복 불가
//		3. value 중복 가능(key가 다를경우만)
//		4. 순서 보장 X

		// String : key 데이터 타입
		// Ineter : value 데이터 타입
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("국어점수: ", 100);
		hashMap.put("영어점수: ", 80);
		hashMap.put("수학점수: ", 60);
		
		// key를 이용해 value 가져오기
		if(hashMap.containsKey("국어점수: ")) {
			System.out.println("------------------------------");			
			System.out.println(hashMap.get("국어점수: "));
			System.out.println("------------------------------");
		}
		
		// for문을 이용해 key, value 가져오기
		for(String key : hashMap.keySet()) {
			System.out.println(key + hashMap.get("국어점수: "));
//			System.out.println(hashMap.get(key)); // value 꺼내기
//			System.out.println(key); // key 꺼내기
		}
		System.out.println("------------------------------");
		System.out.println(hashMap);
	}

}