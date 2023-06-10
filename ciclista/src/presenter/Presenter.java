package presenter;
import view.View;
import model.Ciclist;
import model.Team;

public class Presenter {
	private View viewTest;
	private Team teamTest;
	
	public void presenter() {
		viewTest = new View();
		teamTest = new Team();
		viewTest.showMessage("Bienvenido al equipo");
	}
	
	public int showReadMenu() {
		int option = viewTest.readInt("\n1.Registrar la vinculacion de un ciclista "
				+ "\n2.Visualizar información de un  ciclista que tiene asiganado un número determinado"
				+ "\n3. Visualizar la informacion del número de cupos no utilizados(vacantes) "
				+ "\n4. Visualizar la informacion del promedio de edad de los ciclistas vinculados "
				+ "\n5. Registrar la desvinculación de un ciclista (liberando el espacio ocupado)"
				+ "\n6. Terminar");
		return option;
	}
	
	public Ciclist readCiclist() {
		int numberCiclist = viewTest.readInt("Ingrese el numero del ciclista");
		String nameCiclist = viewTest.readString("Ingrese el nombre del ciclista");
		int ageCiclist = viewTest.readInt("Ingrese la edad del ciclista");
		Ciclist ciclistTest = new Ciclist(numberCiclist, nameCiclist, ageCiclist);
		return ciclistTest;
	}
	
	public void showCiclist(int numberCiclist) {
		if (teamTest.viewInformationCiclist(numberCiclist) == null) {
			viewTest.showMessage("El ciclista que busca no esta registrado. \nVerifique que el numero del ciclista sea el correcto");
		} else {
			viewTest.showMessage("***Informacion del ciclista***"
					+ "\nNombre: " + teamTest.viewInformationCiclist(numberCiclist).getName()
					+ "\nNúmero: " + teamTest.viewInformationCiclist(numberCiclist).getNumber()
					+ "\nEdad: " + teamTest.viewInformationCiclist(numberCiclist).getAge());
		}
	}
	
	public void vinculation() {
		if(teamTest.vacancies() != 0) {
			if (teamTest.registerCyclist(readCiclist()) == true) {
				viewTest.showMessage("Ciclista registrado con exito");
			}
		} else {
			viewTest.showMessage("Lo sentimos no existen vacantes disponibles");
		}
	}
	
	public void disassociation() {
		int numCiclistDisassociation = viewTest.readInt("Ingrese el numero del ciclista que desea desvincular");
		if (teamTest.disassociationCyclist(numCiclistDisassociation) == true) {
			viewTest.showMessage("Ciclista desvinculado con exito");
		} else {
			viewTest.showMessage("El ciclista que busca no se encuentra registrado, por lo tanto no puede ser desvinculado");
		}
	}
	
	public void run() {
		presenter();
		teamTest.startValues();
		int option;
		do {
			option = showReadMenu();
			switch (option) {
			case 1:
				vinculation();
				break;
			case 2:
				int numberCiclist = viewTest.readInt("Ingrese el numero del ciclista del que desea conocer la informacion");
				showCiclist(numberCiclist);
				break;
			case 3:
				viewTest.showMessage("El numero de vacantes disponibles es: " + teamTest.vacancies());
				break;
			case 4: 
				viewTest.showMessage("El promedio de las edades de los ciclistas es de: " + teamTest.averageAge());
				break;
			case 5:
				disassociation();
				break;
			case 6:
				break;
			 default:
				 viewTest.showMessage("Error! Opción invalida. Vuelva a intentar");
			}
			 
		}
		while(option != 6);
		viewTest.showMessage("Ha sido un placer. Vuelva pronto.");
	}
	
	public static void main (String [] args) {
		Presenter presenterTest;
		presenterTest = new Presenter();
		presenterTest.run();
		
	}
}