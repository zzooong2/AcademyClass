package kr.co.quiz;

import java.util.HashMap;
import java.util.Scanner;

public class Ex14_HashMap {

	public static void main(String[] args) {
		// 전화번호 추가, 검색, 삭제
		// 전화번호 추가 : 이름, 전화번호
		// Key(김재섭) = Value(01091201466)
		// 전화번호 검색 : 이름을 검색해서 원하는 전화번호만 찾을 수 있음

		HashMap<String, String> phoneBook = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("1. 전화번호 추가");
			System.out.println("2. 전화번호 검색");
			System.out.println("3. 전화번호 전체 검색");
			System.out.println("4. 전화번호 삭제");
			System.out.println("5. 종료");
			System.out.print("메뉴를 선택해주세요: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("이름을 입력하세요: ");
				String name = sc.nextLine();

				System.out.print("전화번호를 입력하세요: ");
				String phone = sc.nextLine();

				// 전화번호 추가 (hashMap 에 데이터넣기)
				// 이름, 전화번호 입력받음
				phoneBook.put(name, phone);

				System.out.println(name + "의 전화번호를 추가했습니다.");
				System.out.println("----------------------------");
				break;

			case 2:
				// 전화번호 검색
				// 이름 입력받음
				System.out.print("이름을 입력하세요: ");
				name = sc.nextLine();

				// 일치하는 이름이 있을 때
				// Key(name), Value(phone) 출력
				if (phoneBook.containsKey(name)) {
					System.out.println(name + "의 전화번호: " + phoneBook.get(name));
					System.out.println("-----------------------------------");
				} else if (!phoneBook.containsKey(name))
					// 일치하는 이름이 없을 때
					System.out.println(name + "의 전화번호를 찾을 수 없습니다.");
				System.out.println("-----------------------------------");

				break;

			case 3:
				// 전체검색
				// 모든 key와 value 출력
				for (String key : phoneBook.keySet()) {
					System.out.println("이름: " + key + "전화번호: " + phoneBook.get(key));
				}
				break;

			case 4:
				// 전화번호 삭제
				// 이름 입력받음
				System.out.print("이름을 입력하세요: ");
				name = sc.nextLine();

				if (phoneBook.containsKey(name)) {
					// 일치하는 이름이 있을 때
					System.out.println(name + "의 전화번호를 삭제했습니다.");
					phoneBook.remove(name);
					System.out.println("-----------------------------------");
				} else if (!phoneBook.containsKey(name)) {
					// 일치하는 이름이 없을 때
					System.out.println(name + "의 전화번호를 찾을 수 없습니다.");
					System.out.println("-----------------------------------");
				}
				break;

			case 5:
				// 종료
				System.out.println("프로그램을 종료합니다.");
				isTrue = false;
				break;

			default:

				// 올바른 번호를 입력해주세요.
				System.out.println("올바른 번호를 입력해주세요.");
				System.out.println("-----------------------------------");
			}
		}
	}

}
