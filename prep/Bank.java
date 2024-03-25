package kr.co.prep;

public class Bank {
	public static void main(String[] args) {
		
		Account kim = new Account(1000, "111-111", 1);
		kim.checkAccount();
		
		System.out.println();
		Account lee = new Account(2000, "222-222", 2);
		lee.checkAccount();
	}

}
