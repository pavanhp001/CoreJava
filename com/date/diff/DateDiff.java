package com.date.diff;

import java.util.Date;

//import com.allconnect.ui.util.Utils;

public class DateDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 

		String[] arr = "APt  1".split(" ");
		
		String[] temp = new String[arr.length];
		int j = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != "" && arr[i] != null){
				System.out.println("----"+arr[i]);
				temp[j]=arr[i];
				j++;
			}
		}
		for (String string : temp) {
			System.out.println("  "+string);
			
		}
		/*Date date1 = new Date();
		System.out.println(date1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2 = new Date();
		
		long l = date2.getTime() - date1.getTime();
		
		System.out.println(l);
		System.out.println(date2);*/
	}
}
