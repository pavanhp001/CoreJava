package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class DiffVoltileAtom extends Thread{
	
	volatile Integer i = 1;
	AtomicInteger j = new AtomicInteger(1);
	int k = 1;
	
	public void countVolatile(){
		System.out.println("countVolatile()="+this.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			i = i+1;
			System.out.print("-"+i);
		}
		System.out.println();
	}
	public void countAtom(){
		System.out.println("countAtom()="+this.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			j.addAndGet(1);
			System.out.print("="+j.get());
		}
		System.out.println();
	}
	public void countPrimitiv(){
		System.out.println("countPrimitiv()="+this.currentThread().getName());
		
		for (int i = 0; i < 10; i++) {
			k = k+1;
			System.out.print(".."+k);
		}
		System.out.println();
	}
	public void run(){
		//System.out.println("countVolatile====================================");
		//countVolatile();
		System.out.println("countAtom=====================================");
		countAtom();
		//System.out.println("countPrimitiv=====================================");
		//countPrimitiv();
	}

	public static void main(String[] args) throws InterruptedException {
		
		DiffVoltileAtom d1 = new DiffVoltileAtom();
		DiffVoltileAtom d2 = new DiffVoltileAtom();
		DiffVoltileAtom d3 = new DiffVoltileAtom();
		DiffVoltileAtom d4 = new DiffVoltileAtom();
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		
		try {
			d1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d3.join();
		d4.join();
		
		

	}

}
