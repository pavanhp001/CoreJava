package com.GC;

public class GCDemo {

	public static void main(String[] args) throws InterruptedException {
        GCDemo t1 = new GCDemo();
        GCDemo t2 = new GCDemo();
        GCDemo t3 = new GCDemo();
        GCDemo t4 = new GCDemo();
        GCDemo t5 = new GCDemo();
        
        GCDemo t6 = new GCDemo();
        GCDemo t7 = new GCDemo();
        GCDemo t8 = new GCDemo();
        GCDemo t9 = new GCDemo();
        GCDemo t10 = new GCDemo();
        GCDemo t11 = new GCDemo();
        GCDemo t12 = new GCDemo();
        
         
        // Nullifying the reference variable
        t1 = null;
        
        t2 = null;
        t3 = null;
        System.gc();
        sleep();
        t4 = null;
        System.gc();
        sleep();
        t5 = null;
        System.gc();
        sleep();
        t6 = null;
        System.gc();
        sleep();
        t7 = null;
        System.gc();
        sleep();
        t8 = null;
        System.gc();
        sleep();
        t9 = null;
         
        // requesting JVM for running Garbage Collector
        System.gc();
         
        // Nullifying the reference variable
  
        
         
        // requesting JVM for running Garbage Collector
        Runtime.getRuntime().gc();
     
    }
	     
    @Override
    // finalize method is called on object once 
    // before garbage collecting it
    protected void finalize() throws Throwable
    {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this.getClass().getName());
    }
    public static void sleep(){
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
