package kr.co.game;

public class Game_2_CharacterAbility {
	
	// 힘, 민첩, 지력, 경험치, 체력, 마력
	private int str, dex, knowledge;
	private int level = 1;
	private int experience;
	private int hp = 100;
	private int mp = 100;
	
	
	// Getter
	public int getStr() {
		return str;
	}
	
	public int getDex() {
		return dex;
	}
	
	public int getKnowledge() {
		return knowledge;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public int getLevel() {
		return level;
	}
	
	
	// Setter
	public void setStr(int str) {
		this.str = str;
	}
	
	public void setDex(int dex) {
		this.dex = dex;
	}
	
	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
//	public void exp100(int experience) {
//		if(this.experience > 100) {
//			if(this.str >= 50) {
//				this.str += 5;
//			} else if (this.dex >= 50) {
//				this.dex += 5;
//			} else if (this.knowledge >= 50) {
//				this.knowledge += 5;
//			}
//			System.out.println("----------레벨업!!----------");
//			this.level += 1;
//			this.experience = this.experience - 100;
//		}
//			
//	}

	
}

