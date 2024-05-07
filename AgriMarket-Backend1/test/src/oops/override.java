package oops;

class a
{
	
void show()
{
	
 System.out.println("show a");
}


}

class b extends a
{
  void show()
  {
	  System.out.println("show b");
  }

}

public class override {
	
	public static void main(String[] args) {
		
		
		a c=new a();
		c.show();
		
		b f=new b();
		f.show();
	}

}
