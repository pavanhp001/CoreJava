package com.thread.account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		List<Runner> l = new ArrayList<Runner>();
		
		final Account acount1 = new Account(5000,"pavan");
		final Account acount2 = new Account(1000,"swathi");
		final Account acount3 = new Account(1000,"Thanmaya");
		final Account acount4 = new Account(1000,"sweety");
		
		l.add(new Runner(acount1,acount2,200));
		l.add(new Runner(acount1,acount2,400));
		l.add(new Runner(acount1,acount2,200));
		l.add(new Runner(acount2,acount3,200));
		l.add(new Runner(acount1,acount2,300));
		l.add(new Runner(acount2,acount4,200));
		l.add(new Runner(acount1,acount2,200));
		l.add(new Runner(acount2,acount3,400));
		l.add(new Runner(acount1,acount2,100));
		
		ExecutorService e = Executors.newFixedThreadPool(10);
		
		for(Runner r : l){
			e.execute(r);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.shutdown();
		// Wait until all threads are finish
		e.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println("Finished all threads");
		
		
		
		System.out.println("acount1 balance "+acount1.getBalance());
		System.out.println("acount2 balance "+acount2.getBalance());
		System.out.println("acount3 balance "+acount3.getBalance());
		System.out.println("acount4 balance "+acount4.getBalance());
	}
}
