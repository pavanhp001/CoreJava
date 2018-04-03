package com.thread.account;

import java.util.concurrent.Callable;

import clojure.lang.LockingTransaction;
import clojure.lang.Ref;

//import clojure.lang.*;

public class Account {
	private String name; 
	private Ref balance;
	
	public int getBalance() {
		return (Integer)balance.deref();
	}

	public void setBalance(Ref balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account(final int initiolBalance, final String name){
		balance = new Ref(initiolBalance);
		this.name = name;
	}
	
	public void deposit(final int amount) throws Exception{
		LockingTransaction.runInTransaction(new Callable<Void>(){
			public Void call() throws Exception {
				System.out.println("deposit amount +++"+amount);
				if(amount > 0){
					balance.set(getBalance() + amount);
				}
				return null;
			}
		});
	}
	
	public void withdrow(final int amount) throws Exception{
		LockingTransaction.runInTransaction(new Callable<Void>(){
			public Void call() throws Exception {
				System.out.println("withdrow amount --- "+amount);
				if(amount > 0 && amount <= getBalance()){
					balance.set(getBalance() - amount);
				}else{
					throw new RuntimeException("Not enogh money");
				}
				return null;
			}
		});
	}
}
