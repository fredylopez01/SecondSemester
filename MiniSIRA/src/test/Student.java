package test;

public class Student {
	private int code;
	private String name;
	private int rating[];
	private int finalGrade;
	
	public Student() {
		rating = new int[3];
	}
	
	public int calculateFinalGrade() {
		finalGrade = (rating[0] + rating[1] + rating[2])/3;
		return finalGrade;
	}
	
}