package com.spring;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;  
	private List names;
	
	public Student(){
		
	}
	
	public Student(String name, List names){
		
		this.name = name;
		this.names = names;
		
	}
	  
	public List getNames() {
		return names;
	}

	public void setNames(List names) {
		this.names = names;
	}

	public String getName() {  
	    return name;  
	}  
	  
	public void setName(String name) {  
	    this.name = name;  
	}  
	  
	public void displayInfo(){  
	    System.out.println("Hello: "+name);  
	} 
	public void displayNames(){  
	    System.out.println("Names: "+names);  
	} 
}
