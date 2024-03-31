package kr.co.game;

public class Game_3_CharacterAbility {

	// 캐릭터 기본속성: 힘, 민첩, 지력, 경험치
	private int str, dex, kno, exe;

	// 캐릭터 기본레벨: 1
	private int level = 1;

	// 캐릭터 기본체력: 100
	private int hp = 100;

	// 캐릭터 기본마력: 100
	private int mp = 100;

	// 캐릭터 초기속성: 0
	private int unusedStatus = 0;

	// 체력포션 기본값 10, 사용시 체력 50회복
	private int hpPortion = 10;

	// 마나포션 기본값 10, 사용시 마력 50회복
	private int mpPortion = 10;

	// 기본생성자
	public Game_3_CharacterAbility() {
		this.str = 30;
		this.dex = 30;
		this.kno = 30;
		this.exe = 0;
	}

	// Getter
	public int getStr() {
		return str;
	}

	public int getDex() {
		return dex;
	}

	public int getKno() {
		return kno;
	}

	public int getExe() {
		return exe;
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

	public int getUnusedStatus() {
		return unusedStatus;
	}

	public int getHpPortion() {
		return hpPortion;
	}

	public int getMpPortion() {
		return mpPortion;
	}

	// Setter
	public void setStr(int str) {
		this.str = str;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public void setKno(int kno) {
		this.kno = kno;
	}

	public void setExe(int exe) {
		this.exe = exe;
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

	public void setUnusedStatus(int unusedStatus) {
		this.unusedStatus = unusedStatus;
	}

	public void setHpPortion(int hpPortion) {
		this.hpPortion = hpPortion;
	}

	public void setMpPortion(int mpPortion) {
		this.mpPortion = mpPortion;
	}

}
