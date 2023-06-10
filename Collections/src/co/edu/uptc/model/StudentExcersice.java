package co.edu.uptc.model;

public class StudentExcersice {
	private int code;
	private int id;
	private String name;
	private String lastName;
	private int age;
	private String nameCourse;
	private float qualification;
	
	public StudentExcersice(int code, int id, String name, String lastName, int age, String nameCourse,
			float qualification) {
		this.code = code;
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.nameCourse = nameCourse;
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Codigo = " + code + " id = " + id + " Nombre = " + name + " Apellido = " + lastName + " Edad = "
				+ age + " Curso = " + nameCourse + " Calificacion = " + qualification + "\n\n";
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public float getQualification() {
		return qualification;
	}

	public void setQualification(float qualification) {
		this.qualification = qualification;
	}
	
}
