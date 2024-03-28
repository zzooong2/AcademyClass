package kr.co.game;

public class Game_1 extends Game_1_Character {

	public static void main(String[] args) {
		
		// warload 생성 (힘50, 민첩10, 지력10)
		Game_1_Warlord warlord = new Game_1_Warlord(50, 10, 10);
		
		System.out.println("Warlord 능력치");
		warlord.characterInfo();
		System.out.println("---------------------");
		
		warlord.attack();
		warlord.skill();
		warlord.levelUp();
		
		System.out.println("---------------------");
		
		System.out.println("Warlord 능력치");
		warlord.characterInfo();
		System.out.println("---------------------");
		
		
		// sorceress 생성 (힘10, 민첩10, 지력50)
		Game_1_Sorceress sorceress = new Game_1_Sorceress(10, 10, 50);
		
		System.out.println("Sorceress 능력치");
		sorceress.characterInfo();
		System.out.println("---------------------");
		
		sorceress.attack();
		sorceress.skill();
		sorceress.levelUp();
		
		System.out.println("---------------------");
		
		System.out.println("Sorceress 능력치");
		sorceress.characterInfo();
		System.out.println("---------------------");
		
		
		// archer 생성 (힘10, 민첩50, 지력10)
		Game_1_Archer archer = new Game_1_Archer(10, 50, 10);
		
		System.out.println("Archer 능력치");
		archer.characterInfo();
		System.out.println("---------------------");
		
		archer.attack();
		archer.skill();
		archer.levelUp();
		
		System.out.println("---------------------");
		
		System.out.println("Archer 능력치");
		archer.characterInfo();
		System.out.println("---------------------");
		
		
	}

}
