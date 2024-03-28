package kr.co.game;

public class Game_1_Warlord extends Game_1_Character {
	
	public Game_1_Warlord(int str, int dex, int knowledge) {
		super(str, dex, knowledge);
	}
	
	@Override
	public void attack() {
		System.out.println("둔기를 휘두릅니다.");
	}
	
	@Override
	public void skill() {
		System.out.println("리프 어택을 사용합니다.");
	}
	
	@Override
	public void levelUp() {
		System.out.println("레벨업을 하여 힘이 5 증가합니다.");
		super.str += 5;
		super.level += 1;
	}
		
}
