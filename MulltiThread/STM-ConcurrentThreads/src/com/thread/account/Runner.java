package com.thread.account;

public class Runner implements Runnable {
	
	private Account account1;
	private Account account2;
	private int amount;
	
	public Runner(Account account1, Account account2, int amount){
		this.account1 = account1;
		this.account2 = account2;
		this.amount = amount;
	}

	public void run() {
		AccountService.transfer(account1, account2, amount);
	}
}
