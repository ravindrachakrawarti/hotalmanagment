package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {
	
	
	public static void main(String[] args) {
		
		
		
		List<String> list =Arrays.asList("ravin","vikas","rahul");
		
		List<String> str=  list.stream().filter(e->e.startsWith("ra")).toList();
		
		
		System.out.println(str);
		
		 List<Notes> noteLst = new ArrayList<>();
	        noteLst.add(new Notes(1, "aa", 11));
	        noteLst.add(new Notes(3, "cc", 33));
	        noteLst.add(new Notes(4, "bb", 44));
			noteLst.add(new Notes(2, "dd", 34));
	        noteLst.add(new Notes(5, "aa", 32));
	        
	        
	        noteLst.stream().filter(e->e.getName().startsWith("dd")).map(e->e.getMo()).forEach(e->System.out.println(e));
		
	List<String> lst= noteLst.stream().map(e->e.getName().toUpperCase()).collect(Collectors.toList());
	
	
	System.out.println(lst);
	
	
	      Map<String,Long> l1= noteLst.stream().collect(Collectors.groupingBy(e->e.getName(),Collectors.counting()));
	      
	      System.out.println(l1);

	List<String> list34=l1.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).collect(Collectors.toList());
	
	System.out.println(list34);
	
	
	List<List<Integer>> list56= Arrays.asList(
			
			Arrays.asList(1,2,4),
			Arrays.asList(1,2,4),
			Arrays.asList(1,2,4)
			);
	
	List<Integer> list3= list56.stream().flatMap(List::stream).collect(Collectors.toList());
	
	
	System.out.println(list3);
	
	
	
	List<String> st = Arrays.asList("Welcome", "to", "TechGeekNext");

	String jonStr = st.stream()
	                .map(String::valueOf)
	                .collect(Collectors.joining(" - "));
	//output
	System.out.println(jonStr);
	
	
	
	
	List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
	Map<String,Long> namesCount = names
	                             .stream()
					             .filter(x->Collections.frequency(names, x)>1)
					             .collect(Collectors.groupingBy
					             (Function.identity(), Collectors.counting()));
	System.out.println(namesCount);
	
	}

}
