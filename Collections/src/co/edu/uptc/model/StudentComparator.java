package co.edu.uptc.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentWeek13>{

	@Override
	public int compare(StudentWeek13 o1, StudentWeek13 o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
