package co.edu.uptc.Test;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uptc.model.StudentExcersice;

public class LambdaExpresition {
	private ArrayList<StudentExcersice> listStudents = new ArrayList<StudentExcersice>();
	
	public LambdaExpresition() {
		listStudents.add(new StudentExcersice(1, 191919, "Cristian Raul", "Ramirez Escalantes", 45, "Microservicios", 50));
		listStudents.add(new StudentExcersice(2, 73728, "Camilo Stiven", "Silva", 19, "Ingles", 40));
		listStudents.add(new StudentExcersice(3, 191919, "Pedro saves", "Laverde", 34, "Sociales", 30));
		listStudents.add(new StudentExcersice(4, 737282, "Camila estela", "Noguera", 26, "Matematicas", 31));
		listStudents.add(new StudentExcersice(5, 88282, "Anyel Gabriel", "Gomez Vargas", 34, "Java", 21));
		listStudents.add(new StudentExcersice(6, 9101010, "Daniel Alexander", "Restrepo Gomez", 56, "Python", 32));
		listStudents.add(new StudentExcersice(7, 818282, "Franklin Daniel", "Bautista Cepeda", 23, "Seguridad Informatica", 21));
		listStudents.add(new StudentExcersice(8, 83839101, "Natalia Yineth", "Arango", 16, "css", 45));
		listStudents.add(new StudentExcersice(9, 8292911, "Yulianna Camila", "Moreno", 43, "html", 40));
		listStudents.add(new StudentExcersice(10, 29929101, "Cristian Camilo", "Garcia", 42, "sql", 13));
		listStudents.add(new StudentExcersice(11, 28119100, "Johan David", "Pulido", 12, "bases de datos", 26));
		listStudents.add(new StudentExcersice(12, 1913241, "Heidy ", "Ibanñez", 32, "programacion", 43));
		listStudents.add(new StudentExcersice(13, 1432349, "Claudia Daniela", "Callejas", 13, "hackin", 16));
		listStudents.add(new StudentExcersice(14, 1941341, "Diana", "Wilches", 83, "inteligencia artificial", 22));
		listStudents.add(new StudentExcersice(15, 4134412, "Clemencia", "Pulido", 82, "desarrollo web", 23));
		listStudents.add(new StudentExcersice(16, 3455324, "Lorena", "Lopez", 20, "finanzas", 45));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LambdaExpresition i = new LambdaExpresition();
		int option = 0;
		do {
			System.out.println("Menu \n1. Obtener Alumnos cuyo nombre empiezan con C \n2. Imprimir numero de estudiantes "
					+ "\n3. Imprimir el alumno con menor edad \n4. Imprimir el alumno con mayor edad \n5. Encontrar el primer alumno"
					+ "\n6. Listar alumnos con criterio de quue sus cursos terminen en s \n7. Listar los alumnos donde el nombre del "
					+ "curso tiene una a \n8. Listar alumnos que el tamaño del nombre es mayor a 10 caracteres \n9. Terminar");
			option = input.nextInt();
			switch(option) {
			case 1:
				System.out.println("Lista de Estudiantes \n-----------------------------------");
				i.a();
				break;
			case 2:
				i.b();
				break;
			case 3:
				i.c();
				break;
			case 4:
				i.d();
				break;
			case 5:
				i.e();
				break;
			case 6:
				i.f();
				break;
			case 7:
				i.g();
				break;
			case 8:
				i.h();
				break;
			}
		} while(option != 9);
	}
	
	public void a() {
		listStudents.stream().filter(x ->x.getName().charAt(0) == 'C').forEach(x -> System.out.println(x));
	}
	
	public void b() {
		System.out.println("Numero de estudiantes: " + listStudents.stream().count());
	}
	
	public void c() {
		System.out.println(listStudents.stream().min((x,y) -> x.getAge()-y.getAge()));
	}
	
	public void d() {
		System.out.println(listStudents.stream().max((x,y) -> x.getAge()-y.getAge()));
	}
	
	public void e() {
		System.out.println(listStudents.stream().findFirst());
	}
	
	public void f() {
		listStudents.stream().filter(x -> x.getNameCourse().endsWith("s")).forEach(x -> System.out.println(x));
	}
	
	public void g() {
		listStudents.stream().filter(x ->x.getNameCourse().contains("a")).forEach(x -> System.out.println(x));
	}
	
	public void h() {
		listStudents.stream().filter(x -> x.getName().length() > 13).forEach(x -> System.out.println(x));
	}
}
