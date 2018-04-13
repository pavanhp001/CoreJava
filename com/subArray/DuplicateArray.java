package com.subArray;

import java.util.Arrays;

public class DuplicateArray {

	public static void main(String[] args) {
		
		int[] arr = {1,4,6,2,1,4,6,2,3,4};
		System.out.println("before Array="+Arrays.toString(arr));
		
		//int[] newArr = distictArra(arr);
		int[] newArr = toUniqueArray(arr);
		System.out.println("after Array="+Arrays.toString(newArr));

	}
	public static int[] distictArra(int[] arr) {
		int[] newArr = new int[arr.length];
		int count = 0;
		
		for (int i = 0; i < newArr.length-1; i++) {
			boolean isdistinct = false;
			for (int j = 0; j < i; j++) {
				/*if(arr[i] != arr[j]){
					newArr[count] = arr[i];
				}*/
				if(arr[i] == arr[j]){
					//isdistinct = true;
					break;
				}
				
				if((i == j)){
					newArr[count] = arr[i];
					count++;
				}
			}
			//count++;
		}
		
		
		return newArr;
	}
	
	public static boolean isUnique(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert the given array to an array with unique values
     * without duplicates and returns it.
     */
    public static int[] toUniqueArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1; // in case u have value of 0 in the array
        }

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (isUnique(temp, array[i]))
                temp[counter++] = array[i];
        }

        int[] uniqueArray = new int[counter];
        System.arraycopy(temp, 0, uniqueArray, 0, uniqueArray.length);
        return uniqueArray;
    }

    /**
     * Print given array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }
}
