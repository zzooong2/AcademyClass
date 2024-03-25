package kr.co.prep;

public class Account {
	
	int balance;
	String accountNumber;
	int clientNumber;
	
	public Account(int bal, String accNum, int clientNum) {
		this.balance = bal;
		this.accountNumber = accNum;
		this.clientNumber = clientNum;		
	}
	
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	
	public int checkAccount() {
		System.out.println("고객 번호: " + clientNumber);
		System.out.println("계좌 번호: " + accountNumber);
		System.out.println("통장 잔고: " + balance);
		return balance;
	}

}
