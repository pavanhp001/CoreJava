package com.thread;

public class PrintAddEven {
	
	private Boolean isAdd = true;
	private int maxValue = 30;
	private int count = 0;
	
	public void printAdd(){
		synchronized (this) {
			while(maxValue > count){
				while(!isAdd){   //if we comments we get  0 and 0 we never get out put
					try {
						System.out.println(" Add "+count);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				count++;
				if(count%2 != 0){
					isAdd = false;
				}
				notify();
			}
		}
	}
	public void printEven(){
		synchronized (this) {
			while(maxValue > count){
				while(isAdd){
					try {
						System.out.println(" Even "+count);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				count++;
				if(count%2 == 0){
					isAdd = true;
				}
				notify();
			}
		}
	}

	public static void main(String[] args) {
		
		final PrintAddEven print = new PrintAddEven();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				print.printAdd();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				print.printEven();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
