package co.edu.uptc.presenter;

import animalComer.Cow;
import animalComer.Dog;
import animalComer.Person;
import animalComer.Plant;
import co.edu.uptc.carrosPolimorfismo.Car;
import co.edu.uptc.carrosPolimorfismo.SportCar;
import co.edu.uptc.carrosPolimorfismo.TransportCar;
import co.edu.uptc.view.View;

public class Presenter {
	View viewTest;
	Cow cowTest;
	Dog dogTest;
	Person personTest;
	Plant plantTest;
	Car[] cars;
	
	public Presenter() {
		viewTest = new View();
		cowTest = new Cow();
		dogTest = new Dog();
		personTest = new Person();
		plantTest = new Plant();
		cars = new Car[3];
		cars[0] = new Car("Totota", "2022");
		cars[1] = new SportCar("Lamborgini", "2023", "verde fosforesente");
		cars[2] = new TransportCar("Chevorlet", "2012", 2300);
	}
	
	public void run() {
		viewTest.showMessage("Como comen \nPersona: " + personTest.comer() + "\nPerro: " + dogTest.comer() + "\nVaca: " + cowTest.comer());
		viewTest.showMessage("Que comen: \n Planta: " + plantTest.alimentarse() + "\nPersona: " + personTest.alimentarse()
		+ "\nPerro: " + dogTest.alimentarse() + "\nVaca: " + cowTest.alimentarse());
		for(Car vehiculos: cars) {
			viewTest.showMessage(vehiculos.mostrarDatos() + "\n");
		}
	}
	
	public static void main(String[] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
}
