package oops;




abstract class animal{
	
	
	
	public abstract void sound();   
	
}

class Dog extends animal{
	
	
	

   public void sound()
   {
	   System.out.println("dog sound");
   }
	
}

class cat extends animal
{
	

  

 public void sound()
 {
	 System.out.println("cat sound");
 }

}



public class Abstractclass {
	
	public static void main(String[] args) {
		
		
		Dog dog=new Dog();
		dog.sound();
		cat catt=new cat();
		catt.sound();
		
		
	}

}
