package CodePractice;

public class Fibonacci {

	public static void main(String[] args) {
		 //input to print Fibonacci series upto how many numbers
        System.out.println("Enter number upto which Fibonacci series to print: ");
        int number = 10;
      
        System.out.println("Fibonacci series upto " + number +" numbers : ");
        System.out.println("tail recursion");
        //printing Fibonacci series upto number
        for(int i=1; i<=number; i++){
            System.out.print(fibonacci(i) +" "); //1 1 2 3 5 8 13 21 34 55 
        }
        System.out.println();
        System.out.println("Fibonacci number is sum of previous two Fibonacci number");
        for(int i=1; i<=number; i++){
            
             System.out.print(fibonacci2(i) +" ");//1 1 2 3 5 8 13 21 34 55 
         }
        System.out.println();
        
        System.out.print(fibonacci2(10) +" ");//55

	}
	
	public static int fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        }
      //System.out.println("number"+number);
        return fibonacci(number-1) + fibonacci(number -2); //tail recursion
    }
	
	 public static int fibonacci2(int number){
	        if(number == 1 || number == 2){
	            return 1;
	        }
	        int fibo1=1, fibo2=1, fibonacci=1;
	        for(int i= 3; i<= number; i++){
	           
	            //Fibonacci number is sum of previous two Fibonacci number
	            fibonacci = fibo1 + fibo2;             
	            fibo1 = fibo2;
	            fibo2 = fibonacci;
	          
	        }
	        return fibonacci; //Fibonacci number
	      
	    }   
}
