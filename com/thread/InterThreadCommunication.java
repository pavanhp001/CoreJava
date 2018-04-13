package com.thread;

public class InterThreadCommunication {
	
	
	public static void main(String[] args) {

		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();
		
		System.out.println("printAmount : "+ c.printAmount());
		
	}
}

class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}if(this.amount >= amount){
			this.amount -= amount;
			System.out.println("withdraw completed...");
		}
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		//notify();
	}
	
	public synchronized  int printAmount(){
		System.out.println("In printAmount" );
		try{
		notify(); //java.lang.IllegalMonitorStateException
		}catch(IllegalMonitorStateException im){
			
			im.printStackTrace();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return this.amount;
	}
}
