package co.edu.uptc.presenter;

import co.edu.uptc.model.ParkingFuntions;
import co.edu.uptc.model.Car;
import co.edu.uptc.view.View;

public class Presenter {
	private View viewTest;
	private ParkingFuntions funtionsTest;
	
	public Presenter() {
		viewTest = new View();
		funtionsTest = new ParkingFuntions();
		viewTest.showMessage("Bienvenido al sistema de parqueo");
	}
	
	public int showReadMenu() {
		int option = viewTest.readInt("\n1. Registrar entreada de un vehiculo "
				+ "\n2. Recuperar la información del vehiculo que ocupa un espacio determinado"
				+ "\n3. Obtener el número de espacios vacios "
				+ "\n4. Obtener el número de espacios ocupados "
				+ "\n5. Registrar la salida de un vehiculo(por placa)"
				+ "\n6. Terminar");
		return option;
	}
	
	public Car readCar() {
		String plate = viewTest.readString("Ingrese la placa del vehiculo");
		String hour = viewTest.readString("Ingrese la hora de entrada del vehiculo");
		Car carVerify= new Car(plate, hour);
		return carVerify;
	}
	
	public void showCar(int carSpace) {
		if (funtionsTest.viewInformationCar(carSpace) == null) {
			viewTest.showMessage("El espacio esta desocupádo verifique que si sea el espacio que busca");
		} else {
			viewTest.showMessage("Informacion del vehiclo \nPlaca: " + funtionsTest.viewInformationCar(carSpace).getPlate()
					+ "\nHora: " + funtionsTest.viewInformationCar(carSpace).gethour());
		}
	}
	
	public void entrance() {
		if(funtionsTest.vacanciesAvailable() != 0) {
			if (funtionsTest.isLogInCar(readCar()) == true) {
				viewTest.showMessage("Carro registrado y guardado con exito");
			}
		} else {
			viewTest.showMessage("Lo sentimos no existen espacios disponibles disponibles");
		}
	}
	
	public void exit() {
		String plateVerify = viewTest.readString("Ingrese la placa del vehiculo que saldra");
		if (funtionsTest.isCheckOut(plateVerify) == true) {
			viewTest.showMessage("Salida registrada con exito");
		} else {
			viewTest.showMessage("La placa ingresada no pertenece a ningun carro que halla entrado. Revise la informacion");
		}
	}
	
	public void run() {
		funtionsTest.startValues();
		int option;
		do {
			option = showReadMenu();
			switch (option) {
			case 1:
				entrance();
				break;
			case 2:
				int carSpace = viewTest.readInt("Ingrese el numero del espacio ocupado por el vehiculo");
				showCar(carSpace);
				break;
			case 3:
				viewTest.showMessage("El numero de espacios disponibles es: " + funtionsTest.vacanciesAvailable());
				break;
			case 4: 
				viewTest.showMessage("El numero de espacios ocupados es: " + funtionsTest.filledVacancies());
				break;
			case 5:
				exit();
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

	public static void main(String[] args) {
		Presenter presenterTest;
		presenterTest = new Presenter();
		presenterTest.run();
	}

}