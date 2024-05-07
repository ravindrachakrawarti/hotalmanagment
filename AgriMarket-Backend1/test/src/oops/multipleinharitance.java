package oops;



interface animals{
	
	void sound();
}

interface birt{
	
	void sound();
}

public class multipleinharitance implements animals, birt
{
	
	public void sound()
	{
		
		System.out.println("both sound is good ");
	}
	
	
	public static void main(String[] args) {
		
		
		multipleinharitance m =new multipleinharitance();
		m.sound();
	}
	

}
