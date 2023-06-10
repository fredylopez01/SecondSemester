package co.edu.uptc.model;

public class Student extends Assistant implements Person{
	private int code;
	private int age;
	
	public Student(int id, String firstName, String lastName, int code, int age) {
		super(id, firstName, lastName);
		this.code = code;
		this.age = age;
	}
	
	public boolean isAdult() {
		boolean isAdult = false;
		if(age > 18) {
			isAdult = true;
		}
		return isAdult;
	}
	
	public String fullName() {
		return "Est. " + getFirstName() + " " +  getLastName();
	}
	
}
