package co.edu.uptc.model;

public class Student implements Comparable<Student> {
	private int code;
	private String name;
	
	public Student(int code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
		//return code - o.code;
	}

	
	
}
