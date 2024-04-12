package kr.co.java.game;

public class Game_2_CharacterAbility {

	// 힘, 민첩, 지력, 경험치, 체력, 마력
	private int str, dex, knowledge, experience;
	private int level = 1;
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

}
