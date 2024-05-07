package stream;

import java.util.Arrays;
import java.util.List;

public class test {
	
	public static void main(String[] args) {
		
		
		List<Integer> list=Arrays.asList(2,4,5,6,3);
		
		
		Integer ints= list.stream().max((a,b)->b-a).get().reverse(0);
		
		System.out.println(ints);
		
		
		
	}

}
