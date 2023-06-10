package co.edu.uptc.presenter;

import co.edu.uptc.view.View;
import co.edu.uptc.model.AirplaneFlight;
import co.edu.uptc.model.Chair;

public class Presenter {
	View viewTest;
	AirplaneFlight flightTest;
	
	public static void main(String [] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
	
	public Presenter() {
		viewTest = new View();
		flightTest = new AirplaneFlight();
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
	

	public void reserve() {
		int optionClass = viewTest.readInt("Selecione la clase en la que desea viajar:\n 1. Ejecutiva\n2. Económica");
		String selectC = "Selecione la ubicación de su silla:\n 1. Ventana\n2. Pasillo";
		if(optionClass == 1) {
			reserveByClass(flightTest.getExecutive(), selectC);
		} else if(optionClass == 2 && flightTest.isChairByClass(flightTest.getEconomic())) {
			selectC += "\n3. Centro";
			reserveByClass(flightTest.getEconomic(), selectC);
		} else {
			viewTest.showMessage("Opción incorrecta");
		}
		
	}
	
	public void reserveByClass(Chair[][] matrizClass, String selectC) {
		String ubication;
		if(flightTest.isChairByClass(matrizClass)) {
			ubication = ubication(viewTest.readInt(selectC));
			if(flightTest.isChairsByUbication(ubication, matrizClass)) {
				askForInformation(matrizClass, ubication);
			} else{
				viewTest.showMessage("Las sillas de esta posición estan agotadas");
			}
		} else{
			viewTest.showMessage("Las sillas de esta clase estan agotadas");
		}
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
	
	public void askForInformation(Chair[][] matrizClass, String ubication) {
		int id = viewTest.readInt("Ingrese su identificacion para poder reservar");
		String name = viewTest.readString("Ingrese su nombre");
		Chair chairConsumer = flightTest.reserveChair(matrizClass, ubication, id, name);
		if(chairConsumer != null) {
			viewTest.showMessage("Reserva con éxito\n");
			readChair(chairConsumer);
		}
	}
	
	
	public void readChair(Chair myChair) {
		String message = "Datos de la reserva: \nSilla: " + myChair.getId() + "\nUbicación: " + myChair.getUbication();
		if(myChair.getConsumer() != null) {
			message += "\nPasajero:\n Nombre: "+  myChair.getConsumer().getName() + "\n Identificación: " + myChair.getConsumer().getId();
		} else {
			message += "\nDatos del Pasajero: \n Silla Libre";
		}
		viewTest.showMessage(message);
	}
	
	public void showInformationFlight() {
		String showInformation = "";
		showInformation += "          ********CLASE EJECUTIVA********\n";
		showInformation += readMatrix(flightTest.getExecutive());
			showInformation += "\n";
		showInformation += "          ********CLASE ECONOMICA********\n";
		showInformation += readMatrix(flightTest.getEconomic());
		viewTest.showMessage(showInformation);
	}
	
	public String readMatrix(Chair[][] matrizClass) {
		String showInformation = "";
		for(int i = 0; i < matrizClass.length; i++) {
			for(int j = 0; j < matrizClass[0].length; j++) {
				showInformation += "id: " + matrizClass[i][j].getId() + "   ";
				showInformation += "Ubi.: " + matrizClass[i][j].getUbication() + "       ";
				if(matrizClass[i][j].getConsumer() != null) {
					showInformation += "Esp.: Vendida-------";
				} else {
					showInformation += "Esp.: Libre---------";
				}
			}
			showInformation += "\n";
		}
		return showInformation;
	}
	
	public void searchInformationIdChair() {
		Chair myChair;
		int optionClass = viewTest.readInt("Selecione la clase en la que se encuentra la silla:\n 1. Ejecutiva\n2. Económica");
		String id = viewTest.readString("Ingrese el identificador de su silla");
		if(optionClass ==1) {
			myChair = flightTest.searchInformation(flightTest.getExecutive(), id);
			readChair(myChair);
		} else if(optionClass == 2) {
			myChair = flightTest.searchInformation(flightTest.getEconomic(), id);
			readChair(myChair);
		}
		
	}
	
}
