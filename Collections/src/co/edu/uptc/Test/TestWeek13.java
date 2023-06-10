package co.edu.uptc.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

import co.edu.uptc.model.StringComparable;
import co.edu.uptc.model.StudentComparator;
import co.edu.uptc.model.StudentWeek13;

public class TestWeek13 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("kevin");
		list.add("brayan");
		list.add("adraiana");
		list.add("gregorio");
		System.out.println(list);
		
		//Clase Concreta.Utiliza el metodo sort pasandole por parametro una instancia de una clase que implementa Comparator
		list.sort(new StringComparable());
		System.out.println(list);
		
		//Clase Anonima
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		//Expresion lambda
		//Dados x y y de tipo String el resultado es: compareTo
		list.sort((x,y)->x.compareTo(y));
		
		//Referencia a metodo. Cuando la clase ya tiene un metodo que hace esto
		list.sort(String::compareTo);
		
		
		
		ArrayList<StudentWeek13> students = new ArrayList<StudentWeek13>();
		students.add(new StudentWeek13(748, "kevin"));
		students.add(new StudentWeek13(391, "camilo"));
		students.add(new StudentWeek13(19292, "Daniel"));
		students.add(new StudentWeek13(192, "Stiven"));
		System.out.println("");
		//Clase concreta
		students.sort(new StudentComparator());
		for(StudentWeek13 i: students) {
			System.out.println(i);
		}
		
		System.out.println("");
		//Clase anonima
		students.sort(new Comparator<StudentWeek13>() {

			@Override
			public int compare(StudentWeek13 o1, StudentWeek13 o2) {
				return o1.getCode()-o2.getCode();
			}
			
		});
		for(StudentWeek13 i: students) {
			System.out.println(i);
		}
		
		System.out.println("");
		//expresion Lambda
		students.sort((x,y)->x.getName().compareTo(y.getName()));
		for(StudentWeek13 i: students) {
			System.out.println(i);
		}
		
		System.out.println("");
		//Referencia a metodo
		students.sort(StudentWeek13::compare);
		for(StudentWeek13 i: students) {
			System.out.println(i);
		}
		
		System.out.println("Filtro");
		//Filtrar 
		students.stream().filter(x -> x.getName().charAt(0) =='k').forEach(x->System.out.println(x));;
		
		//For Each
		//students.forEach(x->System.out.println(x.getName()));
	}
	
}
