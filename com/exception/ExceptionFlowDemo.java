package com.exception;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExceptionFlowDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*try{
			String e = null;
			e.charAt(0);
			System.out.println("trtttt");
			 List list = new LinkedList<String>();
			
		}catch(NullPointerException ne){
			System.out.println("NullPointerException sdfs");
		}catch(Exception ne){
			System.out.println("Exception");
		}finally{
			System.out.println("finally");
		}*/
		
		Integer i = new Integer(2);
		if(i == 2){
			System.out.println("true");
		}
		
		List list = new LinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        
        Collections.reverse(list);
        Iterator iter = list.iterator();
        
        /*for (Object o : iter) {
            System.out.print(o + " ");
        }*/
        
        try{
        	
        }catch(Exception e){
        	
        }

	}

}
