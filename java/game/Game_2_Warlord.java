package kr.co.java.game;

public class Game_2_Warlord extends Game_2_Character {

	Game_2_CharacterAbility ab = new Game_2_CharacterAbility();

	public Game_2_Warlord() {
		ab.setStr(50);
		ab.setDex(10);
		ab.setKnowledge(10);
	};

	@Override
	public void attack() {
		if (ab.getHp() < 0) {
			System.out.println("체력이 부족하여 공격할 수 없습니다.");
		} else {
			System.out.println("둔기를 휘두릅니다.");

			ab.setExperience(ab.getExperience() + 25);
			System.out.println("현재 경험치: " + ab.getExperience());
			ab.setHp(ab.getHp() - 10);
			System.out.println("현재 hp: " + ab.getHp());

		}
		exp100();
	}

	@Override
	public void skill() {
		if (ab.getMp() < 0) {
			System.out.println("마력이 부족하여 공격할 수 없습니다.");
		} else {
			System.out.println("리프 어택을 사용합니다.");

			ab.setExperience(ab.getExperience() + 30);
			System.out.println("현재 경험치: " + ab.getExperience());
			ab.setMp(ab.getMp() - 10);
			System.out.println("현재 mp: " + ab.getMp());

		}
		exp100();

	}

	public void exp100() {
		if (ab.getExperience() >= 100) {
			System.out.println("**************레벨업**************");
			System.out.println("힘이 5 증가합니다.");
			ab.setExperience(ab.getExperience() - 100);
			ab.setLevel(ab.getLevel() + 1);
			ab.setStr(ab.getStr() + 5);
		}
	}

}
