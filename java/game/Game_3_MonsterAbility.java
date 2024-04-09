package kr.co.game;

public class Game_3_MonsterAbility {

	// 몬스터 공격력
	private int damage = 5;
	// 몬스터 체력
	private int hp = 100;

	// Getter
	public int getDamage() {
		return damage;
	}

	public int getHp() {
		return hp;
	}

	// Setter
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
