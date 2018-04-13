package com.countdownlatch.exp;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker	 {
	
	public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
    }
     
    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
        	System.out.println("NetworkHealthChecker name= ");
        	System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
