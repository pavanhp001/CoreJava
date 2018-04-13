package com.map.sort;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			
			System.out.println(shortSet.add(i));
			System.out.println(shortSet.remove(i - 1));//Now "i-1" will be converted to int while evaluation and after that it will autoboxed to Integer object but there are no Integer object in the HashSet	
		}
		System.out.println(shortSet.size());
		Iterator itr = shortSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			
		}
		int x = 10*10-10;
		System.out.println("===============");
		System.out.println(x);
		try {
			throw new IOException("Hello");
		}catch(IOException | Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
