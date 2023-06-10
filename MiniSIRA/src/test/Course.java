package test;

public class Course {
	public String name;
	public String teacher;
	private Student list[];
	
	public Course() {
		list = new Student[3];
	}
	
	public void insert(int position) {
		System.out.println("Ingrese el nombre del estudiante");
		System.out.println("Ingrese el codigo del estudiante");
		System.out.println("Ingrese ");
		//list[position];
	}
	
	public Student retraive(int position) {
		return list[position];
	}
	
	public Student bestAverage() {
		Student studentWin = null;
		for(int i = 0; i < list.length; i++) {
		//	if(studentWin.calculateFinalGrade()<list[i].calculateFinalGrade()) {
				studentWin = list[i];
			}
		//}
		return studentWin;
	}
}