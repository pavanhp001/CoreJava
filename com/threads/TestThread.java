package com.threads;

public class TestThread {

	   public static Object Lock1 = new Object();
	   public static Object Lock2 = new Object();
	   
	  /* public Object Lock1 = new Object(); // error Cannot make a static reference to the non-static field Lock1
	   public Object Lock2 = new Object();
	   */
	   public static void main(String args[]) {
	      ThreadDemo1 T1 = new ThreadDemo1();
	      ThreadDemo2 T2 = new ThreadDemo2();
	      T1.start();
	      T2.start();
	   }
	   
	   private static class ThreadDemo1 extends Thread {
	      public void run() {
	         synchronized (Lock1) {
	            System.out.println(Thread.currentThread().getName()+" Holding lock 1...");
	            
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println(Thread.currentThread().getName()+" Waiting for lock 2...");
	            
	            synchronized (Lock2) {
	               System.out.println(Thread.currentThread().getName()+" Holding lock 1 & 2...");
	            }
	         }
	      }
	   }
	   private static class ThreadDemo2 extends Thread {
	      public void run() {
	        // synchronized (Lock2) { // dead lock scenario
	    	  synchronized (Lock1) {
	            System.out.println(Thread.currentThread().getName()+" Holding lock 2...");
	            
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println(Thread.currentThread().getName()+" Waiting for lock 1...");
	            
	           // synchronized (Lock1) { // dead lock scenario
	            synchronized (Lock2) {
	               System.out.println(Thread.currentThread().getName()+" Holding lock 1 & 2...");
	            }
	         }
	      }
	   }

}

/* 
o/p data  dead lock scenario
*Thread-0 Holding lock 1...
Thread-1 Holding lock 2...
Thread-0 Waiting for lock 2...
Thread-1 Waiting for lock 1...
*/

/*
 * 
 * Normal scenario
Thread-0 Holding lock 1...
Thread-0 Waiting for lock 2...
Thread-0 Holding lock 1 & 2...
Thread-1 Holding lock 2...
Thread-1 Waiting for lock 1...
Thread-1 Holding lock 1 & 2...

*
*/

