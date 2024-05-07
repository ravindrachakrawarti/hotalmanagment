package StreamPrograming;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import stream.optional;
import test.collect;

public class EmployeeStream {
	
	
	
	public static void main(String[] args) {
		
		 List<Employee> employee =new ArrayList<>();
		
		employee.add(new Employee(111,"ravi",23,"male","softwore dev",2011,43000));
		employee.add(new Employee(111,"ravin",21,"male","softwore dev",2011,40000));
		employee.add(new Employee(112,"nikana",24,"female","softwore test",2016,44000));
		employee.add(new Employee(113,"reena",53,"female","softwore eng",2013,48000));
		employee.add(new Employee(114,"vikas",33,"male","softwore mang",2016,50000));
		employee.add(new Employee(1115,"sanay",63,"male","softwore lead",2020,20000));
		employee.add(new Employee(1116,"arun",29,"male","softwore jr",2021,60000));
		employee.add(new Employee(1117,"sabnam",53,"female","softwore sr",2012,80000));
		employee.add(new Employee(1113,"vishal",63,"male","softwore ceo",2018,120000));
		employee.add(new Employee(1112,"mohit",46,"male","softwore hr",2015,30000));
		
		System.out.println(".... Total male and female ");
		Map<String,Long> maleandfemale =	employee.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	
	    
		System.out.println(maleandfemale);
		
		
		
		System.out.println(".... Total show department ");
			employee.stream().map(Employee::getDeparment).distinct().forEach(System.out::println);
			
			
			System.out.println(".... Average age  male and female ");
			Map<String,Double> avagemaleandfemale =	employee.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
		
			System.out.println(avagemaleandfemale);
		
	
	    
			System.out.println(".... Highest pay employee ");
		Optional<Employee> maxsalary=	employee.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		    
			System.out.println(maxsalary.get().getName()+" "+maxsalary.get().getSalary());
			
			
			System.out.println(".... who joining after 2015 ");
				employee.stream().filter(e->e.getYear()>2015).map(Employee::getName).forEach(System.out::println);
				
				

				System.out.println(".... avarage salary each department ");
			Map<String,Double> avgsalaryeachdep=	 employee.stream().collect(Collectors.groupingBy(Employee::getDeparment,Collectors.averagingDouble(Employee::getSalary)));
			    
			
			Set<Entry<String ,Double>> entry=	avgsalaryeachdep.entrySet(); 
			
			for(Entry<String, Double> avgentry:entry)
			{
				
				System.out.println(avgentry.getKey()+" "+avgentry.getValue());
			
			}
			
			
			
			System.out.println(".... min age name ");
			
			
		Optional<Employee> minAge=employee.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
		
		System.out.println(minAge.get().getName());
		
		
		
		System.out.println(".... young male  emp dev deparment ");
		
		
	Optional<Employee> youngmaledev= employee.stream().filter(e->e.getGender()=="male" && e.getDeparment() =="softwore dev").min(Comparator.comparingInt(Employee::getAge));
		
		System.out.println(youngmaledev.get().getName());
		

		System.out.println(".... max experience employee");
		
	Optional<Employee> mostexperience=	employee.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYear)));
		
	
	System.out.println(mostexperience.get().getName());
	
	
	System.out.println(".... male and female avg");
	
	
      Map<String, Double> mandfavg=  employee.stream().collect(Collectors.groupingBy(Employee::getGender , Collectors.averagingDouble(Employee::getSalary)));
	
	
	System.out.println(mandfavg);
	
	
	System.out.println(".... number of emp each  department");
	
Map<String, List<Employee>> numofdep=	employee.stream().collect(Collectors.groupingBy(Employee::getDeparment));

            
System.out.println(numofdep);

     Set<Entry<String, List<Employee>>> entryset = numofdep.entrySet();
     
     
     for(Entry<String, List<Employee>> entryemset:entryset)
     {
    	 System.out.println("............................");
    	 System.out.println(entryemset.getKey());
    
    	
    	List<Employee> list= entryemset.getValue();
    	
    	list.forEach(e->System.out.println(e.getName()));
 
    	
    	
     }

     System.out.println(".... find the sum and avg of salary");
     
       DoubleSummaryStatistics doublesummarystat=  employee.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
       
       
       System.out.println(doublesummarystat.getAverage());
       System.out.println(doublesummarystat.getSum());
	
       
       System.out.println(".... age 35 below and 35 above separate");
       
       
     Map<Boolean, List<Employee>> partitionemp=   employee.stream().collect(Collectors.partitioningBy(e->e.getAge()>35));
     
     
        Set<Entry<Boolean, List<Employee>>> entrypartition=  partitionemp.entrySet();
        
        
        for(Entry<Boolean, List<Employee>> entrypar:entrypartition)
        {
        	if(entrypar.getKey())
        	{
        		System.out.println("age is 35 above");
        	}
        	else{
        		System.out.println("age is 35 below");
        	}
        	
        	
        List<Employee> list2=entrypar.getValue();
        
        list2.forEach(e->System.out.println(e.getName()));
        }
       
       Optional<Employee> maxage   =   employee.stream().max(Comparator.comparingInt(Employee::getAge));
       
       Employee empl=  maxage.get();
       
       System.out.println(empl.getAge());
       System.out.println(empl.getName());
       
	}
	

}
