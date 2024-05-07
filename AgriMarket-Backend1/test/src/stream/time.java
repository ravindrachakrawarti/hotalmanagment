package stream;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class time {
	public static void main(String[] args) {
		
		
		LocalDate ld= LocalDate.now();
		
	int pp=	ld.getDayOfMonth();
		
		
		System.out.println(pp);
		
		LocalTime lt = LocalTime.now();
		
		System.out.println(lt);
		
		LocalDate llt= LocalDate.of( 1990,4,4);
		
		
		System.out.println(llt);
		
		
		String date= "23/12/1990";
		 DateTimeFormatter newformate= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 
		 LocalDate ldate= LocalDate.parse(date,newformate);
		 
		 System.out.println(ldate);
		
	}

}
