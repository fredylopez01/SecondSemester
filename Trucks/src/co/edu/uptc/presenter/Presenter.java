package co.edu.uptc.presenter;

import co.edu.uptc.model.Enterprise;
import co.edu.uptc.model.ExceptionEquals;
import co.edu.uptc.model.ExceptionEqualsCapacity;
import co.edu.uptc.model.Truck;
import co.edu.uptc.view.ConsoleView;
import co.edu.uptc.view.Iview;
import co.edu.uptc.view.JOptionPaneView;

public class Presenter {
	private Enterprise company;
	private Iview viewTest;
	
	public Presenter(String mode) {
		company = new Enterprise(10);
		if(mode .equals("console")) {
			viewTest = new ConsoleView();
		} else {
			viewTest = new JOptionPaneView();
		}
		load();
	}
	
	public static void main(String[] args) {
		Presenter presenterTest = new Presenter(args[0]);
		presenterTest.run();
	}
	
	public void load() {
		Truck truckOne = new Truck("svf567", 5000, 1.5);
		Truck truckTwo = new Truck("zog291", 8000, 4);
		
		company.getTrucks()[0] = truckOne;
		company.getTrucks()[1] = truckTwo;
	}
	
	public void run() {
		int option = 0;
		do {
			option = viewTest.readInt("Compañia de Camiones: \n1. Agregar camion \n2. Mostrar camion con mayor capacidad \n3. Carga maxima a la puede comprometer la empresa  "
					+ "\n4. Promedio de consumo de combustible por kilometro de los camiones \n5. Salir"); 
			switch(option) {
				case 1:
					createTruck();
					break;
				case 2:
					maxCapacity();
					break;
				case 3:
					viewTest.showMessage("Carga maxima: " + company.totalCapacity() + " kg");
					break;
				case 4:
					viewTest.showMessage("Promedio combustible: " + company.avgConsumption() + " galones");
					break;
			}
		} while(option != 5);
	}
	
	public void createTruck() {
		String licensePlate = viewTest.readString("Placa: ");
		int capacity = viewTest.readInt("Capacidad del camion: ");
		double consumption = Double.parseDouble(viewTest.readString("Consumo por kilometro: "));
		Truck truck = new Truck(licensePlate, capacity, consumption);
		try {
			company.addTruck(truck);
		} catch(ExceptionEquals e) {
			viewTest.showMessage(e.getMessage());
		}
	}
	
	public void maxCapacity() {
		try {
			viewTest.showMessage("El camion con Placa: " + company.maxCapacity());
		} catch (ExceptionEqualsCapacity e) {
			viewTest.showMessage(e.getMessage());
		}
	}
	
	public void changeView() {
		viewTest.readInt("Ingrese el tipo de vista");
	}
	
}
