package com.thread;

public class DeadLock {

	public static void main(String[] args) throws InterruptedException {


		LockObj l = new LockObj();
		Thread t1 = new Thread(l);
		Thread t2 = new Thread(l);
		Thread t3 = new Thread(l);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
	}

}

class LockObj implements Runnable{
	public void method1() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (String.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (Integer.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

	@Override
	public void run() {
		method1();
		method2();
	}
}