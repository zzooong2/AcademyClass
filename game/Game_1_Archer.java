package kr.co.game;

public class Game_1_Archer extends Game_1_Character {

	public Game_1_Archer(int str, int dex, int knowledge) {
		super(str, dex, knowledge);
	}
	
	@Override
	public void attack() {
		System.out.println("활을 쏩니다.");
	}
	
	@Override
	public void skill() {
		System.out.println("집중 공격을 사용합니다.");
	}
	
	@Override
	public void levelUp() {
		System.out.println("레벨업을 하여 민첩이 5 증가합니다.");
		super.dex += 5;
		super.level += 1;
	}
}
