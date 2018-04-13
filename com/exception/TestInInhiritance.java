package com.exception;

import java.io.IOException;

public class TestInInhiritance {

	public static void main(String[] args) throws IOException{
		
		A a = new B();
		a.m();  //In B
		a.m1();
	}
}

class A {
	public void m() throws IOException{
		System.out.println("In m A");
	}
	
	public void m1() {
		System.out.println("In m1 A");
	}
}

class B extends A{
	
	// we can overring m() without throws Checked Exception  
	
	//but if child class method throws Checked Exception then parent class method should throws Checked Exception.
	public void m(){   // 
		System.out.println("In m B");
	}
	// If parent method doesn't throws Exception child class should not throws IoException
	/*public void m1() throws IOException{  // java.lang.Error: Unresolved compilation problem: Exception IOException is not compatible with throws clause in A.m1()
		System.out.println("In m1 A");
	}*/
}
