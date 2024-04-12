package kr.co.java.game;

import java.util.Scanner;

public class Game_3 {

	static Scanner sc = new Scanner(System.in);

	static Game_3_Warloard w = new Game_3_Warloard(); // 케릭터
	static Game_3_CharacterAbility cAb = new Game_3_CharacterAbility(); // 케릭터 어빌리티

	public static void main(String[] args) {
		// 게임 시작
		startGame();
	}

	public static void startGame() {
		// 게임 시작
		do {
			System.out.println("게임 메뉴를 선택해주세요.");
			System.out.println("1. 사냥 시작");
			System.out.println("2. 인벤토리-포션");
			System.out.println("3. 스텟");
			System.out.println("4. 케릭터 정보 확인");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			System.out.println("------------------");

			if (menu == 1) {
				// 사냥 시작
				huntMenu();
			} else if (menu == 2) {
				// 인벤토리-포션
				setPotion();
			} else if (menu == 3) {
				// 스텟
				setStatus();
			} else if (menu == 4) {
				getCharInfo();
				// 케릭터 정보 확인
			} else if (menu == 0) {
				// 종료
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 메뉴를 선택해주세요.");
				System.out.println("------------------");
			}
		} while (true);
	}

	public static boolean huntMenu() {
		
		Game_3_MonsterAbility mAb = new Game_3_MonsterAbility(); // 몬스터 어빌리티
		
		do {
			System.out.println("공격을 선택해주세요.");
			System.out.println("1. 기본 공격");
			System.out.println("2. 민첩 스킬 사용");
			System.out.println("3. 지력 스킬 사용");
			System.out.println("0. 처음으로 돌아가기");
			System.out.print("메뉴 선택 : ");
			int selectAttack = sc.nextInt();
			System.out.println("------------------");

			if (selectAttack == 1) {
				// warloard의 attack 메서드를 호출하세요.
				// 인자값으로 monster를 넘겨주어야 합니다.
				w.attack(mAb);

			} else if (selectAttack == 2) {
				// warloard의 dexSkill 메서드를 호출하세요.
				// 인자값으로 monster를 넘겨주어야 합니다.
				w.dexSkill(mAb);

			} else if (selectAttack == 3) {
				// warloard의 knowledgeSkill();메서드를 호출하세요.
				// 인자값으로 monster를 넘겨주어야 합니다.
				w.knowledgeSkill(mAb);

			} else if (selectAttack == 0) {
				// 처음으로 돌아가기
				System.out.println("처음 메뉴로 돌아갑니다.");
				System.out.println("------------------");
				return true;
			} else {
				System.out.println("------------------");
				System.out.println("올바른 메뉴를 선택해주세요.");
			}
			System.out.println("------------------");

		} while (true);
	}

	public static boolean setStatus() {
		// 레벨업 할때마다 스텟(unusedStatus) 5가 생김
		cAb.setUnusedStatus(cAb.getUnusedStatus() + 5);

		// 현재 레벨 확인 후 여유분의 스텟을 추가하는 코드 작성
		System.out.println("레벨: " + cAb.getLevel());

		// * ability의 setter/getter를 이용
		do {
			System.out.println("사용할 스텟을 입력해주세요.");
			System.out.println("1. 힘+5");
			System.out.println("2. 민첩+5");
			System.out.println("3. 지력+5");
			System.out.println("0. 처음으로 돌아가기");
			System.out.print("사용할 스텟 : ");
			int selectStatus = sc.nextInt();
			System.out.println("------------------");

			if (selectStatus == 1) {
				// 힘이 5 증가되는 코드 작성
				cAb.setStr(cAb.getStr() + 5);

				System.out.println("힘이 5 증가되었습니다.");
				System.out.println("총 힘 : " + cAb.getStr()); // 총 힘 출력

			} else if (selectStatus == 2) {
				// 민첩이 5 증가되는 코드 작성
				cAb.setDex(cAb.getDex() + 5);

				System.out.println("민첩이 5 증가되었습니다.");
				System.out.println("총 민첩 : " + cAb.getDex()); // 총 민첩 출력

			} else if (selectStatus == 3) {
				// 지력이 5 증가되는 코드 작성
				cAb.setKno(cAb.getKno() + 5);

				System.out.println("지력이 5 증가되었습니다.");
				System.out.println("총 지력 : " + cAb.getKno()); // 총 지력 출력

			} else if (selectStatus == 0) {
				// 처음으로 돌아가기
				System.out.println("처음 메뉴로 돌아갑니다.");
				System.out.println("------------------");
				return true;

			} else {
				System.out.println("올바른 메뉴를 선택해주세요.");
			}
			System.out.println("------------------");

		} while (true);
	}

	public static boolean getCharInfo() {
		// 케릭터의 체력, 마나, 힘, 민첩, 지력, 사용가능스텟, 현재 경험치를 출력하는 코드 작성
		// ability의 getter 사용
		System.out.println("<케릭터 정보>");
		System.out.println("레벨: " + cAb.getLevel());
		System.out.println("체력 : " + cAb.getHp());
		System.out.println("마나 : " + cAb.getMp());
		System.out.println("힘 : " + cAb.getStr());
		System.out.println("민첩 : " + cAb.getDex());
		System.out.println("지력 : " + cAb.getKno());
		System.out.println("사용 가능 스텟 : " + cAb.getUnusedStatus());
		System.out.println("현재 경험치 : " + cAb.getExe());
		System.out.println("------------------");
		return true;
	}

	public static boolean setPotion() {
		do {
			System.out.println("인벤토리-포션");
			System.out.println("1. 체력 포션");
			System.out.println("2. 마나 포션");
			System.out.println("3. 포션 목록");
			System.out.println("0. 처음으로 돌아가기");
			System.out.print("사용할 포션을 선택하세요: ");
			int selectPorsion = sc.nextInt();
			System.out.println("------------------");

			if (selectPorsion == 1) {
				// hpPortionCount 1 감소 (만약, 개수가 0개라면 사용 불가)
				if (cAb.getHpPortion() == 0) {
					System.out.println("체력회복 포션이 없습니다.");
				} else {
					cAb.setHpPortion(cAb.getHpPortion() - 1);
					// hp 50 증가
					cAb.setHp(cAb.getHp() + 50);
				}

				System.out.println("체력 포션을 사용했습니다!");
				System.out.println("현재 체력 : " + cAb.getHp()); // 회복 후 체력 출력

			} else if (selectPorsion == 2) {
				// mpPortionCount 1 감소 (만약, 개수가 0개라면 사용 불가)
				if (cAb.getMpPortion() == 0) {
					System.out.println("마나회복 포션이 없습니다.");
				} else {
					cAb.setMpPortion(cAb.getMpPortion() - 1);
					// mp 50 증가
					cAb.setMp(cAb.getMp() + 50);
				}

				System.out.println("마나 포션을 사용했습니다!");
				System.out.println("현재 마나 : " + cAb.getMp()); // 회복 후 마나 출력

			} else if (selectPorsion == 3) {
				System.out.println("현재 체력 포션 개수 : " + cAb.getHpPortion()); // hpPortionCount 출력
				System.out.println("현재 마나 포션 개수 : " + cAb.getMpPortion()); // mpPortionCount 출력
			} else if (selectPorsion == 0) {
				// 처음으로 돌아가기
				System.out.println("처음 메뉴로 돌아갑니다.");
				System.out.println("------------------");
				return true;
			} else {
				System.out.println("올바른 메뉴를 선택해주세요.");
			}
			System.out.println("------------------");
		} while (true);
	}

}
