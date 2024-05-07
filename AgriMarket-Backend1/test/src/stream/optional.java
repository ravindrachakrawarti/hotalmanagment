package stream;

import java.util.Optional;

public class optional {
	
	private static Optional<String> getname()
	{
		String str="yy";
		
		return Optional.ofNullable(str);
	}
	
	
	public static void main(String[] args) {
		
		Optional<String> strr=getname();
		
		
		String sr=strr.orElse("value is null");
		
	System.out.println(sr);
		
		
		
	}
	
	

}
