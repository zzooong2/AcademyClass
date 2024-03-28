package kr.co.game;

public class Game_2 {
	
	public static void main(String[] args) {
		
		Game_2_Warlord warlord = new Game_2_Warlord();
		Game_2_Sorceress sorceress = new Game_2_Sorceress();
		Game_2_Archer archer = new Game_2_Archer();
		
		displayInfo(warlord.ab);
		warlord.attack();
		warlord.attack();
		warlord.attack();
		warlord.attack();
		warlord.attack();
		displayInfo(warlord.ab);
		
		displayInfo(sorceress.ab);
		sorceress.attack();
		sorceress.attack();
		sorceress.attack();
		sorceress.attack();
		sorceress.attack();
		displayInfo(sorceress.ab);
		
		displayInfo(archer.ab);
		archer.attack();
		archer.attack();
		archer.attack();
		archer.attack();
		archer.attack();
		displayInfo(archer.ab);
		
		displayInfo(warlord.ab);
		displayInfo(sorceress.ab);
		displayInfo(archer.ab);
		
	}
	
	public static void displayInfo(Game_2_CharacterAbility ab) {
		System.out.println("---------------능력치-------------");
		System.out.println("level: " + ab.getLevel());
		System.out.println("str: " + ab.getStr());
		System.out.println("dex: " + ab.getDex());
		System.out.println("knowledge: " + ab.getKnowledge());
		System.out.println("experience: " + ab.getExperience());
		System.out.println("hp: " + ab.getHp());
		System.out.println("mp: " + ab.getMp());
		System.out.println("---------------------------------");
	}
}
