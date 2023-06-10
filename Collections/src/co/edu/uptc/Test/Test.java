package co.edu.uptc.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import co.edu.uptc.model.Student;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("lunes");
		list.add("martes");
		list.add("miercoles");
		list.add("jueves");
		list.add("viernes");
		
		System.out.println(list);
		
		
		LinkedList<String> listTwo = new LinkedList<String>();
		listTwo.add("lunes");
		listTwo.add("martes");
		listTwo.add("miercoles");
		listTwo.add("jueves");
		listTwo.add("viernes");
		listTwo.add("viernes");
		System.out.println(listTwo);
		
		HashSet<String> listThree = new HashSet<String>();
		listThree.add("lunes");
		listThree.add("martes");
		listThree.add("miercoles");
		listThree.add("jueves");
		listThree.add("viernes");
		listThree.add("sabado");
		listThree.add("viernes");
		System.out.println(listThree);
		
		TreeSet<String> listFour = new TreeSet<String>();
		listFour.add("lunes");
		listFour.add("martes");
		listFour.add("miercoles");
		listFour.add("jueves");
		listFour.add("viernes");
		listFour.add("sabado");
		listFour.add("viernes");
		System.out.println(listFour);
		
		TreeSet<Integer> numberList = new TreeSet<Integer>();
		numberList.add(8);
		numberList.add(33);
		numberList.add(11);
		numberList.add(23);
		numberList.add(62);
		numberList.add(25);
		System.out.println(numberList);
		
		TreeSet<Student> studentList = new TreeSet<Student>();
		studentList.add(new Student(123, "juan"));
		studentList.add(new Student(45, "jaime"));
		studentList.add(new Student(200, "luis"));
		System.out.println(studentList);
		
		HashSet<Student> studentHashList = new HashSet<Student>();
		Student l = new Student(200, "luis");
		studentHashList.add(new Student(123, "juan"));
		studentHashList.add(new Student(45, "jaime"));
		studentHashList.add(l);
		studentHashList.add(l);
		System.out.println(studentHashList);
		
		TreeMap<String ,Student> mapE = new TreeMap<String, Student>();
		mapE.put("m", new Student(45, "jaime"));
		mapE.put("a", l);
		mapE.put("z", new Student(123, "juan"));
		Set<String> keysStudent = mapE.keySet();
		System.out.println(mapE);
		for(String s : keysStudent) {
			System.out.println(s);
			System.out.println(mapE.get(s));
		}
		Collection<Student> students =  mapE.values();
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println(mapE.get("h"));
		
		HashMap<String, Student> hashMapE = new HashMap<String, Student>(); 
		hashMapE.put("a", l);//cualquiera de las dos variables (key, value) puden ser null
		hashMapE.put("z", l);
		hashMapE.put("h", l);
		Collection<Student> studentHash = hashMapE.values();
		for(Student e: studentHash) {
			System.out.println(e);
		}
		System.out.println();
	}
}
