package kr.co.prep;

public class ManchesterUnited {

	public static void main(String[] args) {

		Attacker att = new Attacker("GARNACHO", "LW", 17, "인버티드 윙어", 11);
		MidFielder mid = new MidFielder("BRUNO FERNANDES", "CAM", 8, "플레이 메이커", 8);
		Deffender def = new Deffender("LINDELOF", "CB", 2, "엥커맨", 5);
		GoalKeeper goa = new GoalKeeper("ANDRE ONANA", "GK", 24, "스위퍼 키퍼",  1);
	
		att.attackerRole();
		System.out.println();
		mid.midFielderRole();
		System.out.println();
		def.deffenderRole();
		System.out.println();
		goa.goalKeeperRole();
		
	}

}
