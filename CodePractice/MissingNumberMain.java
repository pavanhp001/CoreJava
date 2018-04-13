package CodePractice;

import java.util.Arrays;

public class MissingNumberMain {

	public static void main(String[] args) {
		
		//int[] a1 = {7,6,4,2,5,1};
		//missingNumber(a1);
		
		int[] a1 = {7,6,4,2,5,1,9,11,13};
		int[] a3 = {7,6,4,2,11};
		
		missingNumbers(a1);
		
		int[] a2 = {7,6,4,2,5,1,8,3,10};
		//missingNumber(a2);
		
	}
	
	private static void missingNumber(int[] a){
		
		int length = a.length + 1;
		
		int b = length + 1;
		
		int total  = (length*(length+1))/2;
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		int missingNum = total - sum;
		System.out.println("missingNum : "+missingNum);
	}
	
	private static void missingNumbers(int[] a){
		Arrays.sort(a);
		for (int i : a) {
			System.out.print(","+i);
		}
		System.out.println();
		
		//System.out.println("starting element : "+a[0]);
		int startElem = a[0];
		int lastElem = a[a.length-1];
		
		int j = 0;
		int length = a.length;
		for (int i = startElem; i <= length; i++) {
			if(i != a[j]){
				System.out.println("missing value : "+i);
				length++;
			}else{
				j++;
				if(i >= length && lastElem > i){
					length++;
				}
			}
		}
		
	}
}
