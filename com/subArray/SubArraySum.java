package com.subArray;

public class SubArraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		
		int x = 280;
		
		int result = findSubArray(arr, arr.length, 8);
		System.out.println("result: "+result);
		
	}

	private static int findSubArray(int[] arr, int length, int x) {
		
		int max_sum = 0;
		
		int sum = 0;
		
		for(int i=0; i< length; i++){
			
			for(int j=0; j< 4; j++){
				
				sum += arr[j];
				
			}
			if(sum > x){
				if(sum > max_sum){
					max_sum = sum;
				}
			}
			sum = 0;
		}
			
		return max_sum;
	}

}
