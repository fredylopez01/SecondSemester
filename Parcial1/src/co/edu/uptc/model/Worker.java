package co.edu.uptc.model;

public class Worker extends Assistant{
	private int salary;
	private int dependency;
	
	public Worker(int id, String firstName, String lastName, int salary, int dependency) {
		super(id, firstName, lastName);
		this.salary = salary;
		this.dependency = dependency;
	}
	
	public String fullName() {
		return "Sr(a) " + getFirstName() + " " + getLastName();
	}

	public int getDependency() {
		return dependency;
	}

	public void setDependency(int dependency) {
		this.dependency = dependency;
	}
	
}
