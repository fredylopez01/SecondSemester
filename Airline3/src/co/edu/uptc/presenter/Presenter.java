package co.edu.uptc.presenter;

import co.edu.uptc.view.View;
import co.edu.uptc.model.AirplaneFlight;
import co.edu.uptc.model.Chair;

public class Presenter {
	View viewTest;
	AirplaneFlight flightTest;
	
	public Presenter() {
		viewTest = new View();
		flightTest = new AirplaneFlight();
	}
	
	public void showInformationFlight() {
		String showInformation = "";
		showInformation += "          ********CLASE EJECUTIVA********\n";
		for(int i = 0; i < flightTest.getExecutive().length; i++) {
			for(int j = 0; j < flightTest.getExecutive()[0].length; j++) {
				showInformation += "id: " + flightTest.getExecutive()[i][j].getId() + "   ";
				showInformation += "Ubicación: " + flightTest.getExecutive()[i][j].getUbication() + "       ";
				if(flightTest.getExecutive()[i][j].getConsumer() != null) {
					showInformation += "Espacio: Vendida----------";
				} else {
					showInformation += "Espacio: Libre----------";
				}
			}
			showInformation += "\n";
		}
		showInformation += "          ********CLASE ECONOMICA********\n";
		for(int i = 0; i < flightTest.getEconomic().length; i++) {
			for(int j = 0; j < flightTest.getEconomic()[0].length; j++) {
				showInformation += "id: " + flightTest.getEconomic()[i][j].getId() + "   ";
				showInformation += "Ubicación: " + flightTest.getEconomic()[i][j].getUbication() + "       ";
				if(flightTest.getEconomic()[i][j].getConsumer() != null) {
					showInformation += "Espacio: Vendida----------";
				} else {
					showInformation += "Espacio: Libre----------";
				}
			}
			showInformation += "\n";
		}
		viewTest.showMessage(showInformation);
		
	}
	
	public String ubication(int selectChair) {
		String ubication = "";
		if(selectChair == 1) {
			ubication = "Window";
		} else if(selectChair == 2) {
			ubication = "Hallway";
		} else if(selectChair == 3) {
			ubication = "Center";
		}
		return ubication;
	}
	
	public void askForInformation(int optionClass, String ubication) {
		int id = viewTest.readInt("Ingrese su identificacion para poder reservar");
		String name = viewTest.readString("Ingrese su nombre");
		Chair chairConsumer = flightTest.reserveChair(optionClass, ubication, id, name);
		if(chairConsumer != null) {
			viewTest.showMessage("Reserva con éxito\n Datos de la reserva: \n"
				+ "Silla asignada: " + chairConsumer.getId() + "\nUbicación: " + chairConsumer.getUbication()
				+ "\nDatos del Pasajero:\n Nombre: "+  chairConsumer.getConsumer().getName() 
				+ "\n Identificación: " + chairConsumer.getConsumer().getId());
		}
	}
	
	public void reserve() {
		int optionClass = viewTest.readInt("Selecione la clase en la que desea viajar:\n 1. Ejecutiva\n2. Económica");
		String selectC = "Selecione la ubicación de su silla:\n 1. Ventana\n2. Pasillo";
		String ubication;
		if(optionClass == 1) {
			ubication = ubication(viewTest.readInt(selectC));
			if(flightTest.isExecutiveChairsByUbication(ubication)) {
				askForInformation(optionClass, ubication);
			} else{
				viewTest.showMessage("Las sillas de esta posición estan agotadas");
			}
		} else if(optionClass == 2) {
			selectC += "\n3. Centro";
			ubication = ubication(viewTest.readInt(selectC));
			if(flightTest.isEconomicChairsByUbication(ubication)) {
				askForInformation(optionClass, ubication);
			} else{
				viewTest.showMessage("Las sillas de esta posición estan agotadas");
			}
		} else {
			viewTest.showMessage("Opción incorrecta");
		}
		
	}
	
	public void searchInformationIdChair() {
		Chair myChair;
		int optionClass = viewTest.readInt("Selecione la clase en la que se encuentra la silla:\n 1. Ejecutiva\n2. Económica");
		String id = viewTest.readString("Ingrese el identificador de su silla");
		myChair = flightTest.searchInformation(optionClass, id);
		String message = "Reserva con éxito\n Datos de la reserva: \nSilla asignada: " + myChair.getId() + "\nUbicación: " + myChair.getUbication();
			if(myChair.getConsumer() != null) {
				message += "\nDatos del Pasajero:\n Nombre: "+  myChair.getConsumer().getName() + "\n Identificación: " + myChair.getConsumer().getId();
			} else {
				message += "\nDatos del Pasajero: \n Silla Libre";
			}
		viewTest.showMessage(message);
	}
	
	public void run() {
		int option = 0;
		do {
			option = viewTest.readInt("Menú \n \n1. Reservar puesto \n2. Mostrar Información de puestos \n3. Buscar informacion de "
					+ "silla por identificador\n4. Salir \n \nDigite opción:");
			switch(option) {
			case 1:
				reserve();
				break;
			case 2:
				showInformationFlight();
				break;
			case 3:
				searchInformationIdChair();
				break;
			}
		} while(option !=4);
	}
	
	public static void main(String [] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
}
