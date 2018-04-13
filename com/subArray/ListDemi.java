package com.subArray;

import java.util.ArrayList;
import java.util.List;

public class ListDemi {

	public static void main(String[] args) {
		
		List<String> s = new ArrayList<String>();
		
		s.add("1234");
		s.add("1233");
		s.add("123234");
		s.add("123234");
		s.add("122334");
		System.out.println("  + "+s);
		s.remove("123234");
		System.out.println("  + "+s);
		
		

	}

}
