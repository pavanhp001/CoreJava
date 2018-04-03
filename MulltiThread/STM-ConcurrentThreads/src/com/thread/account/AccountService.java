package com.thread.account;

import java.util.concurrent.Callable;

import clojure.lang.LockingTransaction;

public class AccountService {
	
	public static void transfer(final Account from, final Account to, final int amount){
		try{
			LockingTransaction.runInTransaction(new Callable<Void>() {
				
				public Void call() throws Exception {
					System.out.println("from name : "+from.getName()+" to : "+to.getName());
					System.out.println("from : "+from.getBalance()+" to : "+to.getBalance());
					System.out.println("transfer amount : "+amount);
					from.withdrow(amount);
					to.deposit(amount);
					return null;
				}
			});
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("Error in AccountService"+);
		}
		
	}

}
