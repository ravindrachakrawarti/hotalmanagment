package test;


interface i{
    
    public default void display()
    {
    	
    }
    
    
    
}

class b implements i
{
    public void display()
    {
        System.out.println("hello world");
    }
}



class Test1 {
    public static void main(String[] args) {
        b c=new b();
        c.display();
    }
}
