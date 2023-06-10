package co.edu.uptc.carrosPolimorfismo;

public class SportCar extends Car{
	private String color;
	
	public SportCar(String marca, String modelo, String color) {
		super(marca, modelo);
		this.color = color;
	}
	
	public String mostrarDatos() {
		return "Datos del Carro Deportivo: \nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nColor: " + color;
	}
}
