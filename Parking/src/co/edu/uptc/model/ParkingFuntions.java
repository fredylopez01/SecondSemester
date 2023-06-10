package co.edu.uptc.model;

import co.edu.uptc.model.Car;

public class ParkingFuntions {
private Car[] parking; 
	
	public void startValues() {
		parking = new Car[20];
	}
	
	public boolean isLogInCar(Car carSave) {
		boolean isSave = false;
		for (int i = 0; i < parking.length && isSave == false; i++) {
			if(parking[i] == null) {
				parking[i] = carSave;
				isSave = true;
			}
		}
		return isSave;
	}
	
	public Car viewInformationCar(int carSpace) {
		Car carInformation = null;
		for (int i = 0; i < parking.length && carInformation == null; i++) {
			if (parking[i] != null) {
				if(i == carSpace) {
					carInformation = parking[i];
				}
			}
		}
		return carInformation;
	}
	
	public int vacanciesAvailable() {
		int numberVacancies = 0;
		for (int i = 0; i < parking.length; i++) {
			if(parking[i] == null) {
				numberVacancies++;
			}
		}
		return numberVacancies;
	}
	
	public int filledVacancies() {
		int numberVacancies = 0;
		for (int i = 0; i < parking.length; i++) {
			if(parking[i] != null) {
				numberVacancies++;
			}
		}
		return numberVacancies;
	}
	
	public boolean isCheckOut(String plateVerify) {
		boolean isEliminate = false;
		for (int i = 0; i < parking.length && isEliminate == false; i++) {
			if(parking[i] != null) {
				if(parking[i].getPlate().equalsIgnoreCase(plateVerify)) {
					parking[i] = null;
					isEliminate = true;
				}
			}
		}
		return isEliminate;
	}
	
}
