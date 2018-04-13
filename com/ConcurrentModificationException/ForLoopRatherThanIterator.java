package com.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

public class ForLoopRatherThanIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String> myList = new CopyOnWriteArrayList<String>();
		
		List<String> myList = new ArrayList<String>();
		
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		System.out.println("myList: "+myList);
		for(int i = 0; i<myList.size(); i++){
			System.out.println(myList.get(i));
			if(myList.get(i).equals("3")){
				myList.remove(i);
				i--;         // ===========> mondatory to decrease size of array
				myList.add("6");
				myList.add("7");
			}
		}
		myList.add("8");
		System.out.println("myList: "+myList);

	}

}
/*
myList: [1, 2, 3, 4, 5]
1
2
3
4
5
6
7
myList: [1, 2, 4, 5, 6, 7, 8]
*/
