package oops;

public class overloding {
	
	
	
	int a=12,b=23;
	
	void add()
	{
		int c=a+b;
		
		System.out.println(c);
	}
	
	void add(int a,int b)
	{
		int c=a+b;
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		
		overloding ovr=new overloding();
		ovr.add();
		ovr.add(12, 34);
	}
	

}
