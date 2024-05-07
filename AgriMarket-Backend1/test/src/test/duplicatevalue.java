package test;

public class duplicatevalue {
	
	
	public static void main(String[] args) {
		
		String str="ravindra";
		
		
		for(int i=0;i<str.length();i++)
		{
			
			Boolean contain=true;
			
			for(int j=0;j<str.length();j++)
			{
				
				if(i!=j && str.charAt(i)==str.charAt(j))
				{
					
					contain=false;
					break;
				}
				
			}
			
			if(contain)
			{
				
				System.out.println(str.charAt(i));
			}
			
		}
		
	}
	

}
