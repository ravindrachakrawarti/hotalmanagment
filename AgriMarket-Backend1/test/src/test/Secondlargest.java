package test;

import java.util.Arrays;

import java.util.List;



public class Secondlargest {
	
	
	public static void main(String[] args) {
		
		 List<Integer> list=Arrays.asList(2,5,8,4,9,3);
		 
		 int secondLargest = list.stream()
	                 
	                .sorted((a, b) -> b - a) 
	                .distinct() 
	                .skip(1) 
	                .findFirst() 
	                .orElseThrow(() -> new IllegalArgumentException("Array is empty or has only one element."));

	        System.out.println("Second largest number in the array: " + secondLargest);
	    
	     
	     
	    
		      
		      int[] numbers = {5, 2, 8, 10, 1, 9};
		        
		        int secondLargest1 = Arrays.stream(numbers)
		                .boxed() 
		                .sorted((a, b) -> b - a) 
		                .distinct() 
		                .skip(1) 
		                .findFirst() 
		                .orElseThrow(() -> new IllegalArgumentException("Array is empty or has only one element."));

		        System.out.println("Second largest number in the array: " + secondLargest1);
		    }
		
	

}
