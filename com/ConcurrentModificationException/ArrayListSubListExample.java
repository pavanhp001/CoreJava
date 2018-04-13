package com.ConcurrentModificationException;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListSubListExample {

	public static void main(String[] args) {
		
		//List<String> names = new ArrayList<String>();
		List<String> names = new CopyOnWriteArrayList<String>();
		names.add("Java"); names.add("PHP");names.add("SQL");names.add("Angular 2");
		
		List<String> first2Names = names.subList(0, 2);
		
		System.out.println(names +" , "+first2Names);
		//System.out.println(names );
		
		names.set(1, "JavaScript");
		//check the output below.
		System.out.println(names +" , "+first2Names);
		
		//Let's modify the list size and get ConcurrentModificationException
		names.set(1, "JavaScript2");
		//names.set(3, "JavaScript4"); //[Java, JavaScript2, SQL, JavaScript4]
		//names.set(4, "JavaScript4"); //java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
		System.out.println(names );
		names.add("NodeJS");  // Modifying the length of ArrayList 
		System.out.println(first2Names ); //java.util.ConcurrentModificationException
		//System.out.println(names +" , "+first2Names); //this line throws exception
	}
}
