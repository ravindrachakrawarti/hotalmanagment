package test;

public class Notes {
	
	
	private long id;
	private String name;
	private int mo;
	public Notes(long id, String name, int mo) {
		super();
		this.id = id;
		this.name = name;
		this.mo = mo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMo() {
		return mo;
	}
	public void setMo(int mo) {
		this.mo = mo;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", name=" + name + ", mo=" + mo + "]";
	}
	
	
	

}
