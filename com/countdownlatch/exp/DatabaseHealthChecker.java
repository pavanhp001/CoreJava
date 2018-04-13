package com.countdownlatch.exp;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {
	
	public DatabaseHealthChecker (CountDownLatch latch)  {
        super("DatabaseHealthChecker Service", latch);
    }
     
    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
        	System.out.println("DatabaseHealthChecker name= ");
        	System.out.println(Thread.currentThread().getName());
            Thread.sleep(13000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
