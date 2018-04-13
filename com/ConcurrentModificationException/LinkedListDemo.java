package com.ConcurrentModificationException;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("15");
		list.add("12");
		list.add("13");
		list.add("16");
		list.add("14");
				
		System.out.println("list"+list);
		Collections.reverse(list);
		System.out.println("list"+list);
		Collections.sort(list);
		System.out.println("list"+list);

	}

}
