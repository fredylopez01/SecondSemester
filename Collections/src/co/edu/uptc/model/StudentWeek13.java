package co.edu.uptc.model;

public class StudentWeek13 {
	private int code;
	private String name;
	
	public StudentWeek13(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentWeek13 [code=" + code + ", name=" + name + "]";
	}
	
	public int compare(StudentWeek13 o) {
		return code-o.code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
