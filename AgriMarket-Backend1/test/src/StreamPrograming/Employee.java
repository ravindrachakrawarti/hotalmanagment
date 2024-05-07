package StreamPrograming;

public class Employee {
	
	
	
	private int Id;
	private String Name;
	private int age;
	private String Gender;
	private String Deparment;
	private int Year;
	private int Salary;
	public Employee(int id, String name, int age, String gender, String deparment, int year, int salary) {
		super();
		Id = id;
		Name = name;
		this.age = age;
		Gender = gender;
		Deparment = deparment;
		Year = year;
		Salary = salary;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDeparment() {
		return Deparment;
	}
	public void setDeparment(String deparment) {
		Deparment = deparment;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", age=" + age + ", Gender=" + Gender + ", Deparment="
				+ Deparment + ", Year=" + Year + ", Salary=" + Salary + "]";
	}


	
	
	
	

}
