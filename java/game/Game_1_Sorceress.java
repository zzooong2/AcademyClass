package kr.co.java.game;

public class Game_1_Sorceress extends Game_1_Character {

	public Game_1_Sorceress(int str, int dex, int knowledge) {
		super(str, dex, knowledge);
	}
	
	@Override
	public void attack() {
		System.out.println("지팡이를 휘두릅니다.");
	}
	
	@Override
	public void skill() {
		System.out.println("아이스 애로우를 사용 합니다.");
	}
	
	@Override
	public void levelUp() {
		System.out.println("레벨업을 하여 지력이 5 증가합니다. ");
		super.knowledge += 5;
		super.level += 1;
	}
	
}
