package kr.co.java.game;

public class Game_2_Archer extends Game_2_Character {

	Game_2_CharacterAbility ab = new Game_2_CharacterAbility();

	public Game_2_Archer() {
		ab.setStr(10);
		ab.setDex(50);
		ab.setKnowledge(10);
	};

	@Override
	public void attack() {

		if (ab.getHp() < 0) {
			System.out.println("체력이 부족하여 공격할 수 없습니다.");
		} else {
			System.out.println("활을 쏩니다.");

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
			System.out.println("집중 공격을 사용합니다.");

			ab.setExperience(ab.getExperience() + 50);
			System.out.println("현재 경험치: " + ab.getExperience());
			ab.setMp(ab.getMp() - 10);
			System.out.println("현재 mp: " + ab.getMp());

		}
		exp100();
	}

	public void exp100() {
		if (ab.getExperience() >= 100) {
			System.out.println("**************레벨업**************");
			System.out.println("민첩이 5 증가합니다.");
			ab.setExperience(ab.getExperience() - 100);
			ab.setLevel(ab.getLevel() + 1);
			ab.setDex(ab.getDex() + 5);
		}
	}

}
