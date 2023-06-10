package co.edu.uptc.model;

public class Teacher extends Assistant{
	private int profession;
	
	public Teacher(int id, String firstName, String lastName, int profession) {
		super(id, firstName, lastName);
		this.profession = profession;
	}
	
	public String fullName() {
		return "Prof. " + getFirstName() + " " + getLastName();
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
	}
	
}
