package com.map.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwapArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 List<String> list = new ArrayList<String>();
		    list.add("Java");
		    list.add("R");
		    list.add("CSS");
		    list.add("XML");
		    System.out.println("Normal List: " + list);

		    Collections.sort(list);
		    System.out.println(" sort List: " + list);

		    // Swap elements at indexes 1 and 3
		    Collections.swap(list, 1, 3);
		    System.out.println("swap: "+list);
		    
		    Collections.rotate(list, 2);
		    System.out.println("After  Rotating by  2: " + list);
	}

}
