package com.findcharacterAccurences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindCharacterAccurences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findCharacterAccurences("hello world pavan is good boy");

	}
	
	public static void findCharacterAccurences(String str){
		Map<Character,ArrayList<Integer>> map = new TreeMap<Character,ArrayList<Integer>>();
		char[] chr = str.toCharArray();
		System.out.println(chr);
		for(int i = 0; i < chr.length;i++){
			if(map.containsKey(chr[i])){
				ArrayList<Integer> al = map.get(chr[i]);
				al.add(i);
				map.put(chr[i], al);
			}else{
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				map.put(chr[i], al);
			}
		}
		/*Collections.sort(map, new Comparator<T>() {
			
			public int compare(Character c1, Character c2){
				
			}
		});*/
		System.out.println(map);
	}

}
