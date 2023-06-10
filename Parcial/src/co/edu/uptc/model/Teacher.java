package co.edu.uptc.model;

public class Teacher extends Assistant{
	private Profession profession;
	
	public Teacher(int id, String firstName, String lastName, Profession profession) {
		super(id, firstName, lastName);
		this.profession = profession;
	}
	
	public String fullName() {
		return "Prof. " + getFirstName() + " " + getLastName();
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
}
