package co.edu.uptc.presenter;

import co.edu.uptc.model.Assistant;
import co.edu.uptc.model.Meeting;
import co.edu.uptc.model.Student;
import co.edu.uptc.model.Teacher;
import co.edu.uptc.model.Worker;
import co.edu.uptc.view.View;

public class Presenter {
	private Meeting meetingTest;
	private View viewTest;
	
	public Presenter() {
		meetingTest = new Meeting();
		viewTest = new View();
	}
	
	public void loadDate() {
		meetingTest.getAssistants()[0] = new Student(123, "Brayan", "Ateortua", 2022458, 17);
		meetingTest.getAssistants()[1] = new Teacher(1054281, "Jorge", "Hoyos", 1);
		meetingTest.getAssistants()[2] = new Worker(234, "Pablo", "Iriarte", 1200000, 1);
		meetingTest.getAssistants()[3] = new Student(1222, "Enrique", "Bonilla", 202204, 19);
	}
	
	public static void main (String [] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
	
	public void run() {
		int option = 0;
		do {
			option = viewTest.readInt("BIENVENIDO AL SISTEMA DE NUESTRA TIENDA\n\n"+ "1. Agregar un nuevo perticipante "
					+ "\n2. Eliminar paritcipante ya incrito \n3. Consultar la cantidad de participantes"
					+ "\n4. Consulatr cantidad de participantes estudiantes adultos"
					+ "\n5. Consultar la cantidad de profesores con una profesion determninada"
					+ "\n6. Consulatr la dependencia que cuenta con el mayor numero de trabajadores participando den "
					+ "el evento\n7) Salir");
			switch(option) {
				case 1:
					meetingTest.addParticipant(createParticipant());
					break;
				case 2:
					meetingTest.removeParticipant(viewTest.readInt("Ingrese la identificación del asistente que desea eliminar del evento"));
					break;
				case 3:
					viewTest.showMessage("El numero de asistentes es: " + meetingTest.countParticipants());
					break;
				case 4:
					viewTest.showMessage("La cantidad de estudiantes mayores de edad es: " + meetingTest.countAdulStudents());
					break;
				case 5:
					meetingTest.countTeacherByProfession(countTeacherByProfession());
					break;
				case 6: 
					viewTest.showMessage("La dependencia con mayor participantes es: "+ meetingTest.dependencyWithMoreNumber());
					break;
			}
		}
		while(option != 7);
	}
	
	public Assistant createParticipant() {
		Assistant assistantTest = null;
		viewTest.showMessage("Ingrese los datos del aistente");
		int id = viewTest.readInt("Identificacion: ");
		String firstName = viewTest.readString("Nombre");
		String lastName = viewTest.readString("Apellido");
		int groupAssistant = viewTest.readInt("A que grupo forma parte el asistente \n1. Profesor \n2. Estudiante \n3. Trabajador");
		if(groupAssistant == 1) {
			assistantTest = createTeacher(id,firstName, lastName);
		} else if( groupAssistant == 2) {
			assistantTest = createStudent(id,firstName, lastName);
		} else if(groupAssistant == 3) {
			assistantTest = createWorker(id,firstName, lastName);
		}
		return assistantTest;
	}
	
	public Teacher createTeacher(int id, String firstName, String lastName) {
		int profession = viewTest.readInt("Profesion del profesor: \n1.Ingeniero \2. Licenciado 3.Administrador 4.Abogado");
		return new Teacher(id, firstName, lastName, profession);
	}
	
	public Student createStudent(int id, String firstName, String lastName) {
		int code = viewTest.readInt("código");
		int age = viewTest.readInt("Edad");
		return new Student(id, firstName, lastName, code, age);
	}
	
	public Worker createWorker(int id, String firstName, String lastName) {
		int salary = viewTest.readInt("Ingrese el salario");
		int dependency = viewTest.readInt("Depencia de la que forma parte: \n1.Talento Humnao \n2. tesoreria \n3.Juridica");
		return new Worker(id, firstName, lastName,salary, dependency);
	}
	
	public int countTeacherByProfession() {
		return viewTest.readInt("Cual es la profesion del profesor: \n1.Ingeniero \2. Licenciado 3.Administrador 4.Abogado");
	}
}
