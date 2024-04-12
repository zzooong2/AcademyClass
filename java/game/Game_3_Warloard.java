package kr.co.java.game;

public class Game_3_Warloard implements Game_3_Character {

	Game_3_CharacterAbility cAb = new Game_3_CharacterAbility();
	Game_3_MonsterAbility mAb = new Game_3_MonsterAbility();
	int exp = cAb.getExe();
	
	
	public Game_3_Warloard() {}

	// 캐릭터의 경험치가 100 이상이라면 레벨 +1, 경험치 0으로 초기화
	public void checkExe() {
		if (cAb.getExe() >= 100) {
			cAb.setLevel(cAb.getLevel() + 1);
			cAb.setExe(0);
			// 레벨업 할 때마다 스텟 5가 생기고, 현재 레벨 확인 후 여유분의 스텟을 추가
			Game_3.setStatus();
		}
	}

	// 기본공격 구현
	@Override
	public void attack(Game_3_MonsterAbility mAb) {

		// 기본공격시 마나가 10 미만이면 공격 사용 불가
		if (cAb.getMpPortion() < 10) {
			System.out.println("마나가 부족합니다.");
		} else {
			// 기본공격: 마나 3 소모
			cAb.setMp(cAb.getMp() - 3);
			// 몬스터의 체력을 (힘 * 1.3) 만큼 감소
			double attackProbability = 1.3;
			double attackDamage = (cAb.getStr() * attackProbability);
			mAb.setHp(mAb.getHp() - (int) attackDamage);

			System.out.println("기본 공격을 사용했습니다.");
			System.out.println("캐릭터 마력: " + cAb.getMp());
			System.out.println("몬스터가 " + (int) attackDamage + "의 피해를 입었습니다.");
			System.out.println("몬스터 체력: " + mAb.getHp());

		}

		// 몬스터 체력이 0이면
		if (mAb.getHp() <= 0) {
			// 캐릭터 경험치 13 증가, 처음 메뉴 리턴
			System.out.println("몬스터가 쓰러졌습니다.");
			cAb.setExe(exp + 13);
			checkExe();
			mAb.setHp(100);
			System.out.println("------------------");
			Game_3.startGame();
		}

		System.out.println();

		int monsterDamage = mAb.getDamage();
		System.out.println("몬스터가 공격했습니다.");
		System.out.println("캐릭터가 " + monsterDamage + "의 피해를 입었습니다.");
		cAb.setHp(cAb.getHp() - monsterDamage);
		System.out.println("캐릭터 체력: " + cAb.getHp());

		// 캐릭터 체력 0 되면
		if (cAb.getHp() <= 0) {
			// 체력 70, 마나 70, 경험치 (현재 경험치 - 30) 초기화
			cAb.setHp(70);
			cAb.setMp(70);
			cAb.setExe(exp - 30);
			System.out.println("캐릭터가 사망하였습니다.");
			System.out.println("처음 메뉴로 돌아갑니다.");
			System.out.println("-------------------");
		}

	}

	// 민첩스킬 구현
	@Override
	public void dexSkill(Game_3_MonsterAbility mAb) {
		// 스킬사용시 마나가 20 미만이면 스킬 사용 불가
		if (cAb.getMp() < 20) {
			System.out.println("마나가 부족합니다.");
		} else {
			// 스킬 사용: 마나 7 소모
			cAb.setMp(cAb.getMp() - 7);

			// 몬스터의 체력을 (민첩 * 1.8) 만큼 감소
			double dexSkillProbability = 1.8;
			double dexSkillDamage = cAb.getDex() * dexSkillProbability;
			mAb.setHp(mAb.getHp() - (int) dexSkillDamage);

			System.out.println("민첩 스킬을 사용했습니다.");
			System.out.println("캐릭터 마력: " + cAb.getMp());
			System.out.println("몬스터가 " + (int) dexSkillDamage + "의 피해를 입었습니다.");
			System.out.println("몬스터 체력: " + mAb.getHp());
		}

		// 몬스터 체력 0이면
		if (mAb.getHp() <= 0) {
			// 경험치 15 증가, 처음 메뉴 리턴
			System.out.println("몬스터가 쓰러졌습니다.");
			cAb.setExe(exp + 15);
			checkExe();
			mAb.setHp(100);
			System.out.println("------------------");
			Game_3.startGame();
		}

		System.out.println();

		int monsterDamage = mAb.getDamage();
		System.out.println("몬스터가 공격했습니다.");
		System.out.println("캐릭터가 " + monsterDamage + "의 피해를 입었습니다.");
		System.out.println("캐릭터 체력: " + cAb.getHp());
		cAb.setHp(cAb.getHp() - monsterDamage);

		// 캐릭터 체력 0 되면
		if (cAb.getHp() <= 0) {
			// 체력 70, 마나 70, 경험치 (현재 경험치 - 30) 초기화
			cAb.setHp(70);
			cAb.setMp(70);
			cAb.setExe(exp -30);
			System.out.println("캐릭터가 사망하였습니다.");
			System.out.println("처음 메뉴로 돌아갑니다.");
			System.out.println("-------------------");
		}

	}

	// 지력스킬 구현
	@Override
	public void knowledgeSkill(Game_3_MonsterAbility mAb) {
		// 스킬 사용시 마나가 30 미만이면 사용 불가
		if (cAb.getMp() < 30) {
			System.out.println("마나가 부족합니다.");
		} else {
			// 스킬사용: 마나 15 소모
			cAb.setMp(cAb.getMp() - 15);

			// 몬스터의 체력을 (지력 * 2.5) 만큼 감소
			double knowledgeSkillProbability = 2.5;
			double knowledgeSkillDamage = cAb.getKno() * knowledgeSkillProbability;
			mAb.setHp(mAb.getHp() - (int) knowledgeSkillDamage);

			System.out.println("지력 스킬을 사용했습니다.");
			System.out.println("캐릭터 마력: " + cAb.getMp());
			System.out.println("몬스터가 " + knowledgeSkillDamage + "의 피해를 입었습니다.");
			System.out.println("몬스터 체력: " + mAb.getHp());
		}

		// 몬스터 체력 0이면
		if (mAb.getHp() <= 0) {
			// 경험치 21 증가, 처음 메뉴 리턴
			System.out.println("몬스터가 쓰러졌습니다.");
			cAb.setExe(exp + 21);
			checkExe();
			mAb.setHp(100);
			System.out.println("------------------");
			Game_3.startGame();
		}

		System.out.println();

		int monsterDamage = mAb.getDamage();
		System.out.println("몬스터가 공격했습니다.");
		System.out.println("캐릭터가 " + monsterDamage + "의 피해를 입었습니다.");
		cAb.setHp(cAb.getHp() - monsterDamage);
		System.out.println("캐릭터 체력: " + cAb.getHp());

		// 캐릭터 체력 0 되면
		if (cAb.getHp() <= 0) {
			// 체력 70, 마나 70, 경험치 (현재 경험치 - 30) 초기화
			cAb.setHp(70);
			cAb.setMp(70);
			cAb.setExe(exp - 30);
			System.out.println("캐릭터가 사망하였습니다.");
			System.out.println("처음 메뉴로 돌아갑니다.");
			System.out.println("-------------------");
		}

	}

}
