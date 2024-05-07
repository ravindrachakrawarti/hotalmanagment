package test;

import java.util.Arrays;
import java.util.Collections;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practics {
	public static void main(String[] args) {
		
		
		List<Integer> list=Arrays.asList(4,5,6,4,3,7,8);
		
		int abc=   list.stream().sorted((a,b)->b-a).distinct().skip(1).findAny().orElseThrow(()-> new IllegalArgumentException("abc"));
		
		System.out.println(abc);
		
		
		Long bb=list.stream().count();
		
		
		System.out.println(bb);
		int max =  list.stream()
                .max(Integer::compare)
                .get();
		
		System.out.println(max);
		
		Set<Integer> set=new HashSet();
		
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		list.stream().sorted((a,b)->b-a).forEach(System.out::print);
		
		
		int list1[]= {3,5,7,4,9,7};
		
	List<Integer> arr= Arrays.stream(list1).boxed().collect(Collectors.toList());
		
	Set<Integer> set1=new HashSet(arr);
	
	
	if(set1.size()==arr.size())
	{
		
		System.out.println("fasle");
	}
	else {
		System.out.println("true");
	}
	
	
	System.out.println(java.time.LocalDateTime.now());
	
	

	List<Integer> list3=Arrays.asList(4,5,6,4,3,7,8);

	List<Integer> list4=Arrays.asList(4,5,6,4,3,7,8);
	
	            Stream<Integer> stream = Stream.concat(list3.stream(), list4.stream());
	            
	              stream.forEach(System.out::print);           
	
	       list4.stream().map(e->e*e*e).filter(e->e>50).forEach(System.out::println);
	
	   	List<String> list6=Arrays.asList("ra","gsd","ra","gd","hj");
	   	
	   Map<String,Long> map= list6.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
	
	System.out.println(map);
	
         Map<String,Long> map2= list6.stream().filter(e->Collections.frequency(list6, e)>1).collect(Collectors.groupingBy(e->e,Collectors.counting()));
	
	System.out.println(map2);
	
	
	String str="my name is ravindra";
	
      Map<String,Long> str2=Arrays.stream(str.split("")).collect(Collectors.groupingBy(e->e, LinkedHashMap::new,Collectors.counting()));
	
        Map<Character,Long>  strr=  str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));
          System.out.println(strr);
	
	}
	

}
