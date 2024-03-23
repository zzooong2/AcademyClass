package kr.co.self_study_extends;

public class ManchesterUnited {

	public static void main(String[] args) {

		Deffender def = new Deffender("LINDELOF", "CB", 2, "엥커맨", 5);
		Attacker att = new Attacker("GARNACHO", "LW", 17, "인버티드 윙어", 11);
		
		def.deffenderRole();
		System.out.println();
		att.attackerRole();
	}

}
