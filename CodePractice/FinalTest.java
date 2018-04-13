package CodePractice;

public class FinalTest {

	public static void main(String[] args) {
	
		int val = 5;
		String s1 = "Kumar";
		System.out.println("val "+val+" s1 "+s1);
		new FinalTest().m1(val, s1);
		System.out.println("val "+val+" s1 "+s1);

	}
	
	//public int m1(final int val, final String s){
	public int m1(int val, String s){
		
		val = 10;  // The final local variable val cannot be assigned. It must be blank and not using a compound assignment
		s = s.concat("pavan"); //The final local variable s cannot be assigned. It must be blank and not using a compound assignment
		System.out.println("val in m1 method "+val+" s "+s);
		return val;
		
	}

}

/*
val 5 s1 Kumar
val in m1 method 10 s Kumarpavan
val 5 s1 Kumar
*/
