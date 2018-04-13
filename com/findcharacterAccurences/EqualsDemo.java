package com.findcharacterAccurences;

public class EqualsDemo {

	public static void main(String[] args) {


		long l = 10000L;
		String ls = Long.toString(l);
		String s = "10000";
		System.out.println(l);
		System.out.println(s.equals(l));; // false
		System.out.println(ls.equals(s));; //true

	}

}

/*
10000
false
true
*/
