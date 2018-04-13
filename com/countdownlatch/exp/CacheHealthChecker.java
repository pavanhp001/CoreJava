package com.countdownlatch.exp;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BaseHealthChecker {
	
	public CacheHealthChecker (CountDownLatch latch)  {
        super("CacheHealthChecker Service", latch);
    }
     
    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
        	System.out.println("CacheHealthChecker name= ");
        	System.out.println(Thread.currentThread().getName());
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
