package com.stm;

import java.util.concurrent.Callable;

import clojure.lang.LockingTransaction;
import clojure.lang.Ref;

public class STMTest {

	public static void main(String[] args) {
		// final needed to be used in anonymous class
	    final Ref r = new Ref(1);
	    final Ref s = new Ref(5);

	    try {
	      // run this in a transaction
	      // don't do IO inside
	      LockingTransaction.runInTransaction(
	        new Callable<Object>() {
	          public Object call(){
	            s.set((Integer)r.deref() + 10);
	            r.set(2);
	            return null;
	          }
	        }
	      );
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	        
	    System.out.println(r.deref());
	    System.out.println(s.deref());
	  }

}
