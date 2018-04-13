package Strings;

public class OverrideException {
	
	public void get(String s){
		System.out.println("String");
		double d = Math.random();
		System.out.println("data="+d);
	}
	public void get(Object s){
		System.out.println("Object");
	}

	public static void main(String[] args) {
		
		new OverrideException().get(null);

	}

}
