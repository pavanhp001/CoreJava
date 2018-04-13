package com.ConcurrentModificationException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class mapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeMap<String,String> tm = new TreeMap<String,String>();
		//tm.put(null, "test"); //java.lang.NullPointerException
		tm.put("test", null );
		tm.put("test1", null );
		System.out.println(tm); //{test=null, test1=null}
		
		Map<String,String> hm = new HashMap<String,String>();
		/* HashMap allow null as key and values */
		hm.put(null, "test");
		hm.put(null, "test1");
		hm.put(null, null);
		System.out.println(hm); //{null=null}
		
		Hashtable <String,String> ht = new Hashtable<String,String>();
		/* Hashtable does not allow null as key and values */
		//ht.put(null, "test"); //java.lang.NullPointerException
		
		ht.put("test",null); //java.lang.NullPointerException
		/*ht.put(null, "test1");
		ht.put(null, "test2");
		System.out.println(ht);*/
	}
}
