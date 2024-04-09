package kr.co.game;

public class Game_1_Character {
	
	// 힘, 민첩, 지력, 레벨
	public int str, dex, knowledge, level;
	
	public Game_1_Character() {};
	
	public Game_1_Character(int str, int dex, int knowledge) {
		this.str = str;
		this.dex = dex;
		this.knowledge = knowledge;
	};
	
	// 캐릭터의 행동
	public void walk() {
		System.out.println("캐릭터가 한걸음 걷습니다.");
	}
	
	public void stop() {
		System.out.println("캐릭터가 멈춥니다.");
	}
	
	public void attack() {
		System.out.println("공격");
	}
	
	public void skill() {
		System.out.println("공통 스킬 사용");
	}
	
	public void levelUp() {
		System.out.println("레벨업! 능력치가 5 증가합니다.");
	}
	
	public void characterInfo( ) {
		System.out.println("힘: " + str);
		System.out.println("민첩: " + dex);
		System.out.println("지력: " + knowledge);
		System.out.println("레벨: " + level);
	}
	
	
}
