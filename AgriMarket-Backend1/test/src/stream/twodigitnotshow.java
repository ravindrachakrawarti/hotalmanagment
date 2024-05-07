package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class twodigitnotshow {
	
	public static void main(String[] args) {
		
		
		List<Integer> list=Arrays.asList(2,4,7,9,5,49,66,45,33,35);
		
		 Random random = new Random();
	        int skipIndex = random.nextInt(list.size());
		
		list.stream().filter(e->e!=7 && e!=33).forEach(e->System.out.println(e));
		
		list.stream().skip(skipIndex).forEach(e->System.out.println("......"+e));
	}
	

}
